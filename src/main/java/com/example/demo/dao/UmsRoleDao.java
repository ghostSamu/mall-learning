package com.example.demo.dao;

import com.example.demo.mbg.model.UmsMenu;
import com.example.demo.mbg.model.UmsResource;
import com.example.demo.mbg.model.UmsRole;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.apache.ibatis.type.JdbcType.BIGINT;

@Repository
public interface UmsRoleDao {

    //根据后台用户ID获取菜单
    List<UmsMenu> getMenuList(@Param("adminId") Long adminId);

    //根据角色ID获取菜单
    List<UmsMenu> getMenuListByRoleId(@Param("roleId") Long roleId);

    //根据角色ID获取资源
    List<UmsResource> getResourceListByRoleId(@Param("roleId") Long roleId);
}
