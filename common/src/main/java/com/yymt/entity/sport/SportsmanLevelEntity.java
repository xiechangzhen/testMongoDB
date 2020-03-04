package com.yymt.entity.sport;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 运动员等级
 *
 * @author cots
 * @date 2018-09-12 11:04:21
 */
@TableName("tb_sportsman_level")
@ApiModel(description = "运动员等级")
public class SportsmanLevelEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 序号
     */
    @TableId
    @ApiModelProperty(value = "序号")
    private Integer id;
    /**
     * 运动员等级名称
     */
    @ApiModelProperty(value = "运动员等级名称")
    private String levelName;
    /**
     * 等级类型(0-运动员,1-教练员,2-裁判员,3-社会指导员)
     */
    @ApiModelProperty(value = "等级类型(0-运动员,1-教练员,2-裁判员,3-社会指导员)")
    private Integer levelType;
    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    /**
     * 修改时间
     */
    @ApiModelProperty(value = "修改时间")
    private Date updateTime;

    /**
     * 设置：序号
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取：序号
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置：运动员等级名称
     */
    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    /**
     * 获取：运动员等级名称
     */
    public String getLevelName() {
        return levelName;
    }

    /**
     * 设置：等级类型(0-运动员,1-教练员,2-裁判员,3-社会指导员)
     */
    public void setLevelType(Integer levelType) {
        this.levelType = levelType;
    }

    /**
     * 获取：等级类型(0-运动员,1-教练员,2-裁判员,3-社会指导员)
     */
    public Integer getLevelType() {
        return levelType;
    }

    /**
     * 设置：创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取：创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置：修改时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取：修改时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }
}
