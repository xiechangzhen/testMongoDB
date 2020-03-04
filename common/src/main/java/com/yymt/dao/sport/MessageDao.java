package com.yymt.dao.sport;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.yymt.entity.sport.MessageEntity;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

/**
 * 互动留言表
 * 
 * @author hgq
 * @date 2018-03-14 15:07:41
 */
public interface MessageDao extends BaseMapper<MessageEntity> {
    List selectMessagePage(RowBounds rowBounds, @Param("userId1") Long userId1, @Param("userId2") Long userId2);
    Integer queryMessageCountByDay(Map<String, Object> param);
}
