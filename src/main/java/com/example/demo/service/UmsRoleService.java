package com.example.demo.service;

import com.example.demo.mbg.model.UmsResource;
import com.example.demo.mbg.model.UmsRole;
import com.example.demo.mbg.model.UmsMenu;

import java.util.List;

public interface UmsRoleService {

    //创建角色
    int create(UmsRole umsRole);
    //修改角色
    int update(Long id, UmsRole role);
    //删除角色
    int delete(List<Long> ids);
    //获取所有角色列表
    List<UmsRole> list();
    //分页获取角色列表
    List<UmsRole> list(String keyword, Integer pageSize, Integer pageNum);
    //获取角色相关菜单
    List<UmsMenu> getMenuList(Long adminId);
    //给角色分配菜单
    int allocMenu(Long roleId, List<Long> menuIds);
    //获取角色相关菜单
    List<UmsMenu> listMenu(Long roleId);
    //给角色分配资源
    int allocResource(Long roleId, List<Long> resourceIds);
    //获取角色相关资源
    List<UmsResource> listResource(Long roleId);

}
