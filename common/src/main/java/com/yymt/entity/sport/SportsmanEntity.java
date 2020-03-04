package com.yymt.entity.sport;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 运动员等级
 *
 * @author cots
 * @date 2018-08-22 08:52:52
 */
@TableName("tb_sportsman")
public class SportsmanEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    @TableId
    private Integer id;
    /**
     *
     */
    private String levelName;

    /**
     *
     */
    private Integer levelType;
    /**
     *
     */
    private Date createTime;
    /**
     *
     */
    private Date updateTime;

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
     * 设置：
     */
    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    /**
     * 获取：
     */
    public String getLevelName() {
        return levelName;
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

    /**
     * 设置：
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取：
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 获取：等级类型(0-运动员,1-教练员,2-裁判员,3-社会指导员)
     */
    public Integer getLevelType() {
        return levelType;
    }

    /**
     * 设置：等级类型(0-运动员,1-教练员,2-裁判员,3-社会指导员)
     *
     * @param levelType
     */
    public void setLevelType(Integer levelType) {
        this.levelType = levelType;
    }
}
