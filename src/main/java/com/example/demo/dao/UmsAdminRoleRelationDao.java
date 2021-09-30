package com.example.demo.dao;
import com.example.demo.mbg.model.UmsAdminRoleRelation;
import com.example.demo.mbg.model.UmsPermission;
import com.example.demo.mbg.model.UmsRole;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UmsAdminRoleRelationDao {

    //批量插入用户角色关系
    int insertList(@Param("list")List<UmsAdminRoleRelation> umsAdminRoleRelationList);

    //获取角色
    List<UmsRole> getRoleList(@Param("adminId") Long adminId);

    //获取用户权限（包括+—权限）
    List<UmsPermission> getPermissionList(@Param("adminId") Long adminId);

    //根据资源id获取用户Id列表
    List<Long> getAdminIdList(@Param("resourceId") Long resourceId);
}
