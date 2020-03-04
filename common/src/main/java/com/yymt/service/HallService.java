package com.yymt.service;

import com.baomidou.mybatisplus.service.IService;
import com.yymt.common.utils.PageUtils;
import com.yymt.entity.sport.HallEntity;

import java.util.List;
import java.util.Map;

/**
 * 场馆表
 *
 * @author cots
 * @date 2018-08-27 11:44:46
 */
public interface HallService extends IService<HallEntity> {

    PageUtils queryPage(Map<String, Object> params);
    PageUtils listHall(Map<String, Object> params);
    Map hallDetail(Map<String, Object> params);

    PageUtils listHallForBackgroud(Map<String,Object> param);

    /**
     * 获取指定标识集的场馆列表
     *
     * @param ids 场馆标识集
     */
    List<HallEntity> getHallsListByIds(List<Integer> ids);
    Map hallDetailForBackground(int id);

    int auditCount(Map<String, Object> params);
    /**
     * 查询未入驻某场馆的账号
     *
     * @param hallId 场馆id
     */
    List<Map<String,Object>> getUnbindUserByHallId(Integer hallId);
    /**
     * 查询未入驻某场馆的账号
     *
     * @param hallId 场馆id
     */
    List<Map<String,Object>> getBindUserByHallId(Integer hallId);

    /**
     * 根据场馆id删除该场馆所有入驻的场馆用户
     * */
    void deleteByHlllId(Integer hallId);

    /**
     * 查询场馆所有用户的id
     * */
    List<Integer> selectListUserId();

    /**
     * 查询出场馆管理员的所有用户
     * */
    List<Integer> selectListUserPosition();

    /**
     * 分页查询某场馆的入驻账号
     * */
    PageUtils getBindUserByHallIdPage(Map<String, Object> params);

    /**
     * 删除场馆及和场馆有关的数据
     * */
    void deleteHall(Integer[] ids);
}

