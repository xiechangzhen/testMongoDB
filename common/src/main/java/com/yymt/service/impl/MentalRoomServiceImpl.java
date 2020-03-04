package com.yymt.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.SqlHelper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.yymt.common.utils.PageUtils;
import com.yymt.common.utils.Query;
import com.yymt.dao.sport.MentalRoomDao;
import com.yymt.entity.sport.HelpEntity;
import com.yymt.entity.sport.MentalRoomEntity;
import com.yymt.service.MentalRoomService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("mentalRoomService")
public class MentalRoomServiceImpl extends ServiceImpl<MentalRoomDao, MentalRoomEntity> implements MentalRoomService {


    @Override
    public PageUtils queryMentalPage(Map<String, Object> params) {
        Page<HelpEntity> page = new Query<HelpEntity>(params).getPage();
        EntityWrapper entityWrapper = new EntityWrapper<HelpEntity>();
        SqlHelper.fillWrapper(page, entityWrapper);
        page.setRecords(baseMapper.queryMentalList(
                page,
                params
        ));
        return new PageUtils(page);
    }
}
