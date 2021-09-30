package com.example.demo.mbg.mapper;

import java.sql.JDBCType;
import java.util.Date;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class UmsResourceCategoryDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final UmsResourceCategory umsResourceCategory = new UmsResourceCategory();

    public static final SqlColumn<Long> id = umsResourceCategory.id;

    public static final SqlColumn<Date> createTime = umsResourceCategory.createTime;

    public static final SqlColumn<String> name = umsResourceCategory.name;

    public static final SqlColumn<Integer> sort = umsResourceCategory.sort;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class UmsResourceCategory extends SqlTable {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<Date> createTime = column("create_time", JDBCType.TIMESTAMP);

        public final SqlColumn<String> name = column("name", JDBCType.VARCHAR);

        public final SqlColumn<Integer> sort = column("sort", JDBCType.INTEGER);

        public UmsResourceCategory() {
            super("ums_resource_category");
        }
    }
}