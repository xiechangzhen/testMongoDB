package com.yymt.modules.common.entity.antiepidemic;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 告警管理
 *
 * @author xielin
 * @since 2020-2-26 13:27
 */

@TableName("FaceAlarmInfoParse")
@ApiModel(description = "告警管理")
public class FaceAlarmInfoParseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键Id
     */
    @TableId
    @ApiModelProperty(value = "主键Id")
    private String Id;

    /**
     * 内容
     */
    private String Content;

    /**
     * 数据类型
     */
    private String DataType;

    /**
     * 设备RemoteIp
     */
    private String RemoteIP;

    /**
     * 时间戳
     */
    private Long TimeStamp;

    @TableField(exist = false)
    private int ViolationStatus;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public String getDataType() {
        return DataType;
    }

    public void setDataType(String dataType) {
        DataType = dataType;
    }

    public String getRemoteIP() {
        return RemoteIP;
    }

    public void setRemoteIP(String remoteIP) {
        RemoteIP = remoteIP;
    }

    public Long getTimeStamp() {
        return TimeStamp;
    }

    public void setTimeStamp(Long timeStamp) {
        TimeStamp = timeStamp;
    }

    public int getViolationStatus() {
        return ViolationStatus;
    }

    public void setViolationStatus(int violationStatus) {
        ViolationStatus = violationStatus;
    }
}
