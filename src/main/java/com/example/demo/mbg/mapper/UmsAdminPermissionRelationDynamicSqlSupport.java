package com.example.demo.mbg.mapper;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class UmsAdminPermissionRelationDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final UmsAdminPermissionRelation umsAdminPermissionRelation = new UmsAdminPermissionRelation();

    public static final SqlColumn<Long> id = umsAdminPermissionRelation.id;

    public static final SqlColumn<Long> adminId = umsAdminPermissionRelation.adminId;

    public static final SqlColumn<Long> permissionId = umsAdminPermissionRelation.permissionId;

    public static final SqlColumn<Integer> type = umsAdminPermissionRelation.type;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class UmsAdminPermissionRelation extends SqlTable {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<Long> adminId = column("admin_id", JDBCType.BIGINT);

        public final SqlColumn<Long> permissionId = column("permission_id", JDBCType.BIGINT);

        public final SqlColumn<Integer> type = column("type", JDBCType.INTEGER);

        public UmsAdminPermissionRelation() {
            super("ums_admin_permission_relation");
        }
    }
}