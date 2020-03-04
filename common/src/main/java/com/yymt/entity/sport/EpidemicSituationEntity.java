package com.yymt.entity.sport;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;

import java.io.Serializable;
import java.util.Date;

/**
 * 疫情上报信息表
 * 
 * @author cots
 * @date 2020-01-28 17:28:09
 */
@TableName("tb_epidemic_situation")
@ApiModel(description="疫情上报信息表")
public class EpidemicSituationEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	@ApiModelProperty(value="")
private Integer id;
	/**
	 * 姓名
	 */
	@ApiModelProperty(value="姓名")
private String name;


	/**
	 * 人员类型
	 */
	@ApiModelProperty(value="人员类型")
	private String personType;
	/**
	 * 是否有湖北旅居史
	 */
	@ApiModelProperty(value="是否有湖北旅居史")
	private String isHbJourney;

	/**
	 * 是否有如下症状
	 */
	@ApiModelProperty(value="是否有如下症状")
	private String symptomList;
	/**
	 * 体温
	 */
	@ApiModelProperty(value="体温")
private Float temperature;
	/**
	 * 联系电话
	 */
	@ApiModelProperty(value="联系电话")
private String contact;
	/**
	 * 地址
	 */
	@ApiModelProperty(value="地址")
private String address;

	/**
	 * 地址
	 */
	@ApiModelProperty(value="详细地址")
	private String extraAddress;

	/**
	 * 经纬度
	 */
	@ApiModelProperty(value="经纬度")
private String gps;
	/**
	 * 描述
	 */
	@ApiModelProperty(value="描述")
private String description;
	/**
	 * 上报时间
	 */
	@ApiModelProperty(value="上报时间")
private Date createtime;
	/**
	 * 备注
	 */
	@ApiModelProperty(value="备注")
private String remark;

	/**
	 * 所属用户
	 */
	@ApiModelProperty("所属用户")
	private Long userid;

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

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
	 * 设置：姓名
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：姓名
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：体温
	 */
	public void setTemperature(Float temperature) {
		this.temperature = temperature;
	}
	/**
	 * 获取：体温
	 */
	public Float getTemperature() {
		return temperature;
	}
	/**
	 * 设置：联系电话
	 */
	public void setContact(String contact) {
		this.contact = contact;
	}
	/**
	 * 获取：联系电话
	 */
	public String getContact() {
		return contact;
	}
	/**
	 * 设置：地址
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * 获取：地址
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * 设置：经纬度
	 */
	public void setGps(String gps) {
		this.gps = gps;
	}
	/**
	 * 获取：经纬度
	 */
	public String getGps() {
		return gps;
	}
	/**
	 * 设置：描述
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * 获取：描述
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * 设置：上报时间
	 */
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	/**
	 * 获取：上报时间
	 */
	public Date getCreatetime() {
		return createtime;
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

	public String getExtraAddress() {
		return extraAddress;
	}

	public void setExtraAddress(String extraAddress) {
		this.extraAddress = extraAddress;
	}

	public String getPersonType() {
		return personType;
	}

	public void setPersonType(String personType) {
		this.personType = personType;
	}

	public String getIsHbJourney() {
		return isHbJourney;
	}

	public void setIsHbJourney(String isHbJourney) {
		this.isHbJourney = isHbJourney;
	}

	public String getSymptomList() {
		return symptomList;
	}

	public void setSymptomList(String symptomList) {
		this.symptomList = symptomList;
	}
}
