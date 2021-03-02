package com.example.demo.mbg.mapper;

import static com.example.demo.mbg.mapper.UmsPermissionDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.example.demo.mbg.model.UmsPermission;
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
public interface UmsPermissionMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(id, pid, name, value, icon, type, uri, status, createTime, sort);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="record.id", before=false, resultType=Long.class)
    int insert(InsertStatementProvider<UmsPermission> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("UmsPermissionResult")
    Optional<UmsPermission> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="UmsPermissionResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="pid", property="pid", jdbcType=JdbcType.BIGINT),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="value", property="value", jdbcType=JdbcType.VARCHAR),
        @Result(column="icon", property="icon", jdbcType=JdbcType.VARCHAR),
        @Result(column="type", property="type", jdbcType=JdbcType.INTEGER),
        @Result(column="uri", property="uri", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="sort", property="sort", jdbcType=JdbcType.INTEGER)
    })
    List<UmsPermission> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, umsPermission, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, umsPermission, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(UmsPermission record) {
        return MyBatis3Utils.insert(this::insert, record, umsPermission, c ->
            c.map(pid).toProperty("pid")
            .map(name).toProperty("name")
            .map(value).toProperty("value")
            .map(icon).toProperty("icon")
            .map(type).toProperty("type")
            .map(uri).toProperty("uri")
            .map(status).toProperty("status")
            .map(createTime).toProperty("createTime")
            .map(sort).toProperty("sort")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(UmsPermission record) {
        return MyBatis3Utils.insert(this::insert, record, umsPermission, c ->
            c.map(pid).toPropertyWhenPresent("pid", record::getPid)
            .map(name).toPropertyWhenPresent("name", record::getName)
            .map(value).toPropertyWhenPresent("value", record::getValue)
            .map(icon).toPropertyWhenPresent("icon", record::getIcon)
            .map(type).toPropertyWhenPresent("type", record::getType)
            .map(uri).toPropertyWhenPresent("uri", record::getUri)
            .map(status).toPropertyWhenPresent("status", record::getStatus)
            .map(createTime).toPropertyWhenPresent("createTime", record::getCreateTime)
            .map(sort).toPropertyWhenPresent("sort", record::getSort)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<UmsPermission> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, umsPermission, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<UmsPermission> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, umsPermission, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<UmsPermission> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, umsPermission, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<UmsPermission> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, umsPermission, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(UmsPermission record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(pid).equalTo(record::getPid)
                .set(name).equalTo(record::getName)
                .set(value).equalTo(record::getValue)
                .set(icon).equalTo(record::getIcon)
                .set(type).equalTo(record::getType)
                .set(uri).equalTo(record::getUri)
                .set(status).equalTo(record::getStatus)
                .set(createTime).equalTo(record::getCreateTime)
                .set(sort).equalTo(record::getSort);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(UmsPermission record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(pid).equalToWhenPresent(record::getPid)
                .set(name).equalToWhenPresent(record::getName)
                .set(value).equalToWhenPresent(record::getValue)
                .set(icon).equalToWhenPresent(record::getIcon)
                .set(type).equalToWhenPresent(record::getType)
                .set(uri).equalToWhenPresent(record::getUri)
                .set(status).equalToWhenPresent(record::getStatus)
                .set(createTime).equalToWhenPresent(record::getCreateTime)
                .set(sort).equalToWhenPresent(record::getSort);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(UmsPermission record) {
        return update(c ->
            c.set(pid).equalTo(record::getPid)
            .set(name).equalTo(record::getName)
            .set(value).equalTo(record::getValue)
            .set(icon).equalTo(record::getIcon)
            .set(type).equalTo(record::getType)
            .set(uri).equalTo(record::getUri)
            .set(status).equalTo(record::getStatus)
            .set(createTime).equalTo(record::getCreateTime)
            .set(sort).equalTo(record::getSort)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(UmsPermission record) {
        return update(c ->
            c.set(pid).equalToWhenPresent(record::getPid)
            .set(name).equalToWhenPresent(record::getName)
            .set(value).equalToWhenPresent(record::getValue)
            .set(icon).equalToWhenPresent(record::getIcon)
            .set(type).equalToWhenPresent(record::getType)
            .set(uri).equalToWhenPresent(record::getUri)
            .set(status).equalToWhenPresent(record::getStatus)
            .set(createTime).equalToWhenPresent(record::getCreateTime)
            .set(sort).equalToWhenPresent(record::getSort)
            .where(id, isEqualTo(record::getId))
        );
    }
}