package com.yymt.modules.common.service.antiepidemic.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yymt.modules.common.dao.antiepidemic.OrganizationDao;
import com.yymt.modules.common.entity.antiepidemic.OrganizationEntity;
import com.yymt.modules.common.service.antiepidemic.OrganizationService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 组织结构
 *
 * @author xiezhen
 * @since 2020/2/26 14:16
 */
@Service
public class OrganizationServiceImpl extends ServiceImpl<OrganizationDao, OrganizationEntity> implements OrganizationService {

    @Override
    public List<Map<String, Object>> queryList(String name) {

        List<Map<String, Object>> list = baseMapper.selList(name);
        return list.stream().map(map -> {
            ArrayList devices = (ArrayList)map.get("Devices");
            if(devices == null || devices.size() == 0){
                map.put("Devices",null);
            }
            return map;
        }).filter(map -> Objects.nonNull(map.get("Devices"))).collect(Collectors.toList());
    }

    @Override
    public Map<String, Object> queryOrganizationInfoByOrganizationName(String organizationName) {

        Map<String, Object> params = new HashMap<>();
        params.put("Communities", baseMapper.sqlOrganizationInfoByOrganizationName(organizationName));
        return params;
    }
}
