package com.yymt.entity.sport;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 组织点赞表
 *
 * @author cots
 * @date 2018-09-14 11:13:50
 */
@TableName("tb_corporation_greats")
@ApiModel(description = "组织点赞表")
public class CorporationGreatsEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 社团ID
     */
    @ApiModelProperty(value = "社团ID")
    private Integer corporationId;
    /**
     * 用户ID
     */
    @ApiModelProperty(value = "用户ID")
    private Long userId;
    /**
     * 点赞时间
     */
    @ApiModelProperty(value = "点赞时间")
    private Date greatsTime;

    /**
     * 设置：社团ID
     */
    public void setCorporationId(Integer corporationId) {
        this.corporationId = corporationId;
    }

    /**
     * 获取：社团ID
     */
    public Integer getCorporationId() {
        return corporationId;
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
    public void setGreatsTime(Date greatsTime) {
        this.greatsTime = greatsTime;
    }

    /**
     * 获取：点赞时间
     */
    public Date getGreatsTime() {
        return greatsTime;
    }
}
