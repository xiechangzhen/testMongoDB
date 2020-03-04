package com.yymt.entity.sport;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 智能手表设备位置上报数据
 * 
 * @author hgq
 * @date 2018-02-08 15:47:01
 */
@TableName("tb_device_gps")
public class DeviceGpsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 设备主键
	 */
	private Long devId;
	/**
	 * 西经
	 */
	private Float devGpsLongitude;
	/**
	 * 北纬
	 */
	private Float devGpsLatitude;
	/**
	 * 速度，单位是公里/小时
	 */
	private Float devGpsSpeed;
	/**
	 * 定位上传时间
	 */
	private Date devGpsLocationTime;
	/**
	 * 创建时间
	 */
	private Date devGpsCreate;
	/**
	 * 备注
	 */
	private String remark;

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
	 * 设置：设备主键
	 */
	public void setDevId(Long devId) {
		this.devId = devId;
	}
	/**
	 * 获取：设备主键
	 */
	public Long getDevId() {
		return devId;
	}
	/**
	 * 设置：西经
	 */
	public void setDevGpsLongitude(Float devGpsLongitude) {
		this.devGpsLongitude = devGpsLongitude;
	}
	/**
	 * 获取：西经
	 */
	public Float getDevGpsLongitude() {
		return devGpsLongitude;
	}
	/**
	 * 设置：北纬
	 */
	public void setDevGpsLatitude(Float devGpsLatitude) {
		this.devGpsLatitude = devGpsLatitude;
	}
	/**
	 * 获取：北纬
	 */
	public Float getDevGpsLatitude() {
		return devGpsLatitude;
	}
	/**
	 * 设置：速度，单位是公里/小时
	 */
	public void setDevGpsSpeed(Float devGpsSpeed) {
		this.devGpsSpeed = devGpsSpeed;
	}
	/**
	 * 获取：速度，单位是公里/小时
	 */
	public Float getDevGpsSpeed() {
		return devGpsSpeed;
	}
	/**
	 * 设置：定位上传时间
	 */
	public void setDevGpsLocationTime(Date devGpsLocationTime) {
		this.devGpsLocationTime = devGpsLocationTime;
	}
	/**
	 * 获取：定位上传时间
	 */
	public Date getDevGpsLocationTime() {
		return devGpsLocationTime;
	}
	/**
	 * 设置：创建时间
	 */
	public void setDevGpsCreate(Date devGpsCreate) {
		this.devGpsCreate = devGpsCreate;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getDevGpsCreate() {
		return devGpsCreate;
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
}
