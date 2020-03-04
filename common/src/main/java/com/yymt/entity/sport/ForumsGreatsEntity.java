package com.yymt.entity.sport;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 帖子点赞表
 * 
 * @author cots
 * @date 2018-09-12 11:04:21
 */
@TableName("tb_forums_greats")
@ApiModel(description="帖子点赞表")
public class ForumsGreatsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 帖子ID
	 */
	@ApiModelProperty(value="帖子ID")
private Integer forumsId;
	/**
	 * 用户ID
	 */
	@ApiModelProperty(value="用户ID")
private Long userId;
	/**
	 * 点赞时间
	 */
	@ApiModelProperty(value="点赞时间")
private Date createTime;
	/**
	 * 备注
	 */
	@ApiModelProperty(value="备注")
private String remark;
	/**
	 * 设置：帖子ID
	 */
	public void setForumsId(Integer forumsId) {
		this.forumsId = forumsId;
	}
	/**
	 * 获取：帖子ID
	 */
	public Integer getForumsId() {
		return forumsId;
	}
	/**
	 * 设置：用户ID
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * 获取：用户ID
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * 设置：点赞时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：点赞时间
	 */
	public Date getCreateTime() {
		return createTime;
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
