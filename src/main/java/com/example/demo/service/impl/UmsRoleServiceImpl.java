package com.example.demo.service.impl;

import com.example.demo.mbg.mapper.UmsRoleMapper;
import com.example.demo.mbg.model.UmsRole;
import com.example.demo.service.UmsRoleService;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UmsRoleServiceImpl implements UmsRoleService {

    @Autowired
    private UmsRoleMapper roleMapper;

    @Override
    public List<UmsRole> list() {
        return roleMapper.select(SelectDSLCompleter.allRows());
    }
}
