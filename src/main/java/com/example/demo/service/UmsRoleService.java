package com.example.demo.service;

import com.example.demo.mbg.model.UmsRole;
import com.example.demo.mbg.model.UmsMenu;

import java.util.List;

public interface UmsRoleService {

    //创建角色
    int create(UmsRole umsRole);

    //获取所有角色列表
    List<UmsRole> list();

    //根据管理员ID获取对应菜单
    List<UmsMenu> getMenuList(Long adminId);
}
