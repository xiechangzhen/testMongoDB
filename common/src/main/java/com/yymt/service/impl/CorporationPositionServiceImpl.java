package com.yymt.service.impl;

import com.yymt.common.annotation.DataFilter;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.yymt.common.utils.PageUtils;
import com.yymt.common.utils.Query;

import com.yymt.dao.sport.CorporationPositionDao;
import com.yymt.entity.sport.CorporationPositionEntity;
import com.yymt.service.CorporationPositionService;


@Service("corporationPositionService")
public class CorporationPositionServiceImpl extends ServiceImpl<CorporationPositionDao, CorporationPositionEntity> implements CorporationPositionService {

    @Override
    @DataFilter(subDept = true, user = false)
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CorporationPositionEntity> page = this.selectPage(
                new Query<CorporationPositionEntity>(params).getPage(),
                new EntityWrapper<CorporationPositionEntity>()
        );

        return new PageUtils(page);
    }

}
