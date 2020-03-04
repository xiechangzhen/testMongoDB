package com.yymt.entity.sport;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 预约时间表
 *
 * @author hgq
 * @date 2018-03-28 09:14:22
 */
@TableName("tb_appointment_schedule")
public class AppointmentScheduleEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键ID
	 */
	@TableId
	private Integer id;
	/**
	 * 专家ID
	 */
	private Long expertId;
	/**
	 * 预约用户ID
	 */
	private Long userId;
	/**
	 * 预约日期
	 */
	private String appointmentDate;
	/**
	 * 预约星期
	 */
	private String appointmentWeek;
	/**
	 * 预约时间段
	 */
	private String appointmentPeriod;
	/**
	 * 预约起始时间
	 */
	private Date appointmentStartTime;
	/**
	 * 预约结束时间
	 */
	private Date appointmentEndTime;
	/**
	 * 是否被预约（0-未选,1-已选）
	 */
	private Integer isChecked;
	/**
	 * 预约时间
	 */
	private Date chooseTime;

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
	 * 设置：预约用户ID
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * 获取：预约用户ID
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * 设置：预约日期
	 */
	public void setAppointmentDate(String appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	/**
	 * 获取：预约日期
	 */
	public String getAppointmentDate() {
		return appointmentDate;
	}
	/**
	 * 设置：预约星期
	 */
	public void setAppointmentWeek(String appointmentWeek) {
		this.appointmentWeek = appointmentWeek;
	}
	/**
	 * 获取：预约星期
	 */
	public String getAppointmentWeek() {
		return appointmentWeek;
	}
	/**
	 * 设置：预约时间段
	 */
	public void setAppointmentPeriod(String appointmentPeriod) {
		this.appointmentPeriod = appointmentPeriod;
	}
	/**
	 * 获取：预约时间段
	 */
	public String getAppointmentPeriod() {
		return appointmentPeriod;
	}
	/**
	 * 设置：预约起始时间
	 */
	public void setAppointmentStartTime(Date appointmentStartTime) {
		this.appointmentStartTime = appointmentStartTime;
	}
	/**
	 * 获取：预约起始时间
	 */
	public Date getAppointmentStartTime() {
		return appointmentStartTime;
	}
	/**
	 * 设置：预约结束时间
	 */
	public void setAppointmentEndTime(Date appointmentEndTime) {
		this.appointmentEndTime = appointmentEndTime;
	}
	/**
	 * 获取：预约结束时间
	 */
	public Date getAppointmentEndTime() {
		return appointmentEndTime;
	}
	/**
	 * 设置：是否被预约（0-未选,1-已选）
	 */
	public void setIsChecked(Integer isChecked) {
		this.isChecked = isChecked;
	}
	/**
	 * 获取：是否被预约（0-未选,1-已选）
	 */
	public Integer getIsChecked() {
		return isChecked;
	}
	/**
	 * 设置：预约时间
	 */
	public void setChooseTime(Date chooseTime) {
		this.chooseTime = chooseTime;
	}
	/**
	 * 获取：预约时间
	 */
	public Date getChooseTime() {
		return chooseTime;
	}
}
