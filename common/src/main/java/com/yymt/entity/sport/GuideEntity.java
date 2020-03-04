package com.yymt.entity.sport;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 指南
 *
 * @author cots
 * @date 2018-09-13 20:54:42
 */
@TableName("tb_guide")
@ApiModel(description = "指南")
public class GuideEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    @TableId
    @ApiModelProperty(value = "编号")
    private Integer id;
    /**
     * 名称
     */
    @ApiModelProperty(value = "名称")
    private String name;
    /**
     * 文件省略名
     * */
    @TableField(exist = false)
    private String nameSuffer;
    /**
     * 文件地址
     */
    @ApiModelProperty(value = "文件地址")
    private String file;
    /**
     * 状态（1待审核 2已通过 3未通过）
     * */
    @ApiModelProperty(value = "状态")
    private Integer status;
    /**
     * 文件后缀
     */
    @TableField(exist = false)
    private String suffer;
    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    /**
     * 审核时间
     * */
    @ApiModelProperty(value = "审核时间")
    private Date auditTime;
    /**
     * 创建人
     * */
    @ApiModelProperty(value = "创建人")
    private Long authorId;
    /**
     * 审核人
     * */
    @ApiModelProperty(value = "审核人")
    private Long auditorId;

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
     * 设置：名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取：名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置：文件地址
     */
    public void setFile(String file) {
        this.file = file;
    }

    /**
     * 获取：文件地址
     */
    public String getFile() {
        return file;
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

    public String getSuffer() {
        return suffer;
    }

    public void setSuffer(String suffer) {
        this.suffer = suffer;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getNameSuffer() {
        return nameSuffer;
    }

    public void setNameSuffer(String nameSuffer) {
        this.nameSuffer = nameSuffer;
    }

    public Date getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public Long getAuditorId() {
        return auditorId;
    }

    public void setAuditorId(Long auditorId) {
        this.auditorId = auditorId;
    }
}
