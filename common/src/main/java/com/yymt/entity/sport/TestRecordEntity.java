package com.yymt.entity.sport;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 测试题目记录表
 * 
 * @author hgq
 * @date 2018-04-19 11:29:07
 */
@TableName("tb_test_record")
public class TestRecordEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@ApiModelProperty(hidden = true)
	@TableId
	private Integer id;
	/**
	 * 测试用户ID
	 */
	@ApiModelProperty(hidden = true)
	private Long userId;
	/**
	 * 测试题库ID
	 */
	private Long testId;
	/**
	 * 测试结果
	 */
	private String testResult;
	/**
	 * 测试结果说明
	 */
	private String testResultDetail;
	/**
	 * 分析与建议
	 */
	private String testAdvice;
	/**
	 * 推荐的专家
	 */
	private String recommendExpert;
	/**
	 * 是否完成测试
	 */
	private Integer isFinish;
	/**
	 * 测试时间
	 */
	@ApiModelProperty(hidden = true)
	private Date testTime;

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
	 * 设置：测试用户ID
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * 获取：测试用户ID
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * 设置：测试题库ID
	 */
	public void setTestId(Long testId) {
		this.testId = testId;
	}
	/**
	 * 获取：测试题库ID
	 */
	public Long getTestId() {
		return testId;
	}
	/**
	 * 设置：测试结果
	 */
	public void setTestResult(String testResult) {
		this.testResult = testResult;
	}
	/**
	 * 获取：测试结果
	 */
	public String getTestResult() {
		return testResult;
	}
	/**
	 * 设置：测试结果说明
	 */
	public void setTestResultDetail(String testResultDetail) {
		this.testResultDetail = testResultDetail;
	}
	/**
	 * 获取：测试结果说明
	 */
	public String getTestResultDetail() {
		return testResultDetail;
	}
	/**
	 * 设置：分析与建议
	 */
	public void setTestAdvice(String testAdvice) {
		this.testAdvice = testAdvice;
	}
	/**
	 * 获取：分析与建议
	 */
	public String getTestAdvice() {
		return testAdvice;
	}
	/**
	 * 设置：推荐的专家
	 */
	public void setRecommendExpert(String recommendExpert) {
		this.recommendExpert = recommendExpert;
	}
	/**
	 * 获取：推荐的专家
	 */
	public String getRecommendExpert() {
		return recommendExpert;
	}
	/**
	 * 设置：是否完成测试
	 */
	public void setIsFinish(Integer isFinish) {
		this.isFinish = isFinish;
	}
	/**
	 * 获取：是否完成测试
	 */
	public Integer getIsFinish() {
		return isFinish;
	}
	/**
	 * 设置：测试时间
	 */
	public void setTestTime(Date testTime) {
		this.testTime = testTime;
	}
	/**
	 * 获取：测试时间
	 */
	public Date getTestTime() {
		return testTime;
	}
}
