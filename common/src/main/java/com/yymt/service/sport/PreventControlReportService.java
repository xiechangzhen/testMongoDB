package com.yymt.service.sport;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.service.IService;
import com.yymt.common.utils.PageUtils;
import com.yymt.common.utils.R;
import com.yymt.entity.sport.PreventControlReportEntity;

/**
 * 防控报备表
 *
 * @author xiaojin
 * @date 2020-02-09 20:54:47
 */
public interface PreventControlReportService extends IService<PreventControlReportEntity> {

	PageUtils queryPage(Map<String, Object> params);

	/**
	 * 查询防控报备大数据分析
	 */
	R queryDataAnalyse();
	
	long addPlace(String name,String code);
	
	/**
	 * 根据身份证查询最新防控报备的到哪里去信息
	 * @param identityCard
	 * @return
	 */
	String queryWhereGo(String identityCard);
	
	/**
	 * 根据用户id查询用户防控报备列表
	 * 
	 * @param params
	 * @return
	 */
	List<Map<String, Object>> queryListByUserId(Map<String, Object> params);

	/**
	 * 根据用户id查询用户防控报备统计数
	 * 
	 * @param params
	 * @return
	 */
	int queryCountByUserId(Map<String, Object> params);
	

	/**
	 * 根据用户id与id查询用户防控报备详情
	 * @param params
	 * @return
	 */
	Map<String, Object> queryInfoByUserId(Map<String, Object> params);
	
}
