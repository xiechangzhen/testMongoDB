package com.yymt.entity.sport;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户心情表
 * 
 * @author hgq
 * @date 2018-03-03 10:44:04
 */
@TableName("tb_feelings")
public class FeelingsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 心情ID
	 */
	@TableId
	private Integer id;
	/**
	 * 心情内容
	 */
	private String feelingsComment;
	/**
	 * 用户ID
	 */
	private Long userId;
	/**
	 * 是否匿名发布(0-非匿名，1-匿名)
	 */
	private Integer isAnonymous;
	/**
	 * 心情背景图片
	 */
	private String backgroundImage;
	/**
	 * 心情创建时间
	 */
	private Date feelingsCreatetime;
	/**
	 * 心情阅读量
	 */
	private Long feelingsReadCount;
	/**
	 * 备注
	 */
	private String remark;

	/**
	 * 设置：心情ID
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：心情ID
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：心情内容
	 */
	public void setFeelingsComment(String feelingsComment) {
		this.feelingsComment = feelingsComment;
	}
	/**
	 * 获取：心情内容
	 */
	public String getFeelingsComment() {
		return feelingsComment;
	}
	/**
	 * 设置：用户ID
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * 获取：用户ID
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * 设置：是否匿名发布(0-非匿名，1-匿名)
	 */
	public void setIsAnonymous(Integer isAnonymous) {
		this.isAnonymous = isAnonymous;
	}
	/**
	 * 获取：是否匿名发布(0-非匿名，1-匿名)
	 */
	public Integer getIsAnonymous() {
		return isAnonymous;
	}
	/**
	 * 设置：心情背景图片
	 */
	public void setBackgroundImage(String backgroundImage) {
		this.backgroundImage = backgroundImage;
	}
	/**
	 * 获取：心情背景图片
	 */
	public String getBackgroundImage() {
		return backgroundImage;
	}
	/**
	 * 设置：心情创建时间
	 */
	public void setFeelingsCreatetime(Date feelingsCreatetime) {
		this.feelingsCreatetime = feelingsCreatetime;
	}
	/**
	 * 获取：心情创建时间
	 */
	public Date getFeelingsCreatetime() {
		return feelingsCreatetime;
	}
	/**
	 * 设置：心情阅读量
	 */
	public void setFeelingsReadCount(Long feelingsReadCount) {
		this.feelingsReadCount = feelingsReadCount;
	}
	/**
	 * 获取：心情阅读量
	 */
	public Long getFeelingsReadCount() {
		return feelingsReadCount;
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
