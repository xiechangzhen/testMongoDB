package com.yymt.entity.sport;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 心情评论点赞表
 * 
 * @author hgq
 * @date 2018-02-28 13:11:25
 */
@TableName("tb_feelings_comment_greats")
public class FeelingsCommentGreatsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	@ApiModelProperty(hidden = true)
	private Integer id;
	/**
	 * 心情评论ID
	 */
	private Integer feelingsCommentId;
	/**
	 * 点赞用户ID
	 */
	@ApiModelProperty(hidden = true)
	private Long userId;
	/**
	 * 点赞时间
	 */
	@ApiModelProperty(hidden = true)
	private Date greatsCreateTime;

	/**
	 * 所属评论ID（方便删除）
	 */
	private Integer feelingsId;

	/**
	 * 获取所属评论ID（方便删除）
	 */
	public Integer getFeelingsId() {
		return feelingsId;
	}

	/**
	 *
	 * s设置属评论ID（方便删除）
	 */
	public void setFeelingsId(Integer feelingsId) {
		this.feelingsId = feelingsId;
	}

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
	 * 设置：心情评论ID
	 */
	public void setFeelingsCommentId(Integer feelingsCommentId) {
		this.feelingsCommentId = feelingsCommentId;
	}
	/**
	 * 获取：心情评论ID
	 */
	public Integer getFeelingsCommentId() {
		return feelingsCommentId;
	}
	/**
	 * 设置：点赞用户ID
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * 获取：点赞用户ID
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * 设置：点赞时间
	 */
	public void setGreatsCreateTime(Date greatsCreateTime) {
		this.greatsCreateTime = greatsCreateTime;
	}
	/**
	 * 获取：点赞时间
	 */
	public Date getGreatsCreateTime() {
		return greatsCreateTime;
	}
}
