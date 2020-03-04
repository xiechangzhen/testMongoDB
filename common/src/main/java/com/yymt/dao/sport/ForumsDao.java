package com.yymt.dao.sport;

import com.yymt.entity.sport.ForumsEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

/**
 * 社区论坛帖子表
 *
 * @author cots
 * @date 2018-09-05 16:23:30
 */
public interface ForumsDao extends BaseMapper<ForumsEntity> {

    /**
     * 后台获取社区详情
     */
    Map selectForumsDetailBack(@Param("id") Integer id);
    /**
     * 后台获取社区列表
     */
    List selectForumsListBack(RowBounds rowBounds, Map<String, Object> params);
    Integer countRevealingForums(Map<String, Object> params);
    /**
     * APP获取社区列表
     */
    List selectForumsList(RowBounds rowBounds, Map<String, Object> params);

    /**
     * APP获取社区详情
     */
    Map selectForumsDetail(Map<String, Object> params);

    /**
     * 批量删除社区动态及其评论和点赞
     */
    boolean deleteForumsAndCommentsAndGreatsBatch(Integer[] forumsId);

    /**
     * 获取指定标识集的社区帖子列表
     *
     * @param ids 社区帖子标识集
     */
    List<ForumsEntity> getPostListByIds(@Param("ids") List<Integer> ids);
}
