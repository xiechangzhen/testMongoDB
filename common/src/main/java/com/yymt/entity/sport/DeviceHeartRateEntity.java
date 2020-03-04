package com.yymt.entity.sport;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 智能手表设备监测到的心率上报数据
 * 
 * @author hgq
 * @date 2018-02-08 15:47:01
 */
@TableName("tb_device_heart_rate")
public class DeviceHeartRateEntity implements Serializable {
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
	 * 测到的心率
	 */
	private Integer devHeartRate;
	/**
	 * 创建时间
	 */
	private Date devHeartRateTime;
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
	 * 设置：测到的心率
	 */
	public void setDevHeartRate(Integer devHeartRate) {
		this.devHeartRate = devHeartRate;
	}
	/**
	 * 获取：测到的心率
	 */
	public Integer getDevHeartRate() {
		return devHeartRate;
	}
	/**
	 * 设置：创建时间
	 */
	public void setDevHeartRateTime(Date devHeartRateTime) {
		this.devHeartRateTime = devHeartRateTime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getDevHeartRateTime() {
		return devHeartRateTime;
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
