package com.yymt.entity.sport;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 求助评论表
 * 
 * @author hgq
 * @date 2018-03-06 15:44:37
 */
@TableName("tb_help_comment")
public class HelpCommentEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 评论ID
	 */
	private Long helpId;
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
	 * 父评论ID
	 */
	private Long parentId;
	/**
	 * 是否被采纳(0-未采纳，1-已采纳)
	 */
	private Integer isBestAnswer;

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
	public void setHelpId(Long helpId) {
		this.helpId = helpId;
	}
	/**
	 * 获取：主题ID
	 */
	public Long getHelpId() {
		return helpId;
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
	 * 设置：父评论ID
	 */
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	/**
	 * 获取：父评论ID
	 */
	public Long getParentId() {
		return parentId;
	}
	/**
	 * 设置：是否被采纳(0-未采纳，1-已采纳)
	 */
	public void setIsBestAnswer(Integer isBestAnswer) {
		this.isBestAnswer = isBestAnswer;
	}
	/**
	 * 获取：是否被采纳(0-未采纳，1-已采纳)
	 */
	public Integer getIsBestAnswer() {
		return isBestAnswer;
	}
}
