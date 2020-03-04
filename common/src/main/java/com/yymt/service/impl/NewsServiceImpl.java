package com.yymt.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.SqlHelper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.yymt.common.annotation.YYTDataFilter;
import com.yymt.common.utils.PageUtils;
import com.yymt.common.utils.Query;
import com.yymt.dao.sport.NewsDao;
import com.yymt.entity.sport.NewsEntity;
import com.yymt.service.NewsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("newsService")
public class NewsServiceImpl extends ServiceImpl<NewsDao, NewsEntity> implements NewsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        int newsStatus = params.get("newsStatus") == null ? 2 : Integer.parseInt(params.get("newsStatus").toString());
        Page<NewsEntity> page = this.selectPage(
                new Query<NewsEntity>(params).getPage(),
                new EntityWrapper<NewsEntity>()
                        .eq("news_status", newsStatus)
        );
        return new PageUtils(page);
    }

    @Override
    public Map newsDetail(Map map) {
        return baseMapper.newsDetail(map);
    }

    /**
     * APP
     */
    @Override
    public PageUtils selectNewsPage(Map<String, Object> params) {
//        int status = (int)params.get("newsStatus");
        Page<NewsEntity> page = new Query<NewsEntity>(params).getPage();
        EntityWrapper entityWrapper = new EntityWrapper<NewsEntity>();
        SqlHelper.fillWrapper(page, entityWrapper);
        page.setRecords(baseMapper.selectNewsPage(
                page,
                params
        ));
        return new PageUtils(page);
    }

    /**
     * APP首页：单独查询公告、资讯、活动
     *
     * @param params
     * @return
     */
    @Override
    public PageUtils selectNoticePage(Map<String, Object> params) {
//        int status = (int)params.get("newsStatus");
        Page<NewsEntity> page = new Query<NewsEntity>(params).getPage();
        EntityWrapper entityWrapper = new EntityWrapper<NewsEntity>();
        SqlHelper.fillWrapper(page, entityWrapper);
        page.setRecords(baseMapper.selectNoticePage(
                page,
                params
        ));
        return new PageUtils(page);
    }



   /* @Override
    public PageUtils selectNewsList(Map<String, Object> params) {
        // 不进行 count sql 优化，解决 MP 无法自动优化 SQL 问题
        // page.setOptimizeCountSql(false);
        // 不查询总记录数
        // page.setSearchCount(false);
        Page<Map> page = new Query<Map>(params).getPage();
        page.setSearchCount(true);
        page.setRecords(baseMapper.selectNewsList());
        return new PageUtils(page);
    }*/

    /**
     * 后台新闻资讯列表
     *
     * @param params
     * @return
     */
//    @DataFilter(subDept = true, user = false)
    @YYTDataFilter(userId="news_author",auditPermission = "sport:news:audit")
    public PageUtils queryNewsPage(Map<String, Object> params) {
        Page<NewsEntity> page = new Query<NewsEntity>(params).getPage();
        EntityWrapper entityWrapper = new EntityWrapper<NewsEntity>();
        SqlHelper.fillWrapper(page, entityWrapper);
        page.setRecords(baseMapper.queryNewsPage(
                page,
                params
        ));
        return new PageUtils(page);
    }
    /**
     * 后台统计待审核新闻
     * @param params
     * @return
     */
    @Override
//    @DataFilter(subDept = true, user = false)
    @YYTDataFilter(userId="news_author",auditPermission = "sport:news:audit")
    public Integer countAuditNews(Map<String, Object> params){
        return baseMapper.countAuditNews(params);
    }

    /**
     * 后台知识科普、公告 详情
     */
    public Map newsDetailBack(Integer id) {
        return baseMapper.newsDetailBack(id);
    }

    /**
     * 首页新闻列表查询
     *
     * @param columnId  新闻栏目标识
     * @param takeCount 取多少项内容
     */
    @Override
    public List<NewsEntity> indexListByCategoryAndTakeCount(int columnId, int takeCount) {
        return baseMapper.indexListByCategoryAndTakeCount(columnId, takeCount);
    }

    /**
     * 首页新闻列表查询
     *
     * @param columnId  新闻栏目标识
     * @param pageSize  页大小
     * @param pageIndex 页码（从1开始计数）
     */
    @Override
    public List<NewsEntity> newsListByCategoryAndPage(int columnId, int pageSize, int pageIndex) {
        if (pageIndex < 1)
            pageIndex = 1;
        int offSet = (pageIndex - 1) * pageSize;
        int limit = pageSize;
        return baseMapper.newsListByCategoryAndPageLimit(columnId, offSet, limit);
    }

    /**
     * 首页新闻列表分页查询
     *
     * @param columnId  新闻栏目标识
     * @param pageSize  页大小
     * @param pageIndex 页码（从1开始计数）
     */
    @Override
    public PageUtils newsPagedListByCategory(int columnId, int pageSize, int pageIndex) {
        if (pageIndex < 1)
            pageIndex = 1;
        List<NewsEntity> list = this.newsListByCategoryAndPage(columnId, pageSize, pageIndex);
        Page<NewsEntity> page = new Page<>();
        page.setSize(pageSize);
        page.setCurrent(pageIndex);
        page.setRecords(list);
        int totalCount = baseMapper.newsListCountByCategory(columnId);
        page.setTotal(totalCount);
        return new PageUtils(page);
    }


    /**
     * 获取新闻详细内容
     *
     * @param id 新闻标识
     */
    @Override
    public NewsEntity getNewsDetailById(int id) {
        return baseMapper.getNewsDetailById(id);
    }

    /**
     * 获取指定新闻指定用户是否点赞
     *
     * @param newsId 新闻标识
     * @param userId 用户标识
     */
    @Override
    public boolean getNewsIsGivenGreats(int newsId, int userId) {
        return baseMapper.getNewsIsGivenGreats(newsId, userId);
    }

    /**
     * 首页轮播图片新闻查询
     */
    @Override
    public List<NewsEntity> marqueePictureNewsList() {
        return baseMapper.marqueePictureNewsList();
    }

    /**
     * 首页指定标识集的新闻列表
     *
     * @param ids 新闻标识集
     */
    @Override
    public List<NewsEntity> getNewsListByIds(List<Integer> ids) {
        return baseMapper.getNewsListByIds(ids);
    }
}
