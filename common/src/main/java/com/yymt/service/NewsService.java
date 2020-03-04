package com.yymt.service;

import com.baomidou.mybatisplus.service.IService;
import com.yymt.common.utils.PageUtils;
import com.yymt.entity.sport.NewsEntity;

import java.util.List;
import java.util.Map;

/**
 * 新闻资讯
 *
 * @author hgq
 * @date 2018-02-10 14:26:32
 */
public interface NewsService extends IService<NewsEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 新闻详情，包含点赞和是否收藏
     *
     * @return
     */
    Map newsDetail(Map map);


    /**
     * APP
     * @param params
     * @return
     */
    PageUtils selectNewsPage(Map<String, Object> params);

    /**
     * APP首页：单独查询公告、资讯、活动
     *
     * @param params
     * @return
     */
    PageUtils selectNoticePage(Map<String, Object> params);

    /**
     * 后台新闻资讯列表
     *
     * @param params
     * @return
     */
    PageUtils queryNewsPage(Map<String, Object> params);
    Integer countAuditNews(Map<String, Object> params);
    /**
     * 后台知识科普、公告 详情
     */
    Map newsDetailBack(Integer id);

    /**
     * 首页新闻列表查询
     *
     * @param columnId  新闻栏目标识
     * @param takeCount 取多少项内容
     */
    List<NewsEntity> indexListByCategoryAndTakeCount(int columnId, int takeCount);

    /**
     * 首页新闻列表查询
     *
     * @param columnId  新闻栏目标识
     * @param pageSize  页大小
     * @param pageIndex 页码（从1开始计数）
     */
    List<NewsEntity> newsListByCategoryAndPage(int columnId, int pageSize, int pageIndex);

    /**
     * 首页新闻列表分页查询
     *
     * @param columnId  新闻栏目标识
     * @param pageSize  页大小
     * @param pageIndex 页码（从1开始计数）
     */
    public PageUtils newsPagedListByCategory(int columnId, int pageSize, int pageIndex);

    /**
     * 获取新闻详细内容
     *
     * @param id 新闻标识
     */
    NewsEntity getNewsDetailById(int id);

    /**
     * 获取指定新闻指定用户是否点赞
     *
     * @param newsId 新闻标识
     * @param userId 用户标识
     */
    boolean getNewsIsGivenGreats(int newsId, int userId);

    /**
     * 首页轮播图片新闻查询
     */
    List<NewsEntity> marqueePictureNewsList();

    /**
     * 首页指定标识集的新闻列表
     *
     * @param ids  新闻标识集
     */
    List<NewsEntity> getNewsListByIds(List<Integer> ids);
}

