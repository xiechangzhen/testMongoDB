package com.yymt.entity.sport;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import com.yymt.entity.sys.SysUserEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

/**
 * 行业人员
 *
 * @author cots
 * @date 2018-09-12 11:04:21
 */
@TableName("tb_industry_person")
@ApiModel(description = "行业人员")
public class IndustryPersonEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @TableId
    @ApiModelProperty(value = "编号")
    private Integer id;
    /**
     * 真实姓名
     */
    @ApiModelProperty(value = "真实姓名")
    private String realName;
    /**
     * 性别(0-女，1-男)
     */
    @ApiModelProperty(value = "性别(0-女，1-男)")
    private Integer sex;
    /**
     * 身份证号码
     */
    @ApiModelProperty(value = "身份证号码")
    private String identityNumber;
    /**
     * 照片
     */
    @ApiModelProperty(value = "照片")
    private String photo;
    /**
     * 联系电话
     */
    @ApiModelProperty(value = "联系电话")
    private String contact;

    /**
     * 审核状态（0：待审核  1：通过  2：未通过）
     */
    @ApiModelProperty(value = "审核状态")
    private Integer status;

    /**
     * 添加人
     */
    @ApiModelProperty(value = "添加人")
    private Long authorId;

    /**
     * 审核人id
     */
    @ApiModelProperty(value = "审核人")
    private Long auditorId;

    /**
     * 审核时间
     */
    @ApiModelProperty(value = "审核时间")
    private Date auditTime;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间")
    private Date modifyTime;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remark;

    /**
     * 创建者
     */
    @TableField(exist = false)
    private SysUserEntity authorSysUser;

    /**
     * 审核者
     */
    @TableField(exist = false)
    private SysUserEntity auditorSysUser;

    /**
     * 行业人员职称
     */
    @TableField(exist = false)
    private List<IndustrySportsLevelEntity> industrySportsLevels;

    /**
     * 头衔文本
     */
    @TableField(exist = false)
    private String sportLevelString;

    /**
     * 设置：编号
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取：编号
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置：真实姓名
     */
    public void setRealName(String realName) {
        this.realName = realName;
    }

    /**
     * 获取：真实姓名
     */
    public String getRealName() {
        return realName;
    }

    /**
     * 设置：性别(0-女，1-男)
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * 获取：性别(0-女，1-男)
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * 设置：照片
     */
    public void setPhoto(String photo) {
        this.photo = photo;
    }

    /**
     * 获取：照片
     */
    public String getPhoto() {
        return photo;
    }

    /**
     * 设置：联系电话
     */
    public void setContact(String contact) {
        this.contact = contact;
    }

    /**
     * 获取：联系电话
     */
    public String getContact() {
        return contact;
    }

    /**
     * 设置：备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 获取：备注
     */
    public String getRemark() {
        return remark;
    }


    /**
     * 获取添加人
     */
    public Long getAuthorId() {
        return authorId;
    }

    /**
     * 设置添加人
     */
    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    /**
     * 获取审核人
     */
    public Long getAuditorId() {
        return auditorId;
    }

    /**
     * 设置审核人
     */
    public void setAuditorId(Long auditorId) {
        this.auditorId = auditorId;
    }

    /**
     * 获取审核时间
     */
    public Date getAuditTime() {
        return auditTime;
    }

    /**
     * 设置审核时间
     */
    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    /**
     * 设置添加时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 获取添加时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取：创建者（管理员）
     */
    public SysUserEntity getAuthorSysUser() {
        return authorSysUser;
    }

    /**
     * 设置：创建者（管理员）
     */
    public void setAuthorSysUser(SysUserEntity authorSysUser) {
        this.authorSysUser = authorSysUser;
    }

    /**
     * 获取：审核者
     */
    public SysUserEntity getAuditorSysUser() {
        return auditorSysUser;
    }

    /**
     * 设置：审核者
     */
    public void setAuditorSysUser(SysUserEntity auditorSysUser) {
        this.auditorSysUser = auditorSysUser;
    }

    /**
     * 获取：行业人员职称
     */
    public List<IndustrySportsLevelEntity> getIndustrySportsLevels() {
        return industrySportsLevels;
    }

    /**
     * 设置：行业人员职称
     *
     * @param industrySportsLevels
     */
    public void setIndustrySportsLevels(List<IndustrySportsLevelEntity> industrySportsLevels) {
        this.industrySportsLevels = industrySportsLevels;
    }

    /**
     * 获取：身份证号码
     */
    public String getIdentityNumber() {
        return identityNumber;
    }

    /**
     * 设置：身份证号码
     *
     * @param identityNumber
     */
    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    /**
     * 获取：头衔文本
     */
    public String getSportLevelString() {
        return sportLevelString;
    }

    /**
     * 设置：头衔文本
     *
     * @param sportLevelString
     */
    public void setSportLevelString(String sportLevelString) {
        this.sportLevelString = sportLevelString;
    }

    /**
     * 获取：审核状态（0：待审核  1：通过  2：未通过）
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置：审核状态（0：待审核  1：通过  2：未通过）
     *
     * @param status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取：更新时间
     *
     * @return
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 设置：更新时间
     *
     * @param modifyTime
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

}
