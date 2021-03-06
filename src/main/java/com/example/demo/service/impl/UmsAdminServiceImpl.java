package com.example.demo.service.impl;

import com.example.demo.mbg.mapper.UmsAdminMapper;
import com.example.demo.mbg.mapper.UmsMemberDynamicSqlSupport;
import com.example.demo.mbg.mapper.UmsMemberMapper;
import com.example.demo.mbg.model.UmsAdmin;
import com.example.demo.service.UmsAdminService;
import com.example.demo.util.JwtTokenUtil;
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
import static org.mybatis.dynamic.sql.SqlBuilder.isIn;

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

    private static final Logger LOGGER = LoggerFactory.getLogger(UmsAdminServiceImpl.class);

    //注册
    @Override
    public UmsAdmin register(UmsAdmin umsAdminParam){
        //添加用户
        UmsAdmin umsAdmin = new UmsAdmin();
        BeanUtils.copyProperties(umsAdminParam, umsAdmin);
        umsAdmin.setCreateTime(new Date());
        umsAdmin.setStatus(1);

        SelectStatementProvider selectStatement = SqlBuilder.select(UmsMemberMapper.selectList)
                .from(UmsMemberDynamicSqlSupport.umsMember)
                .where(UmsMemberDynamicSqlSupport.username, isEqualToWhenPresent(umsAdmin.getUsername()))
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
            if (!passwordEncoder.matches(password, userDetails.getPassword())){
                throw new BadCredentialsException("密码错误");
            }
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            token = jwtTokenUtil.generateToken(userDetails);
        }catch (Exception e){
            LOGGER.warn("登陆异常：{}",e.getMessage());
        }
        return null;
    }

    //根据username查找用户
    public UmsAdmin getAdminByUsername(String username, List<Integer> statusList){
        UmsAdmin umsAdmin = new UmsAdmin();
        List<UmsAdmin> umsAdminList = adminMapper.select(c -> c.where(UmsMemberDynamicSqlSupport.username, isEqualToWhenPresent(username))
        .and(UmsMemberDynamicSqlSupport.status, isIn(statusList))
        .orderBy(UmsMemberDynamicSqlSupport.createTime.descending()));
        if (!umsAdminList.isEmpty() && umsAdminList.size() > 0){
            return umsAdminList.get(0);
        }
        return null;
    }
}
