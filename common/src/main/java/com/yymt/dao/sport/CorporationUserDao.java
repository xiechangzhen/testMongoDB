package com.yymt.dao.sport;

import com.yymt.entity.sport.CorporationUserEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * 用户社团表
 * 
 * @author cots
 * @date 2018-09-05 16:23:30
 */
public interface CorporationUserDao extends BaseMapper<CorporationUserEntity> {
    List listUserCorporation(Long id);
}
