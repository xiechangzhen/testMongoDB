package com.yymt.modules.common.entity.antiepidemic;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 分类
 *
 * @author xiezhen
 * @since 2020/2/26 13:43
 */

@TableName("Classification")
@ApiModel(description = "分类")
public class ClassificationEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键Id
     */
    @TableId
    @ApiModelProperty(value = "主键Id")
    private Integer Id;

    /**
     * 分类名称
     */
    @ApiModelProperty(value = "分类名称")
    private String Name;

    /**
     * 分类级别
     */
    @ApiModelProperty(value = "分类级别")
    private Integer Level;

    /**
     * 特殊说明
     */
    @ApiModelProperty(value = "特殊说明")
    private String Extra;

    /**
     * 分类类型id
     */
    @ApiModelProperty(value = "分类类型id")
    private Integer ClassificationTypeId;

    /**
     * 上级分类id
     */
    @ApiModelProperty(value = "上级分类id")
    private Integer ParentId;

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

    public Integer getLevel() {
        return Level;
    }

    public void setLevel(Integer level) {
        Level = level;
    }

    public String getExtra() {
        return Extra;
    }

    public void setExtra(String extra) {
        Extra = extra;
    }

    public Integer getClassificationTypeId() {
        return ClassificationTypeId;
    }

    public void setClassificationTypeId(Integer classificationTypeId) {
        ClassificationTypeId = classificationTypeId;
    }

    public Integer getParentId() {
        return ParentId;
    }

    public void setParentId(Integer parentId) {
        ParentId = parentId;
    }
}
