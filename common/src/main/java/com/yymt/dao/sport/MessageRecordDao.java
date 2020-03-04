package com.yymt.dao.sport;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.yymt.entity.sport.MessageRecordEntity;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

/**
 * 消息记录表
 * 
 * @author hgq
 * @date 2018-03-20 19:24:00
 */
public interface MessageRecordDao extends BaseMapper<MessageRecordEntity> {

    List queryReceivedFocusList(RowBounds rowBounds, Map<String, Object> params);
    List queryReceivedCommentList(RowBounds rowBounds, Map<String, Object> params);
    List queryReceivedGreatList(RowBounds rowBounds, Map<String, Object> params);
    List queryMsgList(RowBounds rowBounds, Map<String, Object> params);
    Map countMsgList(Map<String, Object> params);
    Map messageStatus(Long userId);
    Integer changeMessageStatus(Map<String, Object> params);
}
