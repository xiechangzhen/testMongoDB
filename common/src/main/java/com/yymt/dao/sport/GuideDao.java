package com.yymt.dao.sport;

import com.yymt.entity.sport.GuideEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

/**
 * 指南
 *
 * @author cots
 * @date 2018-09-13 20:54:42
 */
public interface GuideDao extends BaseMapper<GuideEntity> {

    /**
     * 获取指定标识集的指南列表
     *
     * @param ids 指南标识集
     */
    List<GuideEntity> getGuideListByIds(@Param("ids") List<Integer> ids);

    /**
     * 按条件查询指南列表
     */
    List queryGuidePage(RowBounds rowBounds, Map<String, Object> params);

    /**
     * 批量审核
     * */
    void allAudit(@Param("ids") List<Integer> ids,@Param("status") Integer status,@Param("auditorId") Long auditorId);

    /**
     * 查询待审核的记录
     * */
    int auditCount(Map<String, Object> params);
}
