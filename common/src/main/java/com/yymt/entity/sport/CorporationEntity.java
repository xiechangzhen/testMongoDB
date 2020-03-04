package com.yymt.entity.sport;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 社团信息表
 *
 * @author cots
 * @date 2018-09-12 11:04:21
 */
@TableName("tb_corporation")
@ApiModel(description = "社团信息表")
public class CorporationEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @TableId
    @ApiModelProperty(value = "编号")
    private Integer id;
    /**
     * 社团名称
     */
    @ApiModelProperty(value = "社团名称")
    private String corporationName;

    /**
     * 社团类型
     */
    @ApiModelProperty(value = "社团类型")
    private Integer corporationType;


    /**
     * 成立时间
     */
    @ApiModelProperty(value = "成立时间")
    private String corporationFoundingTime;
    /**
     * 社团负责人头衔/职位名称
     */
    @ApiModelProperty(value = "社团负责人头衔/职位名称")
    private Integer corporationLeaderPostion;

    /**
     * 社团负责人职位名称
     */
    @TableField(exist = false)
    private String leaderPositionName;

    /**
     * 负责人
     */
    @ApiModelProperty(value = "负责人")
    private String corporationLeader;
    /**
     * 联系电话
     */
    @ApiModelProperty(value = "联系电话")
    private String corporationContact;
    /**
     * 介绍
     */
    @ApiModelProperty(value = "介绍")
    private String corporationIntroduce;
    /**
     * 组织所在区域编码
     */
    @ApiModelProperty(value = "组织所在区域编码")
    private String corparationArea;
    /**
     * 地址
     */
    @ApiModelProperty(value = "地址")
    private String corporationAddress;
    /**
     * 个人会员数
     */
    @ApiModelProperty(value = "个人会员数")
    private Integer personalVipCount;
    /**
     * 实际录入团体会员数
     * */
    @ApiModelProperty(value = "实际录入团体会员数")
    private Integer actualGroupCount;
    /**
     * 团体会员数
     */
    @ApiModelProperty(value = "团体会员数")
    private Integer personalGroupCount;

    /**
     * 社团状态
     */
    @ApiModelProperty(value = "社团状态")
    private Integer corporationStatus;

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
    private Long author;

    public Long getAuthor() {
        return author;
    }

    public void setAuthor(Long author) {
        this.author = author;
    }

    /**
     * 经度
     */
    @ApiModelProperty(value = "经度")
    private Double longitude;
    /**
     * 纬度
     */
    @ApiModelProperty(value = "纬度")
    private Double latitude;

    @ApiModelProperty(value = "访问量")
    private Integer pageView;

    /**
     * 社团图片
     */
    @ApiModelProperty(value = "社团图片")
    private String corporationImages;
    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remark;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 点赞数
     */
    @TableField(exist = false)
    private Integer greats;

    /**
     * 社团运动项目
     */
    @TableField(exist=false)
    private List<CorporationSportsEntity> corporationSportsEntityList;

    public List<CorporationSportsEntity> getCorporationSportsEntityList() {
        return corporationSportsEntityList;
    }

    public void setCorporationSportsEntityList(List<CorporationSportsEntity> corporationSportsEntityList) {
        this.corporationSportsEntityList = corporationSportsEntityList;
    }

    public Integer getCorporationType() {
        return corporationType;
    }

    public void setCorporationType(Integer corporationType) {
        this.corporationType = corporationType;
    }

    public void setCorporationStatus(Integer corporationStatus) {
        this.corporationStatus = corporationStatus;
    }

    public Integer getCorporationStatus() {
        return corporationStatus;
    }

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

    /**
     * 设置：编号
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取：编号
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置：社团名称
     */
    public void setCorporationName(String corporationName) {
        this.corporationName = corporationName;
    }

    /**
     * 获取：社团名称
     */
    public String getCorporationName() {
        return corporationName;
    }

    /**
     * 设置：成立时间
     */
    public void setCorporationFoundingTime(String corporationFoundingTime) {
        this.corporationFoundingTime = corporationFoundingTime;
    }

    /**
     * 获取：成立时间
     */
    public String getCorporationFoundingTime() {
        return corporationFoundingTime;
    }

    /**
     * 设置：社团负责人头衔/职位名称
     */
    public void setCorporationLeaderPostion(Integer corporationLeaderPostion) {
        this.corporationLeaderPostion = corporationLeaderPostion;
    }

    /**
     * 获取：社团负责人头衔/职位名称
     */
    public Integer getCorporationLeaderPostion() {
        return corporationLeaderPostion;
    }

    /**
     * 设置：负责人
     */
    public void setCorporationLeader(String corporationLeader) {
        this.corporationLeader = corporationLeader;
    }

    /**
     * 获取：负责人
     */
    public String getCorporationLeader() {
        return corporationLeader;
    }

    /**
     * 设置：联系电话
     */
    public void setCorporationContact(String corporationContact) {
        this.corporationContact = corporationContact;
    }

    /**
     * 获取：联系电话
     */
    public String getCorporationContact() {
        return corporationContact;
    }

    /**
     * 设置：介绍
     */
    public void setCorporationIntroduce(String corporationIntroduce) {
        this.corporationIntroduce = corporationIntroduce;
    }

    /**
     * 获取：介绍
     */
    public String getCorporationIntroduce() {
        return corporationIntroduce;
    }

    /**
     * 设置：组织所在区域编码
     */
    public void setCorparationArea(String corparationArea) {
        this.corparationArea = corparationArea;
    }

    /**
     * 获取：组织所在区域编码
     */
    public String getCorparationArea() {
        return corparationArea;
    }

    /**
     * 设置：地址
     */
    public void setCorporationAddress(String corporationAddress) {
        this.corporationAddress = corporationAddress;
    }

    /**
     * 获取：地址
     */
    public String getCorporationAddress() {
        return corporationAddress;
    }

    /**
     * 设置：个人会员数
     */
    public void setPersonalVipCount(Integer personalVipCount) {
        this.personalVipCount = personalVipCount;
    }

    /**
     * 获取：个人会员数
     */
    public Integer getPersonalVipCount() {
        return personalVipCount;
    }

    public Integer getPersonalGroupCount() {
        return personalGroupCount;
    }

    public void setPersonalGroupCount(Integer personalGroupCount) {
        this.personalGroupCount = personalGroupCount;
    }

    /**
     * 设置：经度
     */
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    /**
     * 获取：经度
     */
    public Double getLongitude() {
        return longitude;
    }

    /**
     * 设置：纬度
     */
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    /**
     * 获取：纬度
     */
    public Double getLatitude() {
        return latitude;
    }

    public Integer getPageView() {
        return pageView;
    }

    public void setPageView(Integer pageView) {
        this.pageView = pageView;
    }

    /**
     * 设置：社团图片
     */
    public void setCorporationImages(String corporationImages) {
        this.corporationImages = corporationImages;
    }

    /**
     * 获取：社团图片
     */
    public String getCorporationImages() {
        return corporationImages;
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
     * 获取：社团负责人职位名称
     */
    public String getLeaderPositionName() {
        return leaderPositionName;
    }

    /**
     * 设置：社团负责人职位名称
     */
    public void setLeaderPositionName(String leaderPositionName) {
        this.leaderPositionName = leaderPositionName;
    }

    public Integer getActualGroupCount() {
        return actualGroupCount;
    }

    public void setActualGroupCount(Integer actualGroupCount) {
        this.actualGroupCount = actualGroupCount;
    }
}
