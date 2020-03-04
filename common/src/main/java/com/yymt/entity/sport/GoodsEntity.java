package com.yymt.entity.sport;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.math.BigDecimal;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 商品
 * 
 * @author cots
 * @date 2018-12-13 08:52:56
 */
@TableName("tb_goods")
@ApiModel(description="商品")
public class GoodsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 标识
	 */
	@TableId
	@ApiModelProperty(value="标识")
private Long id;
	/**
	 * 商品名称
	 */
	@ApiModelProperty(value="商品名称")
private String goodsName;
	/**
	 * 价格
	 */
	@ApiModelProperty(value="价格")
private BigDecimal goodsPrice;
	/**
	 * 分类标识
	 */
	@ApiModelProperty(value="分类标识")
private Integer categoryId;
	/**
	 * 商品图片
	 */
	@ApiModelProperty(value="商品图片")
private String goodsImage;
	/**
	 * 状态（0：待审核；1：审核通过；2：审核未通过；3：下架）
	 */
	@ApiModelProperty(value="状态（0：待审核；1：审核通过；2：审核未通过；3：下架）")
private Integer goodsStatus;
	/**
	 * 商品详情
	 */
	@ApiModelProperty(value="商品详情")
private String goodsDetails;
	/**
	 * 发布者标识
	 */
	@ApiModelProperty(value="发布者标识")
private Long createUserId;
	/**
	 * 商铺标识
	 */
	@ApiModelProperty(value="商铺标识")
private Integer shopId;
	/**
	 * 审核者标识
	 */
	@ApiModelProperty(value="审核者标识")
private Long auditUserId;
	/**
	 * 审核时间
	 */
	@ApiModelProperty(value="审核时间")
private Date auditTime;
	/**
	 * 备注
	 */
	@ApiModelProperty(value="备注")
private String remark;
	/**
	 * 创建时间
	 */
	@ApiModelProperty(value="创建时间")
private Date createTime;
	/**
	 * 修改时间
	 */
	@ApiModelProperty(value="修改时间")
private Date modifyTime;
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
	 * 设置：标识
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：标识
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：商品名称
	 */
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	/**
	 * 获取：商品名称
	 */
	public String getGoodsName() {
		return goodsName;
	}
	/**
	 * 设置：价格
	 */
	public void setGoodsPrice(BigDecimal goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	/**
	 * 获取：价格
	 */
	public BigDecimal getGoodsPrice() {
		return goodsPrice;
	}
	/**
	 * 设置：分类标识
	 */
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	/**
	 * 获取：分类标识
	 */
	public Integer getCategoryId() {
		return categoryId;
	}
	/**
	 * 设置：商品图片
	 */
	public void setGoodsImage(String goodsImage) {
		this.goodsImage = goodsImage;
	}
	/**
	 * 获取：商品图片
	 */
	public String getGoodsImage() {
		return goodsImage;
	}
	/**
	 * 设置：状态（0：待审核；1：审核通过；2：审核未通过；3：下架）
	 */
	public void setGoodsStatus(Integer goodsStatus) {
		this.goodsStatus = goodsStatus;
	}
	/**
	 * 获取：状态（0：待审核；1：审核通过；2：审核未通过；3：下架）
	 */
	public Integer getGoodsStatus() {
		return goodsStatus;
	}
	/**
	 * 设置：商品详情
	 */
	public void setGoodsDetails(String goodsDetails) {
		this.goodsDetails = goodsDetails;
	}
	/**
	 * 获取：商品详情
	 */
	public String getGoodsDetails() {
		return goodsDetails;
	}
	/**
	 * 设置：发布者标识
	 */
	public void setCreateUserId(Long createUserId) {
		this.createUserId = createUserId;
	}
	/**
	 * 获取：发布者标识
	 */
	public Long getCreateUserId() {
		return createUserId;
	}
	/**
	 * 设置：商铺标识
	 */
	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}
	/**
	 * 获取：商铺标识
	 */
	public Integer getShopId() {
		return shopId;
	}
	/**
	 * 设置：审核者标识
	 */
	public void setAuditUserId(Long auditUserId) {
		this.auditUserId = auditUserId;
	}
	/**
	 * 获取：审核者标识
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
	 * 设置：修改时间
	 */
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
	/**
	 * 获取：修改时间
	 */
	public Date getModifyTime() {
		return modifyTime;
	}
}
