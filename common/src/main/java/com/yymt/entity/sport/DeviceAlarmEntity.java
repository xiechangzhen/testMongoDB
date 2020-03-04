package com.yymt.entity.sport;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 智能手表报警数据
 * 
 * @author hgq
 * @date 2018-02-08 15:47:01
 */
@TableName("tb_device_alarm")
public class DeviceAlarmEntity implements Serializable {
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
	 * 报警时间
	 */
	private Date devAlarmTime;
	/**
	 * 报警类型(1：SOS报警；2：低电量报警)
	 */
	private Integer devAlarmType;
	/**
	 * 创建时间
	 */
	private Date devAlarmCreate;
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
	 * 设置：报警时间
	 */
	public void setDevAlarmTime(Date devAlarmTime) {
		this.devAlarmTime = devAlarmTime;
	}
	/**
	 * 获取：报警时间
	 */
	public Date getDevAlarmTime() {
		return devAlarmTime;
	}
	/**
	 * 设置：报警类型(1：SOS报警；2：低电量报警)
	 */
	public void setDevAlarmType(Integer devAlarmType) {
		this.devAlarmType = devAlarmType;
	}
	/**
	 * 获取：报警类型(1：SOS报警；2：低电量报警)
	 */
	public Integer getDevAlarmType() {
		return devAlarmType;
	}
	/**
	 * 设置：创建时间
	 */
	public void setDevAlarmCreate(Date devAlarmCreate) {
		this.devAlarmCreate = devAlarmCreate;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getDevAlarmCreate() {
		return devAlarmCreate;
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
