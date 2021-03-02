package com.example.demo.mbg.mapper;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class UmsRolePermissionRelationDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final UmsRolePermissionRelation umsRolePermissionRelation = new UmsRolePermissionRelation();

    public static final SqlColumn<Long> id = umsRolePermissionRelation.id;

    public static final SqlColumn<Long> roleId = umsRolePermissionRelation.roleId;

    public static final SqlColumn<Long> permissionId = umsRolePermissionRelation.permissionId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class UmsRolePermissionRelation extends SqlTable {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<Long> roleId = column("role_id", JDBCType.BIGINT);

        public final SqlColumn<Long> permissionId = column("permission_id", JDBCType.BIGINT);

        public UmsRolePermissionRelation() {
            super("ums_role_permission_relation");
        }
    }
}