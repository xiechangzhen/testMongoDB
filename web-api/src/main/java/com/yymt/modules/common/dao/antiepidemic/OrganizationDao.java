package com.yymt.modules.common.dao.antiepidemic;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yymt.modules.common.entity.antiepidemic.OrganizationEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 小区结构
 *
 * @author xiezhen
 * @since 2020/2/26 14:11
 */
public interface OrganizationDao extends BaseMapper<OrganizationEntity> {

    /*
     * 获取小区列表
     * */
    List<Map<String, Object>> selList(@Param("name") String name);

    /*
     * 根据小区名字查询小区信息
     * */
    List<Map<String, Object>> sqlOrganizationInfoByOrganizationName(@Param("organizationName") String organizationName);
}
