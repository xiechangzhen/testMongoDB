package com.yymt.entity.sport;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import com.yymt.entity.api.UserEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 社区论坛帖子表
 *
 * @author cots
 * @date 2018-09-12 11:04:21
 */
@TableName("tb_forums")
@ApiModel(description = "社区论坛帖子表")
public class ForumsEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @TableId
    @ApiModelProperty(value = "编号")
    private Integer id;
    /**
     * 内容
     */
    @ApiModelProperty(value = "内容")
    private String content;
    /**
     * 帖子图片
     */
    @ApiModelProperty(value = "帖子图片")
    private String images;
    /**
     * 用户id
     */
    @ApiModelProperty(value = "用户id")
    private Long userId;
    /**
     * 社区状态(-1 被删除;0 被隐藏;1 正常;)
     */
    @ApiModelProperty(value = "社区状态(-1 被删除;0 被隐藏;1 正常;)")
    private Integer forumsStatus;
    /**
     * 社区类型(1-运动健身；2-营养)
     */
    @ApiModelProperty(value = "社区类型(1-运动健身；2-营养)")
    private Integer forumsType;
    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    /**
     * 访问量
     */
    @ApiModelProperty(value = "访问量")
    private Integer pageView;
    /**
     * 审核的类型（1色情裸露 2不友善行为 3广告推销 4其他 5正常）
     */
    @ApiModelProperty(value = "审核的类型（1色情裸露 2不友善行为 3广告推销 4其他 5正常）",hidden = true)
    private Integer auditType;
    /**
     * 审核人
     */
    @ApiModelProperty(value = "审核人",hidden = true)
    private Long auditUserId;
    /**
     * 处理动态（1隐藏此动态）
     */
    @ApiModelProperty(hidden = true)
    @TableField(exist = false)
    private Integer handleForumsType;
    /**
     * 处理账号（2冻结账号 3删除账号）
     */
    @ApiModelProperty(hidden = true)
    @TableField(exist = false)
    private Integer handleAccountType;
    /**
     * 处理时间
     */
    @ApiModelProperty(value = "处理时间")
    private Date handleTime;
    /**
     * 是否推荐
     */
    @ApiModelProperty(value = "是否推荐")
    private Integer isRecommend;
    /**
     * 备注（后台处理填写的原因）
     */
    @ApiModelProperty(value = "备注（后台处理填写的原因）")
    private String remark;

    /**
     * 点赞数
     */
    @TableField(exist = false)
    private Integer greats;

    /**
     * 作者（用户）
     */
    @TableField(exist = false)
    private UserEntity authorFrontUser;

    public Integer getForumsStatus() {
        return forumsStatus;
    }

    public void setForumsStatus(Integer forumsStatus) {
        this.forumsStatus = forumsStatus;
    }

    public Long getAuditUserId() {
        return auditUserId;
    }

    public void setAuditUserId(Long auditUserId) {
        this.auditUserId = auditUserId;
    }

    public Integer getHandleForumsType() {
        return handleForumsType;
    }

    public void setHandleForumsType(Integer handleForumsType) {
        this.handleForumsType = handleForumsType;
    }

    public Integer getHandleAccountType() {
        return handleAccountType;
    }

    public void setHandleAccountType(Integer handleAccountType) {
        this.handleAccountType = handleAccountType;
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
     * 设置：内容
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 获取：内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置：帖子图片
     */
    public void setImages(String images) {
        this.images = images;
    }

    /**
     * 获取：帖子图片
     */
    public String getImages() {
        return images;
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
     * 设置：社区类型(1-运动健身；2-营养)
     */
    public void setForumsType(Integer forumsType) {
        this.forumsType = forumsType;
    }

    /**
     * 获取：社区类型(1-运动健身；2-营养)
     */
    public Integer getForumsType() {
        return forumsType;
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
     * 设置：审核的类型（1色情裸露 2不友善行为 3广告推销 4其他 5正常）
     */
    public void setAuditType(Integer auditType) {
        this.auditType = auditType;
    }

    /**
     * 获取：审核的类型（1色情裸露 2不友善行为 3广告推销 4其他 5正常）
     */
    public Integer getAuditType() {
        return auditType;
    }

    /**
     * 设置：处理时间
     */
    public void setHandleTime(Date handleTime) {
        this.handleTime = handleTime;
    }

    /**
     * 获取：处理时间
     */
    public Date getHandleTime() {
        return handleTime;
    }

    /**
     * 设置：是否推荐
     */
    public void setIsRecommend(Integer isRecommend) {
        this.isRecommend = isRecommend;
    }

    /**
     * 获取：是否推荐
     */
    public Integer getIsRecommend() {
        return isRecommend;
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
     * 获取：作者（用户）
     */
    public UserEntity getAuthorFrontUser() {
        return authorFrontUser;
    }

    /**
     * 设置：作者（用户）
     */
    public void setAuthorFrontUser(UserEntity authorFrontUser) {
        this.authorFrontUser = authorFrontUser;
    }
}
