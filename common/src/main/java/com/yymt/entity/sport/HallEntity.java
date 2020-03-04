package com.yymt.entity.sport;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 场馆表
 *
 * @author cots
 * @date 2018-09-12 11:04:21
 */
@TableName("tb_hall")
@ApiModel(description = "场馆表")
public class HallEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    @TableId
    @ApiModelProperty(value = "")
    private Integer id;
    /**
     * 场馆名称
     */
    @ApiModelProperty(value = "场馆名称")
    private String hallName;
    /**
     * 建成时间
     */
    @ApiModelProperty(value = "建成时间")
    private Date buildTime;
    /**
     * 地址
     */
    @ApiModelProperty(value = "地址")
    private String hallAddress;
    /**
     * 经度
     */
    @ApiModelProperty(value = "经度")
    private Double hallLongitude;
    /**
     * 纬度
     */
    @ApiModelProperty(value = "纬度")
    private Double hallLatitude;
    /**
     * 场馆上午开放时间
     */
    @ApiModelProperty(value = "场馆开放时间")
    @JsonFormat(pattern = "HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date hallOpenTimeAm;
    /**
     * 场馆上午关闭时间
     */
    @JsonFormat(pattern = "HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @ApiModelProperty(value = "场馆关闭时间")
    private Date hallCloseTimeAm;

    /**
     * 场馆下午开放时间
     */
    @JsonFormat(pattern = "HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @ApiModelProperty(value = "场馆开放时间")
    private Date hallOpenTimePm;
    /**
     * 场馆下午关闭时间
     */
    @JsonFormat(pattern = "HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @ApiModelProperty(value = "场馆关闭时间")
    private Date hallCloseTimePm;
    /**
     * 场馆联系电话
     */
    @ApiModelProperty(value = "场馆联系电话")
    private String hallContact;
    /**
     * 场馆负责人
     */
    @ApiModelProperty(value = "场馆负责人")
    private String hallLeader;
    /**
     * 场馆网址
     */
    @ApiModelProperty(value = "场馆网址")
    private String hallSite;
    /**
     * 场馆介绍
     */
    @ApiModelProperty(value = "场馆介绍")
    private String hallIntroduction;
    /**
     * 公交线路
     */
    @ApiModelProperty(value = "公交线路")
    private String hallBus;
    /**
     * 场馆状态(0-停业,1-正常)
     */
    @ApiModelProperty(value = "场馆状态(0-停业,1-正常)")
    private Integer hallStatus;
    /**
     * 场馆类型(0-公立,1私立)
     */
    @ApiModelProperty(value = "场馆类型(0-公立,1私立)")
    private String hallType;
    /**
     * 访问量
     */
    @ApiModelProperty(value = "访问量")
    private Integer pageView;
    /**
     * 全景地址
     */
    @ApiModelProperty(value = "全景地址")
    private String hallPanoramaSite;
    /**
     * 开放星期
     */
    @ApiModelProperty(value = "开放星期")
    private String hallOpenWeek;
    /**
     * 区域编码
     */
    @ApiModelProperty(value = "区域编码")
    private Integer hallArea;
    /**
     * 场馆图片
     */
    @ApiModelProperty(value = "场馆图片")
    private String hallImages;
    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remark;

    @TableField(exist=false)
    private List<HallPriceEntity> price;

    @TableField(exist=false)
    private List<HallSportEntity> sportEntities;

    public List<HallSportEntity> getSportEntities() {
        return sportEntities;
    }

    public void setSportEntities(List<HallSportEntity> sportEntities) {
        this.sportEntities = sportEntities;
    }

    /**
     * 审核人
     */
    private Long auditor;
    /**
     * 审核时间
     */
    private Date auditTime;

    /**
     * 创建人
     */
    @ApiModelProperty(value = "创建人")
    private Long author;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    /**
     * 场馆状态
     * */
    @ApiModelProperty(value = "场馆状态")
    private Integer hallIsOpen;


    public Long getAuditor() {
        return auditor;
    }

    public void setAuditor(Long auditor) {
        this.auditor = auditor;
    }

    public Date getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    public Long getAuthor() {
        return author;
    }

    public void setAuthor(Long author) {
        this.author = author;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public List<HallPriceEntity> getPrice() {
        return price;
    }

    public void setPrice(List<HallPriceEntity> price) {
        this.price = price;
    }

    /**
     * 点赞数
     */
    @TableField(exist = false)
    private Integer greats;

    /**
     * 场馆项目列表
     */
    @TableField(exist = false)
    private List<SportsEntity> sports;

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
     * 设置：场馆名称
     */
    public void setHallName(String hallName) {
        this.hallName = hallName;
    }

    /**
     * 获取：场馆名称
     */
    public String getHallName() {
        return hallName;
    }

    /**
     * 设置：建成时间
     */
    public void setBuildTime(Date buildTime) {
        this.buildTime = buildTime;
    }

    /**
     * 获取：建成时间
     */
    public Date getBuildTime() {
        return buildTime;
    }

    /**
     * 设置：地址
     */
    public void setHallAddress(String hallAddress) {
        this.hallAddress = hallAddress;
    }

    /**
     * 获取：地址
     */
    public String getHallAddress() {
        return hallAddress;
    }

    /**
     * 设置：经度
     */
    public void setHallLongitude(Double hallLongitude) {
        this.hallLongitude = hallLongitude;
    }

    /**
     * 获取：经度
     */
    public Double getHallLongitude() {
        return hallLongitude;
    }

    /**
     * 设置：纬度
     */
    public void setHallLatitude(Double hallLatitude) {
        this.hallLatitude = hallLatitude;
    }

    /**
     * 获取：纬度
     */
    public Double getHallLatitude() {
        return hallLatitude;
    }

    public Date getHallOpenTimeAm() {
        return hallOpenTimeAm;
    }

    public void setHallOpenTimeAm(Date hallOpenTimeAm) {
        this.hallOpenTimeAm = hallOpenTimeAm;
    }

    public Date getHallCloseTimeAm() {
        return hallCloseTimeAm;
    }

    public void setHallCloseTimeAm(Date hallCloseTimeAm) {
        this.hallCloseTimeAm = hallCloseTimeAm;
    }

    public Date getHallOpenTimePm() {
        return hallOpenTimePm;
    }

    public void setHallOpenTimePm(Date hallOpenTimePm) {
        this.hallOpenTimePm = hallOpenTimePm;
    }

    public Date getHallCloseTimePm() {
        return hallCloseTimePm;
    }

    public void setHallCloseTimePm(Date hallCloseTimePm) {
        this.hallCloseTimePm = hallCloseTimePm;
    }

    /**
     * 设置：场馆联系电话
     */
    public void setHallContact(String hallContact) {
        this.hallContact = hallContact;
    }

    /**
     * 获取：场馆联系电话
     */
    public String getHallContact() {
        return hallContact;
    }

    /**
     * 设置：场馆负责人
     */
    public void setHallLeader(String hallLeader) {
        this.hallLeader = hallLeader;
    }

    /**
     * 获取：场馆负责人
     */
    public String getHallLeader() {
        return hallLeader;
    }

    /**
     * 设置：场馆网址
     */
    public void setHallSite(String hallSite) {
        this.hallSite = hallSite;
    }

    /**
     * 获取：场馆网址
     */
    public String getHallSite() {
        return hallSite;
    }

    /**
     * 设置：场馆介绍
     */
    public void setHallIntroduction(String hallIntroduction) {
        this.hallIntroduction = hallIntroduction;
    }

    /**
     * 获取：场馆介绍
     */
    public String getHallIntroduction() {
        return hallIntroduction;
    }

    /**
     * 设置：公交线路
     */
    public void setHallBus(String hallBus) {
        this.hallBus = hallBus;
    }

    /**
     * 获取：公交线路
     */
    public String getHallBus() {
        return hallBus;
    }

    /**
     * 设置：场馆状态(0-停业,1-正常)
     */
    public void setHallStatus(Integer hallStatus) {
        this.hallStatus = hallStatus;
    }

    /**
     * 获取：场馆状态(0-停业,1-正常)
     */
    public Integer getHallStatus() {
        return hallStatus;
    }

    /**
     * 设置：场馆类型(0-公立,1私立)
     */
    public void setHallType(String hallType) {
        this.hallType = hallType;
    }

    /**
     * 获取：场馆类型(0-公立,1私立)
     */
    public String getHallType() {
        return hallType;
    }

    /**
     * 设置：访问量
     */
    public void setPageView(Integer pageView) {
        this.pageView = pageView;
    }

    /**
     * 获取：访问量
     */
    public Integer getPageView() {
        return pageView;
    }

    /**
     * 设置：全景地址
     */
    public void setHallPanoramaSite(String hallPanoramaSite) {
        this.hallPanoramaSite = hallPanoramaSite;
    }

    /**
     * 获取：全景地址
     */
    public String getHallPanoramaSite() {
        return hallPanoramaSite;
    }

    /**
     * 设置：开放星期
     */
    public void setHallOpenWeek(String hallOpenWeek) {
        this.hallOpenWeek = hallOpenWeek;
    }

    /**
     * 获取：开放星期
     */
    public String getHallOpenWeek() {
        return hallOpenWeek;
    }

    /**
     * 设置：区域编码
     */
    public void setHallArea(Integer hallArea) {
        this.hallArea = hallArea;
    }

    /**
     * 获取：区域编码
     */
    public Integer getHallArea() {
        return hallArea;
    }

    /**
     * 设置：场馆图片
     */
    public void setHallImages(String hallImages) {
        this.hallImages = hallImages;
    }

    /**
     * 获取：场馆图片
     */
    public String getHallImages() {
        return hallImages;
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

    /**
     * 获取：点赞数
     */
    public Integer getGreats() {
        return greats;
    }

    /**
     * 设置：点赞数
     */
    public void setGreats(Integer greats) {
        this.greats = greats;
    }

    /**
     * 获取：场馆项目列表
     */
    public List<SportsEntity> getSports() {
        return sports;
    }

    /**
     * 设置：场馆项目列表
     */
    public void setSports(List<SportsEntity> sports) {
        this.sports = sports;
    }

    public Integer getHallIsOpen() {
        return hallIsOpen;
    }

    public void setHallIsOpen(Integer hallIsOpen) {
        this.hallIsOpen = hallIsOpen;
    }
}
