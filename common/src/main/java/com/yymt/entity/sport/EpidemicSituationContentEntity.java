package com.yymt.entity.sport;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 疫情信息
 * 
 * @author cots
 * @date 2020-01-28 19:34:48
 */
@TableName("tb_epidemic_situation_content")
@ApiModel(description="疫情信息")
public class EpidemicSituationContentEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	@ApiModelProperty(value="")
private Integer id;
	/**
	 * 新闻标题
	 */
	@ApiModelProperty(value="新闻标题")
private String newsTitle;
	/**
	 * 新闻内容
	 */
	@ApiModelProperty(value="新闻内容")
private String newsContent;
	/**
	 * 摘要
	 */
	@ApiModelProperty(value="摘要")
private String newsSummary;
	/**
	 * 摘要图片
	 */
	@ApiModelProperty(value="摘要图片")
private String newsSummaryImage;
	/**
	 * 新闻导航图片
	 */
	@ApiModelProperty(value="新闻导航图片")
private String newsNavImage;
	/**
	 * 新闻类型（0-疫情宣传,1-疫情防控）
	 */
	@ApiModelProperty(value="新闻类型（0-疫情宣传,1-疫情防控）")
private Integer newsType;
	/**
	 * 附件
	 */
	@ApiModelProperty(value="附件")
private String newsAttach;
	/**
	 * 新闻标签
	 */
	@ApiModelProperty(value="新闻标签")
private String newsTags;
	/**
	 * 点击数
	 */
	@ApiModelProperty(value="点击数")
private Integer pageView;
	/**
	 * 创建时间
	 */
	@ApiModelProperty(value="创建时间")
private Date newsCreateTime;
	/**
	 * 是否放置宣传栏
	 */
	@ApiModelProperty(value="是否放置宣传栏")
private Integer isRecommend;
	/**
	 * 未通过原因
	 */
	@ApiModelProperty(value="未通过原因")
private String remark;

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
	 * 设置：新闻标题
	 */
	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}
	/**
	 * 获取：新闻标题
	 */
	public String getNewsTitle() {
		return newsTitle;
	}
	/**
	 * 设置：新闻内容
	 */
	public void setNewsContent(String newsContent) {
		this.newsContent = newsContent;
	}
	/**
	 * 获取：新闻内容
	 */
	public String getNewsContent() {
		return newsContent;
	}
	/**
	 * 设置：摘要
	 */
	public void setNewsSummary(String newsSummary) {
		this.newsSummary = newsSummary;
	}
	/**
	 * 获取：摘要
	 */
	public String getNewsSummary() {
		return newsSummary;
	}
	/**
	 * 设置：摘要图片
	 */
	public void setNewsSummaryImage(String newsSummaryImage) {
		this.newsSummaryImage = newsSummaryImage;
	}
	/**
	 * 获取：摘要图片
	 */
	public String getNewsSummaryImage() {
		return newsSummaryImage;
	}
	/**
	 * 设置：新闻导航图片
	 */
	public void setNewsNavImage(String newsNavImage) {
		this.newsNavImage = newsNavImage;
	}
	/**
	 * 获取：新闻导航图片
	 */
	public String getNewsNavImage() {
		return newsNavImage;
	}
	/**
	 * 设置：新闻类型（0-疫情宣传,1-疫情防控）
	 */
	public void setNewsType(Integer newsType) {
		this.newsType = newsType;
	}
	/**
	 * 获取：新闻类型（0-疫情宣传,1-疫情防控）
	 */
	public Integer getNewsType() {
		return newsType;
	}
	/**
	 * 设置：附件
	 */
	public void setNewsAttach(String newsAttach) {
		this.newsAttach = newsAttach;
	}
	/**
	 * 获取：附件
	 */
	public String getNewsAttach() {
		return newsAttach;
	}
	/**
	 * 设置：新闻标签
	 */
	public void setNewsTags(String newsTags) {
		this.newsTags = newsTags;
	}
	/**
	 * 获取：新闻标签
	 */
	public String getNewsTags() {
		return newsTags;
	}
	/**
	 * 设置：点击数
	 */
	public void setPageView(Integer pageView) {
		this.pageView = pageView;
	}
	/**
	 * 获取：点击数
	 */
	public Integer getPageView() {
		return pageView;
	}
	/**
	 * 设置：创建时间
	 */
	public void setNewsCreateTime(Date newsCreateTime) {
		this.newsCreateTime = newsCreateTime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getNewsCreateTime() {
		return newsCreateTime;
	}
	/**
	 * 设置：是否放置宣传栏
	 */
	public void setIsRecommend(Integer isRecommend) {
		this.isRecommend = isRecommend;
	}
	/**
	 * 获取：是否放置宣传栏
	 */
	public Integer getIsRecommend() {
		return isRecommend;
	}
	/**
	 * 设置：未通过原因
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：未通过原因
	 */
	public String getRemark() {
		return remark;
	}
}
