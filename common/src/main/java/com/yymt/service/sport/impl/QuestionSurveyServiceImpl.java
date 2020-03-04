package com.yymt.service.sport.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.yymt.common.annotation.DataFilter;
import com.yymt.common.utils.PageUtils;
import com.yymt.common.utils.Query;
import com.yymt.dao.sport.QuestionSurveyDao;
import com.yymt.entity.sport.QuestionSurveyEntity;
import com.yymt.service.sport.QuestionSurveyService;

@Service("questionSurveyService")
public class QuestionSurveyServiceImpl extends ServiceImpl<QuestionSurveyDao, QuestionSurveyEntity>
		implements QuestionSurveyService {

	@Override
	@DataFilter(subDept = true, user = false)
	public PageUtils queryPage(Map<String, Object> params) {
		Page<QuestionSurveyEntity> page = this.selectPage(new Query<QuestionSurveyEntity>(params).getPage(),
				new EntityWrapper<QuestionSurveyEntity>());

		return new PageUtils(page);
	}

	/**
	 * 根据用户 id查询问卷调查列表
	 * 
	 * @return
	 */
	@Override
	public List<Map<String, Object>> queryListByUserId(Map<String, Object> parmas) {
		return baseMapper.queryListByUserId(parmas);
	}

	/**
	 * 根据用户 id查询问卷调查数量
	 * 
	 * @param parmas
	 * @return
	 */
	@Override
	public int queryCountByUserId(Map<String, Object> parmas) {
		return baseMapper.queryCountByUserId(parmas);
	}

}
