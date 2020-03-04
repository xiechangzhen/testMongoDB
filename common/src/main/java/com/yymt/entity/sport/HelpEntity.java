package com.yymt.entity.sport;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 求助表
 * 
 * @author hgq
 * @date 2018-03-06 15:44:37
 */
@TableName("tb_help")
public class HelpEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 求助内容
	 */
	private String helpContent;
	/**
	 * 
	 */
	@ApiModelProperty(hidden = true)
	private Long helpUserId;
	/**
	 * 是否匿名发布(0-非匿名，1-匿名)
	 */
	private String isAnonymous;
	/**
	 * 求助类型(0-情感，1-婚姻，2-失恋，3-家庭，4-职场，5-校园，6-同性，7-创业，8-海外，9-两性，10-青春，11-其他)
	 */
	private Integer helpType;
	/**
	 * 求助时间
	 */
	@ApiModelProperty(hidden = true)
	private Date helpCreateTime;
	/**
	 * 是否已解决（0-未解决，1-已解决）
	 */
	@ApiModelProperty(hidden = true)
	private Integer isSolve;
	/**
	 * 备注
	 */
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
	 * 设置：求助内容
	 */
	public void setHelpContent(String helpContent) {
		this.helpContent = helpContent;
	}
	/**
	 * 获取：求助内容
	 */
	public String getHelpContent() {
		return helpContent;
	}
	/**
	 * 设置：
	 */
	public void setHelpUserId(Long helpUserId) {
		this.helpUserId = helpUserId;
	}
	/**
	 * 获取：
	 */
	public Long getHelpUserId() {
		return helpUserId;
	}
	/**
	 * 设置：是否匿名发布(0-非匿名，1-匿名)
	 */
	public void setIsAnonymous(String isAnonymous) {
		this.isAnonymous = isAnonymous;
	}
	/**
	 * 获取：是否匿名发布(0-非匿名，1-匿名)
	 */
	public String getIsAnonymous() {
		return isAnonymous;
	}
	/**
	 * 设置：求助类型(0-情感，1-婚姻，2-失恋，3-家庭，4-职场，5-校园，6-同性，7-创业，8-海外，9-两性，10-青春，11-其他)
	 */
	public void setHelpType(Integer helpType) {
		this.helpType = helpType;
	}
	/**
	 * 获取：求助类型(0-情感，1-婚姻，2-失恋，3-家庭，4-职场，5-校园，6-同性，7-创业，8-海外，9-两性，10-青春，11-其他)
	 */
	public Integer getHelpType() {
		return helpType;
	}
	/**
	 * 设置：求助时间
	 */
	public void setHelpCreateTime(Date helpCreateTime) {
		this.helpCreateTime = helpCreateTime;
	}
	/**
	 * 获取：求助时间
	 */
	public Date getHelpCreateTime() {
		return helpCreateTime;
	}
	/**
	 * 设置：是否已解决（0-未解决，1-已解决）
	 */
	public void setIsSolve(Integer isSolve) {
		this.isSolve = isSolve;
	}
	/**
	 * 获取：是否已解决（0-未解决，1-已解决）
	 */
	public Integer getIsSolve() {
		return isSolve;
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
