package com.yymt.service;

import com.baomidou.mybatisplus.service.IService;
import com.yymt.common.utils.PageUtils;
import com.yymt.entity.sport.GamesGreatsEntity;

import java.util.Map;

/**
 * 赛事点赞
 *
 * @author cots
 * @date 2018-09-14 11:13:50
 */
public interface GamesGreatsService extends IService<GamesGreatsEntity> {

    PageUtils queryPage(Map<String, Object> params);

    Integer queryGreatCountByGameId(int id);
}

