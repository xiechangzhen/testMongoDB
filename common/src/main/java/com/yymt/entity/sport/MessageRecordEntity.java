package com.yymt.entity.sport;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 消息记录表
 * 
 * @author cots
 * @date 2018-09-12 11:04:21
 */
@TableName("tb_message_record")
@ApiModel(description="消息记录表")
public class MessageRecordEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 消息ID
	 */
	@TableId
	@ApiModelProperty(value="消息ID")
private Integer id;
	/**
	 * 发送方ID
	 */
	@ApiModelProperty(value="发送方ID")
private Long fromUserId;
	/**
	 * 接收方ID
	 */
	@ApiModelProperty(value="接收方ID")
private Long toUserId;
	/**
	 * 消息类型（消息-1，留言-2）
	 */
	@ApiModelProperty(value="消息类型（消息-1，留言-2）")
private Integer messageType;
	/**
	 * 消息栏目（赞-1，评论-2，关注-3，留言-4）
	 */
	@ApiModelProperty(value="消息栏目（赞-1，评论-2，关注-3，留言-4）")
private Integer messageTab;
	/**
	 * 消息栏目分类（1-文章点赞2-心情点赞3-心情评论点赞4-心情评论5-求助评论6-关注7-留言）
	 */
	@ApiModelProperty(value="消息栏目分类（1-文章点赞2-心情点赞3-心情评论点赞4-心情评论5-求助评论6-关注7-留言）")
private Integer messageTabType;
	/**
	 * 消息内容
	 */
	@ApiModelProperty(value="消息内容")
private String messageContent;
	/**
	 * 记录ID（由message_tab决定关联表的ID）
	 */
	@ApiModelProperty(value="记录ID（由message_tab决定关联表的ID）")
private Integer recordId;
	/**
	 * 是否查看（0-未读，1-已读）
	 */
	@ApiModelProperty(value="是否查看（0-未读，1-已读）")
private Integer isRead;
	/**
	 * 添加时间
	 */
	@ApiModelProperty(value="添加时间")
private Date createTime;
	/**
	 * 查看时间
	 */
	@ApiModelProperty(value="查看时间")
private Date readTime;

	/**
	 * 设置：消息ID
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：消息ID
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：发送方ID
	 */
	public void setFromUserId(Long fromUserId) {
		this.fromUserId = fromUserId;
	}
	/**
	 * 获取：发送方ID
	 */
	public Long getFromUserId() {
		return fromUserId;
	}
	/**
	 * 设置：接收方ID
	 */
	public void setToUserId(Long toUserId) {
		this.toUserId = toUserId;
	}
	/**
	 * 获取：接收方ID
	 */
	public Long getToUserId() {
		return toUserId;
	}
	/**
	 * 设置：消息类型（消息-1，留言-2）
	 */
	public void setMessageType(Integer messageType) {
		this.messageType = messageType;
	}
	/**
	 * 获取：消息类型（消息-1，留言-2）
	 */
	public Integer getMessageType() {
		return messageType;
	}
	/**
	 * 设置：消息栏目（赞-1，评论-2，关注-3，留言-4）
	 */
	public void setMessageTab(Integer messageTab) {
		this.messageTab = messageTab;
	}
	/**
	 * 获取：消息栏目（赞-1，评论-2，关注-3，留言-4）
	 */
	public Integer getMessageTab() {
		return messageTab;
	}
	/**
	 * 设置：消息栏目分类（1-文章点赞2-心情点赞3-心情评论点赞4-心情评论5-求助评论6-关注7-留言）
	 */
	public void setMessageTabType(Integer messageTabType) {
		this.messageTabType = messageTabType;
	}
	/**
	 * 获取：消息栏目分类（1-文章点赞2-心情点赞3-心情评论点赞4-心情评论5-求助评论6-关注7-留言）
	 */
	public Integer getMessageTabType() {
		return messageTabType;
	}
	/**
	 * 设置：消息内容
	 */
	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}
	/**
	 * 获取：消息内容
	 */
	public String getMessageContent() {
		return messageContent;
	}
	/**
	 * 设置：记录ID（由message_tab决定关联表的ID）
	 */
	public void setRecordId(Integer recordId) {
		this.recordId = recordId;
	}
	/**
	 * 获取：记录ID（由message_tab决定关联表的ID）
	 */
	public Integer getRecordId() {
		return recordId;
	}
	/**
	 * 设置：是否查看（0-未读，1-已读）
	 */
	public void setIsRead(Integer isRead) {
		this.isRead = isRead;
	}
	/**
	 * 获取：是否查看（0-未读，1-已读）
	 */
	public Integer getIsRead() {
		return isRead;
	}
	/**
	 * 设置：添加时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：添加时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：查看时间
	 */
	public void setReadTime(Date readTime) {
		this.readTime = readTime;
	}
	/**
	 * 获取：查看时间
	 */
	public Date getReadTime() {
		return readTime;
	}
}
