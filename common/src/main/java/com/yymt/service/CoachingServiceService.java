package com.yymt.service;

import com.baomidou.mybatisplus.service.IService;
import com.yymt.common.utils.PageUtils;
import com.yymt.entity.sport.CoachingServiceEntity;

import java.util.List;
import java.util.Map;

/**
 * 教练服务表
 *
 * @author cots
 * @date 2018-12-13 14:35:48
 */
public interface CoachingServiceService extends IService<CoachingServiceEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 分页查询教练服务
     *
     * @param params
     * @return
     */
    PageUtils listCoachingService(Map<String, Object> params);

    /**
     * 教练服务详情查询
     *
     * @param serviceId
     * @return
     */
    CoachingServiceEntity queryCoachingServiceById(Integer serviceId);

    /**
     * 后台获取教练服务列表
     *
     * @param params
     * @return
     */
    PageUtils queryCoachingServiceListPage(Map<String, Object> params);

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
    List<CoachingServiceEntity> getCoachingServiceListByIds(List<Integer> ids);
}

