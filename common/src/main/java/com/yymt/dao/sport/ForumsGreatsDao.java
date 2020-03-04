package com.yymt.dao.sport;

import com.yymt.entity.sport.ForumsGreatsEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

/**
 * 帖子点赞表
 * 
 * @author cots
 * @date 2018-09-05 16:23:30
 */
public interface ForumsGreatsDao extends BaseMapper<ForumsGreatsEntity> {
    int cancelGreat(ForumsGreatsEntity entity);
    int queryGreatCountByForumsId(int id);
    List like(RowBounds rowBounds, Map<String, Object> params);
}
