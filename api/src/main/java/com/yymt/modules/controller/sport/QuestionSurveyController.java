package com.yymt.modules.controller.sport;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yymt.common.utils.ConvertUtil;
import com.yymt.common.utils.PageUtils;
import com.yymt.common.utils.R;
import com.yymt.entity.sport.QuestionSurveyEntity;
import com.yymt.service.sport.QuestionSurveyService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 问卷调查表
 *
 * 
 * @author xiaojin
 * @date 2020-02-06 17:23:30
 */
@RestController
@RequestMapping("sport/questionSurvey")
@Api(tags = "问卷调查")
public class QuestionSurveyController extends BaseController {

	@Autowired
	private QuestionSurveyService questionSurveyService;

	/**
	 * 问卷调查提交
	 */
	@PostMapping("/save")
	@RequiresPermissions("sport:questionSurvey:save")
	@ApiOperation(value = "问卷调查提交", response = QuestionSurveyEntity.class)
	public R save(@RequestBody QuestionSurveyEntity surveyEntity) {
		int score = getScore(surveyEntity);
		surveyEntity.setUserId(getUserIdByTokenWithoutValidate());
		surveyEntity.setCreateTime(new Date());
		surveyEntity.setQuestionScore(score);
		questionSurveyService.insert(surveyEntity);
		return R.ok().put("score", score);
	}

	@PostMapping("/list")
	@RequiresPermissions("sport:questionSurvey:list")
	@ApiOperation(value = "个人问卷调查列表")
	public R list(@ApiParam(value = "pageSize（每页显示的条数），" + "currPage（当前页）") @RequestBody Map<String, Object> params) {
		Long userId = getUserIdByToken();
		params.put("userId", userId);
		params = ConvertUtil.getPageParams(params);
		List<Map<String, Object>> list = questionSurveyService.queryListByUserId(params);
		int count = questionSurveyService.queryCountByUserId(params);
		PageUtils page = ConvertUtil.getPageUtil(params, list, count);
		return R.ok().put("page", page);
	}

	/**
	 * 新型肺炎初筛问卷调查评分系统
	 * 
	 * @param surveyEntity
	 * @return
	 */
	public int getScore(QuestionSurveyEntity surveyEntity) {
		int score = 0;
		// 三天内发热情况：是 4，否：0
		if (surveyEntity.getIsFever().equals("是")) {
			score += 4;
		}
		// 三天内咽部不适、咳嗽、流鼻涕：是 4，否：0，三天内拉肚子：是 4 ，否：0
		String s = ConvertUtil.objToStrConverSpace(surveyEntity.getUnComfortable());
		String[] strings = s.split(",");
		String unComfortable = "";
		int scoreUnComfortable = 0;
		int scoRediarrhea = 0;
		for (int i = 0; i < strings.length; i++) {
			unComfortable = ConvertUtil.objToStrConverSpace(strings[i]);
			if (unComfortable.equals("咽部不适") || unComfortable.equals("咳嗽") || unComfortable.equals("流鼻涕")) {
				scoreUnComfortable = 4;
			}
			if (unComfortable.equals("腹泻")) {
				scoRediarrhea = 4;
			}
		}
		score = score + scoreUnComfortable + scoRediarrhea;

		// 请问您所居住的小区或村庄有确诊的新冠病毒肺炎患者或疑似新冠病毒肺炎患者吗？分数 是：1 否： 0
		String isPneumonia = ConvertUtil.objToStrConverSpace(surveyEntity.getIsPneumonia());
		if (isPneumonia.equals("是")) {
			score += 1;
		}

		// 请问您去过武汉吗？ 分数，是：1 否： 0
		String beenWuhan = ConvertUtil.objToStrConverSpace(surveyEntity.getBeenWuhan());
		if (beenWuhan.equals("是")) {
			score += 1;
		}

		// 请问您接触过武汉来的人吗？分数，是：1 否： 0
		String contactWuhan = ConvertUtil.objToStrConverSpace(surveyEntity.getContactWuhan());
		if (contactWuhan.equals("是")) {
			score += 1;
		}
		return score;
	}

}
