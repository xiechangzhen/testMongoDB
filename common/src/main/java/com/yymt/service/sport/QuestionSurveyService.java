package com.yymt.service.sport;

import com.baomidou.mybatisplus.service.IService;
import com.yymt.common.utils.PageUtils;
import com.yymt.entity.sport.QuestionSurveyEntity;

import java.util.List;
import java.util.Map;

/**
 * 调查问卷表
 *
 * @author xiaojin
 * @date 2020-02-07 18:07:45
 */
public interface QuestionSurveyService extends IService<QuestionSurveyEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
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

