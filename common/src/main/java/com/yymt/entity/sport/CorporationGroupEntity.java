package com.yymt.entity.sport;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 社团团体会员关系表
 * 
 * @author cots
 * @date 2018-09-12 11:04:21
 */
@TableName("tb_corporation_group")
@ApiModel(description="社团团体会员关系表")
public class CorporationGroupEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 编号
	 */
	@TableId
	@ApiModelProperty(value="编号")
private Integer id;
	/**
	 * 社团编号
	 */
	@ApiModelProperty(value="社团编号")
private Integer corporationId;
	/**
	 * 团体会员编号
	 */
	@ApiModelProperty(value="团体会员编号")
private Integer groupId;

	/**
	 * 设置：编号
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：编号
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：社团编号
	 */
	public void setCorporationId(Integer corporationId) {
		this.corporationId = corporationId;
	}
	/**
	 * 获取：社团编号
	 */
	public Integer getCorporationId() {
		return corporationId;
	}
	/**
	 * 设置：团体会员编号
	 */
	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}
	/**
	 * 获取：团体会员编号
	 */
	public Integer getGroupId() {
		return groupId;
	}
}
