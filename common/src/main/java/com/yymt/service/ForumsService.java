package com.yymt.service;

import com.baomidou.mybatisplus.service.IService;
import com.yymt.common.utils.PageUtils;
import com.yymt.entity.sport.ForumsEntity;

import java.util.List;
import java.util.Map;

/**
 * 社区论坛帖子表
 *
 * @author cots
 * @date 2018-09-05 16:23:30
 */
public interface ForumsService extends IService<ForumsEntity> {

    /**
     * 后台获取社区详情
     */
    Map selectForumsDetailBack(Integer id);
    /**
     * 后台获取社区列表
     * @param params
     * @return
     */
    PageUtils queryPage(Map<String, Object> params);
    Integer countRevealingForums(Map<String, Object> params);
    /**
     * APP获取社区列表
     */
    PageUtils selectForumsList(Map<String, Object> params);

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
    List<ForumsEntity> getPostListByIds(List<Integer> ids);
}

