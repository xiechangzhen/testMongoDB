package com.yymt.entity.sport;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 问题反馈回复表
 * 
 * @author hgq
 * @date 2018-06-20 09:35:50
 */
@TableName("tb_feedback_message")
public class FeedbackMessageEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@ApiModelProperty(hidden = true)
	@TableId
	private Integer id;
	/**
	 * 回复内容
	 */
	private String message;
	/**
	 * 回复图片
	 */
	private String messageImage;
	/**
	 * 反馈id
	 */
	private Integer feedbackId;
	/**
	 * 发送人ID
	 */
	@ApiModelProperty(hidden = true)
	private Long userId;
	/**
	 * 回复人类型（1-后台，2-APP）
	 */
	@ApiModelProperty(hidden = true)
	private Integer userType;
	/**
	 * 消息状态(0-未读，1-已读)
	 */
	@ApiModelProperty(hidden = true)
	private Integer status;
	/**
	 * 回复时间
	 */
	@ApiModelProperty(hidden = true)
	private Date replyTime;

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
	 * 设置：回复内容
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * 获取：回复内容
	 */
	public String getMessage() {
		return message;
	}

	public String getMessageImage() {
		return messageImage;
	}

	public void setMessageImage(String messageImage) {
		this.messageImage = messageImage;
	}

	/**
	 * 设置：反馈id
	 */
	public void setFeedbackId(Integer feedbackId) {
		this.feedbackId = feedbackId;
	}
	/**
	 * 获取：反馈id
	 */
	public Integer getFeedbackId() {
		return feedbackId;
	}
	/**
	 * 设置：发送人ID
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * 获取：发送人ID
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * 设置：回复人类型（1-后台，2-APP）
	 */
	public void setUserType(Integer userType) {
		this.userType = userType;
	}
	/**
	 * 获取：回复人类型（1-后台，2-APP）
	 */
	public Integer getUserType() {
		return userType;
	}
	/**
	 * 设置：消息状态(0-未读，1-已读)
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：消息状态(0-未读，1-已读)
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * 设置：回复时间
	 */
	public void setReplyTime(Date replyTime) {
		this.replyTime = replyTime;
	}
	/**
	 * 获取：回复时间
	 */
	public Date getReplyTime() {
		return replyTime;
	}
}
