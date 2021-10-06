package com.example.demo.service.impl;

import com.example.demo.mbg.mapper.UmsResourceMapper;
import com.example.demo.mbg.model.UmsResource;
import com.example.demo.service.UmsResourceService;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UmsResourceServiceImpl implements UmsResourceService {

    @Autowired
    private UmsResourceMapper resourceMapper;

    @Override
    public List<UmsResource> listAll() {
        return resourceMapper.select(SelectDSLCompleter.allRows());
    }
}
