package com.yymt.dao.sport;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.yymt.entity.sport.FeelingsEntity;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

/**
 * 用户心情表
 * 
 * @author hgq
 * @date 2018-02-26 17:15:36
 */
public interface FeelingsDao extends BaseMapper<FeelingsEntity> {
    Map feelingsDetail(long id);

    //APP心情列表
    List queryAPPFeelingPage(RowBounds rowBounds, Map<String, Object> params);
    //后台心情列表
    List queryFeelingPage(RowBounds rowBounds, Map<String, Object> params);
}
