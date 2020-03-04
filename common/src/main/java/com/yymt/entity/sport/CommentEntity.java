package com.yymt.entity.sport;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 评论表
 * 
 * @author hgq
 * @date 2018-02-10 14:26:32
 */
@TableName("tb_comment")
public class CommentEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 评论ID
	 */
	@TableId
	private Integer id;
	/**
	 * 评论用户ID
	 */
	private Integer userCommentId;
	/**
	 * 评论新闻ID
	 */
	private Integer newsId;
	/**
	 * 评论时间
	 */
	private Date commentCreateTime;
	/**
	 * 
	 */
	private String commentContent;
	/**
	 * 
	 */
	private String remark;

	/**
	 * 设置：评论ID
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：评论ID
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：评论用户ID
	 */
	public void setUserCommentId(Integer userCommentId) {
		this.userCommentId = userCommentId;
	}
	/**
	 * 获取：评论用户ID
	 */
	public Integer getUserCommentId() {
		return userCommentId;
	}
	/**
	 * 设置：评论新闻ID
	 */
	public void setNewsId(Integer newsId) {
		this.newsId = newsId;
	}
	/**
	 * 获取：评论新闻ID
	 */
	public Integer getNewsId() {
		return newsId;
	}
	/**
	 * 设置：评论时间
	 */
	public void setCommentCreateTime(Date commentCreateTime) {
		this.commentCreateTime = commentCreateTime;
	}
	/**
	 * 获取：评论时间
	 */
	public Date getCommentCreateTime() {
		return commentCreateTime;
	}
	/**
	 * 设置：
	 */
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	/**
	 * 获取：
	 */
	public String getCommentContent() {
		return commentContent;
	}
	/**
	 * 设置：
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：
	 */
	public String getRemark() {
		return remark;
	}
}
