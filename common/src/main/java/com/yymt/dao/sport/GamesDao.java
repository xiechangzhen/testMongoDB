package com.yymt.dao.sport;

import com.yymt.entity.sport.GamesEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

/**
 * 赛事培训表
 *
 * @author cots
 * @date 2018-09-13 10:16:31
 */
public interface GamesDao extends BaseMapper<GamesEntity> {
    //后台赛事培训列表
    List queryGamesPage(RowBounds rowBounds, Map<String, Object> params);

    /**
     * 后台计算待审核赛事数量
     */
    Integer countAuditGames(Map<String, Object> params);

    /**
     * 后台赛事培训详情
     */
    Map gameDetailBack(@Param("gameId") int gameId);

    List selectGamesPage(RowBounds rowBounds, Map<String, Object> params);
    List selectGamesListPage(RowBounds rowBounds, Map<String, Object> params);

    /**
     * 获取指定赛事指定用户是否报名
     *
     * @param gameId 赛事标识
     * @param userId 用户标识
     */
    boolean getGameIsSignUp(@Param("gameId") int gameId, @Param("userId") int userId);


    Map gameDetail(Map<String, Object> param);

    /**
     * 获取指定标识集的赛事列表
     *
     * @param ids 赛事标识集
     */
    List<GamesEntity> getGamesListByIds(@Param("ids") List<Integer> ids);
}
