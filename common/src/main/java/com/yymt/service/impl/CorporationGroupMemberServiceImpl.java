package com.yymt.service.impl;

import com.yymt.common.annotation.DataFilter;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.yymt.common.utils.PageUtils;
import com.yymt.common.utils.Query;

import com.yymt.dao.sport.CorporationGroupMemberDao;
import com.yymt.entity.sport.CorporationGroupMemberEntity;
import com.yymt.service.CorporationGroupMemberService;


@Service("corporationGroupMemberService")
public class CorporationGroupMemberServiceImpl extends ServiceImpl<CorporationGroupMemberDao, CorporationGroupMemberEntity> implements CorporationGroupMemberService {

    @Override
    @DataFilter(subDept = true, user = false)
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CorporationGroupMemberEntity> page = this.selectPage(
                new Query<CorporationGroupMemberEntity>(params).getPage(),
                new EntityWrapper<CorporationGroupMemberEntity>()
        );

        return new PageUtils(page);
    }

}
