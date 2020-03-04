package com.yymt.modules.common.entity.antiepidemic;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.mongodb.util.JSON;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * 告警管理
 *
 * @author xielin
 * @since 2020-2-26 13:27
 */

@Document(collection = "faceAlarmInfoParseMongo")
public class FaceAlarmInfoParseMongoEntity{

    /**
     * 主键Id
     */

    @Id
    private String _id;

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

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public void setContent(String content) {
        Content = content;
    }

    public String getContent() {
        return Content;
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


}
