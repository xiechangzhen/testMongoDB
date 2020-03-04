package com.yymt.dao.sport;

import com.yymt.entity.sport.HallEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

/**
 * 场馆表
 *
 * @author cots
 * @date 2018-08-27 11:44:46
 */
public interface HallDao extends BaseMapper<HallEntity> {

    List listHall(RowBounds rowBounds, Map<String, Object> params);

    Map hallDetail(Map<String, Object> params);

    List listHallForBackgroud(RowBounds rowBounds, Map<String, Object> param);

    /**
     * 获取指定标识集的场馆列表
     *
     * @param ids 场馆标识集
     */
    List<HallEntity> getHallsListByIds(@Param("ids") List<Integer> ids);

    Map hallDetailForBackground(@Param("id") int id);

    int auditCount(Map<String, Object> params);

    /**
     * 查询未入驻某场馆的账号
     *
     * @param hallId 场馆id
     */
    List<Map<String,Object>> getUnbindUserByHallId(@Param("hallId") Integer hallId);
    /**
     * 查询入驻某场馆的账号
     *
     * @param hallId 场馆id
     */
    List<Map<String,Object>> getBindUserByHallId(@Param("hallId") Integer hallId);

    /**
     * 根据场馆id删除该场馆所有入驻的场馆用户
     * */
    void deleteByHlllId(@Param("hallId") Integer hallId);

    /**
     * 查询场馆所有用户的id
     * */
    List<Integer> selectListUserId();

    /**
     * 查询出场馆管理员的所有用户
     * */
    List<Integer> selectListUserPosition();

    /**
     * 查询已入驻场馆的管理员
     * */
    List getBindUserByHallIdPage(RowBounds rowBounds, Map<String, Object> params);

    /**
     * 删除场馆及和场馆有关的数据
     * */
    void deleteHall(@Param("ids") Integer[] ids);
}
