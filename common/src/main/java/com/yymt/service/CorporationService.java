package com.yymt.service;

import com.baomidou.mybatisplus.service.IService;
import com.yymt.common.utils.PageUtils;
import com.yymt.entity.sport.CorporationEntity;

import java.util.List;
import java.util.Map;

/**
 * 社团信息表
 *
 * @author cots
 * @date 2018-09-05 16:23:30
 */
public interface CorporationService extends IService<CorporationEntity> {
    PageUtils queryPage(Map<String, Object> params);
    PageUtils listCorporation(Map<String, Object> params);
    Map corporationDetail(Map<String,Object> param);

    PageUtils listCorporationBackgroud(Map<String, Object> params);

    /**
     * 获取指定标识集的社团列表
     *
     * @param ids 社团标识集
     */
    List<CorporationEntity> getCorporationListByIds(List<Integer> ids);
    Map corporationDetailForBackground(int id);

    int auditCount(Map<String, Object> params);
    /**
     * 批量删除社团及其新闻和赛事
     */
    boolean deleteCorporationAndReleatedDataBatchs(Integer[] ids);
}

