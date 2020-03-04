package com.yymt.service;

import com.baomidou.mybatisplus.service.IService;
import com.yymt.common.utils.PageUtils;
import com.yymt.entity.sport.GamesEntity;

import java.util.List;
import java.util.Map;

/**
 * 赛事培训表
 *
 * @author cots
 * @date 2018-09-13 10:16:31
 */
public interface GamesService extends IService<GamesEntity> {

    PageUtils queryPage(Map<String, Object> params);

    //后台赛事培训列表
    PageUtils queryGamesPage(Map<String, Object> params);

    Integer countAuditGames(Map<String, Object> params);
    /**
     * 后台赛事培训详情
     */
    Map gameDetailBack(Integer id);

    PageUtils selectGamesPage(Map<String, Object> params);
    PageUtils selectGamesListPage(Map<String, Object> params);

    /**
     * 获取指定赛事指定用户是否报名
     *
     * @param gameId 赛事标识
     * @param userId 用户标识
     */
    boolean getGameIsSignUp(int gameId, int userId);

    Map gameDetail(Map<String,Object> param);

    /**
     * 获取指定标识集的赛事列表
     *
     * @param ids 赛事标识集
     */
    List<GamesEntity> getGamesListByIds(List<Integer> ids);
}

