package com.yymt.entity.sport;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 预约设置表
 * 
 * @author hgq
 * @date 2018-03-27 09:10:23
 */
@TableName("tb_appointment_set")
public class AppointmentSetEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键ID
	 */
	@TableId
	private Integer id;
	/**
	 * 上午设置
	 */
	private String morning;
	/**
	 * 中午设置
	 */
	private String afternoon;
	/**
	 * 晚上设置
	 */
	private String night;
	/**
	 * 咨询时间设置
	 */
	private Integer minute;
	/**
	 * 每周工作设置
	 */
	private String week;
	/**
	 * 专家ID
	 */
	private Long expertId;
	/**
	 * 费用
	 */
	private String fee;
	/**
	 * 设置时间
	 */
	private Date createTime;
	/**
	 * 更新时间
	 */
	private Date updateTime;

	public String getFee() {
		return fee;
	}

	public void setFee(String fee) {
		this.fee = fee;
	}

	/**
	 * 设置：主键ID
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：主键ID
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：上午设置
	 */
	public void setMorning(String morning) {
		this.morning = morning;
	}
	/**
	 * 获取：上午设置
	 */
	public String getMorning() {
		return morning;
	}
	/**
	 * 设置：中午设置
	 */
	public void setAfternoon(String afternoon) {
		this.afternoon = afternoon;
	}
	/**
	 * 获取：中午设置
	 */
	public String getAfternoon() {
		return afternoon;
	}
	/**
	 * 设置：晚上设置
	 */
	public void setNight(String night) {
		this.night = night;
	}
	/**
	 * 获取：晚上设置
	 */
	public String getNight() {
		return night;
	}
	/**
	 * 设置：咨询时间设置
	 */
	public void setMinute(Integer minute) {
		this.minute = minute;
	}
	/**
	 * 获取：咨询时间设置
	 */
	public Integer getMinute() {
		return minute;
	}
	/**
	 * 设置：每周工作设置
	 */
	public void setWeek(String week) {
		this.week = week;
	}
	/**
	 * 获取：每周工作设置
	 */
	public String getWeek() {
		return week;
	}
	/**
	 * 设置：专家ID
	 */
	public void setExpertId(Long expertId) {
		this.expertId = expertId;
	}
	/**
	 * 获取：专家ID
	 */
	public Long getExpertId() {
		return expertId;
	}
	/**
	 * 设置：设置时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：设置时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：更新时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：更新时间
	 */
	public Date getUpdateTime() {
		return updateTime;
	}
}
