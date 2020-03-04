package com.yymt.modules.common.entity.antiepidemic;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 小区结构
 *
 * @author xiezhen
 * @since 2020-2-26 13:27
 */

@TableName("Organization")
@ApiModel(description = "组织结构")
public class OrganizationEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键Id
     */
    @TableId
    @ApiModelProperty(value = "主键Id")
    private Integer Id;

    /**
     * 组织编码
     */
    @ApiModelProperty(value = "组织编码")
    private String Code;

    /**
     * 组织名称
     */
    @ApiModelProperty(value = "组织名称")
    private String Name;

    /**
     * 特殊说明
     */
    @ApiModelProperty(value = "特殊说明")
    private String Extra;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date CreateTime;

    /**
     * 创建者
     */
    @ApiModelProperty(value = "创建者")
    private String Creator;

    /**
     * 组织分类id
     */
    @ApiModelProperty(value = "组织分类id")
    private Integer ClassificationId;

    /**
     * 上级组织id
     */
    @ApiModelProperty(value = "上级组织分类id")
    private Integer ParentId;

    @TableField(exist = false)
    private List<DeviceEntity> Devices;

    @TableField(exist = false)
    private ClassificationEntity classification;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getExtra() {
        return Extra;
    }

    public void setExtra(String extra) {
        Extra = extra;
    }

    public Date getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(Date createTime) {
        CreateTime = createTime;
    }

    public String getCreator() {
        return Creator;
    }

    public void setCreator(String creator) {
        Creator = creator;
    }

    public Integer getClassificationId() {
        return ClassificationId;
    }

    public void setClassificationId(Integer classificationId) {
        ClassificationId = classificationId;
    }

    public Integer getParentId() {
        return ParentId;
    }

    public void setParentId(Integer parentId) {
        ParentId = parentId;
    }

    public List<DeviceEntity> getDevices() {
        return Devices;
    }

    public void setDevices(List<DeviceEntity> devices) {
        Devices = devices;
    }

    public ClassificationEntity getClassification() {
        return classification;
    }

    public void setClassification(ClassificationEntity classification) {
        this.classification = classification;
    }
}
