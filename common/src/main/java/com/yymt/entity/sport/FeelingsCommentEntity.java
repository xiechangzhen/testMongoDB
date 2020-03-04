package com.yymt.entity.sport;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 心情评论表
 * 
 * @author hgq
 * @date 2018-03-05 10:16:02
 */
@TableName("tb_feelings_comment")
public class FeelingsCommentEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 主题ID
	 */
	private Integer feelingsId;
	/**
	 * 评论内容
	 */
	private String commentContent;
	/**
	 * 评论时间
	 */
	private Date commentCreatetime;
	/**
	 * 评论用户ID
	 */
	private Long fromUserId;
	/**
	 * 目标用户ID(如果为空，则评论心情，反之回复留言)
	 */
	private Long parentId;

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
	 * 设置：主题ID
	 */
	public void setFeelingsId(Integer feelingsId) {
		this.feelingsId = feelingsId;
	}
	/**
	 * 获取：主题ID
	 */
	public Integer getFeelingsId() {
		return feelingsId;
	}
	/**
	 * 设置：评论内容
	 */
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	/**
	 * 获取：评论内容
	 */
	public String getCommentContent() {
		return commentContent;
	}
	/**
	 * 设置：评论时间
	 */
	public void setCommentCreatetime(Date commentCreatetime) {
		this.commentCreatetime = commentCreatetime;
	}
	/**
	 * 获取：评论时间
	 */
	public Date getCommentCreatetime() {
		return commentCreatetime;
	}
	/**
	 * 设置：评论用户ID
	 */
	public void setFromUserId(Long fromUserId) {
		this.fromUserId = fromUserId;
	}
	/**
	 * 获取：评论用户ID
	 */
	public Long getFromUserId() {
		return fromUserId;
	}
	/**
	 * 设置：目标用户ID(如果为空，则评论心情，反之回复留言)
	 */
	public void setParentId(Long toUserId) {
		this.parentId = toUserId;
	}
	/**
	 * 获取：目标用户ID(如果为空，则评论心情，反之回复留言)
	 */
	public Long getParentId() {
		return parentId;
	}
}
