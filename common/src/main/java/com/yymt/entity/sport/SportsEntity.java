package com.yymt.entity.sport;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 运动项目
 * 
 * @author cots
 * @date 2018-09-12 11:04:21
 */
@TableName("tb_sports")
@ApiModel(description="运动项目")
public class SportsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 序号
	 */
	@TableId
	@ApiModelProperty(value="序号")
private Integer id;
	/**
	 * 赛事项目名称
	 */
	@ApiModelProperty(value="赛事项目名称")
private String sportName;

	/**
	 * 排序
	 * */
	@ApiModelProperty(value = "排序")
	private Integer orderNum;
	/**
	 * 创建时间
	 */
	@ApiModelProperty(value="创建时间")
private Date createTime;
	/**
	 * 修改时间
	 */
	@ApiModelProperty(value="修改时间")
private Date updateTime;

	/**
	 * 设置：序号
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：序号
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：赛事项目名称
	 */
	public void setSportName(String sportName) {
		this.sportName = sportName;
	}
	/**
	 * 获取：赛事项目名称
	 */
	public String getSportName() {
		return sportName;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：修改时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：修改时间
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

	public Integer getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}
}
