package com.example.demo.dao;

import com.example.demo.mbg.model.UmsMenu;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UmsRoleDao {

    //根据后台用户ID获取菜单
    List<UmsMenu> getMenuList(@Param("adminId") Long adminId);

    //根据角色ID获取菜单
    List<UmsMenu> getMenuListByRoleId(@Param("roleId") Long roleId);
}
