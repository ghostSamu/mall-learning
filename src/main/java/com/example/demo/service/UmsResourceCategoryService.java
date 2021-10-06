package com.example.demo.service;

import com.example.demo.mbg.model.UmsResourceCategory;

import java.util.List;

public interface UmsResourceCategoryService {

    //获取后台所有资源分类
    List<UmsResourceCategory> listAll();
}
