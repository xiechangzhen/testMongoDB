package com.yymt.entity.sport;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 测试题
 * 
 * @author hgq
 * @date 2018-04-19 15:10:24
 */
@TableName("tb_test")
public class TestEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 测试页面
	 */
	private String testPage;
	/**
	 * 测试标题
	 */
	private String testTitle;
	/**
	 * 测试分类
	 */
	private String testType;
	/**
	 * 测试题说明
	 */
	private String testTitleDetail;
	/**
	 * 
	 */
	private Integer testQuestionsCount;
	/**
	 * 参与测试人数
	 */
	private Integer joinTestCount;
	/**
	 * 测试图片
	 */
	private String testImage;
	/**
	 * 
	 */
	private Date createTime;

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
	 * 设置：测试页面
	 */
	public void setTestPage(String testPage) {
		this.testPage = testPage;
	}
	/**
	 * 获取：测试页面
	 */
	public String getTestPage() {
		return testPage;
	}
	/**
	 * 设置：测试标题
	 */
	public void setTestTitle(String testTitle) {
		this.testTitle = testTitle;
	}
	/**
	 * 获取：测试标题
	 */
	public String getTestTitle() {
		return testTitle;
	}
	/**
	 * 设置：测试分类
	 */
	public void setTestType(String testType) {
		this.testType = testType;
	}
	/**
	 * 获取：测试分类
	 */
	public String getTestType() {
		return testType;
	}
	/**
	 * 设置：测试题说明
	 */
	public void setTestTitleDetail(String testTitleDetail) {
		this.testTitleDetail = testTitleDetail;
	}
	/**
	 * 获取：测试题说明
	 */
	public String getTestTitleDetail() {
		return testTitleDetail;
	}
	/**
	 * 设置：
	 */
	public void setTestQuestionsCount(Integer testQuestionsCount) {
		this.testQuestionsCount = testQuestionsCount;
	}
	/**
	 * 获取：
	 */
	public Integer getTestQuestionsCount() {
		return testQuestionsCount;
	}
	/**
	 * 设置：参与测试人数
	 */
	public void setJoinTestCount(Integer joinTestCount) {
		this.joinTestCount = joinTestCount;
	}
	/**
	 * 获取：参与测试人数
	 */
	public Integer getJoinTestCount() {
		return joinTestCount;
	}
	/**
	 * 设置：测试图片
	 */
	public void setTestImage(String testImage) {
		this.testImage = testImage;
	}
	/**
	 * 获取：测试图片
	 */
	public String getTestImage() {
		return testImage;
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
