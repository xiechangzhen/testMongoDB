package com.yymt.entity.sport;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 智能手表设备
 * 
 * @author hgq
 * @date 2018-02-09 08:58:21
 */
@TableName("tb_device")
public class DeviceEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 设备ID
	 */
	@TableId
	private Long smartwatchDevId;
	/**
	 * 厂商编号
	 */
	private String manuId;
	/**
	 * 设备在线状态
	 */
	private Integer devStaus;
	/**
	 * 
	 */
	private Date createTime;
	/**
	 * 
	 */
	private Date updateTime;
	/**
	 * 备注
	 */
	private String remark;

	/**
	 * 设置：设备ID
	 */
	public void setSmartwatchDevId(Long smartwatchDevId) {
		this.smartwatchDevId = smartwatchDevId;
	}
	/**
	 * 获取：设备ID
	 */
	public Long getSmartwatchDevId() {
		return smartwatchDevId;
	}
	/**
	 * 设置：厂商编号
	 */
	public void setManuId(String manuId) {
		this.manuId = manuId;
	}
	/**
	 * 获取：厂商编号
	 */
	public String getManuId() {
		return manuId;
	}
	/**
	 * 设置：设备在线状态
	 */
	public void setDevStaus(Integer devStaus) {
		this.devStaus = devStaus;
	}
	/**
	 * 获取：设备在线状态
	 */
	public Integer getDevStaus() {
		return devStaus;
	}
	/**
	 * 设置：
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：
	 */
	public Date getUpdateTime() {
		return updateTime;
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
