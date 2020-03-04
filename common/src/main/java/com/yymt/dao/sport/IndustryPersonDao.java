package com.yymt.dao.sport;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.yymt.entity.sport.GuideEntity;
import com.yymt.entity.sport.IndustryPersonEntity;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

/**
 * 行业人员
 *
 * @author cots
 * @date 2018-09-05 16:23:30
 */
public interface IndustryPersonDao extends BaseMapper<IndustryPersonEntity> {
    List listIndustryPerson(RowBounds rowBounds, Map<String, Object> params);

    /**
     * 根据id查询行业人员的基本信息
     */
    Map<String, Object> selectInfoById(Integer id);

    /**
     * 分页查询行业人员列表
     *
     * @param rowBounds
     * @param params
     * @return
     */
    List<IndustryPersonEntity> getIndustryPersonListPage(RowBounds rowBounds, Map<String, Object> params);

    /**
     * 获取指定标识的行业人员
     *
     * @param id 行业人员标识
     * @return
     */
    IndustryPersonEntity getIndustryPersonById(@Param("id") Integer id);

    /**
     * 获取指定标识集的行业人员列表
     *
     * @param ids 行业人员标识集
     */
    List<IndustryPersonEntity> getIndustryPersonListByIds(@Param("ids") List<Integer> ids);

    /**
     * 获取所有已审核通过的行业人员列表
     *
     * @return
     */
    List<IndustryPersonEntity> getIndustryPersonListAll();

    /**
     * 获取待审核的行业人员数量
     *
     * @return
     */
    int auditCount();

    /**
     * 获取相关参数的待审核的行业人员数量
     *
     * @param params 相关查询参数
     * @return
     */
    int auditCount(Map<String, Object> params);
}
