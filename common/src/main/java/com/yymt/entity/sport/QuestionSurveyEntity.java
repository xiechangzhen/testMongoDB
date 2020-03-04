package com.yymt.entity.sport;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 问卷调查表
 * 
 * @author xiaojin
 * @date 2020-02-13 14:41:41
 */
@TableName("tb_question_survey")
@ApiModel(description = "问卷调查表")
public class QuestionSurveyEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	@ApiModelProperty(value = "")
	private Long id;
	/**
	 * 用户id
	 */
	@ApiModelProperty(value = "用户id")
	private Long userId;
	/**
	 * 问卷调查创建时间
	 */
	@ApiModelProperty(value = "问卷调查创建时间")
	private Date createTime;
	/**
	 * 您好，请问您的姓名是？
	 */
	@ApiModelProperty(value = "您好，请问您的姓名是？")
	private String userName;
	/**
	 * 请问您的身份证是？
	 */
	@ApiModelProperty(value = "请问您的身份证是？")
	private String identityCard;
	/**
	 * 请问您是来看什么病的？
	 */
	@ApiModelProperty(value = "请问您是来看什么病的？")
	private String seeDoctor;
	/**
	 * 请问您的职业是什么？
	 */
	@ApiModelProperty(value = "请问您的职业是什么？")
	private String userJob;
	/**
	 * 请问您近三天有发热吗
	 */
	@ApiModelProperty(value = "请问您近三天有发热吗")
	private String isFever;
	/**
	 * 最高体温多少度？
	 */
	@ApiModelProperty(value = "最高体温多少度？")
	private String temperature;
	/**
	 * 请问您最近三天有以下不适的症状反应吗？【多选】
	 */
	@ApiModelProperty(value = "请问您最近三天有以下不适的症状反应吗？【多选】")
	private String unComfortable;
	/**
	 * 其他
	 */
	@ApiModelProperty(value = "其他")
	private String other;
	/**
	 * 请问您所居住的小区或村庄有确诊的新冠病毒肺炎患者或疑似新冠病毒肺炎患者吗？
	 */
	@ApiModelProperty(value = "请问您所居住的小区或村庄有确诊的新冠病毒肺炎患者或疑似新冠病毒肺炎患者吗？")
	private String isPneumonia;
	/**
	 * 请问您去过武汉吗？
	 */
	@ApiModelProperty(value = "请问您去过武汉吗？")
	private String beenWuhan;
	/**
	 * 请问您接触过武汉来的人吗？
	 */
	@ApiModelProperty(value = "请问您接触过武汉来的人吗？")
	private String contactWuhan;
	/**
	 * 请问您家里有武汉来的客人吗？
	 */
	@ApiModelProperty(value = "请问您家里有武汉来的客人吗？")
	private String guestWuhan;
	/**
	 * 分数
	 */
	@ApiModelProperty(value = "分数")
	private Integer questionScore;

	/**
	 * 设置：
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 获取：
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
	 * 设置：问卷调查创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * 获取：问卷调查创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * 设置：您好，请问您的姓名是？
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * 获取：您好，请问您的姓名是？
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * 设置：请问您的身份证是？
	 */
	public void setIdentityCard(String identityCard) {
		this.identityCard = identityCard;
	}

	/**
	 * 获取：请问您的身份证是？
	 */
	public String getIdentityCard() {
		return identityCard;
	}

	/**
	 * 设置：请问您是来看什么病的？
	 */
	public void setSeeDoctor(String seeDoctor) {
		this.seeDoctor = seeDoctor;
	}

	/**
	 * 获取：请问您是来看什么病的？
	 */
	public String getSeeDoctor() {
		return seeDoctor;
	}

	/**
	 * 设置：请问您的职业是什么？
	 */
	public void setUserJob(String userJob) {
		this.userJob = userJob;
	}

	/**
	 * 获取：请问您的职业是什么？
	 */
	public String getUserJob() {
		return userJob;
	}

	/**
	 * 设置：请问您近三天有发热吗
	 */
	public void setIsFever(String isFever) {
		this.isFever = isFever;
	}

	/**
	 * 获取：请问您近三天有发热吗
	 */
	public String getIsFever() {
		return isFever;
	}

	/**
	 * 设置：最高体温多少度？
	 */
	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	/**
	 * 获取：最高体温多少度？
	 */
	public String getTemperature() {
		return temperature;
	}

	/**
	 * 设置：请问您最近三天有以下不适的症状反应吗？【多选】
	 */
	public void setUnComfortable(String unComfortable) {
		this.unComfortable = unComfortable;
	}

	/**
	 * 获取：请问您最近三天有以下不适的症状反应吗？【多选】
	 */
	public String getUnComfortable() {
		return unComfortable;
	}

	/**
	 * 设置：其他
	 */
	public void setOther(String other) {
		this.other = other;
	}

	/**
	 * 获取：其他
	 */
	public String getOther() {
		return other;
	}

	/**
	 * 设置：请问您所居住的小区或村庄有确诊的新冠病毒肺炎患者或疑似新冠病毒肺炎患者吗？
	 */
	public void setIsPneumonia(String isPneumonia) {
		this.isPneumonia = isPneumonia;
	}

	/**
	 * 获取：请问您所居住的小区或村庄有确诊的新冠病毒肺炎患者或疑似新冠病毒肺炎患者吗？
	 */
	public String getIsPneumonia() {
		return isPneumonia;
	}

	/**
	 * 设置：请问您去过武汉吗？
	 */
	public void setBeenWuhan(String beenWuhan) {
		this.beenWuhan = beenWuhan;
	}

	/**
	 * 获取：请问您去过武汉吗？
	 */
	public String getBeenWuhan() {
		return beenWuhan;
	}

	/**
	 * 设置：请问您接触过武汉来的人吗？
	 */
	public void setContactWuhan(String contactWuhan) {
		this.contactWuhan = contactWuhan;
	}

	/**
	 * 获取：请问您接触过武汉来的人吗？
	 */
	public String getContactWuhan() {
		return contactWuhan;
	}

	/**
	 * 设置：请问您家里有武汉来的客人吗？
	 */
	public void setGuestWuhan(String guestWuhan) {
		this.guestWuhan = guestWuhan;
	}

	/**
	 * 获取：请问您家里有武汉来的客人吗？
	 */
	public String getGuestWuhan() {
		return guestWuhan;
	}

	/**
	 * 设置：分数
	 */
	public void setQuestionScore(Integer questionScore) {
		this.questionScore = questionScore;
	}

	/**
	 * 获取：分数
	 */
	public Integer getQuestionScore() {
		return questionScore;
	}
}
