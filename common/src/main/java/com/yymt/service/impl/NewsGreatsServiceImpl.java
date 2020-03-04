package com.yymt.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.SqlHelper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.yymt.common.utils.PageUtils;
import com.yymt.common.utils.Query;
import com.yymt.dao.sport.NewsGreatsDao;
import com.yymt.entity.sport.NewsGreatsEntity;
import com.yymt.service.NewsGreatsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("newsGreatsService")
public class NewsGreatsServiceImpl extends ServiceImpl<NewsGreatsDao, NewsGreatsEntity> implements NewsGreatsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Object id = params.get("newsId");
        Page<NewsGreatsEntity> page = this.selectPage(
                new Query<NewsGreatsEntity>(params).getPage(),
                new EntityWrapper<NewsGreatsEntity>().eq("news_id",id)
        );
        return new PageUtils(page);
    }

    @Override
    public int cancelGreat(NewsGreatsEntity entity) {
        return baseMapper.cancelGreat(entity);
    }

    @Override
    public int queryGreatCountByNewsId(int id) {
        return baseMapper.queryGreatCountByNewsId(id);
    }

    @Override
    public PageUtils like(Map<String, Object> params) {
        Page page = new Query<>(params).getPage();
        EntityWrapper entityWrapper = new EntityWrapper<>();
        SqlHelper.fillWrapper(page, entityWrapper);
        page.setRecords(baseMapper.like(
                page,
                params
        ));
        return new PageUtils(page);
    }

}
