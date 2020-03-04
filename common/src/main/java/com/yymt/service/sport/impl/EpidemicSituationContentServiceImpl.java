package com.yymt.service.sport.impl;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.yymt.common.annotation.DataFilter;
import com.yymt.service.sport.EpidemicSituationContentService;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.yymt.common.utils.PageUtils;
import com.yymt.common.utils.Query;

import com.yymt.dao.sport.EpidemicSituationContentDao;
import com.yymt.entity.sport.EpidemicSituationContentEntity;


@Service("epidemicSituationContentService")
public class EpidemicSituationContentServiceImpl extends ServiceImpl<EpidemicSituationContentDao, EpidemicSituationContentEntity> implements EpidemicSituationContentService {

    @Override
    @DataFilter(subDept = true, user = false)
    public PageUtils queryPage(Map<String, Object> params) {
        Wrapper ew = null;
        if(params.get("type") != null){
            ew = new EntityWrapper<EpidemicSituationContentEntity>().eq("news_type",params.get("type").toString());
        }else{
            ew = new EntityWrapper<EpidemicSituationContentEntity>();
        }
        Page<EpidemicSituationContentEntity> page = this.selectPage(
                new Query<EpidemicSituationContentEntity>(params).getPage(),
                ew
        );

        return new PageUtils(page);
    }

}
