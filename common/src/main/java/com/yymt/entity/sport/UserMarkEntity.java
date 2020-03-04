package com.yymt.entity.sport;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户收藏表
 * 
 * @author hgq
 * @date 2018-03-03 09:46:37
 */
@TableName("tb_user_mark")
public class UserMarkEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 用户id
	 */
	private Long userId;
	/**
	 * 搜藏ID(根据mark_type的不同，mark_id从属不同的表)
	 */
	private Long markId;
	/**
	 * 收藏类型(0：文章,1:心健康，2:心情,3:求助)
	 */
	private Integer markType;
	/**
	 * 
	 */
	private Date createTime;

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
	 * 设置：用户id
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * 获取：用户id
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * 设置：搜藏ID(根据mark_type的不同，mark_id从属不同的表)
	 */
	public void setMarkId(Long markId) {
		this.markId = markId;
	}
	/**
	 * 获取：搜藏ID(根据mark_type的不同，mark_id从属不同的表)
	 */
	public Long getMarkId() {
		return markId;
	}
	/**
	 * 设置：收藏类型(0：文章,1:心健康，2:心情,3:求助)
	 */
	public void setMarkType(Integer markType) {
		this.markType = markType;
	}
	/**
	 * 获取：收藏类型(0：文章,1:心健康，2:心情,3:求助)
	 */
	public Integer getMarkType() {
		return markType;
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
