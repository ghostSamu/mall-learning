package com.example.demo.service.impl;

import com.example.demo.common.exception.Asserts;
import com.example.demo.mbg.mapper.UmsAdminMapper;
import com.example.demo.mbg.mapper.UmsMemberDynamicSqlSupport;
import com.example.demo.mbg.mapper.UmsMemberMapper;
import com.example.demo.mbg.model.UmsAdmin;
import com.example.demo.mbg.model.UmsMember;
import com.example.demo.service.UmsAdminService;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.render.RenderingStrategy;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.naming.AuthenticationException;
import java.util.Date;
import java.util.List;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualToWhenPresent;

@Service
public class UmsAdminServiceImpl implements UmsAdminService {

    @Autowired
    private UmsAdminMapper adminMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;

    private static final Logger LOGGER = LoggerFactory.getLogger(UmsAdminServiceImpl.class);

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
}
