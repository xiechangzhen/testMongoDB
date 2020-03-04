package com.yymt.entity.sport;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 体温上报
 * 
 * @author cots
 * @date 2020-02-06 10:05:06
 */
@TableName("tb_temperature")
@ApiModel(description="体温上报")
public class TemperatureEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	@ApiModelProperty(value="")
private Integer id;
	/**
	 * 
	 */
	@ApiModelProperty(value="")
private Float temperature;

	/**
	 * 症状
	 */
	private String symptomList;
	/**
	 * 
	 */
	@ApiModelProperty(value="")
private Date createtime;
	/**
	 * 
	 */
	@ApiModelProperty(value="")
private Long userid;
	/**
	 * 
	 */
	@ApiModelProperty(value="")
private String remark;

	public String getSymptomList() {
		return symptomList;
	}

	public void setSymptomList(String symptomList) {
		this.symptomList = symptomList;
	}

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
	 * 设置：
	 */
	public void setTemperature(Float temperature) {
		this.temperature = temperature;
	}
	/**
	 * 获取：
	 */
	public Float getTemperature() {
		return temperature;
	}
	/**
	 * 设置：
	 */
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	/**
	 * 获取：
	 */
	public Date getCreatetime() {
		return createtime;
	}
	/**
	 * 设置：
	 */
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	/**
	 * 获取：
	 */
	public Long getUserid() {
		return userid;
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
}
