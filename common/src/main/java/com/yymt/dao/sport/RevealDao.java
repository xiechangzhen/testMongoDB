package com.yymt.dao.sport;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.yymt.entity.sport.RevealEntity;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

/**
 * 举报记录表
 * 
 * @author hgq
 * @date 2018-03-14 11:21:26
 */
public interface RevealDao extends BaseMapper<RevealEntity> {
    //后台举报列表
    List queryRevealPage(RowBounds rowBounds, Map<String, Object> params);
}
