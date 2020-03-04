package com.yymt.dao.sport;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.yymt.entity.sport.PreventControlReportEntity;

/**
 * 防控报备表
 * 
 * @author xiaojin
 * @date 2020-02-09 20:54:47
 */
public interface PreventControlReportDao extends BaseMapper<PreventControlReportEntity> {
	/**
	 * 人员来源地分析（各省份）
	 */
	List<Map<String, Object>> queryProvinceCountList();

	/**
	 * 外来人员来源城市top10
	 */
	List<Map<String, Object>> queryCityCountTop10List();

	/**
	 * 外来人员交通方式统计
	 */
	List<Map<String, Object>> queryTrafficWayCount();

	/**
	 * 外来人员省内外占比
	 */
	long queryCountByCode(@Param("flag") int flag);

	/**
	 * 查询防控报备总数
	 */
	long queryCount();

	long addPlace(@Param("name") String name, @Param("code") String code);

	/**
	 * 根据身份证查询最新防控报备的到哪里去信息
	 * 
	 * @param identityCard
	 * @return
	 */
	String queryWhereGo(@Param("identityCard") String identityCard);

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
	 * 
	 * @param params
	 * @return
	 */
	Map<String, Object> queryInfoByUserId(Map<String, Object> params);

	/**
	 * 统计外来人员（赣州地区以外的）总数
	 * 
	 * @param params
	 * @return
	 */
	long queryCountForeign();

}
