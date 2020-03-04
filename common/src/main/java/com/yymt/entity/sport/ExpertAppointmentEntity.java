package com.yymt.entity.sport;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 专家预约
 *
 * @author hgq
 * @date 2018-03-15 15:49:32
 */
@TableName("tb_expert_appointment")
public class ExpertAppointmentEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId
	private Integer id;
	/**
	 * 预约者真实姓名
	 */
	private String appointmentRealName;
	/**
	 * 预约者年龄
	 */
	private Integer appointmentAge;
	/**
	 * 预约者性别(0-男，1-女)
	 */
	private Integer appointmentSex;
	/**
	 * 预约者手机号码
	 */
	private String appointmentMobile;
	/**
	 * 预约者职业
	 */
	private String appointmentProfession;
	/**
	 * 预约者问题描述
	 */
	private String appointmentProblemDescription;
	/**
	 * 预约起始时间
	 */
	private Date appointmentStartDate;
	/**
	 * 预约结束时间
	 */
	private Date appointmentEndDate;
	/**
	 * 预约状态(0-预约中,1-待评价,2-已评价,3-取消预约)
	 */
	private Integer appointmentStatus;
	/**
	 * 被预约专家ID(用户ID)
	 */
	private Long appointmentExpertUserId;
	/**
	 * 预约用户ID
	 */
	private Long appointmentUserId;
	/**
	 * 评价内容
	 */
	private String appointmentComment;
	/**
	 * 评价得分（5-五星，4-四星，3-三星，2-二星，1-一星，0-无星）
	 */
	private Integer appointmentScore;
	/**
	 * 评价时间
	 */
	private Date appointmentCommentTime;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 备注
	 */
	private String remark;

	/**
	 * 设置：主键
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：主键
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：预约者真实姓名
	 */
	public void setAppointmentRealName(String appointmentRealName) {
		this.appointmentRealName = appointmentRealName;
	}
	/**
	 * 获取：预约者真实姓名
	 */
	public String getAppointmentRealName() {
		return appointmentRealName;
	}
	/**
	 * 设置：预约者年龄
	 */
	public void setAppointmentAge(Integer appointmentAge) {
		this.appointmentAge = appointmentAge;
	}
	/**
	 * 获取：预约者年龄
	 */
	public Integer getAppointmentAge() {
		return appointmentAge;
	}
	/**
	 * 设置：预约者性别(0-男，1-女)
	 */
	public void setAppointmentSex(Integer appointmentSex) {
		this.appointmentSex = appointmentSex;
	}
	/**
	 * 获取：预约者性别(0-男，1-女)
	 */
	public Integer getAppointmentSex() {
		return appointmentSex;
	}
	/**
	 * 设置：预约者手机号码
	 */
	public void setAppointmentMobile(String appointmentMobile) {
		this.appointmentMobile = appointmentMobile;
	}
	/**
	 * 获取：预约者手机号码
	 */
	public String getAppointmentMobile() {
		return appointmentMobile;
	}
	/**
	 * 设置：预约者职业
	 */
	public void setAppointmentProfession(String appointmentProfession) {
		this.appointmentProfession = appointmentProfession;
	}
	/**
	 * 获取：预约者职业
	 */
	public String getAppointmentProfession() {
		return appointmentProfession;
	}
	/**
	 * 设置：预约者问题描述
	 */
	public void setAppointmentProblemDescription(String appointmentProblemDescription) {
		this.appointmentProblemDescription = appointmentProblemDescription;
	}
	/**
	 * 获取：预约者问题描述
	 */
	public String getAppointmentProblemDescription() {
		return appointmentProblemDescription;
	}
	/**
	 * 设置：预约起始时间
	 */
	public void setAppointmentStartDate(Date appointmentStartDate) {
		this.appointmentStartDate = appointmentStartDate;
	}
	/**
	 * 获取：预约起始时间
	 */
	public Date getAppointmentStartDate() {
		return appointmentStartDate;
	}
	/**
	 * 设置：预约结束时间
	 */
	public void setAppointmentEndDate(Date appointmentEndDate) {
		this.appointmentEndDate = appointmentEndDate;
	}
	/**
	 * 获取：预约结束时间
	 */
	public Date getAppointmentEndDate() {
		return appointmentEndDate;
	}
	/**
	 * 设置：预约状态(0-预约中,1-待评价,2-已评价)
	 */
	public void setAppointmentStatus(Integer appointmentStatus) {
		this.appointmentStatus = appointmentStatus;
	}
	/**
	 * 获取：预约状态(0-预约中,1-待评价,2-已评价)
	 */
	public Integer getAppointmentStatus() {
		return appointmentStatus;
	}
	/**
	 * 设置：被预约专家ID(用户ID)
	 */
	public void setAppointmentExpertUserId(Long appointmentExpertUserId) {
		this.appointmentExpertUserId = appointmentExpertUserId;
	}
	/**
	 * 获取：被预约专家ID(用户ID)
	 */
	public Long getAppointmentExpertUserId() {
		return appointmentExpertUserId;
	}
	/**
	 * 设置：预约用户ID
	 */
	public void setAppointmentUserId(Long appointmentUserId) {
		this.appointmentUserId = appointmentUserId;
	}
	/**
	 * 获取：预约用户ID
	 */
	public Long getAppointmentUserId() {
		return appointmentUserId;
	}
	/**
	 * 设置：评价内容
	 */
	public void setAppointmentComment(String appointmentComment) {
		this.appointmentComment = appointmentComment;
	}
	/**
	 * 获取：评价内容
	 */
	public String getAppointmentComment() {
		return appointmentComment;
	}
	/**
	 * 设置：评价得分（5-五星，4-四星，3-三星，2-二星，1-一星，0-无星）
	 */
	public void setAppointmentScore(Integer appointmentScore) {
		this.appointmentScore = appointmentScore;
	}
	/**
	 * 获取：评价得分（5-五星，4-四星，3-三星，2-二星，1-一星，0-无星）
	 */
	public Integer getAppointmentScore() {
		return appointmentScore;
	}
	/**
	 * 设置：评价时间
	 */
	public void setAppointmentCommentTime(Date appointmentCommentTime) {
		this.appointmentCommentTime = appointmentCommentTime;
	}
	/**
	 * 获取：评价时间
	 */
	public Date getAppointmentCommentTime() {
		return appointmentCommentTime;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateTime() {
		return createTime;
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
