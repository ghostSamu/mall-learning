package com.example.demo.service.impl;

import com.example.demo.dto.UmsMenuNode;
import com.example.demo.mbg.model.UmsMenu;

import java.util.List;

public interface UmsMenuService {

    //获取所有菜单（树状图结构）
    List<UmsMenuNode> getTreeList();
}
