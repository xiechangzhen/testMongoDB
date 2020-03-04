package com.yymt.entity.sport;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author keep
 * @date 2018/10/20 13:49
 */
@TableName("tb_organization_contact")
@ApiModel(description = "部门表 ")
public class OrganizationContactEntity implements Serializable {

    /**
     * 主键id
     * */
    @TableId
    @ApiModelProperty("主键id")
    private Integer id;
    /**
     * 机构id
     * */
    @ApiModelProperty("机构id")
    private Integer organizationId;
    /**
     * 部门名称
     * */
    @ApiModelProperty("部门名称")
    private String name;
    /**
     * 部门电话
     * */
    @ApiModelProperty("部门电话")
    private String contact;
    /**
     * 备注
     * */
    @ApiModelProperty("备注")
    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}

