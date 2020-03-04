package com.yymt.service.impl;

import com.yymt.common.annotation.DataFilter;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.yymt.common.utils.PageUtils;
import com.yymt.common.utils.Query;

import com.yymt.dao.sport.IndustrySportsLevelDao;
import com.yymt.entity.sport.IndustrySportsLevelEntity;
import com.yymt.service.IndustrySportsLevelService;


@Service("industrySportsLevelService")
public class IndustrySportsLevelServiceImpl extends ServiceImpl<IndustrySportsLevelDao, IndustrySportsLevelEntity> implements IndustrySportsLevelService {

    @Override
    @DataFilter(subDept = true, user = false)
    public PageUtils queryPage(Map<String, Object> params) {
        Page<IndustrySportsLevelEntity> page = this.selectPage(
                new Query<IndustrySportsLevelEntity>(params).getPage(),
                new EntityWrapper<IndustrySportsLevelEntity>()
        );

        return new PageUtils(page);
    }

}
