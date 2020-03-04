package com.yymt.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.SqlHelper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.yymt.common.annotation.DataFilter;
import com.yymt.common.utils.PageUtils;
import com.yymt.common.utils.Query;
import com.yymt.dao.sport.DistrictDao;
import com.yymt.entity.sport.DistrictEntity;
import com.yymt.service.DistrictService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("districtService")
public class DistrictServiceImpl extends ServiceImpl<DistrictDao, DistrictEntity> implements DistrictService {

    @Override
    @DataFilter(subDept = true, user = false)
    public PageUtils queryPage(Map<String, Object> params) {
        boolean isCodeExist = params.get("areaCode")!=null;
        Page<DistrictEntity> page = this.selectPage(
                new Query<DistrictEntity>(params).getPage(),
                new EntityWrapper<DistrictEntity>().and(isCodeExist,"parent_code = {0}",params.get("areaCode"))
        );
        return new PageUtils(page);
    }

    @Override
    public PageUtils queryDistrictByDict(Map<String, Object> params) {
        Page<DistrictEntity> page = new Query<DistrictEntity>(params).getPage();
        EntityWrapper entityWrapper = new EntityWrapper<DistrictEntity>();
        SqlHelper.fillWrapper(page, entityWrapper);
        page.setRecords(baseMapper.queryDistrictByDict(
                page,
                params
        ));
        return new PageUtils(page);
    }

    @Override
    public List listDistrict(Map param) {
        return baseMapper.listDistrict(param);
    }

    @Override
    public List listProvince(Integer level) {
        return baseMapper.listProvince(level);
    }
}
