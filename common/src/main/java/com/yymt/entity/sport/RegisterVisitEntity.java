package com.yymt.entity.sport;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 登记拜访表
 * 
 * @author xiaojin
 * @date 2020-02-21 13:04:15
 */
@TableName("tb_register_visit")
@ApiModel(description = "登记拜访表")
public class RegisterVisitEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId
	@ApiModelProperty(value = "主键")
	private Long id;
	/**
	 * 访客姓名
	 */
	@ApiModelProperty(value = "访客姓名")
	private String visitorName;
	/**
	 * 用户id
	 */
	@ApiModelProperty(value = "用户id")
	private Long userId;
	/**
	 * 拜访时间
	 */
	@ApiModelProperty(value = "拜访时间")
	private Date visitTime;
	/**
	 * 访客联系电话
	 */
	@ApiModelProperty(value = "访客联系电话")
	private String vistorTelephone;
	/**
	 * 访客身份证
	 */
	@ApiModelProperty(value = "访客身份证")
	private String identityCard;
	/**
	 * 拜访部门
	 */
	@ApiModelProperty(value = "拜访部门")
	private String visitDept;
	/**
	 * 拜访人员
	 */
	@ApiModelProperty(value = "拜访人员")
	private String visitPersonnel;
	/**
	 * 访客车牌号
	 */
	@ApiModelProperty(value = "访客车牌号")
	private String vistorCarNumber;
	/**
	 * 访客事由
	 */
	@ApiModelProperty(value = "访客事由")
	private String vistorCause;
	/**
	 * 访客单位
	 */
	@ApiModelProperty(value = "访客单位")
	private String vistorCompany;

	/**
	 * 设置：主键
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 获取：主键
	 */
	public Long getId() {
		return id;
	}

	/**
	 * 设置：访客姓名
	 */
	public void setVisitorName(String visitorName) {
		this.visitorName = visitorName;
	}

	/**
	 * 获取：访客姓名
	 */
	public String getVisitorName() {
		return visitorName;
	}

	/**
	 * 设置：用户id
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * 获取：用户id
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * 设置：拜访时间
	 */
	public void setVisitTime(Date visitTime) {
		this.visitTime = visitTime;
	}

	/**
	 * 获取：拜访时间
	 */
	public Date getVisitTime() {
		return visitTime;
	}

	/**
	 * 设置：访客联系电话
	 */
	public void setVistorTelephone(String vistorTelephone) {
		this.vistorTelephone = vistorTelephone;
	}

	/**
	 * 获取：访客联系电话
	 */
	public String getVistorTelephone() {
		return vistorTelephone;
	}

	/**
	 * 设置：访客身份证
	 */
	public void setIdentityCard(String identityCard) {
		this.identityCard = identityCard;
	}

	/**
	 * 获取：访客身份证
	 */
	public String getIdentityCard() {
		return identityCard;
	}

	/**
	 * 设置：拜访部门
	 */
	public void setVisitDept(String visitDept) {
		this.visitDept = visitDept;
	}

	/**
	 * 获取：拜访部门
	 */
	public String getVisitDept() {
		return visitDept;
	}

	/**
	 * 设置：拜访人员
	 */
	public void setVisitPersonnel(String visitPersonnel) {
		this.visitPersonnel = visitPersonnel;
	}

	/**
	 * 获取：拜访人员
	 */
	public String getVisitPersonnel() {
		return visitPersonnel;
	}

	/**
	 * 设置：访客车牌号
	 */
	public void setVistorCarNumber(String vistorCarNumber) {
		this.vistorCarNumber = vistorCarNumber;
	}

	/**
	 * 获取：访客车牌号
	 */
	public String getVistorCarNumber() {
		return vistorCarNumber;
	}

	/**
	 * 设置：访客事由
	 */
	public void setVistorCause(String vistorCause) {
		this.vistorCause = vistorCause;
	}

	/**
	 * 获取：访客事由
	 */
	public String getVistorCause() {
		return vistorCause;
	}

	/**
	 * 设置：访客单位
	 */
	public void setVistorCompany(String vistorCompany) {
		this.vistorCompany = vistorCompany;
	}

	/**
	 * 获取：访客单位
	 */
	public String getVistorCompany() {
		return vistorCompany;
	}
}
