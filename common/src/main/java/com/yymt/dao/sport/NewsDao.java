package com.yymt.dao.sport;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.yymt.entity.sport.NewsEntity;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

/**
 * 新闻资讯
 *
 * @author hgq
 * @date 2018-02-10 14:26:32
 */
public interface NewsDao extends BaseMapper<NewsEntity> {

    /**
     * 新闻详情，包含点赞和是否收藏
     *
     * @return
     */
    Map newsDetail(Map map);

    //APP
    List selectNewsPage(RowBounds rowBounds, Map<String, Object> params);

    List selectNoticePage(RowBounds rowBounds, Map<String, Object> params);

    //后台知识科普列表
    List queryNewsPage(RowBounds rowBounds, Map<String, Object> params);
    /**
     * 后台计算待审核新闻数量
     */
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
    List<NewsEntity> indexListByCategoryAndTakeCount(@Param("columnId") int columnId, @Param("takeCount") int takeCount);

    /**
     * 首页新闻列表查询
     *
     * @param columnId 新闻栏目标识
     * @param offSet   跳过数量
     * @param limit    获取行数
     */
    List<NewsEntity> newsListByCategoryAndPageLimit(@Param("columnId") int columnId,
                                                    @Param("offSet") int offSet,
                                                    @Param("limit") int limit);

    /**
     * 首页新闻列表总数查询
     *
     * @param columnId 新闻栏目标识
     */
    int newsListCountByCategory(@Param("columnId") int columnId);

    /**
     * 获取新闻详细内容
     *
     * @param id 新闻标识
     */
    NewsEntity getNewsDetailById(@Param("id") int id);

    /**
     * 获取指定新闻指定用户是否点赞
     *
     * @param newsId 新闻标识
     * @param userId 用户标识
     */
    boolean getNewsIsGivenGreats(@Param("newsId") int newsId, @Param("userId") int userId);

    /**
     * 首页轮播图片新闻查询
     */
    List<NewsEntity> marqueePictureNewsList();

    /**
     * 首页指定标识集的新闻列表
     *
     * @param ids 新闻标识集
     */
    List<NewsEntity> getNewsListByIds(@Param("ids") List<Integer> ids);
}
