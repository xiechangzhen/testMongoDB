package com.yymt.dao.sport;

import com.yymt.entity.sport.OrganizationEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

/**
 * 组织机构表
 *
 * @author cots
 * @date 2018-09-05 16:23:30
 */
public interface OrganizationDao extends BaseMapper<OrganizationEntity> {
    List listOrganazitionContact(int id);

    /**
     * 获取指定标识集的机构列表
     *
     * @param ids 机构标识集
     */
    List<OrganizationEntity> getOrganizationListByIds(@Param("ids") List<Integer> ids);

    /**
     * 按条件查询机构列表
     * */
    List queryOrganizationPage(RowBounds rowBounds, Map<String, Object> params);

    /**
     * 根据id查询详情
     * */
    Map<String, Object> selectOrgById(Integer id);

    /**
     * 查询待审核的列表
     * */
    Integer count(Map<String, Object> params);

    /**
     * 删除部门列表
     * */
    void deleteOrganizationContactIds(@Param("ids") List ids);
}
