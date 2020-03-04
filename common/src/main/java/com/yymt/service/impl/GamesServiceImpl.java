package com.yymt.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.SqlHelper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
//import com.yymt.common.annotation.DataFilter;
import com.yymt.common.annotation.YYTDataFilter;
import com.yymt.common.utils.PageUtils;
import com.yymt.common.utils.Query;
import com.yymt.dao.sport.GamesDao;
import com.yymt.entity.sport.GamesEntity;
import com.yymt.service.GamesService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("gamesService")
public class GamesServiceImpl extends ServiceImpl<GamesDao, GamesEntity> implements GamesService {

    @Override
//    @DataFilter(subDept = true, user = false)
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GamesEntity> page = this.selectPage(
                new Query<GamesEntity>(params).getPage(),
                new EntityWrapper<>()
        );

        return new PageUtils(page);
    }

    /**
     * 后台赛事列表
     * @param params
     * @return
     */
    @Override
//    @DataFilter(subDept = true, user = false)
    @YYTDataFilter(userId="gameAuthor",auditPermission = "sport:games:audit")
    public PageUtils queryGamesPage(Map<String, Object> params) {
        Page<GamesEntity> page = new Query<GamesEntity>(params).getPage();
        EntityWrapper entityWrapper = new EntityWrapper<GamesEntity>();
        SqlHelper.fillWrapper(page, entityWrapper);
        page.setRecords(baseMapper.queryGamesPage(
                page,
                params
        ));
        return new PageUtils(page);
    }
    /**
     * 后台统计待审核赛事
     * @param params
     * @return
     */
    @Override
//    @DataFilter(subDept = true, user = false)
    @YYTDataFilter(tableAlias = "tb",userId="game_author",auditPermission = "sport:games:audit")
    public Integer countAuditGames(Map<String, Object> params){
        return baseMapper.countAuditGames(params);
    }

    @Override
    public Map gameDetailBack(Integer id) {
        return baseMapper.gameDetailBack(id);
    }

    @Override
    public PageUtils selectGamesPage(Map<String, Object> params) {
        Page<GamesEntity> page = new Query<GamesEntity>(params).getPage();
        EntityWrapper entityWrapper = new EntityWrapper<GamesEntity>();
        SqlHelper.fillWrapper(page, entityWrapper);
        page.setRecords(baseMapper.selectGamesPage(
                page,
                params
        ));
        return new PageUtils(page);
    }

    @Override
    public PageUtils selectGamesListPage(Map<String, Object> params) {
        Page<GamesEntity> page = new Query<GamesEntity>(params).getPage();
        EntityWrapper entityWrapper = new EntityWrapper<GamesEntity>();
        SqlHelper.fillWrapper(page, entityWrapper);
        page.setRecords(baseMapper.selectGamesListPage(
                page,
                params
        ));
        return new PageUtils(page);
    }

    /**
     * 获取指定赛事指定用户是否报名
     *
     * @param gameId 赛事标识
     * @param userId 用户标识
     */
    @Override
    public boolean getGameIsSignUp(int gameId, int userId) {
        return baseMapper.getGameIsSignUp(gameId, userId);
    }

    @Override
    public Map gameDetail(Map<String, Object> param) {
        return baseMapper.gameDetail(param);
    }

    /**
     * 获取指定标识集的赛事列表
     *
     * @param ids 赛事标识集
     */
    @Override
    public List<GamesEntity> getGamesListByIds(List<Integer> ids) {
        return baseMapper.getGamesListByIds(ids);
    }

}
