package com.yymt.entity.sport;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 社团项目表
 * 
 * @author cots
 * @date 2018-09-12 11:04:21
 */
@TableName("tb_corporation_sports")
@ApiModel(description="社团项目表")
public class CorporationSportsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	@ApiModelProperty(value="")
private Integer id;
	/**
	 * 社团ID
	 */
	@ApiModelProperty(value="社团ID")
private Integer corporationId;
	/**
	 * 项目ID
	 */
	@ApiModelProperty(value="项目ID")
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
	 * 设置：社团ID
	 */
	public void setCorporationId(Integer corporationId) {
		this.corporationId = corporationId;
	}
	/**
	 * 获取：社团ID
	 */
	public Integer getCorporationId() {
		return corporationId;
	}
	/**
	 * 设置：项目ID
	 */
	public void setSportId(Integer sportId) {
		this.sportId = sportId;
	}
	/**
	 * 获取：项目ID
	 */
	public Integer getSportId() {
		return sportId;
	}
}
