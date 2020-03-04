package com.yymt.entity.sport;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * @author cots
 * @date 2018-10-15 17:20:49
 */
@TableName("tb_industry_sports_level")
@ApiModel(description = "行业人员职位称号")
public class IndustrySportsLevelEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 人员类别(0-运动员,1-教练员,2-裁判员,3-社会指导员)
     */
    @ApiModelProperty(value = "人员类别(0-运动员,1-教练员,2-裁判员,3-社会指导员)")
    private Integer personType;
    /**
     * 行业人员ID
     */
    @ApiModelProperty(value = "行业人员ID")
    private Integer industryPersonId;
    /**
     * 项目ID
     */
    @ApiModelProperty(value = "项目ID")
    private Integer sportId;
    /**
     * 等级ID
     */
    @ApiModelProperty(value = "等级ID")
    private Integer levelId;

    /**
     * 体育项目名称
     */
    @TableField(exist = false)
    private String sportName;

    /**
     * 等级
     */
    @TableField(exist = false)
    private SportsmanLevelEntity sportsmanLevel;

    /**
     * 设置：人员类别(0-运动员,1-教练员,2-裁判员,3-社会指导员)
     */
    public void setPersonType(Integer personType) {
        this.personType = personType;
    }

    /**
     * 获取：人员类别(0-运动员,1-教练员,2-裁判员,3-社会指导员)
     */
    public Integer getPersonType() {
        return personType;
    }

    /**
     * 设置：行业人员ID
     */
    public void setIndustryPersonId(Integer industryPersonId) {
        this.industryPersonId = industryPersonId;
    }

    /**
     * 获取：行业人员ID
     */
    public Integer getIndustryPersonId() {
        return industryPersonId;
    }

    /**
     * 设置：项目ID
     */
    public void setSportId(Integer sportId) {
        this.sportId = sportId;
    }

    /**
     * 获取：项目ID
     */
    public Integer getSportId() {
        return sportId;
    }

    /**
     * 设置：等级ID
     */
    public void setLevelId(Integer levelId) {
        this.levelId = levelId;
    }

    /**
     * 获取：等级ID
     */
    public Integer getLevelId() {
        return levelId;
    }

    /**
     * 获取：体育项目名称
     */
    public String getSportName() {
        return sportName;
    }

    /**
     * 设置：体育项目名称
     *
     * @param sportName 体育项目名称
     */
    public void setSportName(String sportName) {
        this.sportName = sportName;
    }

    /**
     * 获取：等级
     */
    public SportsmanLevelEntity getSportsmanLevel() {
        return sportsmanLevel;
    }

    /**
     * 设置：等级
     *
     * @param sportsmanLevel
     */
    public void setSportsmanLevel(SportsmanLevelEntity sportsmanLevel) {
        this.sportsmanLevel = sportsmanLevel;
    }
}
