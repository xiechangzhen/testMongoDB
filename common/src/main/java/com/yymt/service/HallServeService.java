package com.yymt.service;

import com.baomidou.mybatisplus.service.IService;
import com.yymt.common.utils.PageUtils;
import com.yymt.entity.sport.HallServeEntity;

import java.util.List;
import java.util.Map;

/**
 * 场馆服务表
 *
 * @author cots
 * @date 2018-12-11 11:39:03
 */
public interface HallServeService extends IService<HallServeEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * App查询场馆服务列表
     */
    PageUtils listHallServe(Map<String, Object> params);

    /**
     * 后台查询列表
     */
    PageUtils listHallAdmin(Map<String, Object> params);

    /**
     * 后台根据id查询
     */
    Map<String, Object> hallServeById(Integer id);

    /**
     * 查询待审核状态的记录数
     */
    Integer count(Map<String, Object> map);

    /**
     * 查询举报的记录数
     */
    Integer reportCount(Map<String, Object> params);

    /**
     * 查询附近的场馆服务列表
     */
    PageUtils nearHallserve(Map<String, Object> params);

    /**
     * 查询附近的场馆有场馆服务的场馆
     */
    PageUtils nearHall(Map<String, Object> params);

    /**
     * 获取指定标识集的场馆服务列表
     *
     * @param ids
     * @return
     */
    List<HallServeEntity> getHallServeListByIds(List<Integer> ids);

    /**
     * 修改场馆服务状态位未入驻
     * */
    int updateByHallId(Map<String, Object> map);
}

