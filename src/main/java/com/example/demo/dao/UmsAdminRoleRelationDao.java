package com.example.demo.dao;

import com.example.demo.mbg.model.UmsPermission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UmsAdminRoleRelationDao {

    //获取用户权限（包括+—权限）
    @SelectProvider(type = UmsAdminRoleRelationSelectProvider.class, method = "getAdminPermissionList")  //注意method名誉 下面class中的名字保持一致，不然会报错
    List<UmsPermission> getAdminPermissionList(@Param("adminId") Long adminId);


     class UmsAdminRoleRelationSelectProvider {

        public String getAdminPermissionList(Long adminId){

            String inStr = "select * from ums_permission where id = " + adminId;
            return inStr;
        }
    }
}
