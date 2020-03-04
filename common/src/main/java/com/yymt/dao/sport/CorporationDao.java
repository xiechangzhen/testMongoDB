package com.yymt.dao.sport;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.yymt.entity.sport.CorporationEntity;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

/**
 * 社团信息表
 *
 * @author cots
 * @date 2018-09-05 16:23:30
 */
public interface CorporationDao extends BaseMapper<CorporationEntity> {
    List listCorporation(RowBounds rowBounds, Map<String, Object> params);

    Map corporationDetail(Map<String, Object> param);

    List listCorporationBackgroud(RowBounds rowBounds, Map<String, Object> params);

    /**
     * 获取指定标识集的社团列表
     *
     * @param ids 社团标识集
     */
    List<CorporationEntity> getCorporationListByIds(@Param("ids") List<Integer> ids);

    Map corporationDetailForBackground(int id);
    int auditCount(Map<String, Object> params);
    /**
     * 批量删除社团及其新闻和赛事
     */
    boolean deleteCorporationAndReleatedDataBatchs(Integer[] ids);
}
