package com.yymt.service;

import com.baomidou.mybatisplus.service.IService;
import com.yymt.common.utils.PageUtils;
import com.yymt.entity.sport.OrganizationContactEntity;
import com.yymt.entity.sport.OrganizationEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 组织机构表

 *
 * @author cots
 * @date 2018-09-05 16:23:30
 */
public interface OrganizationContactService extends IService<OrganizationContactEntity> {

    PageUtils queryPage(Map<String, Object> params);

}

