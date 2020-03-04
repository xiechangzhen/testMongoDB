package com.yymt.dao.sport;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.yymt.entity.sport.FeelingsGreatsEntity;

/**
 * 心情点赞表
 * 
 * @author hgq
 * @date 2018-02-28 13:11:25
 */
public interface FeelingsGreatsDao extends BaseMapper<FeelingsGreatsEntity> {
	int queryFeelingsGreats(Integer id);
}
