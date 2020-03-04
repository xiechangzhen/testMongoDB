package com.yymt.modules.common.entity.antiepidemic;

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

@TableName("FaceAlarmInfo")
@ApiModel(description = "告警管理")
public class FaceAlarmInfoEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键Id
     */
    @TableId
    @ApiModelProperty(value = "主键Id")
    private String Id;

    private Date Time;

    /**
     * 告警类型
     */
    @ApiModelProperty(value = "告警类型")
    private String Type;

    private String Content;

    private Integer IsDeal;

    private Long EventId;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public Date getTime() {
        return Time;
    }

    public void setTime(Date time) {
        Time = time;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public Integer getIsDeal() {
        return IsDeal;
    }

    public void setIsDeal(Integer isDeal) {
        IsDeal = isDeal;
    }

    public Long getEventId() {
        return EventId;
    }

    public void setEventId(Long eventId) {
        EventId = eventId;
    }
}
