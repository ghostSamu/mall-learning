package com.example.demo.mbg.mapper;

import static com.example.demo.mbg.mapper.UmsMemberDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.example.demo.mbg.model.UmsMember;
import java.util.List;
import java.util.Optional;
import javax.annotation.Generated;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.delete.DeleteDSLCompleter;
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
import org.mybatis.dynamic.sql.select.CountDSLCompleter;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.UpdateDSLCompleter;
import org.mybatis.dynamic.sql.update.UpdateModel;
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils;

@Mapper
public interface UmsMemberMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(id, memberLevelId, username, password, nickname, phone, status, createTime, icon, gender, birthday, city, job, personalizedSignature, sourceType, integration, growth, luckeyCount, historyIntegration);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="record.id", before=false, resultType=Long.class)
    int insert(InsertStatementProvider<UmsMember> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("UmsMemberResult")
    Optional<UmsMember> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="UmsMemberResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="member_level_id", property="memberLevelId", jdbcType=JdbcType.BIGINT),
        @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="nickname", property="nickname", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="icon", property="icon", jdbcType=JdbcType.VARCHAR),
        @Result(column="gender", property="gender", jdbcType=JdbcType.INTEGER),
        @Result(column="birthday", property="birthday", jdbcType=JdbcType.DATE),
        @Result(column="city", property="city", jdbcType=JdbcType.VARCHAR),
        @Result(column="job", property="job", jdbcType=JdbcType.VARCHAR),
        @Result(column="personalized_signature", property="personalizedSignature", jdbcType=JdbcType.VARCHAR),
        @Result(column="source_type", property="sourceType", jdbcType=JdbcType.INTEGER),
        @Result(column="integration", property="integration", jdbcType=JdbcType.INTEGER),
        @Result(column="growth", property="growth", jdbcType=JdbcType.INTEGER),
        @Result(column="luckey_count", property="luckeyCount", jdbcType=JdbcType.INTEGER),
        @Result(column="history_integration", property="historyIntegration", jdbcType=JdbcType.INTEGER)
    })
    List<UmsMember> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, umsMember, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, umsMember, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(UmsMember record) {
        return MyBatis3Utils.insert(this::insert, record, umsMember, c ->
            c.map(memberLevelId).toProperty("memberLevelId")
            .map(username).toProperty("username")
            .map(password).toProperty("password")
            .map(nickname).toProperty("nickname")
            .map(phone).toProperty("phone")
            .map(status).toProperty("status")
            .map(createTime).toProperty("createTime")
            .map(icon).toProperty("icon")
            .map(gender).toProperty("gender")
            .map(birthday).toProperty("birthday")
            .map(city).toProperty("city")
            .map(job).toProperty("job")
            .map(personalizedSignature).toProperty("personalizedSignature")
            .map(sourceType).toProperty("sourceType")
            .map(integration).toProperty("integration")
            .map(growth).toProperty("growth")
            .map(luckeyCount).toProperty("luckeyCount")
            .map(historyIntegration).toProperty("historyIntegration")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(UmsMember record) {
        return MyBatis3Utils.insert(this::insert, record, umsMember, c ->
            c.map(memberLevelId).toPropertyWhenPresent("memberLevelId", record::getMemberLevelId)
            .map(username).toPropertyWhenPresent("username", record::getUsername)
            .map(password).toPropertyWhenPresent("password", record::getPassword)
            .map(nickname).toPropertyWhenPresent("nickname", record::getNickname)
            .map(phone).toPropertyWhenPresent("phone", record::getPhone)
            .map(status).toPropertyWhenPresent("status", record::getStatus)
            .map(createTime).toPropertyWhenPresent("createTime", record::getCreateTime)
            .map(icon).toPropertyWhenPresent("icon", record::getIcon)
            .map(gender).toPropertyWhenPresent("gender", record::getGender)
            .map(birthday).toPropertyWhenPresent("birthday", record::getBirthday)
            .map(city).toPropertyWhenPresent("city", record::getCity)
            .map(job).toPropertyWhenPresent("job", record::getJob)
            .map(personalizedSignature).toPropertyWhenPresent("personalizedSignature", record::getPersonalizedSignature)
            .map(sourceType).toPropertyWhenPresent("sourceType", record::getSourceType)
            .map(integration).toPropertyWhenPresent("integration", record::getIntegration)
            .map(growth).toPropertyWhenPresent("growth", record::getGrowth)
            .map(luckeyCount).toPropertyWhenPresent("luckeyCount", record::getLuckeyCount)
            .map(historyIntegration).toPropertyWhenPresent("historyIntegration", record::getHistoryIntegration)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<UmsMember> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, umsMember, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<UmsMember> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, umsMember, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<UmsMember> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, umsMember, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<UmsMember> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, umsMember, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(UmsMember record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(memberLevelId).equalTo(record::getMemberLevelId)
                .set(username).equalTo(record::getUsername)
                .set(password).equalTo(record::getPassword)
                .set(nickname).equalTo(record::getNickname)
                .set(phone).equalTo(record::getPhone)
                .set(status).equalTo(record::getStatus)
                .set(createTime).equalTo(record::getCreateTime)
                .set(icon).equalTo(record::getIcon)
                .set(gender).equalTo(record::getGender)
                .set(birthday).equalTo(record::getBirthday)
                .set(city).equalTo(record::getCity)
                .set(job).equalTo(record::getJob)
                .set(personalizedSignature).equalTo(record::getPersonalizedSignature)
                .set(sourceType).equalTo(record::getSourceType)
                .set(integration).equalTo(record::getIntegration)
                .set(growth).equalTo(record::getGrowth)
                .set(luckeyCount).equalTo(record::getLuckeyCount)
                .set(historyIntegration).equalTo(record::getHistoryIntegration);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(UmsMember record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(memberLevelId).equalToWhenPresent(record::getMemberLevelId)
                .set(username).equalToWhenPresent(record::getUsername)
                .set(password).equalToWhenPresent(record::getPassword)
                .set(nickname).equalToWhenPresent(record::getNickname)
                .set(phone).equalToWhenPresent(record::getPhone)
                .set(status).equalToWhenPresent(record::getStatus)
                .set(createTime).equalToWhenPresent(record::getCreateTime)
                .set(icon).equalToWhenPresent(record::getIcon)
                .set(gender).equalToWhenPresent(record::getGender)
                .set(birthday).equalToWhenPresent(record::getBirthday)
                .set(city).equalToWhenPresent(record::getCity)
                .set(job).equalToWhenPresent(record::getJob)
                .set(personalizedSignature).equalToWhenPresent(record::getPersonalizedSignature)
                .set(sourceType).equalToWhenPresent(record::getSourceType)
                .set(integration).equalToWhenPresent(record::getIntegration)
                .set(growth).equalToWhenPresent(record::getGrowth)
                .set(luckeyCount).equalToWhenPresent(record::getLuckeyCount)
                .set(historyIntegration).equalToWhenPresent(record::getHistoryIntegration);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(UmsMember record) {
        return update(c ->
            c.set(memberLevelId).equalTo(record::getMemberLevelId)
            .set(username).equalTo(record::getUsername)
            .set(password).equalTo(record::getPassword)
            .set(nickname).equalTo(record::getNickname)
            .set(phone).equalTo(record::getPhone)
            .set(status).equalTo(record::getStatus)
            .set(createTime).equalTo(record::getCreateTime)
            .set(icon).equalTo(record::getIcon)
            .set(gender).equalTo(record::getGender)
            .set(birthday).equalTo(record::getBirthday)
            .set(city).equalTo(record::getCity)
            .set(job).equalTo(record::getJob)
            .set(personalizedSignature).equalTo(record::getPersonalizedSignature)
            .set(sourceType).equalTo(record::getSourceType)
            .set(integration).equalTo(record::getIntegration)
            .set(growth).equalTo(record::getGrowth)
            .set(luckeyCount).equalTo(record::getLuckeyCount)
            .set(historyIntegration).equalTo(record::getHistoryIntegration)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(UmsMember record) {
        return update(c ->
            c.set(memberLevelId).equalToWhenPresent(record::getMemberLevelId)
            .set(username).equalToWhenPresent(record::getUsername)
            .set(password).equalToWhenPresent(record::getPassword)
            .set(nickname).equalToWhenPresent(record::getNickname)
            .set(phone).equalToWhenPresent(record::getPhone)
            .set(status).equalToWhenPresent(record::getStatus)
            .set(createTime).equalToWhenPresent(record::getCreateTime)
            .set(icon).equalToWhenPresent(record::getIcon)
            .set(gender).equalToWhenPresent(record::getGender)
            .set(birthday).equalToWhenPresent(record::getBirthday)
            .set(city).equalToWhenPresent(record::getCity)
            .set(job).equalToWhenPresent(record::getJob)
            .set(personalizedSignature).equalToWhenPresent(record::getPersonalizedSignature)
            .set(sourceType).equalToWhenPresent(record::getSourceType)
            .set(integration).equalToWhenPresent(record::getIntegration)
            .set(growth).equalToWhenPresent(record::getGrowth)
            .set(luckeyCount).equalToWhenPresent(record::getLuckeyCount)
            .set(historyIntegration).equalToWhenPresent(record::getHistoryIntegration)
            .where(id, isEqualTo(record::getId))
        );
    }
}