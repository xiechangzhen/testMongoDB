package com.yymt.entity.sport;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 活动参与表
 * 
 * @author hgq
 * @date 2018-03-14 15:07:41
 */
@TableName("tb_activity_join")
public class ActivityJoinEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	@ApiModelProperty(hidden = true)
	private Long id;
	/**
	 * 参加活动用户ID
	 */
	@ApiModelProperty(hidden = true)
	private Long joinUserId;
	/**
	 * 活动ID
	 */
	private Long activityId;
	/**
	 * 加入时间
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
	 * 设置：参加活动用户ID
	 */
	public void setJoinUserId(Long joinUserId) {
		this.joinUserId = joinUserId;
	}
	/**
	 * 获取：参加活动用户ID
	 */
	public Long getJoinUserId() {
		return joinUserId;
	}
	/**
	 * 设置：活动ID
	 */
	public void setActivityId(Long activityId) {
		this.activityId = activityId;
	}
	/**
	 * 获取：活动ID
	 */
	public Long getActivityId() {
		return activityId;
	}
	/**
	 * 设置：加入时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：加入时间
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
