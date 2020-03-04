package com.yymt.dao.sport;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.yymt.entity.sport.CoachingServiceEntity;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

/**
 * 教练服务表
 *
 * @author cots
 * @date 2018-12-13 14:35:48
 */
public interface CoachingServiceDao extends BaseMapper<CoachingServiceEntity> {

    /**
     * 分页查询教练服务
     *
     * @param rowBounds
     * @param params
     * @return
     */
    List<CoachingServiceEntity> listCoachingService(RowBounds rowBounds, Map<String, Object> params);

    /**
     * 教练服务详情查询
     *
     * @param serviceId
     * @return
     */
    CoachingServiceEntity queryCoachingServiceById(@Param("serviceId") Integer serviceId);

    /**
     * 后台获取教练服务列表
     *
     * @param rowBounds
     * @param params
     * @return
     */
    List<CoachingServiceEntity> queryCoachingServiceListPage(RowBounds rowBounds, Map<String, Object> params);

    /**
     * 后台获取待审核教练服务数量
     *
     * @param params
     * @return
     */
    int coachingServiceAuditCount(Map<String, Object> params);

    /**
     * 后台获取被举报教练服务数量
     *
     * @param params
     * @return
     */
    int coachingServiceRevealCount(Map<String, Object> params);

    /**
     * 获取指定标识集的教练服务列表
     *
     * @param ids
     * @return
     */
    List<CoachingServiceEntity> getCoachingServiceListByIds(@Param("ids") List<Integer> ids);
}
