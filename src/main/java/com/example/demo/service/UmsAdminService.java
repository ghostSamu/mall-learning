package com.example.demo.service;


import com.example.demo.mbg.model.UmsAdmin;
import com.example.demo.mbg.model.UmsPermission;
import com.example.demo.mbg.model.UmsRole;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UmsAdminService {

    //注册
    UmsAdmin register(UmsAdmin umsAdminParam);
    //登陆
    String login(String username, String password);
    //刷新token
    String refreshToken(String oldToken);
    //获取用户权限
    List<UmsPermission> getPermissionList(Long adminId);
    //根据用户名获取权限
    UmsAdmin getAdminByUsername(String username);
    //给用户分配角色
    @Transactional
    int updateRole(Long adminId,List<Long> roleIds);
    //获取用户的角色
    List<UmsRole> getRoleList(Long adminId);
    //根据用户名或昵称分页查询用户
    List<UmsAdmin> list(String keyword, Integer pageSize, Integer pageNum);
    //修改用户信息
    int updateAdmin(Long id, UmsAdmin admin);
    //删除用户
    int deleteAdmin(Long id);
    //获取用户
    UmsAdmin getItem(Long id);
}
