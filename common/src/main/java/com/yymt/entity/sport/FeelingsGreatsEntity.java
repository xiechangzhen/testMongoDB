package com.yymt.entity.sport;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 心情点赞表
 * 
 * @author hgq
 * @date 2018-02-28 13:11:25
 */
@TableName("tb_feelings_greats")
public class FeelingsGreatsEntity implements Serializable {
	/**
	 * 
	 */
	@TableId
	@ApiModelProperty(hidden = true)
	private Integer id;
	/**
	 * 心情ID
	 */
	private Integer feelingsId;
	/**
	 * 用户ID
	 */
	@ApiModelProperty(hidden = true)
	private Long userId;
	/**
	 * 点赞时间
	 */
	@ApiModelProperty(hidden = true)
	private Date greatsTime;

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
	 * 设置：心情ID
	 */
	public void setFeelingsId(Integer feelingsId) {
		this.feelingsId = feelingsId;
	}
	/**
	 * 获取：心情ID
	 */
	public Integer getFeelingsId() {
		return feelingsId;
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
	public void setGreatsTime(Date greatsTime) {
		this.greatsTime = greatsTime;
	}
	/**
	 * 获取：点赞时间
	 */
	public Date getGreatsTime() {
		return greatsTime;
	}
}
