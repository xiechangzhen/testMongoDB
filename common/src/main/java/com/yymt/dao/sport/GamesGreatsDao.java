package com.yymt.dao.sport;

import com.yymt.entity.sport.GamesGreatsEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * 赛事点赞
 * 
 * @author cots
 * @date 2018-09-14 11:13:50
 */
public interface GamesGreatsDao extends BaseMapper<GamesGreatsEntity> {
	Integer queryGreatCountByGameId(int id);
}
