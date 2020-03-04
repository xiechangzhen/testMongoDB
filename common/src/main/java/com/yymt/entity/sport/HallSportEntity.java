package com.yymt.entity.sport;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 场馆项目表
 * 
 * @author cots
 * @date 2018-09-12 11:04:21
 */
@TableName("tb_hall_sport")
@ApiModel(description="场馆项目表")
public class HallSportEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	@ApiModelProperty(value="")
private Integer id;
	/**
	 * 场馆ID
	 */
	@ApiModelProperty(value="场馆ID")
private Integer hallId;
	/**
	 * 运动项目ID
	 */
	@ApiModelProperty(value="运动项目ID")
private Integer sportId;

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
	 * 设置：场馆ID
	 */
	public void setHallId(Integer hallId) {
		this.hallId = hallId;
	}
	/**
	 * 获取：场馆ID
	 */
	public Integer getHallId() {
		return hallId;
	}
	/**
	 * 设置：运动项目ID
	 */
	public void setSportId(Integer sportId) {
		this.sportId = sportId;
	}
	/**
	 * 获取：运动项目ID
	 */
	public Integer getSportId() {
		return sportId;
	}
}
