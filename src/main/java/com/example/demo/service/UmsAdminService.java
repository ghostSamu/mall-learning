package com.example.demo.service;


import com.example.demo.mbg.model.UmsAdmin;
import com.example.demo.mbg.model.UmsPermission;

import java.util.List;

public interface UmsAdminService {

    //注册
    UmsAdmin register(UmsAdmin umsAdminParam);
    //登陆
    String login(String username, String password);
    //获取用户权限
    List<UmsPermission> getPermissionList(Long adminId);
    //根据用户名获取权限
    UmsAdmin getAdminByUsername(String username);
    //根据用户名或昵称分页查询用户
    List<UmsAdmin> list(String keyword, Integer pageSize, Integer pageNum);
}
