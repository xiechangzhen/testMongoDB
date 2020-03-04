package com.yymt.entity.sport;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 意见反馈表
 * 
 * @author hgq
 * @date 2018-03-06 10:58:41
 */
@TableName("tb_feed_back")
public class FeedBackEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@ApiModelProperty(hidden = true)
	@TableId
	private Integer id;
	/**
	 * 意见反馈标题
	 */
	private String feedBackTitle;
	/**
	 * 反馈类型
	 */
	private Integer feedBackType;
	/**
	 * 反馈类型-中文
	 * 数据表中无此字段
	 */
	@TableField(exist = false)
	private Integer feedBackTypeName;
	/**
	 * 意见反馈内容
	 */
	private String feedBackContent;
	/**
	 * 意见反馈图片
	 */
	private String feedBackImages;
	/**
	 * 联系电话
	 */
	private String feedBackMobile;
	/**
	 * 反馈用户ID
	 */
	@ApiModelProperty(hidden = true)
	private Long feedBackUserId;
	/**
	 * 意见反馈创建时间
	 */
	@ApiModelProperty(hidden = true)
	private Date feedBackCreate;
	/**
	 * 意见反馈状态（0-未解决，1-已解决）
	 */
	private Integer feedBackStatus;
	/**
	 * 意见反馈回复人
	 */
	private Long feedBackReplayId;
	/**
	 * 意见反馈回复时间
	 */
	private Date feedBackReplayCreate;
	/**
	 * 备注
	 */
	@ApiModelProperty(hidden = true)
	private String remark;
	/**
	 * 最后回复人id
	 */
	private Long feedBackLastReplyId;
	/**
	 * 最后回复人类型（1-后台，2-APP）
	 */
	private Integer feedBackLastReplyType;
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
	 * 设置：意见反馈标题
	 */
	public void setFeedBackTitle(String feedBackTitle) {
		this.feedBackTitle = feedBackTitle;
	}
	/**
	 * 获取：意见反馈标题
	 */
	public String getFeedBackTitle() {
		return feedBackTitle;
	}
	/**
	 * 设置：反馈类型
	 */
	public void setFeedBackType(Integer feedBackType) {
		this.feedBackType = feedBackType;
	}
	/**
	 * 获取：反馈类型
	 */
	public Integer getFeedBackType() {
		return feedBackType;
	}
	/**
	 * 设置：反馈类型
	 */
	public void setFeedBackTypeName(Integer feedBackTypeName) {
		this.feedBackTypeName = feedBackTypeName;
	}
	/**
	 * 获取：反馈类型
	 */
	public Integer getFeedBackTypeName() {
		return feedBackTypeName;
	}
	/**
	 * 设置：意见反馈内容
	 */
	public void setFeedBackContent(String feedBackContent) {
		this.feedBackContent = feedBackContent;
	}
	/**
	 * 获取：意见反馈内容
	 */
	public String getFeedBackContent() {
		return feedBackContent;
	}
	/**
	 * 设置：意见反馈图片
	 */
	public void setFeedBackImages(String feedBackImages) {
		this.feedBackImages = feedBackImages;
	}
	/**
	 * 获取：意见反馈图片
	 */
	public String getFeedBackImages() {
		return feedBackImages;
	}
	/**
	 * 设置：联系电话
	 */
	public void setFeedBackMobile(String feedBackMobile) {
		this.feedBackMobile = feedBackMobile;
	}
	/**
	 * 获取：联系电话
	 */
	public String getFeedBackMobile() {
		return feedBackMobile;
	}
	/**
	 * 设置：反馈用户ID
	 */
	public void setFeedBackUserId(Long feedBackUserId) {
		this.feedBackUserId = feedBackUserId;
	}
	/**
	 * 获取：反馈用户ID
	 */
	public Long getFeedBackUserId() {
		return feedBackUserId;
	}
	/**
	 * 设置：意见反馈创建时间
	 */
	public void setFeedBackCreate(Date feedBackCreate) {
		this.feedBackCreate = feedBackCreate;
	}
	/**
	 * 获取：意见反馈创建时间
	 */
	public Date getFeedBackCreate() {
		return feedBackCreate;
	}
	/**
	 * 设置：意见反馈状态（0-未解决，1-已解决）
	 */
	public void setFeedBackStatus(Integer feedBackStatus) {
		this.feedBackStatus = feedBackStatus;
	}
	/**
	 * 获取：意见反馈状态（0-未解决，1-已解决）
	 */
	public Integer getFeedBackStatus() {
		return feedBackStatus;
	}
	/**
	 * 设置：意见反馈回复人
	 */
	public void setFeedBackReplayId(Long feedBackReplayId) {
		this.feedBackReplayId = feedBackReplayId;
	}
	/**
	 * 获取：意见反馈回复人
	 */
	public Long getFeedBackReplayId() {
		return feedBackReplayId;
	}
	/**
	 * 设置：意见反馈回复时间
	 */
	public void setFeedBackReplayCreate(Date feedBackReplayCreate) {
		this.feedBackReplayCreate = feedBackReplayCreate;
	}
	/**
	 * 获取：意见反馈回复时间
	 */
	public Date getFeedBackReplayCreate() {
		return feedBackReplayCreate;
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
	/**
	 * 设置：最后回复人id
	 */
	public void setFeedBackLastReplyId(Long feedBackLastReplyId) {
		this.feedBackLastReplyId = feedBackLastReplyId;
	}
	/**
	 * 获取：最后回复人id
	 */
	public Long getFeedBackLastReplyId() {
		return feedBackLastReplyId;
	}
	/**
	 * 设置：最后回复人类型（1-后台，2-APP）
	 */
	public void setFeedBackLastReplyType(Integer feedBackLastReplyType) {
		this.feedBackLastReplyType = feedBackLastReplyType;
	}
	/**
	 * 获取：最后回复人类型（1-后台，2-APP）
	 */
	public Integer getFeedBackLastReplyType() {
		return feedBackLastReplyType;
	}
}
