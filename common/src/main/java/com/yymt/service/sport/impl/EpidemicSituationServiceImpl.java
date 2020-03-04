package com.yymt.service.sport.impl;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.yymt.common.annotation.DataFilter;
import com.yymt.service.sport.EpidemicSituationService;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.yymt.common.utils.PageUtils;
import com.yymt.common.utils.Query;

import com.yymt.dao.sport.EpidemicSituationDao;
import com.yymt.entity.sport.EpidemicSituationEntity;


@Service("epidemicSituationService")
public class EpidemicSituationServiceImpl extends ServiceImpl<EpidemicSituationDao, EpidemicSituationEntity> implements EpidemicSituationService {

    @Override
    @DataFilter(subDept = true, user = false)
    public PageUtils queryPage(Map<String, Object> params) {

        Wrapper ew = null;
        if(params.get("userId") != null){
            ew = new EntityWrapper<EpidemicSituationEntity>().eq("userId",params.get("userId").toString());
        }else{
            ew = new EntityWrapper<EpidemicSituationEntity>();
        }
        Page<EpidemicSituationEntity> page = this.selectPage(
                new Query<EpidemicSituationEntity>(params).getPage(),
                ew
        );

        return new PageUtils(page);
    }

}
