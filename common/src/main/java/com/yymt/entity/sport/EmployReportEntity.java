package com.yymt.entity.sport;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 员工信息上报
 * 
 * @author cots
 * @date 2020-02-02 13:37:24
 */
@TableName("tb_employ_report")
@ApiModel(description="员工信息上报")
public class EmployReportEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	@ApiModelProperty(value="")
private Integer id;
	/**
	 * 联系方式
	 */
	@ApiModelProperty(value="联系方式")
private String contact;
	/**
	 * 当前位置
	 */
	@ApiModelProperty(value="当前位置")
private String address;
	/**
	 * 体温
	 */
	@ApiModelProperty(value="体温")
private Float temperature;
	/**
	 * 是否自我隔离
	 */
	@ApiModelProperty(value="是否自我隔离")
private Integer isquarantine;
	/**
	 * 能否正常到岗
	 */
	@ApiModelProperty(value="能否正常到岗")
private Integer isarrive;
	/**
	 * 上报时间
	 */
	@ApiModelProperty(value="上报时间")
private Date createtime;
	/**
	 * 员工工号
	 */
	@ApiModelProperty(value="员工工号")
private Integer employid;
	/**
	 * 
	 */
	@ApiModelProperty(value="")
private String longitude;
	/**
	 * 
	 */
	@ApiModelProperty(value="")
private String latitude;

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
	 * 设置：联系方式
	 */
	public void setContact(String contact) {
		this.contact = contact;
	}
	/**
	 * 获取：联系方式
	 */
	public String getContact() {
		return contact;
	}
	/**
	 * 设置：当前位置
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * 获取：当前位置
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * 设置：体温
	 */
	public void setTemperature(Float temperature) {
		this.temperature = temperature;
	}
	/**
	 * 获取：体温
	 */
	public Float getTemperature() {
		return temperature;
	}
	/**
	 * 设置：是否自我隔离
	 */
	public void setIsquarantine(Integer isquarantine) {
		this.isquarantine = isquarantine;
	}
	/**
	 * 获取：是否自我隔离
	 */
	public Integer getIsquarantine() {
		return isquarantine;
	}
	/**
	 * 设置：能否正常到岗
	 */
	public void setIsarrive(Integer isarrive) {
		this.isarrive = isarrive;
	}
	/**
	 * 获取：能否正常到岗
	 */
	public Integer getIsarrive() {
		return isarrive;
	}
	/**
	 * 设置：上报时间
	 */
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	/**
	 * 获取：上报时间
	 */
	public Date getCreatetime() {
		return createtime;
	}
	/**
	 * 设置：员工工号
	 */
	public void setEmployid(Integer employid) {
		this.employid = employid;
	}
	/**
	 * 获取：员工工号
	 */
	public Integer getEmployid() {
		return employid;
	}
	/**
	 * 设置：
	 */
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	/**
	 * 获取：
	 */
	public String getLongitude() {
		return longitude;
	}
	/**
	 * 设置：
	 */
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	/**
	 * 获取：
	 */
	public String getLatitude() {
		return latitude;
	}
}
