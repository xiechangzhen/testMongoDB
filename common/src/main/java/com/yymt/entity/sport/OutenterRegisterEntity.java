package com.yymt.entity.sport;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 出入登记表
 * 
 * @author xiaojin
 * @date 2020-02-15 19:54:50
 */
@TableName("tb_outenter_register")
@ApiModel(description = "出入登记表")
public class OutenterRegisterEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId
	@ApiModelProperty(value = "主键")
	private Long id;
	/**
	 * 用户id
	 */
	@ApiModelProperty(value = "用户id")
	private Long userId;
	/**
	 * 出入登记时间
	 */
	@ApiModelProperty(value = "出入登记时间")
	private Date registerTime;
	/**
	 * 人员性质：1表示从未离开本区人员，2表示外区入赣人员
	 */
	@ApiModelProperty(value = "人员性质：1表示从未离开本区人员，2表示外区入赣人员")
	private Integer personnelNature;
	/**
	 * 登记类型：1表示外出，2表示回家
	 */
	@ApiModelProperty(value = "登记类型：1表示外出，2表示回家")
	private Integer registerType;
	/**
	 * 与您关系：1表示本人，2表示亲属，3表示朋友，4表示同事，5表示其他
	 */
	@ApiModelProperty(value = "与您关系：1表示本人，2表示亲属，3表示朋友，4表示同事，5表示其他")
	private Integer withRelationship;
	/**
	 * 姓名
	 */
	@ApiModelProperty(value = "姓名")
	private String userName;
	/**
	 * 手机号码
	 */
	@ApiModelProperty(value = "手机号码")
	private String phoneNumber;
	/**
	 * 身份证号码
	 */
	@ApiModelProperty(value = "身份证号码")
	private String identityCard;
	/**
	 * 社区所在地
	 */
	@ApiModelProperty(value = "社区所在地")
	private String communityLocation;

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
	 * 设置：出入登记时间
	 */
	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}

	/**
	 * 获取：出入登记时间
	 */
	public Date getRegisterTime() {
		return registerTime;
	}

	/**
	 * 设置：人员性质：1表示从未离开本区人员，2表示外区入赣人员
	 */
	public void setPersonnelNature(Integer personnelNature) {
		this.personnelNature = personnelNature;
	}

	/**
	 * 获取：人员性质：1表示从未离开本区人员，2表示外区入赣人员
	 */
	public Integer getPersonnelNature() {
		return personnelNature;
	}

	/**
	 * 设置：登记类型：1表示外出，2表示回家
	 */
	public void setRegisterType(Integer registerType) {
		this.registerType = registerType;
	}

	/**
	 * 获取：登记类型：1表示外出，2表示回家
	 */
	public Integer getRegisterType() {
		return registerType;
	}

	/**
	 * 设置：与您关系：1表示本人，2表示亲属，3表示朋友，4表示同事，5表示其他
	 */
	public void setWithRelationship(Integer withRelationship) {
		this.withRelationship = withRelationship;
	}

	/**
	 * 获取：与您关系：1表示本人，2表示亲属，3表示朋友，4表示同事，5表示其他
	 */
	public Integer getWithRelationship() {
		return withRelationship;
	}

	/**
	 * 设置：姓名
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * 获取：姓名
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * 设置：手机号码
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * 获取：手机号码
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * 设置：身份证号码
	 */
	public void setIdentityCard(String identityCard) {
		this.identityCard = identityCard;
	}

	/**
	 * 获取：身份证号码
	 */
	public String getIdentityCard() {
		return identityCard;
	}

	/**
	 * 设置：社区所在地
	 */
	public void setCommunityLocation(String communityLocation) {
		this.communityLocation = communityLocation;
	}

	/**
	 * 获取：社区所在地
	 */
	public String getCommunityLocation() {
		return communityLocation;
	}
}
