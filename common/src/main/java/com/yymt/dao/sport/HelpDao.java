package com.yymt.dao.sport;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.yymt.entity.sport.HelpEntity;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

/**
 * 求助表
 * 
 * @author hgq
 * @date 2018-03-06 15:44:37
 */
public interface HelpDao extends BaseMapper<HelpEntity> {

    Map helpDetail(Integer id);
    Map bestCommentDetail(Integer id);
    //APP求助列表
    List queryAppHelpPage(RowBounds rowBounds, Map<String, Object> params);

    //后台求助列表
    List queryHelpPage(RowBounds rowBounds, Map<String, Object> params);
}
