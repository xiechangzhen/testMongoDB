package com.yymt.entity.sport;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 帖子评论表
 *
 * @author cots
 * @date 2018-09-12 11:04:21
 */
@TableName("tb_forums_comment")
@ApiModel(description = "帖子评论表")
public class ForumsCommentEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @TableId
    @ApiModelProperty(value = "编号")
    private Integer id;
    /**
     * 评论内容
     */
    @ApiModelProperty(value = "评论内容")
    private String comment;
    /**
     * 帖子id
     */
    @ApiModelProperty(value = "帖子id")
    private Integer forumsId;
    /**
     * 用户id
     */
    @ApiModelProperty(value = "用户id")
    private Long userId;
    /**
     * 父评论ID
     */
    @ApiModelProperty(value = "父评论ID")
    private Integer parentId;

    /**
     * 根评论ID
     */
    @ApiModelProperty(value = "根评论ID")
    private Integer rootId;

    /**
     * 评论层级
     */
    @ApiModelProperty(value = "评论层级")
    private Integer level;
    /**
     * 评论时间
     */
    @ApiModelProperty(value = "评论时间")
    private Date createTime;

    public Integer getRootId() {
        return rootId;
    }

    public void setRootId(Integer rootId) {
        this.rootId = rootId;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
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
     * 设置：评论内容
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * 获取：评论内容
     */
    public String getComment() {
        return comment;
    }

    /**
     * 设置：帖子id
     */
    public void setForumsId(Integer forumsId) {
        this.forumsId = forumsId;
    }

    /**
     * 获取：帖子id
     */
    public Integer getForumsId() {
        return forumsId;
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
     * 设置：父评论ID
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取：父评论ID
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * 设置：评论时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取：评论时间
     */
    public Date getCreateTime() {
        return createTime;
    }
}
