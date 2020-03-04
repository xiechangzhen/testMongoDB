package com.yymt.modules.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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
import com.yymt.entity.sport.EpidemicSituationEntity;
import com.yymt.entity.sport.PreventControlReportEntity;
import com.yymt.modules.controller.sport.BaseController;
import com.yymt.service.sport.PreventControlReportService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 防控报备表
 *
 * @author cots
 * @date 2020-02-09 20:54:47
 */
@RestController
@RequestMapping("preventcontrolreport")
@Api(tags = "防控报备")
public class PreventControlReportController extends BaseController {
	@Autowired
	private PreventControlReportService preventControlReportService;

	/**
	 * 保存
	 */
	@PostMapping("/save")
	@ApiOperation(value = "防控报备数据保存",response = PreventControlReportEntity.class)
	@RequiresPermissions("preventcontrolreport:save")
	public R save(@ApiParam(value = "id :主键,userId:用户id,createTime :防控报备创建时间,userName: 姓名,phoneNumber : "
			+ "手机号码,identityCard: 身份证号码,trafficWay :交通方式,trafficInfo: "
			+ "交通信息,whereFrom : 从哪里来,whereGo : 到哪里去,whereGoCode：到哪里去行政code，isEpidemicContact:是否与疫区人员接触,isDiagnosisContact:是否与确诊何疑似病人有接触，isFever：14天内是否有发热症状,temperatureMeasure：体温测量") @RequestBody PreventControlReportEntity preventControlReport) {
		Long userId = getUserIdByToken();
		preventControlReport.setUserId(userId);
		preventControlReport.setCreateTime(new Date());
		preventControlReportService.insert(preventControlReport);
		return R.ok();
	}

	/**
	 * 获取防控报备大数据分析
	 */
	@PostMapping("/getDataAnalyse")
	@ApiOperation(value = "获取防控报备大数据分析")
	@RequiresPermissions("preventcontrolreport:getDataAnalyse")
	public R getDataAnalyse() {
		return preventControlReportService.queryDataAnalyse();
	}

	public String txt2String(File file) {
		StringBuilder result = new StringBuilder();
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));// 构造一个BufferedReader类来读取文件
			String s = null;
			while ((s = br.readLine()) != null) {// 使用readLine方法，一次读一行
				int i1 = s.lastIndexOf(":");
				int i2 = s.lastIndexOf(",");
				// System.out.println(s.substring(4, i1));
				// System.out.println(s.substring(i1+3, i2-1));
				result.append(System.lineSeparator() + s.substring(4, i1) + s.substring(i1 + 3, i2 - 1));
				preventControlReportService.addPlace(s.substring(i1 + 3, i2 - 1), s.substring(4, i1));
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result.toString();
	}

	@PostMapping("/list")
	@ApiOperation(value = "个人防控报备列表")
	public R list(@ApiParam(value = "pageSize（每页显示的条数），"
			+ "currPage（当前页）") @RequestBody Map<String, Object> params) {
		Long userId = getUserIdByToken();
        params.put("userId",userId);
		params = ConvertUtil.getPageParams(params);
		List<Map<String, Object>> list = preventControlReportService.queryListByUserId(params);
		int count = preventControlReportService.queryCountByUserId(params);
		PageUtils page = ConvertUtil.getPageUtil(params, list, count);
		return R.ok().put("page", page);
	}

	@PostMapping("/info")
	@ApiOperation("个人防控报备详情")
	public R info(@ApiParam(value = "id：记录id,userId:用户id") @RequestBody Map<String, Object> params) {
		Long userId = getUserIdByToken();
        params.put("userId",userId);
		Map<String, Object> map = preventControlReportService.queryInfoByUserId(params);
		return R.ok().put("data", map);
	}

	public static void main(String[] args) {
		// File file = new
		// File("C:\\Users\\Administrator\\Desktop\\省市区三级联动.txt");
		// System.out.println(txt2String(file));

		// String s=" 110000: '北京市', ";
		// int i1=s.lastIndexOf(":");
		// int i2=s.lastIndexOf(",");
		// System.out.println(s.substring(4, i1));
		// System.out.println(s.substring(i1+3, i2-1));
		// File file = new
		// File("C:\\Users\\Administrator\\Desktop\\省市区三级联动.txt");
		// txt2String(file);
	}

}
