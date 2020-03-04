package com.yymt.entity.sport;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 社团职位表
 * 
 * @author cots
 * @date 2018-09-12 11:04:21
 */
@TableName("tb_corporation_position")
@ApiModel(description="社团职位表")
public class CorporationPositionEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 编号
	 */
	@TableId
	@ApiModelProperty(value="编号")
private Integer id;
	/**
	 * 职位名称
	 */
	@ApiModelProperty(value="职位名称")
private String positionName;
	/**
	 * 社团id
	 */
	@ApiModelProperty(value="社团id")
private Integer corporationId;
	/**
	 * 备注
	 */
	@ApiModelProperty(value="备注")
private String remark;

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
	 * 设置：职位名称
	 */
	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}
	/**
	 * 获取：职位名称
	 */
	public String getPositionName() {
		return positionName;
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
}
