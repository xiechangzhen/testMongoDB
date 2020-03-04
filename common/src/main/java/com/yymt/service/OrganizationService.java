package com.yymt.service;

import com.baomidou.mybatisplus.service.IService;
import com.yymt.common.utils.PageUtils;
import com.yymt.entity.sport.OrganizationEntity;

import java.util.List;
import java.util.Map;

/**
 * 组织机构表

 *
 * @author cots
 * @date 2018-09-05 16:23:30
 */
public interface OrganizationService extends IService<OrganizationEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List listOrganazitionContact(int id);

    /**
     * 获取指定标识集的机构列表
     *
     * @param ids 机构标识集
     */
    List<OrganizationEntity> getOrganizationListByIds(List<Integer> ids);

    PageUtils queryOrganizationPage(Map<String, Object> params);

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
    void deleteOrganizationContactIds(List ids);
}

