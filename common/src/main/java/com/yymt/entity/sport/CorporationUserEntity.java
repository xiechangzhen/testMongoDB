package com.yymt.entity.sport;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 用户社团表
 * 
 * @author cots
 * @date 2018-09-12 11:04:21
 */
@TableName("tb_corporation_user")
@ApiModel(description="用户社团表")
public class CorporationUserEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 编号
	 */
	@TableId
	@ApiModelProperty(value="编号")
private Integer id;
	/**
	 * 社团id
	 */
	@ApiModelProperty(value="社团id")
private Integer corporationId;
	/**
	 * 用户id
	 */
	@ApiModelProperty(value="用户id")
private Long userId;

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
	 * 设置：社团id
	 */
	public void setCorporationId(Integer corporationId) {
		this.corporationId = corporationId;
	}
	/**
	 * 获取：社团id
	 */
	public Integer getCorporationId() {
		return corporationId;
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
}
