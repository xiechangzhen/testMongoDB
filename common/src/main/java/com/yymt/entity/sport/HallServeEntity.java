package com.yymt.entity.sport;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.math.BigDecimal;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 场馆服务表
 * 
 * @author cots
 * @date 2018-12-11 11:39:03
 */
@TableName("tb_hall_serve")
@ApiModel(description="场馆服务表")
public class HallServeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键id
	 */
	@TableId
	@ApiModelProperty(value="主键id")
	private Integer id;
	/**
	 * 场馆id
	 */
	@ApiModelProperty(value="场馆id")
	private Integer hallId;
	/**
	 * 服务名称
	 */
	@ApiModelProperty(value="服务名称")
	private String serveName;
	/**
	 * 服务类型(0预约 1门票 2优惠券)
	 */
	@ApiModelProperty(value="服务类型(0预约 1门票 2优惠券)")
	private Integer serveType;
	/**
	 * 运动项目
	 */
	@ApiModelProperty(value="运动项目")
	private Integer serveSport;
	/**
	 * 价格
	 */
	@ApiModelProperty(value="价格")
	private BigDecimal servePrice;
	/**
	 * 温馨提示
	 */
	@ApiModelProperty(value="温馨提示")
	private String serveTips;
	/**
	 * 开始时间
	 */
	@ApiModelProperty(value="开始时间")
	private Date beginTime;
	/**
	 * 结束时间
	 */
	@ApiModelProperty(value="结束时间")
	private Date endTime;
	/**
	 * 备注
	 */
	@ApiModelProperty(value="备注")
	private String remark;
	/**
	 * 场馆服务状态（0：待审核；1：已通过；2：未通过）
	 */
	@ApiModelProperty(value="场馆服务状态（0：待审核；1：已通过；2：未通过）")
	private Integer serveStatus;
	/**
	 * 审核人
	 */
	@ApiModelProperty(value="审核人")
	private Long auditUserId;
	/**
	 * 审核时间
	 */
	@ApiModelProperty(value="审核时间")
	private Date auditTime;
	/**
	 * 添加人
	 */
	@ApiModelProperty(value="添加人")
	private Long createUserId;
	/**
	 * 创建时间
	 */
	@ApiModelProperty(value="创建时间")
	private Date createTime;
	/**
	 * 最后更新人
	 */
	@ApiModelProperty(value="最后更新人")
	private Long updateUserId;
	/**
	 * 最后更新时间
	 */
	@ApiModelProperty(value="最后更新时间")
	private Date updateTime;
	/**
	 * 浏览量
	 * */
	@ApiModelProperty(value = "浏览量")
	private Integer pageView;

	/**
	 * 设置：主键id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：主键id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：场馆id
	 */
	public void setHallId(Integer hallId) {
		this.hallId = hallId;
	}
	/**
	 * 获取：场馆id
	 */
	public Integer getHallId() {
		return hallId;
	}
	/**
	 * 设置：服务名称
	 */
	public void setServeName(String serveName) {
		this.serveName = serveName;
	}
	/**
	 * 获取：服务名称
	 */
	public String getServeName() {
		return serveName;
	}
	/**
	 * 设置：服务类型(0预约 1门票 2优惠券)
	 */
	public void setServeType(Integer serveType) {
		this.serveType = serveType;
	}
	/**
	 * 获取：服务类型(0预约 1门票 2优惠券)
	 */
	public Integer getServeType() {
		return serveType;
	}
	/**
	 * 设置：运动项目
	 */
	public void setServeSport(Integer serveSport) {
		this.serveSport = serveSport;
	}
	/**
	 * 获取：运动项目
	 */
	public Integer getServeSport() {
		return serveSport;
	}
	/**
	 * 设置：价格
	 */
	public void setServePrice(BigDecimal servePrice) {
		this.servePrice = servePrice;
	}
	/**
	 * 获取：价格
	 */
	public BigDecimal getServePrice() {
		return servePrice;
	}
	/**
	 * 设置：温馨提示
	 */
	public void setServeTips(String serveTips) {
		this.serveTips = serveTips;
	}
	/**
	 * 获取：温馨提示
	 */
	public String getServeTips() {
		return serveTips;
	}
	/**
	 * 设置：开始时间
	 */
	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}
	/**
	 * 获取：开始时间
	 */
	public Date getBeginTime() {
		return beginTime;
	}
	/**
	 * 设置：结束时间
	 */
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	/**
	 * 获取：结束时间
	 */
	public Date getEndTime() {
		return endTime;
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
	 * 设置：场馆服务状态（0：待审核；1：已通过；2：未通过）
	 */
	public void setServeStatus(Integer serveStatus) {
		this.serveStatus = serveStatus;
	}
	/**
	 * 获取：场馆服务状态（0：待审核；1：已通过；2：未通过）
	 */
	public Integer getServeStatus() {
		return serveStatus;
	}
	/**
	 * 设置：审核人
	 */
	public void setAuditUserId(Long auditUserId) {
		this.auditUserId = auditUserId;
	}
	/**
	 * 获取：审核人
	 */
	public Long getAuditUserId() {
		return auditUserId;
	}
	/**
	 * 设置：审核时间
	 */
	public void setAuditTime(Date auditTime) {
		this.auditTime = auditTime;
	}
	/**
	 * 获取：审核时间
	 */
	public Date getAuditTime() {
		return auditTime;
	}
	/**
	 * 设置：添加人
	 */
	public void setCreateUserId(Long createUserId) {
		this.createUserId = createUserId;
	}
	/**
	 * 获取：添加人
	 */
	public Long getCreateUserId() {
		return createUserId;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：最后更新人
	 */
	public void setUpdateUserId(Long updateUserId) {
		this.updateUserId = updateUserId;
	}
	/**
	 * 获取：最后更新人
	 */
	public Long getUpdateUserId() {
		return updateUserId;
	}
	/**
	 * 设置：最后更新时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：最后更新时间
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

	public Integer getPageView() {
		return pageView;
	}

	public void setPageView(Integer pageView) {
		this.pageView = pageView;
	}
}
