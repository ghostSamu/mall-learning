package com.example.demo.mbg.mapper;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class UmsRoleMenuRelationDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final UmsRoleMenuRelation umsRoleMenuRelation = new UmsRoleMenuRelation();

    public static final SqlColumn<Long> id = umsRoleMenuRelation.id;

    public static final SqlColumn<Long> roleId = umsRoleMenuRelation.roleId;

    public static final SqlColumn<Long> menuId = umsRoleMenuRelation.menuId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class UmsRoleMenuRelation extends SqlTable {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<Long> roleId = column("role_id", JDBCType.BIGINT);

        public final SqlColumn<Long> menuId = column("menu_id", JDBCType.BIGINT);

        public UmsRoleMenuRelation() {
            super("ums_role_menu_relation");
        }
    }
}