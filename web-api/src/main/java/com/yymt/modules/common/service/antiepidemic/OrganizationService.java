package com.yymt.modules.common.service.antiepidemic;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yymt.modules.common.entity.antiepidemic.OrganizationEntity;

import java.util.List;
import java.util.Map;

/**
 * 组织结构
 *
 * @author xiezhen
 * @since 2020/2/26 14:15
 */
public interface OrganizationService extends IService<OrganizationEntity> {

    /*
     * 获取小区列表
     * */
    List<Map<String, Object>> queryList(String name);

    /*
     * 根据小区名字查询小区信息
     * */
    Map<String, Object> queryOrganizationInfoByOrganizationName(String organizationName);
}
