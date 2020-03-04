package com.yymt.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.yymt.common.annotation.DataFilter;
import com.yymt.common.utils.PageUtils;
import com.yymt.common.utils.Query;
import com.yymt.dao.sport.OrganizationContactDao;
import com.yymt.entity.sport.OrganizationContactEntity;
import com.yymt.service.OrganizationContactService;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author keep
 * @date 2018/10/20 14:04
 */
@Service("organizationContactService")
public class OrganizationContactServiceImpl extends ServiceImpl<OrganizationContactDao, OrganizationContactEntity> implements OrganizationContactService {

    @Override
    @DataFilter(subDept = true, user = false)
    public PageUtils queryPage(Map<String, Object> params) {
        boolean isKeywordExist = params.get("keyword") == null ? false : true;
        Page<OrganizationContactEntity> page = this.selectPage(
                new Query<OrganizationContactEntity>(params).getPage(),
                new EntityWrapper<OrganizationContactEntity>().like(isKeywordExist, "name", params.get("keyword") == null ? "" : params.get("keyword").toString())
        );

        return new PageUtils(page);
    }
}

