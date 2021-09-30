package com.example.demo.service;

import com.example.demo.mbg.model.UmsAdmin;
import com.example.demo.mbg.model.UmsResource;

import java.util.List;

public interface UmsAdminCacheService {

    //删除后台用户缓存
    void delAdmin(Long adminId);
    //删除后台用户资源列表缓存
    void delResourceList(Long adminId);
    //当角色相关资源信息改变时删除相关后台用户缓存
    void delResourceListByRole(Long roleId);
    //当角色相关资源信息改变时删除相关后台用户缓存(复数)
    void delResourceListByRoles(List<Long> roleIds);
    //资源信息改变时删除资源项目后台用户数据
    void delResourceListByResource(Long resourceId);
    //获取缓存后台用户信息
    UmsAdmin getAdmin(String username);
    //设置缓存后台用户信息
    void  setAdmin(UmsAdmin umsAdmin);
    //获取缓存后台用户资源列表
    List<UmsResource> getResource(Long adminId);
    //设置缓存后台用户资源列表
    void setResource(Long adminId, UmsResource umsResource);
}
