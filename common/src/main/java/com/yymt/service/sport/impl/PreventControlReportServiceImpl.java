package com.yymt.service.sport.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.yymt.common.annotation.DataFilter;
import com.yymt.common.utils.PageUtils;
import com.yymt.common.utils.Query;
import com.yymt.common.utils.R;
import com.yymt.dao.sport.PreventControlReportDao;
import com.yymt.entity.sport.PreventControlReportEntity;
import com.yymt.service.sport.PreventControlReportService;

@Service("preventControlReportService")
public class PreventControlReportServiceImpl extends ServiceImpl<PreventControlReportDao, PreventControlReportEntity>
		implements PreventControlReportService {

	@Override
	@DataFilter(subDept = true, user = false)
	public PageUtils queryPage(Map<String, Object> params) {
		/*
		 * Page<PreventControlReportEntity> page = this.selectPage( new
		 * Query<PreventControlReportEntity>(params).getPage(), new
		 * EntityWrapper<PreventControlReportEntity>() );
		 */
		Wrapper ew = null;
		if (params.get("keyword") != null) {
			ew = new EntityWrapper<PreventControlReportEntity>().like("user_name", params.get("keyword").toString());
		} else {
			ew = new EntityWrapper<PreventControlReportEntity>();
		}
		Page<PreventControlReportEntity> page = this.selectPage(new Query<PreventControlReportEntity>(params).getPage(),
				ew);
		return new PageUtils(page);
	}

	/**
	 * 查询防控报备大数据分析
	 */
	@Override
	public R queryDataAnalyse() {
		// 人员来源地分析（各省份）
		List<Map<String, Object>> sourcePlaceList = baseMapper.queryProvinceCountList();
		String name = "";
		int value = 0;
		List<Map<String, Object>> list1 = new ArrayList<Map<String, Object>>();
		List<List<Map<String, Object>>> list2 = new ArrayList<List<Map<String, Object>>>();
		List<List<Map<String, Object>>> list3 = new ArrayList<List<Map<String, Object>>>();
		Map<String, Object> map1 = new HashMap<String, Object>();
		for (Map<String, Object> map2 : sourcePlaceList) {
			list1 = new ArrayList<Map<String, Object>>();
			name = String.valueOf(map2.get("name"));
			value = Integer.parseInt(String.valueOf(map2.get("value")));
			map1 = new HashMap<String, Object>();
			map1.put("name", name);
			list1.add(map1);
			map1 = new HashMap<String, Object>();
			map1.put("name", "江西赣州");
			map1.put("value", value);
			list1.add(map1);
			list2.add(list1);
		}
		// 外来人员来源城市top10
		List<Map<String, Object>> sourceCityList = baseMapper.queryCityCountTop10List();
		List<String> x = new ArrayList<String>();
		List<Integer> y = new ArrayList<Integer>();
		Collections.reverse(sourceCityList);
		for (Map<String, Object> map : sourceCityList) {
			name = String.valueOf(map.get("name"));
			value = Integer.parseInt(String.valueOf(map.get("value")));
			x.add(name);
			y.add(value);
		}
		// 查询防控报备总数
		long count = baseMapper.queryCount();
		// 外来人员省内百分比
		long provinceProportion = baseMapper.queryCountByCode(1);
		// 外来人员外省百分比
		long otherProvinceProportion = baseMapper.queryCountByCode(2);
		list1 = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "省内");
		map.put("value", provinceProportion);
		list1.add(map);
		map = new HashMap<String, Object>();
		map.put("name", "省外");
		map.put("value", otherProvinceProportion);
		list1.add(map);
		// 外来人员交通方式统计
		List<Map<String, Object>> trafficWayList = baseMapper.queryTrafficWayCount();
		// 统计外来人员（赣州地区以外的）总数
		long foreignTotal = baseMapper.queryCountForeign();
		return R.ok().put("sourcePlace", list2).put("x", x).put("y", y).put("province", list1)
				.put("trafficWay", trafficWayList).put("foreignTotal", foreignTotal);
	}

	@Override
	public long addPlace(String name, String code) {
		return baseMapper.addPlace(name, code);
	}

	/**
	 * 根据身份证查询最新防控报备的到哪里去信息
	 */
	@Override
	public String queryWhereGo(String identityCard) {
		return baseMapper.queryWhereGo(identityCard);
	}

	/**
	 * 根据用户id查询用户防控报备列表
	 * 
	 * @param params
	 * @return
	 */
	@Override
	public List<Map<String, Object>> queryListByUserId(Map<String, Object> params) {
		return baseMapper.queryListByUserId(params);
	}

	/**
	 * 根据用户id查询用户防控报备统计数
	 * 
	 * @param params
	 * @return
	 */
	@Override
	public int queryCountByUserId(Map<String, Object> params) {
		return baseMapper.queryCountByUserId(params);
	}

	/**
	 * 根据用户id与id查询用户防控报备详情
	 */
	@Override
	public Map<String, Object> queryInfoByUserId(Map<String, Object> params) {
		return baseMapper.queryInfoByUserId(params);
	}

}
