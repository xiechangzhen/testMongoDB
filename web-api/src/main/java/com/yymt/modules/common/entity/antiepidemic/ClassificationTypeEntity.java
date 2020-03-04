package com.yymt.modules.common.entity.antiepidemic;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 分类类型
 *
 * @author xiezhen
 * @since 2020/2/26 13:48
 */

@TableName("ClassificationType")
@ApiModel(description = "分类类型")
public class ClassificationTypeEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 主键Id
     */
    @TableId
    @ApiModelProperty(value = "主键Id")
    private Integer Id;

    /**
     * 分类类型名称
     */
    @ApiModelProperty(value = "分类类型名称")
    private String Name;

    /**
     * 特殊说明
     */
    @ApiModelProperty(value = "特殊说明")
    private String Extra;

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

    public String getExtra() {
        return Extra;
    }

    public void setExtra(String extra) {
        Extra = extra;
    }
}
