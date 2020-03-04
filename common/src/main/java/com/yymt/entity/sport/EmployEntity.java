package com.yymt.entity.sport;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 员工信息表
 * 
 * @author cots
 * @date 2020-02-02 11:36:17
 */
@TableName("tb_employ")
@ApiModel(description="员工信息表")
public class EmployEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	@ApiModelProperty(value="")
private Integer id;
	/**
	 * 
	 */
	@ApiModelProperty(value="")
private String name;
	/**
	 * 
	 */
	@ApiModelProperty(value="")
private String contact;

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
	 * 设置：
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：
	 */
	public void setContact(String contact) {
		this.contact = contact;
	}
	/**
	 * 获取：
	 */
	public String getContact() {
		return contact;
	}
}
