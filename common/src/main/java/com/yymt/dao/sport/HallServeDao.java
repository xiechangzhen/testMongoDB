package com.yymt.dao.sport;

import com.yymt.common.utils.PageUtils;
import com.yymt.entity.sport.HallServeEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

/**
 * 场馆服务表
 *
 * @author cots
 * @date 2018-12-11 11:39:03
 */
public interface HallServeDao extends BaseMapper<HallServeEntity> {

    /**
     * 查询场馆服务列表
     */
    List listHallServe(RowBounds rowBounds, Map<String, Object> param);

    /**
     * 后台查询列表
     */
    List listHallAdmin(RowBounds rowBounds, Map<String, Object> params);

    /**
     * 后台根据id查询
     */
    Map<String, Object> hallServeById(@Param("id") Integer id);

    /**
     * 查询待审核状态的记录数
     */
    Integer count(Map<String, Object> params);

    /**
     * 查询举报的记录数
     */
    Integer reportCount(Map<String, Object> params);

    /**
     * 查询附近的场馆服务列表
     */
    List nearHallserve(RowBounds rowBounds, Map<String, Object> params);

    /**
     * 查询附近的场馆有场馆服务的场馆
     */
    List nearHall(RowBounds rowBounds, Map<String, Object> params);

    /**
     * 获取指定标识集的场馆服务列表
     *
     * @param ids
     * @return
     */
    List<HallServeEntity> getHallServeListByIds(@Param("ids") List<Integer> ids);

    /**
     * 修改场馆服务状态位未入驻
     * */
    int updateByHallId(Map<String, Object> map);
}
