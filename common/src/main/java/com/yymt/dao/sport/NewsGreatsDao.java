package com.yymt.dao.sport;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.yymt.entity.sport.NewsGreatsEntity;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

/**
 * 新闻点赞表
 * 
 * @author hgq
 * @date 2018-02-10 14:26:32
 */
public interface NewsGreatsDao extends BaseMapper<NewsGreatsEntity> {
    int cancelGreat(NewsGreatsEntity entity);
    int queryGreatCountByNewsId(int id);

    List like(RowBounds rowBounds, Map<String, Object> params);
}
