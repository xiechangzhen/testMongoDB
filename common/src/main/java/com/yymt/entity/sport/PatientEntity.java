package com.yymt.entity.sport;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 病历
 *
 * @author cots
 * @date 2020-02-07 17:31:39
 */
@TableName("tb_patient")
@ApiModel(description = "病历")
public class PatientEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    @TableId
    @ApiModelProperty(value = "")
    private Integer id;
    /**
     * 病例编号
     */
    @ApiModelProperty(value = "病例编号")
    private String no;
    /**
     * 确诊日期
     */
    @ApiModelProperty(value = "确诊日期")
    private Date diagnosisDate;
    /**
     * 经度
     */
    @ApiModelProperty(value = "经度")
    private String lng;
    /**
     * 纬度
     */
    @ApiModelProperty(value = "纬度")
    private String lat;
    /**
     *
     */
    @ApiModelProperty(value = "")
    private String address;
    /**
     *
     */
    @ApiModelProperty(value = "")
    private String remark;
    /**
     *
     */
    @ApiModelProperty(value = "")
    private String description;
    /**
     * 人员类型(0-确诊，1-隔离)
     */
    @ApiModelProperty(value = "人员类型(0-确诊，1-隔离)")
    private Integer type;

    /**
     * 设置：
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取：
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置：病例编号
     */
    public void setNo(String no) {
        this.no = no;
    }

    /**
     * 获取：病例编号
     */
    public String getNo() {
        return no;
    }

    /**
     * 设置：确诊日期
     */
    public void setDiagnosisDate(Date diagnosisDate) {
        this.diagnosisDate = diagnosisDate;
    }

    /**
     * 获取：确诊日期
     */
    public Date getDiagnosisDate() {
        return diagnosisDate;
    }

    /**
     * 设置：经度
     */
    public void setLng(String lng) {
        this.lng = lng;
    }

    /**
     * 获取：经度
     */
    public String getLng() {
        return lng;
    }

    /**
     * 设置：纬度
     */
    public void setLat(String lat) {
        this.lat = lat;
    }

    /**
     * 获取：纬度
     */
    public String getLat() {
        return lat;
    }

    /**
     * 设置：
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取：
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置：
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 获取：
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置：
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 获取：
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置：人员类型(0-确诊，1-隔离)
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取：人员类型(0-确诊，1-隔离)
     */
    public Integer getType() {
        return type;
    }
}
