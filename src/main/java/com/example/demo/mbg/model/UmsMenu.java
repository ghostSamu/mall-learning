package com.example.demo.mbg.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import javax.annotation.Generated;

public class UmsMenu implements Serializable {
    private Long id;

    /**
     * 父级ID
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "父级ID")
    private Long parentId;

    /**
     * 创建时间
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    /**
     * 菜单名称
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "菜单名称")
    private String title;

    /**
     * 菜单级数
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "菜单级数")
    private Integer level;

    /**
     * 菜单排序
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "菜单排序")
    private Integer sort;

    /**
     * 前端名称
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "前端名称")
    private String name;

    /**
     * 前端图标
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "前端图标")
    private String icon;

    /**
     * 前端隐藏
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "前端隐藏")
    private Integer hidden;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private static final long serialVersionUID = 1L;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getId() {
        return id;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setId(Long id) {
        this.id = id;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getParentId() {
        return parentId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Date getCreateTime() {
        return createTime;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getTitle() {
        return title;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setTitle(String title) {
        this.title = title;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getLevel() {
        return level;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setLevel(Integer level) {
        this.level = level;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getSort() {
        return sort;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getName() {
        return name;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setName(String name) {
        this.name = name;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getIcon() {
        return icon;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getHidden() {
        return hidden;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setHidden(Integer hidden) {
        this.hidden = hidden;
    }

    @Override
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", parentId=").append(parentId);
        sb.append(", createTime=").append(createTime);
        sb.append(", title=").append(title);
        sb.append(", level=").append(level);
        sb.append(", sort=").append(sort);
        sb.append(", name=").append(name);
        sb.append(", icon=").append(icon);
        sb.append(", hidden=").append(hidden);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}