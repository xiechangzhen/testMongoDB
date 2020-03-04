package com.yymt.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.yymt.dao.sport.CorporationSportsDao;
import com.yymt.entity.sport.CorporationSportsEntity;
import com.yymt.service.CorporationSportsService;
import org.springframework.stereotype.Service;


@Service("corporationSportsService")
public class CorporationSportsServiceImpl extends ServiceImpl<CorporationSportsDao, CorporationSportsEntity> implements CorporationSportsService {


}
