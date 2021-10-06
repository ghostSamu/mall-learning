package com.example.demo.service.impl;

import com.example.demo.mbg.mapper.UmsResourceCategoryMapper;
import com.example.demo.mbg.model.UmsResourceCategory;
import com.example.demo.service.UmsResourceCategoryService;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UmsResourceCategoryServiceImpl implements UmsResourceCategoryService {

    @Autowired
    private UmsResourceCategoryMapper umsResourceCategoryMapper;

    @Override
    public List<UmsResourceCategory> listAll() {
        return umsResourceCategoryMapper.select(SelectDSLCompleter.allRows());
    }
}
