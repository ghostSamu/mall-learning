package com.example.demo.service.impl;

import com.example.demo.dao.UmsAdminRoleRelationDao;
import com.example.demo.mbg.mapper.UmsAdminDynamicSqlSupport;
import com.example.demo.mbg.mapper.UmsAdminMapper;
import com.example.demo.mbg.mapper.UmsMemberDynamicSqlSupport;
import com.example.demo.mbg.mapper.UmsMemberMapper;
import com.example.demo.mbg.model.UmsAdmin;
import com.example.demo.mbg.model.UmsPermission;
import com.example.demo.service.UmsAdminService;
import com.example.demo.util.JwtTokenUtil;
import com.github.pagehelper.PageHelper;
import org.mybatis.dynamic.sql.SqlBuilder;
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
import java.util.Date;
import java.util.List;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualToWhenPresent;


@Service
public class UmsAdminServiceImpl implements UmsAdminService {

    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private UmsAdminMapper adminMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UmsAdminRoleRelationDao umsAdminRoleRelationDao;

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
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            token = jwtTokenUtil.generateToken(userDetails);
        }catch (Exception e){
            LOGGER.warn("登陆异常：{}",e.getMessage());
        }
        return token;
    }

    @Override
    public UmsAdmin getAdminByUsername(String username){
        List<UmsAdmin> umsAdminList = adminMapper.select(c -> c.where(UmsMemberDynamicSqlSupport.username, isEqualToWhenPresent(username))
        .orderBy(UmsMemberDynamicSqlSupport.createTime.descending()));
        if (umsAdminList != null && umsAdminList.size() > 0){
            return umsAdminList.get(0);
        }
        return null;
    }

    @Override
    public List<UmsAdmin> list(String keyword, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        List<UmsAdmin> list = adminMapper.select(c -> c.where(UmsAdminDynamicSqlSupport.username,isEqualToWhenPresent(keyword))
        .orderBy(UmsAdminDynamicSqlSupport.createTime.descending()));
        return list;
    }

    @Override
    public List<UmsPermission> getPermissionList(Long adminId){
        return umsAdminRoleRelationDao.getAdminPermissionList(adminId);
    }
}
