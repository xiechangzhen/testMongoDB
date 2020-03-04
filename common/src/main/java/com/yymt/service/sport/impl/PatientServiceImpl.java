package com.yymt.service.sport.impl;

import com.yymt.common.annotation.DataFilter;
import com.yymt.service.sport.PatientService;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.yymt.common.utils.PageUtils;
import com.yymt.common.utils.Query;

import com.yymt.dao.sport.PatientDao;
import com.yymt.entity.sport.PatientEntity;


@Service("patientService")
public class PatientServiceImpl extends ServiceImpl<PatientDao, PatientEntity> implements PatientService {

    @Override
    @DataFilter(subDept = true, user = false)
    public PageUtils queryPage(Map<String, Object> params) {
        Page<PatientEntity> page = this.selectPage(
                new Query<PatientEntity>(params).getPage(),
                new EntityWrapper<PatientEntity>()
        );

        return new PageUtils(page);
    }

}
