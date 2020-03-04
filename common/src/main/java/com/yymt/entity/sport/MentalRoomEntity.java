package com.yymt.entity.sport;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 心防室
 *
 * @author hgq
 * @date 2018-03-12 09:17:13
 */
@TableName("tb_mental_room")
public class MentalRoomEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 心防室ID
	 */
	@TableId
	private Integer id;
	/**
	 * 心防室名称
	 */
	private String roomName;

	/**
	 * 获取心防室负责人
	 * @return
	 */
	public String getRoomLeadingOfficial() {
		return roomLeadingOfficial;
	}

	/**
	 * 设置心防室负责人
	 * @param roomLeadingOfficial
	 */
	public void setRoomLeadingOfficial(String roomLeadingOfficial) {
		this.roomLeadingOfficial = roomLeadingOfficial;
	}

	/**
	 * 心防室负责人
	 */
	private String roomLeadingOfficial;

	/**
	 * 地址
	 */
	private String address;
	/**
	 * 行政编号
	 */
	private String areacode;
	/**
	 * 联系电话
	 */
//	@JsonIgnore
	private String phone;
	/**
	 * 功能介绍
	 */
	private String functionIntroduce;
	/**
	 * 组织机构
	 */
	private String organization;
	/**
	 * 师资队伍
	 */
	private String teachingGroup;
	/**
	 * 工作流程
	 */
	private String workflow;
	/**
	 * 经度
	 */
	private String longitude;
	/**
	 * 纬度
	 */
	private String latitude;
	/**
	 * 图片
	 */
	private String images;
	/**
	 * 添加人ID
	 */
	private Integer addUserId;
	/**
	 * 添加时间
	 */
	private Date addTime;
	/**
	 * 更新时间
	 */
	private Date updateTime;

	/**
	 * 设置：心防室ID
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：心防室ID
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：心防室名称
	 */
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	/**
	 * 获取：心防室名称
	 */
	public String getRoomName() {
		return roomName;
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
	 * 设置：行政编号
	 */
	public void setAreacode(String areacode) {
		this.areacode = areacode;
	}
	/**
	 * 获取：行政编号
	 */
	public String getAreacode() {
		return areacode;
	}
	/**
	 * 设置：联系电话
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * 获取：联系电话
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * 设置：功能介绍
	 */
	public void setFunctionIntroduce(String functionIntroduce) {
		this.functionIntroduce = functionIntroduce;
	}
	/**
	 * 获取：功能介绍
	 */
	public String getFunctionIntroduce() {
		return functionIntroduce;
	}
	/**
	 * 设置：组织机构
	 */
	public void setOrganization(String organization) {
		this.organization = organization;
	}
	/**
	 * 获取：组织机构
	 */
	public String getOrganization() {
		return organization;
	}
	/**
	 * 设置：师资队伍
	 */
	public void setTeachingGroup(String teachingGroup) {
		this.teachingGroup = teachingGroup;
	}
	/**
	 * 获取：师资队伍
	 */
	public String getTeachingGroup() {
		return teachingGroup;
	}
	/**
	 * 设置：工作流程
	 */
	public void setWorkflow(String workflow) {
		this.workflow = workflow;
	}
	/**
	 * 获取：工作流程
	 */
	public String getWorkflow() {
		return workflow;
	}
	/**
	 * 设置：经度
	 */
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	/**
	 * 获取：经度
	 */
	public String getLongitude() {
		return longitude;
	}
	/**
	 * 设置：纬度
	 */
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	/**
	 * 获取：纬度
	 */
	public String getLatitude() {
		return latitude;
	}
	/**
	 * 设置：图片
	 */
	public void setImages(String images) {
		this.images = images;
	}
	/**
	 * 获取：图片
	 */
	public String getImages() {
		return images;
	}
	/**
	 * 设置：添加人ID
	 */
	public void setAddUserId(Integer addUserId) {
		this.addUserId = addUserId;
	}
	/**
	 * 获取：添加人ID
	 */
	public Integer getAddUserId() {
		return addUserId;
	}
	/**
	 * 设置：添加时间
	 */
	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}
	/**
	 * 获取：添加时间
	 */
	public Date getAddTime() {
		return addTime;
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
