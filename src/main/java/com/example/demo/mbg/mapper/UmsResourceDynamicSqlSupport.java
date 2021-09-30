package com.example.demo.mbg.mapper;

import java.sql.JDBCType;
import java.util.Date;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class UmsResourceDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final UmsResource umsResource = new UmsResource();

    public static final SqlColumn<Long> id = umsResource.id;

    public static final SqlColumn<Date> createTime = umsResource.createTime;

    public static final SqlColumn<String> name = umsResource.name;

    public static final SqlColumn<String> url = umsResource.url;

    public static final SqlColumn<String> description = umsResource.description;

    public static final SqlColumn<Long> categoryId = umsResource.categoryId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class UmsResource extends SqlTable {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<Date> createTime = column("create_time", JDBCType.TIMESTAMP);

        public final SqlColumn<String> name = column("name", JDBCType.VARCHAR);

        public final SqlColumn<String> url = column("url", JDBCType.VARCHAR);

        public final SqlColumn<String> description = column("description", JDBCType.VARCHAR);

        public final SqlColumn<Long> categoryId = column("category_id", JDBCType.BIGINT);

        public UmsResource() {
            super("ums_resource");
        }
    }
}