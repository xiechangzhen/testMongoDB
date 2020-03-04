package com.yymt.entity.sport;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 帖子评论点赞表
 * 
 * @author cots
 * @date 2018-09-12 11:04:21
 */
@TableName("tb_forums_comment_greats")
@ApiModel(description="帖子评论点赞表")
public class ForumsCommentGreatsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 编号
	 */
	@TableId
	@ApiModelProperty(value="编号")
private Integer id;
	/**
	 * 帖子评论ID
	 */
	@ApiModelProperty(value="帖子评论ID")
private Integer forumsCommentId;
	/**
	 * 用户ID
	 */
	@ApiModelProperty(value="用户ID")
private Long userId;
	/**
	 * 帖子ID
	 */
	@ApiModelProperty(value="帖子ID")
private Integer forumsId;
	/**
	 * 点赞时间
	 */
	@ApiModelProperty(value="点赞时间")
private Date createTime;

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
	 * 设置：帖子评论ID
	 */
	public void setForumsCommentId(Integer forumsCommentId) {
		this.forumsCommentId = forumsCommentId;
	}
	/**
	 * 获取：帖子评论ID
	 */
	public Integer getForumsCommentId() {
		return forumsCommentId;
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
	 * 设置：帖子ID
	 */
	public void setForumsId(Integer forumsId) {
		this.forumsId = forumsId;
	}
	/**
	 * 获取：帖子ID
	 */
	public Integer getForumsId() {
		return forumsId;
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
}
