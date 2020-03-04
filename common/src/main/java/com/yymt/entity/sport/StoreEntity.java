package com.yymt.entity.sport;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 店铺表
 * 
 * @author cots
 * @date 2018-12-13 08:52:56
 */
@TableName("tb_store")
@ApiModel(description="店铺表")
public class StoreEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键id
	 */
	@TableId
	@ApiModelProperty(value="主键id")
private Integer id;
	/**
	 * 商户id
	 */
	@ApiModelProperty(value="商户id")
private Long sellerId;
	/**
	 * 店铺名
	 */
	@ApiModelProperty(value="店铺名")
private String storeName;
	/**
	 * 店铺logo
	 */
	@ApiModelProperty(value="店铺logo")
private String storeLogo;
	/**
	 * 店铺地址
	 */
	@ApiModelProperty(value="店铺地址")
private String storeAddress;
	/**
	 * 店铺经度
	 */
	@ApiModelProperty(value="店铺经度")
private Double longitude;
	/**
	 * 店铺纬度
	 */
	@ApiModelProperty(value="店铺纬度")
private Double latitude;
	/**
	 * 店铺详情
	 */
	@ApiModelProperty(value="店铺详情")
private String storeIntroduce;
	/**
	 * 店铺状态（0：待审核；1：已通过；2：未通过）
	 */
	@ApiModelProperty(value="店铺状态（0：待审核；1：已通过；2：未通过）")
private Integer storeStatus;
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
	 * 创建时间
	 */
	@ApiModelProperty(value="创建时间")
private Date createTime;
	/**
	 * 备注
	 */
	@ApiModelProperty(value="备注")
private String remark;
	/**
	 * 浏览量
	 * */
	@ApiModelProperty(value = "浏览量")
	private Integer pageView;

    public Integer getPageView() {
        return pageView;
    }

    public void setPageView(Integer pageView) {
        this.pageView = pageView;
    }

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
	 * 设置：商户id
	 */
	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
	}
	/**
	 * 获取：商户id
	 */
	public Long getSellerId() {
		return sellerId;
	}
	/**
	 * 设置：店铺名
	 */
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	/**
	 * 获取：店铺名
	 */
	public String getStoreName() {
		return storeName;
	}
	/**
	 * 设置：店铺logo
	 */
	public void setStoreLogo(String storeLogo) {
		this.storeLogo = storeLogo;
	}
	/**
	 * 获取：店铺logo
	 */
	public String getStoreLogo() {
		return storeLogo;
	}
	/**
	 * 设置：店铺地址
	 */
	public void setStoreAddress(String storeAddress) {
		this.storeAddress = storeAddress;
	}
	/**
	 * 获取：店铺地址
	 */
	public String getStoreAddress() {
		return storeAddress;
	}
	/**
	 * 设置：店铺经度
	 */
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	/**
	 * 获取：店铺经度
	 */
	public Double getLongitude() {
		return longitude;
	}
	/**
	 * 设置：店铺纬度
	 */
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	/**
	 * 获取：店铺纬度
	 */
	public Double getLatitude() {
		return latitude;
	}
	/**
	 * 设置：店铺详情
	 */
	public void setStoreIntroduce(String storeIntroduce) {
		this.storeIntroduce = storeIntroduce;
	}
	/**
	 * 获取：店铺详情
	 */
	public String getStoreIntroduce() {
		return storeIntroduce;
	}
	/**
	 * 设置：店铺状态（0：待审核；1：已通过；2：未通过）
	 */
	public void setStoreStatus(Integer storeStatus) {
		this.storeStatus = storeStatus;
	}
	/**
	 * 获取：店铺状态（0：待审核；1：已通过；2：未通过）
	 */
	public Integer getStoreStatus() {
		return storeStatus;
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
