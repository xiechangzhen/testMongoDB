package com.yymt.entity.sport;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户管理的场馆表
 * 
 * @author cots
 * @date 2018-12-11 11:39:03
 */
@TableName("tb_hall_user")
@ApiModel(description="用户管理的场馆表")
public class HallUserEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键id
	 */
	@TableId
	@ApiModelProperty(value="主键id")
private Integer id;
	/**
	 * 用户id
	 */
	@ApiModelProperty(value="用户id")
private Integer userId;
	/**
	 * 场馆id
	 */
	@ApiModelProperty(value="场馆id")
private Integer hallId;
	/**
	 * 设置：主键id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：主键id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：用户id
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	/**
	 * 获取：用户id
	 */
	public Integer getUserId() {
		return userId;
	}
	/**
	 * 设置：场馆id
	 */
	public void setHallId(Integer hallId) {
		this.hallId = hallId;
	}
	/**
	 * 获取：场馆id
	 */
	public Integer getHallId() {
		return hallId;
	}
}
