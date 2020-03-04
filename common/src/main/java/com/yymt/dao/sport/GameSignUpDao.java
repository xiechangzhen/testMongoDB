package com.yymt.dao.sport;

import com.yymt.entity.sport.GameSignUpEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

/**
 * 赛事培训报名表
 * 
 * @author cots
 * @date 2018-09-05 16:23:30
 */
public interface GameSignUpDao extends BaseMapper<GameSignUpEntity> {
    List selectGameSignUpPage(RowBounds rowBounds, Map<String, Object> params);
    int querySignupCount(int gameId);
}
