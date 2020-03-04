package com.yymt.entity.sport;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 举报记录表
 *
 * @author cots
 * @date 2018-09-18 16:36:17
 */
@TableName("tb_reveal")
@ApiModel(description="举报记录表")
public class RevealEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId
	@ApiModelProperty(value="主键")
	private Integer id;
	/**
	 * 举报人ID
	 */
	@ApiModelProperty(value="举报人ID")
	private Long revealUserId;
	/**
	 * 1-社区举报
	 */
	@ApiModelProperty(value="1-社区举报,2-店铺举报,3-商品举报,4-场馆服务举报,5-教练服务举报")
	private Integer revealType;
	/**
	 * 举报的社区ID
	 */
	@ApiModelProperty(value="举报的内容ID")
	private Integer revealContentId;
	/**
	 * 举报类型（1-色情 2-不友善 3-广告 4-其他）
	 */
	@ApiModelProperty(value="举报类型（1-色情 2-不友善 3-广告 4-其他 5-违禁违规 6-假冒伪劣 7-虚假宣传 8-其他）")
	private Integer revealCategory;
	/**
	 * 举报状态（0-待处理1-有效举报 2-无效举报）
	 */
	@ApiModelProperty(value="举报状态（0-待处理1-有效举报 2-无效举报）")
	private Integer revealStatus;
	/**
	 * 举报原因
	 */
	@ApiModelProperty(value="举报原因",hidden = true)
	private String revealContent;
	/**
	 * 证据图片
	 */
	@ApiModelProperty(value="证据图片",hidden = true)
	private String revealImages;
	/**
	 * 举报时间
	 */
	@ApiModelProperty(value="举报时间")
	private Date createTime;

	/**
	 * 设置：主键
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：主键
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：举报人ID
	 */
	public void setRevealUserId(Long revealUserId) {
		this.revealUserId = revealUserId;
	}
	/**
	 * 获取：举报人ID
	 */
	public Long getRevealUserId() {
		return revealUserId;
	}
	/**
	 * 设置：1-社区举报
	 */
	public void setRevealType(Integer revealType) {
		this.revealType = revealType;
	}
	/**
	 * 获取：1-社区举报
	 */
	public Integer getRevealType() {
		return revealType;
	}

	public Integer getRevealStatus() {
		return revealStatus;
	}

	public void setRevealStatus(Integer revealStatus) {
		this.revealStatus = revealStatus;
	}

	/**
	 * 设置：举报的社区ID
	 */
	public void setRevealContentId(Integer revealContentId) {
		this.revealContentId = revealContentId;
	}
	/**
	 * 获取：举报的社区ID
	 */
	public Integer getRevealContentId() {
		return revealContentId;
	}
	/**
	 * 设置：举报类型（1-色情 2-不友善 3-广告 4-其他）
	 */
	public void setRevealCategory(Integer revealCategory) {
		this.revealCategory = revealCategory;
	}
	/**
	 * 获取：举报类型（1-色情 2-不友善 3-广告 4-其他）
	 */
	public Integer getRevealCategory() {
		return revealCategory;
	}
	/**
	 * 设置：举报原因
	 */
	public void setRevealContent(String revealContent) {
		this.revealContent = revealContent;
	}
	/**
	 * 获取：举报原因
	 */
	public String getRevealContent() {
		return revealContent;
	}
	/**
	 * 设置：证据图片
	 */
	public void setRevealImages(String revealImages) {
		this.revealImages = revealImages;
	}
	/**
	 * 获取：证据图片
	 */
	public String getRevealImages() {
		return revealImages;
	}
	/**
	 * 设置：举报时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：举报时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
}
