package com.yymt.dao.sport;

import com.yymt.entity.sport.CorporationGreatsEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

/**
 * 组织点赞表
 * 
 * @author cots
 * @date 2018-09-11 18:54:03
 */
public interface CorporationGreatsDao extends BaseMapper<CorporationGreatsEntity> {
    Integer queryGreatCountByCorporationId(int id);

    List like(RowBounds rowBounds, Map<String, Object> params);

    List<String> listCorporationGreatUser(int corporationId);
}
