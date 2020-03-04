package com.yymt.entity.sport;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

/**
 * 组织机构表
 *
 * @author cots
 * @date 2018-09-12 11:04:21
 */
@TableName("tb_organization")
@ApiModel(description = "组织机构表 ")
public class OrganizationEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @TableId
    @ApiModelProperty(value = "编号")
    private Integer id;
    /**
     * 组织名称
     */
    @ApiModelProperty(value = "组织名称")
    private String orgName;
    /**
     * 机构地址
     */
    @ApiModelProperty(value = "机构地址")
    private String address;
    /**
     * 职责
     */
    @ApiModelProperty(value = "职责")
    private String duty;
    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remark;

    /**
     * 状态
     * */
    @ApiModelProperty(value = "状态")
    private Integer status;
    /**
     * 审核人id
     * */
    @ApiModelProperty(value = "审核人id")
    private BigInteger auditorId;
    /**
     * 审核时间
     * */
    @ApiModelProperty(value = "审核时间")
    private Date auditTime;
    /**
     * 添加人id
     * */
    @ApiModelProperty(value = "添加人id")
    private BigInteger authorId;
    /**
     * 添加时间
     * */
    @ApiModelProperty(value = "添加时间")
    private Date createTime;
    /**
     * 区域编码
     * */
    @ApiModelProperty(value = "区域编码")
    private String orgArea;

    @TableField(exist=false)
    private List<OrganizationContactEntity> contactList;

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
     * 设置：组织名称
     */
    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    /**
     * 获取：组织名称
     */
    public String getOrgName() {
        return orgName;
    }

    /**
     * 设置：机构地址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取：机构地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置：职责
     */
    public void setDuty(String duty) {
        this.duty = duty;
    }

    /**
     * 获取：职责
     */
    public String getDuty() {
        return duty;
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
     * 获取：状态
     * */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置：状态
     * */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取：审核人id
     * */
    public BigInteger getAuditorId() {
        return auditorId;
    }

    /**
     * 设置：审核人id
     * */
    public void setAuditorId(BigInteger auditorId) {
        this.auditorId = auditorId;
    }

    /**
     * 获取：审核时间
     * */
    public Date getAuditTime() {
        return auditTime;
    }

    /**
     * 设置：审核时间
     * */
    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    /**
     * 获取：添加人id
     * */
    public BigInteger getAuthorId() {
        return authorId;
    }

    /**
     * 设置：添加人id
     * */
    public void setAuthorId(BigInteger authorId) {
        this.authorId = authorId;
    }

    /**
     * 获取：添加时间
     * */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置：添加时间
     * */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public List<OrganizationContactEntity> getContactList() {
        return contactList;
    }

    public String getOrgArea() {
        return orgArea;
    }

    public void setOrgArea(String orgArea) {
        this.orgArea = orgArea;
    }

    public void setContactList(List<OrganizationContactEntity> contactList) {
        this.contactList = contactList;
    }
}
