package com.example.demo.mbg.mapper;

import java.sql.JDBCType;
import java.util.Date;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class UmsPermissionDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final UmsPermission umsPermission = new UmsPermission();

    public static final SqlColumn<Long> id = umsPermission.id;

    public static final SqlColumn<Long> pid = umsPermission.pid;

    public static final SqlColumn<String> name = umsPermission.name;

    public static final SqlColumn<String> value = umsPermission.value;

    public static final SqlColumn<String> icon = umsPermission.icon;

    public static final SqlColumn<Integer> type = umsPermission.type;

    public static final SqlColumn<String> uri = umsPermission.uri;

    public static final SqlColumn<Integer> status = umsPermission.status;

    public static final SqlColumn<Date> createTime = umsPermission.createTime;

    public static final SqlColumn<Integer> sort = umsPermission.sort;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class UmsPermission extends SqlTable {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<Long> pid = column("pid", JDBCType.BIGINT);

        public final SqlColumn<String> name = column("name", JDBCType.VARCHAR);

        public final SqlColumn<String> value = column("value", JDBCType.VARCHAR);

        public final SqlColumn<String> icon = column("icon", JDBCType.VARCHAR);

        public final SqlColumn<Integer> type = column("type", JDBCType.INTEGER);

        public final SqlColumn<String> uri = column("uri", JDBCType.VARCHAR);

        public final SqlColumn<Integer> status = column("status", JDBCType.INTEGER);

        public final SqlColumn<Date> createTime = column("create_time", JDBCType.TIMESTAMP);

        public final SqlColumn<Integer> sort = column("sort", JDBCType.INTEGER);

        public UmsPermission() {
            super("ums_permission");
        }
    }
}