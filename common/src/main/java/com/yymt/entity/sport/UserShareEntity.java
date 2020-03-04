package com.yymt.entity.sport;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户分享表
 * 
 * @author cots
 * @date 2018-09-12 11:04:21
 */
@TableName("tb_user_share")
@ApiModel(description="用户分享表")
public class UserShareEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	@ApiModelProperty(value="")
private Integer id;
	/**
	 * 用户id
	 */
	@ApiModelProperty(value="用户id")
private Long userId;
	/**
	 * 搜藏ID(根据mark_type的不同，mark_id从属不同的表)
	 */
	@ApiModelProperty(value="搜藏ID(根据mark_type的不同，mark_id从属不同的表)")
private Long shareId;
	/**
	 * 分享类型(0：新闻,1:赛事,2:场馆,3:社团4人员5指南6机构7社区)
	 */
	@ApiModelProperty(value="分享类型(0：新闻,1:赛事,2:场馆,3:社团4人员5指南6机构7社区)")
private Integer shareType;
	/**
	 * 
	 */
	@ApiModelProperty(value="")
private Date createTime;

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
	 * 设置：用户id
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * 获取：用户id
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * 设置：搜藏ID(根据mark_type的不同，mark_id从属不同的表)
	 */
	public void setShareId(Long shareId) {
		this.shareId = shareId;
	}
	/**
	 * 获取：搜藏ID(根据mark_type的不同，mark_id从属不同的表)
	 */
	public Long getShareId() {
		return shareId;
	}
	/**
	 * 设置：分享类型(0：新闻,1:赛事,2:场馆,3:社团4人员5指南6机构7社区)
	 */
	public void setShareType(Integer shareType) {
		this.shareType = shareType;
	}
	/**
	 * 获取：分享类型(0：新闻,1:赛事,2:场馆,3:社团4人员5指南6机构7社区)
	 */
	public Integer getShareType() {
		return shareType;
	}
	/**
	 * 设置：
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：
	 */
	public Date getCreateTime() {
		return createTime;
	}
}
