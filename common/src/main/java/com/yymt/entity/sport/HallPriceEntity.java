package com.yymt.entity.sport;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.math.BigDecimal;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 场馆项目报价表
 * 
 * @author cots
 * @date 2018-09-12 11:04:21
 */
@TableName("tb_hall_price")
@ApiModel(description="场馆项目报价表")
public class HallPriceEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 编号
	 */
	@TableId
	@ApiModelProperty(value="编号")
private Integer id;
	/**
	 * 体育项目ID
	 */
	@ApiModelProperty(value="体育项目ID")
private Integer sportId;
	/**
	 * 价格
	 */
	@ApiModelProperty(value="价格")
private String price;
	/**
	 * 是否提供器材
	 */
	@ApiModelProperty(value="是否提供器材")
private Integer provideEquipment;
	/**
	 * 所属场馆
	 */
	@ApiModelProperty(value="所属场馆")
private Integer hallId;

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
	 * 设置：体育项目ID
	 */
	public void setSportId(Integer sportId) {
		this.sportId = sportId;
	}
	/**
	 * 获取：体育项目ID
	 */
	public Integer getSportId() {
		return sportId;
	}
	/**
	 * 设置：价格
	 */
	public void setPrice(String price) {
		this.price = price;
	}
	/**
	 * 获取：价格
	 */
	public String getPrice() {
		return price;
	}
	/**
	 * 设置：是否提供器材
	 */
	public void setProvideEquipment(Integer provideEquipment) {
		this.provideEquipment = provideEquipment;
	}
	/**
	 * 获取：是否提供器材
	 */
	public Integer getProvideEquipment() {
		return provideEquipment;
	}
	/**
	 * 设置：所属场馆
	 */
	public void setHallId(Integer hallId) {
		this.hallId = hallId;
	}
	/**
	 * 获取：所属场馆
	 */
	public Integer getHallId() {
		return hallId;
	}
}
