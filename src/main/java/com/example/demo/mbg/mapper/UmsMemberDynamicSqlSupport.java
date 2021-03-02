package com.example.demo.mbg.mapper;

import java.sql.JDBCType;
import java.util.Date;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class UmsMemberDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final UmsMember umsMember = new UmsMember();

    public static final SqlColumn<Long> id = umsMember.id;

    public static final SqlColumn<Long> memberLevelId = umsMember.memberLevelId;

    public static final SqlColumn<String> username = umsMember.username;

    public static final SqlColumn<String> password = umsMember.password;

    public static final SqlColumn<String> nickname = umsMember.nickname;

    public static final SqlColumn<String> phone = umsMember.phone;

    public static final SqlColumn<Integer> status = umsMember.status;

    public static final SqlColumn<Date> createTime = umsMember.createTime;

    public static final SqlColumn<String> icon = umsMember.icon;

    public static final SqlColumn<Integer> gender = umsMember.gender;

    public static final SqlColumn<Date> birthday = umsMember.birthday;

    public static final SqlColumn<String> city = umsMember.city;

    public static final SqlColumn<String> job = umsMember.job;

    public static final SqlColumn<String> personalizedSignature = umsMember.personalizedSignature;

    public static final SqlColumn<Integer> sourceType = umsMember.sourceType;

    public static final SqlColumn<Integer> integration = umsMember.integration;

    public static final SqlColumn<Integer> growth = umsMember.growth;

    public static final SqlColumn<Integer> luckeyCount = umsMember.luckeyCount;

    public static final SqlColumn<Integer> historyIntegration = umsMember.historyIntegration;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class UmsMember extends SqlTable {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<Long> memberLevelId = column("member_level_id", JDBCType.BIGINT);

        public final SqlColumn<String> username = column("username", JDBCType.VARCHAR);

        public final SqlColumn<String> password = column("password", JDBCType.VARCHAR);

        public final SqlColumn<String> nickname = column("nickname", JDBCType.VARCHAR);

        public final SqlColumn<String> phone = column("phone", JDBCType.VARCHAR);

        public final SqlColumn<Integer> status = column("status", JDBCType.INTEGER);

        public final SqlColumn<Date> createTime = column("create_time", JDBCType.TIMESTAMP);

        public final SqlColumn<String> icon = column("icon", JDBCType.VARCHAR);

        public final SqlColumn<Integer> gender = column("gender", JDBCType.INTEGER);

        public final SqlColumn<Date> birthday = column("birthday", JDBCType.DATE);

        public final SqlColumn<String> city = column("city", JDBCType.VARCHAR);

        public final SqlColumn<String> job = column("job", JDBCType.VARCHAR);

        public final SqlColumn<String> personalizedSignature = column("personalized_signature", JDBCType.VARCHAR);

        public final SqlColumn<Integer> sourceType = column("source_type", JDBCType.INTEGER);

        public final SqlColumn<Integer> integration = column("integration", JDBCType.INTEGER);

        public final SqlColumn<Integer> growth = column("growth", JDBCType.INTEGER);

        public final SqlColumn<Integer> luckeyCount = column("luckey_count", JDBCType.INTEGER);

        public final SqlColumn<Integer> historyIntegration = column("history_integration", JDBCType.INTEGER);

        public UmsMember() {
            super("ums_member");
        }
    }
}