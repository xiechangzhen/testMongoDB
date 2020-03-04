package com.yymt.entity.sport;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 互动留言表
 * 
 * @author hgq
 * @date 2018-03-14 15:07:41
 */
@TableName("tb_message")
public class MessageEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	@ApiModelProperty(hidden = true)
	private Long id;
	/**
	 * 留言内容
	 */
	private String leaveMessage;
	/**
	 * 发送人ID
	 */
	private Long fromUserId;
	/**
	 * 接收人ID
	 */
	private Long toUserId;
	/**
	 * 消息状态(0-未读，1-已读)
	 */
	private Integer status;
	/**
	 * 留言创建时间
	 */
	@ApiModelProperty(hidden = true)
	private Date createTime;
	/**
	 * 备注
	 */
	private String remark;

	/**
	 * 设置：
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：留言内容
	 */
	public void setLeaveMessage(String message) {
		this.leaveMessage = message;
	}
	/**
	 * 获取：留言内容
	 */
	public String getLeaveMessage() {
		return leaveMessage;
	}
	/**
	 * 设置：发送人ID
	 */
	public void setFromUserId(Long fromUserId) {
		this.fromUserId = fromUserId;
	}
	/**
	 * 获取：发送人ID
	 */
	public Long getFromUserId() {
		return fromUserId;
	}
	/**
	 * 设置：接收人ID
	 */
	public void setToUserId(Long toUserId) {
		this.toUserId = toUserId;
	}
	/**
	 * 获取：接收人ID
	 */
	public Long getToUserId() {
		return toUserId;
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
	 * 设置：留言创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：留言创建时间
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
