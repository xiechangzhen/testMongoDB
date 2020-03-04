package com.yymt.entity.sport;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 中国县以上行政区及行政区代码
 * 
 * @author cots
 * @date 2018-09-12 11:04:21
 */
@TableName("tb_district")
@ApiModel(description="中国县以上行政区及行政区代码")
public class DistrictEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 行政区代码
	 */
	@TableId
	@ApiModelProperty(value="行政区代码")
private Integer code;
	/**
	 * 行政区级别。1代表一级行政区，2代表二级行政区，3代表三级行政区
	 */
	@ApiModelProperty(value="行政区级别。1代表一级行政区，2代表二级行政区，3代表三级行政区")
private Integer level;
	/**
	 * 行政区名称
	 */
	@ApiModelProperty(value="行政区名称")
private String name;
	/**
	 * 上级行政区代码
	 */
	@ApiModelProperty(value="上级行政区代码")
private Integer parentCode;
	/**
	 * 上级行政区级别
	 */
	@ApiModelProperty(value="上级行政区级别")
private Integer parentLevel;

	/**
	 * 设置：行政区代码
	 */
	public void setCode(Integer code) {
		this.code = code;
	}
	/**
	 * 获取：行政区代码
	 */
	public Integer getCode() {
		return code;
	}
	/**
	 * 设置：行政区级别。1代表一级行政区，2代表二级行政区，3代表三级行政区
	 */
	public void setLevel(Integer level) {
		this.level = level;
	}
	/**
	 * 获取：行政区级别。1代表一级行政区，2代表二级行政区，3代表三级行政区
	 */
	public Integer getLevel() {
		return level;
	}
	/**
	 * 设置：行政区名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：行政区名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：上级行政区代码
	 */
	public void setParentCode(Integer parentCode) {
		this.parentCode = parentCode;
	}
	/**
	 * 获取：上级行政区代码
	 */
	public Integer getParentCode() {
		return parentCode;
	}
	/**
	 * 设置：上级行政区级别
	 */
	public void setParentLevel(Integer parentLevel) {
		this.parentLevel = parentLevel;
	}
	/**
	 * 获取：上级行政区级别
	 */
	public Integer getParentLevel() {
		return parentLevel;
	}
}
