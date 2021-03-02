package com.example.demo.mbg.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import javax.annotation.Generated;

public class UmsMember implements Serializable {
    private Long id;

    private Long memberLevelId;

    /**
     * 用户名
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "用户名")
    private String username;

    /**
     * 密码
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "密码")
    private String password;

    /**
     * 昵称
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "昵称")
    private String nickname;

    /**
     * 手机号码
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "手机号码")
    private String phone;

    /**
     * 帐号启用状态:0->禁用；1->启用
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "帐号启用状态:0->禁用；1->启用")
    private Integer status;

    /**
     * 注册时间
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "注册时间")
    private Date createTime;

    /**
     * 头像
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "头像")
    private String icon;

    /**
     * 性别：0->未知；1->男；2->女
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "性别：0->未知；1->男；2->女")
    private Integer gender;

    /**
     * 生日
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "生日")
    private Date birthday;

    /**
     * 所做城市
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "所做城市")
    private String city;

    /**
     * 职业
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "职业")
    private String job;

    /**
     * 个性签名
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "个性签名")
    private String personalizedSignature;

    /**
     * 用户来源
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "用户来源")
    private Integer sourceType;

    /**
     * 积分
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "积分")
    private Integer integration;

    /**
     * 成长值
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "成长值")
    private Integer growth;

    /**
     * 剩余抽奖次数
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "剩余抽奖次数")
    private Integer luckeyCount;

    /**
     * 历史积分数量
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "历史积分数量")
    private Integer historyIntegration;

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
    public Long getMemberLevelId() {
        return memberLevelId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setMemberLevelId(Long memberLevelId) {
        this.memberLevelId = memberLevelId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getUsername() {
        return username;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setUsername(String username) {
        this.username = username;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getPassword() {
        return password;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setPassword(String password) {
        this.password = password;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getNickname() {
        return nickname;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getPhone() {
        return phone;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getStatus() {
        return status;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setStatus(Integer status) {
        this.status = status;
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
    public String getIcon() {
        return icon;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getGender() {
        return gender;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setGender(Integer gender) {
        this.gender = gender;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Date getBirthday() {
        return birthday;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getCity() {
        return city;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setCity(String city) {
        this.city = city;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getJob() {
        return job;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setJob(String job) {
        this.job = job;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getPersonalizedSignature() {
        return personalizedSignature;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setPersonalizedSignature(String personalizedSignature) {
        this.personalizedSignature = personalizedSignature;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getSourceType() {
        return sourceType;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setSourceType(Integer sourceType) {
        this.sourceType = sourceType;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getIntegration() {
        return integration;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setIntegration(Integer integration) {
        this.integration = integration;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getGrowth() {
        return growth;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setGrowth(Integer growth) {
        this.growth = growth;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getLuckeyCount() {
        return luckeyCount;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setLuckeyCount(Integer luckeyCount) {
        this.luckeyCount = luckeyCount;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getHistoryIntegration() {
        return historyIntegration;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setHistoryIntegration(Integer historyIntegration) {
        this.historyIntegration = historyIntegration;
    }

    @Override
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", memberLevelId=").append(memberLevelId);
        sb.append(", username=").append(username);
        sb.append(", password=").append(password);
        sb.append(", nickname=").append(nickname);
        sb.append(", phone=").append(phone);
        sb.append(", status=").append(status);
        sb.append(", createTime=").append(createTime);
        sb.append(", icon=").append(icon);
        sb.append(", gender=").append(gender);
        sb.append(", birthday=").append(birthday);
        sb.append(", city=").append(city);
        sb.append(", job=").append(job);
        sb.append(", personalizedSignature=").append(personalizedSignature);
        sb.append(", sourceType=").append(sourceType);
        sb.append(", integration=").append(integration);
        sb.append(", growth=").append(growth);
        sb.append(", luckeyCount=").append(luckeyCount);
        sb.append(", historyIntegration=").append(historyIntegration);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}