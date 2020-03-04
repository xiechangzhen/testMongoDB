package com.yymt.dao.sport;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.yymt.entity.sport.QuestionSurveyEntity;

/**
 * 调查问卷表
 * 
 * @author cots
 * @date 2020-02-07 18:07:45
 */
public interface QuestionSurveyDao extends BaseMapper<QuestionSurveyEntity> {

	/**
	 * 根据用户 id查询问卷调查列表
	 * 
	 * @return
	 */
	List<Map<String, Object>> queryListByUserId(Map<String, Object> parmas);

	/**
	 * 根据用户 id查询问卷调查数量
	 * 
	 * @param parmas
	 * @return
	 */
	int queryCountByUserId(Map<String, Object> parmas);

}
