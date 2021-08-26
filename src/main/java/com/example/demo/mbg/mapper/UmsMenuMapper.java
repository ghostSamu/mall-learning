package com.example.demo.mbg.mapper;

import static com.example.demo.mbg.mapper.UmsMenuDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.example.demo.mbg.model.UmsMenu;
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
public interface UmsMenuMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(id, parentId, createTime, title, level, sort, name, icon, hidden);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="record.id", before=false, resultType=Long.class)
    int insert(InsertStatementProvider<UmsMenu> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("UmsMenuResult")
    Optional<UmsMenu> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="UmsMenuResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="parent_id", property="parentId", jdbcType=JdbcType.BIGINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="level", property="level", jdbcType=JdbcType.INTEGER),
        @Result(column="sort", property="sort", jdbcType=JdbcType.INTEGER),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="icon", property="icon", jdbcType=JdbcType.VARCHAR),
        @Result(column="hidden", property="hidden", jdbcType=JdbcType.INTEGER)
    })
    List<UmsMenu> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, umsMenu, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, umsMenu, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(UmsMenu record) {
        return MyBatis3Utils.insert(this::insert, record, umsMenu, c ->
            c.map(parentId).toProperty("parentId")
            .map(createTime).toProperty("createTime")
            .map(title).toProperty("title")
            .map(level).toProperty("level")
            .map(sort).toProperty("sort")
            .map(name).toProperty("name")
            .map(icon).toProperty("icon")
            .map(hidden).toProperty("hidden")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(UmsMenu record) {
        return MyBatis3Utils.insert(this::insert, record, umsMenu, c ->
            c.map(parentId).toPropertyWhenPresent("parentId", record::getParentId)
            .map(createTime).toPropertyWhenPresent("createTime", record::getCreateTime)
            .map(title).toPropertyWhenPresent("title", record::getTitle)
            .map(level).toPropertyWhenPresent("level", record::getLevel)
            .map(sort).toPropertyWhenPresent("sort", record::getSort)
            .map(name).toPropertyWhenPresent("name", record::getName)
            .map(icon).toPropertyWhenPresent("icon", record::getIcon)
            .map(hidden).toPropertyWhenPresent("hidden", record::getHidden)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<UmsMenu> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, umsMenu, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<UmsMenu> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, umsMenu, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<UmsMenu> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, umsMenu, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<UmsMenu> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, umsMenu, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(UmsMenu record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(parentId).equalTo(record::getParentId)
                .set(createTime).equalTo(record::getCreateTime)
                .set(title).equalTo(record::getTitle)
                .set(level).equalTo(record::getLevel)
                .set(sort).equalTo(record::getSort)
                .set(name).equalTo(record::getName)
                .set(icon).equalTo(record::getIcon)
                .set(hidden).equalTo(record::getHidden);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(UmsMenu record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(parentId).equalToWhenPresent(record::getParentId)
                .set(createTime).equalToWhenPresent(record::getCreateTime)
                .set(title).equalToWhenPresent(record::getTitle)
                .set(level).equalToWhenPresent(record::getLevel)
                .set(sort).equalToWhenPresent(record::getSort)
                .set(name).equalToWhenPresent(record::getName)
                .set(icon).equalToWhenPresent(record::getIcon)
                .set(hidden).equalToWhenPresent(record::getHidden);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(UmsMenu record) {
        return update(c ->
            c.set(parentId).equalTo(record::getParentId)
            .set(createTime).equalTo(record::getCreateTime)
            .set(title).equalTo(record::getTitle)
            .set(level).equalTo(record::getLevel)
            .set(sort).equalTo(record::getSort)
            .set(name).equalTo(record::getName)
            .set(icon).equalTo(record::getIcon)
            .set(hidden).equalTo(record::getHidden)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(UmsMenu record) {
        return update(c ->
            c.set(parentId).equalToWhenPresent(record::getParentId)
            .set(createTime).equalToWhenPresent(record::getCreateTime)
            .set(title).equalToWhenPresent(record::getTitle)
            .set(level).equalToWhenPresent(record::getLevel)
            .set(sort).equalToWhenPresent(record::getSort)
            .set(name).equalToWhenPresent(record::getName)
            .set(icon).equalToWhenPresent(record::getIcon)
            .set(hidden).equalToWhenPresent(record::getHidden)
            .where(id, isEqualTo(record::getId))
        );
    }
}