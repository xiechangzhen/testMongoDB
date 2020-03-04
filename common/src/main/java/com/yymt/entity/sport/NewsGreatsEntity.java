package com.yymt.entity.sport;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 新闻点赞表
 *
 * @author cots
 * @date 2018-09-14 11:13:50
 */
@TableName("tb_news_greats")
@ApiModel(description = "新闻点赞表")
public class NewsGreatsEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 新闻ID
     */
    @ApiModelProperty(value = "新闻ID")
    private Integer newsId;

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
     * 设置：新闻ID
     */
    public void setNewsId(Integer newsId) {
        this.newsId = newsId;
    }

    /**
     * 获取：新闻ID
     */
    public Integer getNewsId() {
        return newsId;
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
