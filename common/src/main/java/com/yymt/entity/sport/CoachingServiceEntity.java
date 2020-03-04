package com.yymt.entity.sport;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.yymt.entity.api.UserEntity;
import com.yymt.entity.sys.SysUserEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 教练服务表
 *
 * @author cots
 * @date 2018-12-13 14:35:48
 */
@TableName("tb_coaching_service")
@ApiModel(description = "教练服务表")
public class CoachingServiceEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 标识
     */
    @TableId
    @ApiModelProperty(value = "标识")
    private Integer id;
    /**
     * 教练用户标识
     */
    //@NotNull(message = "教练用户标识不能为空")
    @ApiModelProperty(value = "教练用户标识")
    private Long userId;
    /**
     * 服务名称
     */
    @NotBlank(message = "服务名称不能为空")
    @Length(max = 30, message = "服务名称长度不能超过30字符")
    @ApiModelProperty(value = "服务名称")
    private String serviceName;
    /**
     * 运动项目标识
     */
    @NotNull(message = "运动项目不能为空")
    @ApiModelProperty(value = "运动项目")
    private Integer serviceSport;

    /**
     * 运动项目名称
     */
    @TableField(exist = false)
    private String serviceSportName;

    /**
     * 服务地点
     */
    @NotBlank(message = "服务地点不能为空")
    @ApiModelProperty(value = "服务地点")
    private String serviceAddress;
    /**
     * 经度
     */
    @NotNull(message = "经度不能为空")
    @ApiModelProperty(value = "经度")
    private Double longitude;
    /**
     * 纬度
     */
    @NotNull(message = "纬度不能为空")
    @ApiModelProperty(value = "纬度")
    private Double latitude;
    /**
     * 开始时间
     */
    @NotNull(message = "开始时间不能为空")
    @ApiModelProperty(value = "开始时间")
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm")
    private Date beginTime;
    /**
     * 结束时间
     */
    @NotNull(message = "结束时间不能为空")
    @ApiModelProperty(value = "结束时间")
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm")
    private Date endTime;
    /**
     * 价格
     */
    @NotNull(message = "价格不能为空")
    @ApiModelProperty(value = "价格")
    private BigDecimal servicePrice;
    /**
     * 说明
     */
    @ApiModelProperty(value = "说明")
    private String serviceDescription;
    /**
     * 状态（0：待审核；1：审核通过；2：未通过）
     */
    @ApiModelProperty(value = "状态（0：待审核；1：审核通过；2：未通过）")
    private Integer serviceStatus;
    /**
     * 审核者标识
     */
    @ApiModelProperty(value = "审核者")
    private Long auditUserId;

    /**
     * 审核者
     */
    @TableField(exist = false)
    private SysUserEntity auditorSysUser;

    /**
     * 审核时间
     */
    @ApiModelProperty(value = "审核时间")
    private Date auditTime;
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
    /**
     * 修改时间
     */
    @ApiModelProperty(value = "修改时间")
    private Date modifyTime;


    /**
     * 阅读数
     */
    private Integer pageView;

    /**
     * 教练信息
     */
    @TableField(exist = false)
    private UserEntity coacher;

    /**
     * 被举报数量
     */
    @TableField(exist = false)
    private Integer revealCount;

    /**
     * 设置：标识
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取：标识
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置：教练用户标识
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取：教练用户标识
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置：服务名称
     */
    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    /**
     * 获取：服务名称
     */
    public String getServiceName() {
        return serviceName;
    }

    /**
     * 设置：运动项目
     */
    public void setServiceSport(Integer serviceSport) {
        this.serviceSport = serviceSport;
    }

    /**
     * 获取：运动项目
     */
    public Integer getServiceSport() {
        return serviceSport;
    }

    /**
     * 设置：服务地点
     */
    public void setServiceAddress(String serviceAddress) {
        this.serviceAddress = serviceAddress;
    }

    /**
     * 获取：服务地点
     */
    public String getServiceAddress() {
        return serviceAddress;
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

    /**
     * 设置：开始时间
     */
    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    /**
     * 获取：开始时间
     */
    public Date getBeginTime() {
        return beginTime;
    }

    /**
     * 设置：结束时间
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * 获取：结束时间
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * 设置：价格
     */
    public void setServicePrice(BigDecimal servicePrice) {
        this.servicePrice = servicePrice;
    }

    /**
     * 获取：价格
     */
    public BigDecimal getServicePrice() {
        return servicePrice;
    }

    /**
     * 设置：说明
     */
    public void setServiceDescription(String serviceDescription) {
        this.serviceDescription = serviceDescription;
    }

    /**
     * 获取：说明
     */
    public String getServiceDescription() {
        return serviceDescription;
    }

    /**
     * 设置：状态（0：待审核；1：审核通过；2：未通过）
     */
    public void setServiceStatus(Integer serviceStatus) {
        this.serviceStatus = serviceStatus;
    }

    /**
     * 获取：状态（0：待审核；1：审核通过；2：未通过）
     */
    public Integer getServiceStatus() {
        return serviceStatus;
    }

    /**
     * 设置：审核者
     */
    public void setAuditUserId(Long auditUserId) {
        this.auditUserId = auditUserId;
    }

    /**
     * 获取：审核者
     */
    public Long getAuditUserId() {
        return auditUserId;
    }

    /**
     * 设置：审核时间
     */
    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    /**
     * 获取：审核时间
     */
    public Date getAuditTime() {
        return auditTime;
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
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * 获取：修改时间
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 获取：阅读数
     */
    public Integer getPageView() {
        return pageView;
    }

    /**
     * 设置：阅读数
     */
    public void setPageView(Integer pageView) {
        this.pageView = pageView;
    }

    /**
     * 获取：运动项目名称
     *
     * @return
     */
    public String getServiceSportName() {
        return serviceSportName;
    }

    /**
     * 设置：运动项目名称
     *
     * @param serviceSportName
     */
    public void setServiceSportName(String serviceSportName) {
        this.serviceSportName = serviceSportName;
    }

    /**
     * 获取：教练信息
     *
     * @return
     */
    public UserEntity getCoacher() {
        return coacher;
    }

    /**
     * 设置：教练信息
     *
     * @param coacher
     */
    public void setCoacher(UserEntity coacher) {
        this.coacher = coacher;
    }

    public Integer getRevealCount() {
        return revealCount;
    }

    public void setRevealCount(Integer revealCount) {
        this.revealCount = revealCount;
    }

    public SysUserEntity getAuditorSysUser() {
        return auditorSysUser;
    }

    public void setAuditorSysUser(SysUserEntity auditorSysUser) {
        this.auditorSysUser = auditorSysUser;
    }

}
