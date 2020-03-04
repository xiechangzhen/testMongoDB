package com.yymt.entity.sport;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 团体会员信息表
 *
 * @author cots
 * @date 2018-09-12 11:04:21
 */
@TableName("tb_corporation_group_member")
@ApiModel(description = "团体会员信息表")
public class CorporationGroupMemberEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @TableId
    @ApiModelProperty(value = "编号")
    private Integer id;
    /**
     * 团体会员名称
     */
    @ApiModelProperty(value = "团体会员名称")
    private String groupMenberName;

    /**
     * 所属社团
     */
    @ApiModelProperty(value = "所属社团")
    private long corporationId;
    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remark;


    public long getCorporationId() {
        return corporationId;
    }

    public void setCorporationId(long corporationId) {
        this.corporationId = corporationId;
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
     * 设置：团体会员名称
     */
    public void setGroupMenberName(String groupMenberName) {
        this.groupMenberName = groupMenberName;
    }

    /**
     * 获取：团体会员名称
     */
    public String getGroupMenberName() {
        return groupMenberName;
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
}
