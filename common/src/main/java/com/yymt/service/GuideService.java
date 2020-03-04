package com.yymt.service;

import com.baomidou.mybatisplus.service.IService;
import com.yymt.common.utils.PageUtils;
import com.yymt.entity.sport.GuideEntity;

import java.util.List;
import java.util.Map;

/**
 * 指南
 *
 * @author cots
 * @date 2018-09-13 20:54:42
 */
public interface GuideService extends IService<GuideEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 获取指定标识集的指南列表
     *
     * @param ids 指南标识集
     */
    List<GuideEntity> getGuideListByIds(List<Integer> ids);

    /**
     * 条件查询指南管理
     */
    PageUtils queryGuidePage(Map<String, Object> param);

    /**
     * 批量审核
     * */
    void allAudit(List<Integer> ids, Integer status,Long id);

    /**
     * 查询待审核的记录
     * */
    int auditCount(Map<String, Object> params);
}

