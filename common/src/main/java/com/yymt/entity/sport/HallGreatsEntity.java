package com.yymt.entity.sport;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 场馆点赞表
 *
 * @author cots
 * @date 2018-09-14 11:13:50
 */
@TableName("tb_hall_greats")
@ApiModel(description = "场馆点赞表")
public class HallGreatsEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 场馆ID
     */
    @ApiModelProperty(value = "场馆ID")
    private Integer hallId;
    /**
     * 用户ID
     */
    @ApiModelProperty(value = "用户ID")
    private Long userId;
    /**
     *
     */
    @ApiModelProperty(value = "点赞时间")
    private Date createTime;

    /**
     * 设置：场馆ID
     */
    public void setHallId(Integer hallId) {
        this.hallId = hallId;
    }

    /**
     * 获取：场馆ID
     */
    public Integer getHallId() {
        return hallId;
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
