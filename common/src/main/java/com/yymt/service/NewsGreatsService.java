package com.yymt.service;

import com.baomidou.mybatisplus.service.IService;
import com.yymt.common.utils.PageUtils;
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
public interface NewsGreatsService extends IService<NewsGreatsEntity> {

    PageUtils queryPage(Map<String, Object> params);
    int cancelGreat(NewsGreatsEntity entity);
    int queryGreatCountByNewsId(int id);
    PageUtils like(Map<String, Object> params);
}

