package com.yymt.entity.sport;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 赛事点赞
 * 
 * @author cots
 * @date 2018-09-14 11:13:50
 */
@TableName("tb_games_greats")
@ApiModel(description="赛事点赞")
public class GamesGreatsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 赛事培训ID
	 */
	@TableId
	@ApiModelProperty(value="赛事培训ID")
private Integer gameId;
	/**
	 * 用户ID
	 */
	@ApiModelProperty(value="用户ID")
private Long userId;
	/**
	 * 点赞时间
	 */
	@ApiModelProperty(value="点赞时间")
private Date createTime;

	/**
	 * 设置：赛事培训ID
	 */
	public void setGameId(Integer gameId) {
		this.gameId = gameId;
	}
	/**
	 * 获取：赛事培训ID
	 */
	public Integer getGameId() {
		return gameId;
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
	 * 设置：点赞时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：点赞时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
}
