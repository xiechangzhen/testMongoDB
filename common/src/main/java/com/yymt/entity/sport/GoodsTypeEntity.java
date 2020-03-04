package com.yymt.entity.sport;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 商品分类表
 * 
 * @author cots
 * @date 2018-12-13 08:52:56
 */
@TableName("tb_goods_type")
@ApiModel(description="商品分类表")
public class GoodsTypeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键id
	 */
	@TableId
	@ApiModelProperty(value="主键id")
private Integer id;
	/**
	 * 父级id
	 */
	@ApiModelProperty(value="父级id")
private Integer parentId;
	/**
	 * 类型名称
	 */
	@ApiModelProperty(value="类型名称")
private String goodsTypeName;
	/**
	 * 类型图标
	 * */
	@ApiModelProperty(value = "类型图标")
	private String goodsImages;
	/**
	 * 排序序号
	 */
	@ApiModelProperty(value="排序序号")
private Integer orderNum;
	/**
	 * 创建时间
	 */
	@ApiModelProperty(value="创建时间")
private Date createTime;

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
	 * 设置：父级id
	 */
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	/**
	 * 获取：父级id
	 */
	public Integer getParentId() {
		return parentId;
	}
	/**
	 * 设置：类型名称
	 */
	public void setGoodsTypeName(String goodsTypeName) {
		this.goodsTypeName = goodsTypeName;
	}
	/**
	 * 获取：类型名称
	 */
	public String getGoodsTypeName() {
		return goodsTypeName;
	}
	/**
	 * 设置：排序序号
	 */
	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}
	/**
	 * 获取：排序序号
	 */
	public Integer getOrderNum() {
		return orderNum;
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

	public String getGoodsImages() {
		return goodsImages;
	}

	public void setGoodsImages(String goodsImages) {
		this.goodsImages = goodsImages;
	}
}
