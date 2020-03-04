package com.yymt.modules.common.entity.antiepidemic;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 网格信息
 *
 * @author xiezhen
 * @since 2020/2/28
 */
@TableName("Grid")
@ApiModel(description = "网格信息")
public class GridEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键Id
     */
    @TableId
    @ApiModelProperty(value = "主键Id")
    private Integer Id;

    private String Name;

    private String Range;

    private String PersonInCharge;

    private String Extra;

    private Integer Level;

    private Integer ParentId;

    private Integer OrganizationId;

    private Integer ClassificationId;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getRange() {
        return Range;
    }

    public void setRange(String range) {
        Range = range;
    }

    public String getPersonInCharge() {
        return PersonInCharge;
    }

    public void setPersonInCharge(String personInCharge) {
        PersonInCharge = personInCharge;
    }

    public String getExtra() {
        return Extra;
    }

    public void setExtra(String extra) {
        Extra = extra;
    }

    public Integer getLevel() {
        return Level;
    }

    public void setLevel(Integer level) {
        Level = level;
    }

    public Integer getParentId() {
        return ParentId;
    }

    public void setParentId(Integer parentId) {
        ParentId = parentId;
    }

    public Integer getOrganizationId() {
        return OrganizationId;
    }

    public void setOrganizationId(Integer organizationId) {
        OrganizationId = organizationId;
    }

    public Integer getClassificationId() {
        return ClassificationId;
    }

    public void setClassificationId(Integer classificationId) {
        ClassificationId = classificationId;
    }
}
