package com.example.demo.service.impl;

import cn.hutool.core.util.StrUtil;
import com.example.demo.dao.UmsAdminRoleRelationDao;
import com.example.demo.dao.UmsRoleDao;
import com.example.demo.mbg.mapper.*;
import com.example.demo.mbg.model.UmsAdmin;
import com.example.demo.mbg.model.UmsAdminRoleRelation;
import com.example.demo.mbg.model.UmsPermission;
import com.example.demo.mbg.model.UmsRole;
import com.example.demo.service.UmsAdminCacheService;
import com.example.demo.service.UmsAdminService;
import com.example.demo.util.JwtTokenUtil;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.annotations.Select;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.render.RenderingStrategy;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.mybatis.dynamic.sql.SqlBuilder.*;


@Service
public class UmsAdminServiceImpl implements UmsAdminService {

    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private UmsAdminMapper adminMapper;
    @Autowired
    private UmsAdminRoleRelationMapper adminRoleRelationMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UmsAdminRoleRelationDao umsAdminRoleRelationDao;
    @Autowired
    private UmsRoleDao umsRoleDao;
    @Autowired
    private UmsAdminCacheService adminCacheService;

    private static final Logger LOGGER = LoggerFactory.getLogger(UmsAdminServiceImpl.class);

    //注册
    @Override
    public UmsAdmin register(UmsAdmin umsAdminParam){
        //添加用户
        UmsAdmin umsAdmin = new UmsAdmin();
        BeanUtils.copyProperties(umsAdminParam, umsAdmin);
        umsAdmin.setCreateTime(new Date());
        umsAdmin.setStatus(1);

        SelectStatementProvider selectStatement = SqlBuilder.select(UmsAdminMapper.selectList)
                .from(UmsAdminDynamicSqlSupport.umsAdmin)
                .where(UmsAdminDynamicSqlSupport.username, isEqualToWhenPresent(umsAdmin.getUsername()))
                .build()
                .render(RenderingStrategy.MYBATIS3);
        List<UmsAdmin> umsAdmins = adminMapper.selectMany(selectStatement);
        if (!CollectionUtils.isEmpty(umsAdmins)){
            return null;
        }
        String encodePassword = passwordEncoder.encode(umsAdmin.getPassword());
        umsAdmin.setPassword(encodePassword);
        adminMapper.insert(umsAdmin);
        return umsAdmin;
    }

    //登陆
    @Override
    public String login(String username, String password) {
        String token = null;
        try {
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
            if (!passwordEncoder.matches(password, userDetails.getPassword())){  //AdminUserDetails 的 getPassword 方法设置了return null  导致一直返回null
                throw new BadCredentialsException("密码错误");
            }
            token = jwtTokenUtil.generateToken(userDetails);
        }catch (Exception e){
            LOGGER.warn("登陆异常：{}",e.getMessage());
        }
        return token;
    }

    @Override
    public String refreshToken(String oldToken) {
        return jwtTokenUtil.refreshToken(oldToken);
    }

    @Override
    public UmsAdmin getAdminByUsername(String username){
        UmsAdmin umsAdmin = adminCacheService.getAdmin(username);
        if (umsAdmin != null){
            return umsAdmin;
        }
        List<UmsAdmin> umsAdminList = adminMapper.select(c -> c.where(UmsAdminDynamicSqlSupport.username, isEqualToWhenPresent(username))
        .orderBy(UmsMemberDynamicSqlSupport.createTime.descending()));
        if (umsAdminList != null && umsAdminList.size() > 0){
            adminCacheService.setAdmin(umsAdminList.get(0));
            return umsAdminList.get(0);
        }
        return null;
    }
    //给用户分配角色
    @Override
    public int updateRole(Long adminId, List<Long> roleIds) {
        int count = roleIds == null ? 0 : roleIds.size();
        //删除原有关系
        DeleteStatementProvider deleteStatement = SqlBuilder.deleteFrom(UmsAdminRoleRelationDynamicSqlSupport.umsAdminRoleRelation)
                .where(UmsAdminRoleRelationDynamicSqlSupport.adminId,isEqualTo(adminId))
                .build()
                .render(RenderingStrategy.MYBATIS3);
        adminRoleRelationMapper.delete(deleteStatement);
        //建立新关系
        if (!CollectionUtils.isEmpty(roleIds)){
            List<UmsAdminRoleRelation> list = new ArrayList<>();
            for (Long roleId : roleIds){
                UmsAdminRoleRelation roleRelation = new UmsAdminRoleRelation();
                roleRelation.setAdminId(adminId);
                roleRelation.setRoleId(roleId);
                list.add(roleRelation);
            }
            umsAdminRoleRelationDao.insertList(list);
        }
        adminCacheService.delResourceList(adminId);
        return count;
    }

    //获取用户角色
    @Override
    public List<UmsRole> getRoleList(Long adminId) {
        List roleList = umsAdminRoleRelationDao.getRoleList(adminId);
        return umsAdminRoleRelationDao.getRoleList(adminId);
    }


    @Override
    public List<UmsAdmin> list(String keyword, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        List<UmsAdmin> list = adminMapper.select(c -> c.where(UmsAdminDynamicSqlSupport.username,isEqualToWhenPresent(keyword))
        .orderBy(UmsAdminDynamicSqlSupport.createTime.descending()));
        return list;
    }
    @Override
    public int updateAdmin(Long id, UmsAdmin admin) {
        admin.setId(id);
        Optional<UmsAdmin> rawAdmin = adminMapper.selectByPrimaryKey(id);
        if (rawAdmin.isPresent()){
            if (rawAdmin.get().getPassword().equals(admin.getPassword())){
                admin.setPassword(null);
            }else {
                if (StrUtil.isEmpty(admin.getPassword())){
                    admin.setPassword(null);
                }else {
                    admin.setPassword(passwordEncoder.encode(admin.getPassword()));
                }
            }
        }
        int count = adminMapper.updateByPrimaryKey(admin);
        return count;
    }

    @Override
    public int deleteAdmin(Long id) {
        int count = adminMapper.deleteByPrimaryKey(id);

        return count;
    }

    @Override
    public UmsAdmin getItem(Long id){
        return adminMapper.selectByPrimaryKey(id).get();
    }

    //获取用户权限
    @Override
    public List<UmsPermission> getPermissionList(Long adminId){

        return umsAdminRoleRelationDao.getPermissionList(adminId);
    }
}
