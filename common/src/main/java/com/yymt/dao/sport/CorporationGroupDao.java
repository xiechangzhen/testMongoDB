package com.yymt.dao.sport;

import com.yymt.entity.sport.CorporationGroupEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * 社团团体会员关系表
 * 
 * @author cots
 * @date 2018-09-05 16:23:30
 */
public interface CorporationGroupDao extends BaseMapper<CorporationGroupEntity> {
    List listGroupMember(int id);
}
