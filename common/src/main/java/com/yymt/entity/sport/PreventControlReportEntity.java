package com.yymt.entity.sport;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 防控报备表
 * 
 * @author xiaojin
 * @date 2020-02-12 17:12:41
 */
@TableName("tb_prevent_control_report")
@ApiModel(description = "防控报备表")
public class PreventControlReportEntity implements Serializable {
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
	 * 防控报备创建时间
	 */
	@ApiModelProperty(value = "防控报备创建时间")
	private Date createTime;
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
	 * 交通方式
	 */
	@ApiModelProperty(value = "交通方式")
	private String trafficWay;
	/**
	 * 交通信息
	 */
	@ApiModelProperty(value = "交通信息")
	private String trafficInfo;
	/**
	 * 从哪里来
	 */
	@ApiModelProperty(value = "从哪里来")
	private String whereFrom;
	/**
	 * 从哪里来行政区代码
	 */
	@ApiModelProperty(value = "从哪里来行政区代码")
	private Integer whereFromCode;
	/**
	 * 到哪里去
	 */
	@ApiModelProperty(value = "到哪里去")
	private String whereGo;
	/**
	 * 到哪里去行政区代码
	 */
	@ApiModelProperty(value = "到哪里去行政区代码")
	private Integer whereGoCode;
	/**
	 * 到哪里去经度
	 */
	@ApiModelProperty(value = "到哪里去经度")
	private String longitude;
	/**
	 * 到哪里去纬度
	 */
	@ApiModelProperty(value = "到哪里去纬度")
	private String latitude;
	/**
	 * 是否与疫区人员接触
	 */
	@ApiModelProperty(value = "是否与疫区人员接触")
	private Integer isEpidemicContact;
	/**
	 * 是否与确诊何疑似病人有接触
	 */
	@ApiModelProperty(value = "是否与确诊何疑似病人有接触")
	private Integer isDiagnosisContact;
	/**
	 * 14天内是否有发热症状
	 */
	@ApiModelProperty(value = "14天内是否有发热症状")
	private Integer isFever;
	/**
	 * 体温测量
	 */
	@ApiModelProperty(value = "体温测量")
	private Integer temperatureMeasure;

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
	 * 设置：防控报备创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * 获取：防控报备创建时间
	 */
	public Date getCreateTime() {
		return createTime;
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
	 * 设置：交通方式
	 */
	public void setTrafficWay(String trafficWay) {
		this.trafficWay = trafficWay;
	}

	/**
	 * 获取：交通方式
	 */
	public String getTrafficWay() {
		return trafficWay;
	}

	/**
	 * 设置：交通信息
	 */
	public void setTrafficInfo(String trafficInfo) {
		this.trafficInfo = trafficInfo;
	}

	/**
	 * 获取：交通信息
	 */
	public String getTrafficInfo() {
		return trafficInfo;
	}

	/**
	 * 设置：从哪里来
	 */
	public void setWhereFrom(String whereFrom) {
		this.whereFrom = whereFrom;
	}

	/**
	 * 获取：从哪里来
	 */
	public String getWhereFrom() {
		return whereFrom;
	}

	/**
	 * 设置：从哪里来行政区代码
	 */
	public void setWhereFromCode(Integer whereFromCode) {
		this.whereFromCode = whereFromCode;
	}

	/**
	 * 获取：从哪里来行政区代码
	 */
	public Integer getWhereFromCode() {
		return whereFromCode;
	}

	/**
	 * 设置：到哪里去
	 */
	public void setWhereGo(String whereGo) {
		this.whereGo = whereGo;
	}

	/**
	 * 获取：到哪里去
	 */
	public String getWhereGo() {
		return whereGo;
	}

	/**
	 * 设置：到哪里去行政区代码
	 */
	public void setWhereGoCode(Integer whereGoCode) {
		this.whereGoCode = whereGoCode;
	}

	/**
	 * 获取：到哪里去行政区代码
	 */
	public Integer getWhereGoCode() {
		return whereGoCode;
	}

	/**
	 * 设置：到哪里去经度
	 */
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	/**
	 * 获取：到哪里去经度
	 */
	public String getLongitude() {
		return longitude;
	}

	/**
	 * 设置：到哪里去纬度
	 */
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	/**
	 * 获取：到哪里去纬度
	 */
	public String getLatitude() {
		return latitude;
	}

	/**
	 * 设置：是否与疫区人员接触
	 */
	public void setIsEpidemicContact(Integer isEpidemicContact) {
		this.isEpidemicContact = isEpidemicContact;
	}

	/**
	 * 获取：是否与疫区人员接触
	 */
	public Integer getIsEpidemicContact() {
		return isEpidemicContact;
	}

	/**
	 * 设置：是否与确诊何疑似病人有接触
	 */
	public void setIsDiagnosisContact(Integer isDiagnosisContact) {
		this.isDiagnosisContact = isDiagnosisContact;
	}

	/**
	 * 获取：是否与确诊何疑似病人有接触
	 */
	public Integer getIsDiagnosisContact() {
		return isDiagnosisContact;
	}

	/**
	 * 设置：14天内是否有发热症状
	 */
	public void setIsFever(Integer isFever) {
		this.isFever = isFever;
	}

	/**
	 * 获取：14天内是否有发热症状
	 */
	public Integer getIsFever() {
		return isFever;
	}

	/**
	 * 设置：体温测量
	 */
	public void setTemperatureMeasure(Integer temperatureMeasure) {
		this.temperatureMeasure = temperatureMeasure;
	}

	/**
	 * 获取：体温测量
	 */
	public Integer getTemperatureMeasure() {
		return temperatureMeasure;
	}
}
