package com.yymt.entity.api;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import com.yymt.entity.sys.SysUserEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户身份表
 *
 * @author cots
 * @date 2018-12-13 10:14:43
 */
@TableName("tb_user_position")
@ApiModel(description = "用户身份表")
public class UserPositionEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 标识
     */
    @TableId
    @ApiModelProperty(value = "标识")
    private Integer id;
    /**
     * 用户标识
     */
    @ApiModelProperty(value = "用户标识")
    private Long userId;
    /**
     * 身份（1：社团管理员；2：场馆管理员；3：教练；4：商家；）
     */
    @ApiModelProperty(value = "身份（1：社团管理员；2：场馆管理员；3：教练；4：商家；）")
    private Integer userPosition;
    /**
     * 状态（0：待审核；1：审核通过；2：未通过）
     */
    @ApiModelProperty(value = "状态（0：待审核；1：审核通过；2：未通过）")
    private Integer positionStatus;
    /**
     * 审核者标识
     */
    @ApiModelProperty(value = "审核者标识")
    private Long auditUserId;
    /**
     * 审核时间
     */
    @ApiModelProperty(value = "审核时间")
    private Date auditTime;
    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remark;

    /**
     * 入驻时间
     */
    @ApiModelProperty(value = "入驻时间")
    private Date createTime;

    /**
     * 修改时间
     */
    @ApiModelProperty(value = "修改时间")
    private Date modifyTime;

    /**
     * 审核者信息
     */
    @TableField(exist = false)
    private SysUserEntity auditorSysUser;

    /**
     * 设置：标识
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取：标识
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置：用户标识
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取：用户标识
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置：身份（1：社团管理员；2：场馆管理员；3：教练；4：商家；）
     */
    public void setUserPosition(Integer userPosition) {
        this.userPosition = userPosition;
    }

    /**
     * 获取：身份（1：社团管理员；2：场馆管理员；3：教练；4：商家；）
     */
    public Integer getUserPosition() {
        return userPosition;
    }

    /**
     * 设置：状态（0：待审核；1：审核通过；2：未通过）
     */
    public void setPositionStatus(Integer positionStatus) {
        this.positionStatus = positionStatus;
    }

    /**
     * 获取：状态（0：待审核；1：审核通过；2：未通过）
     */
    public Integer getPositionStatus() {
        return positionStatus;
    }

    /**
     * 设置：审核者标识
     */
    public void setAuditUserId(Long auditUserId) {
        this.auditUserId = auditUserId;
    }

    /**
     * 获取：审核者标识
     */
    public Long getAuditUserId() {
        return auditUserId;
    }

    /**
     * 设置：审核时间
     */
    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    /**
     * 获取：审核时间
     */
    public Date getAuditTime() {
        return auditTime;
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
     * 获取：入驻时间
     *
     * @return
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置：入驻时间
     *
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取：修改时间
     *
     * @return
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 设置：修改时间
     *
     * @return
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * 获取：审核者信息
     *
     * @return
     */
    public SysUserEntity getAuditorSysUser() {
        return auditorSysUser;
    }

    /**
     * 设置：审核者信息
     *
     * @param auditorSysUser
     */
    public void setAuditorSysUser(SysUserEntity auditorSysUser) {
        this.auditorSysUser = auditorSysUser;
    }
}
