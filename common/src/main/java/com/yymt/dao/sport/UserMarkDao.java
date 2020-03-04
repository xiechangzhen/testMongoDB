package com.yymt.dao.sport;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.yymt.entity.sport.UserMarkEntity;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

/**
 * 用户收藏表
 * 
 * @author hgq
 * @date 2018-02-10 14:26:32
 */
public interface UserMarkDao extends BaseMapper<UserMarkEntity> {
    int cancelMark(UserMarkEntity entity);
    List selectNewsPage(RowBounds rowBounds, Map<String, Object> params);
    List selectFeelingsPage(RowBounds rowBounds, Map<String, Object> params);
    List selectHelpPage(RowBounds rowBounds, Map<String, Object> params);

    Integer queryCountById(Map<String, Object> params);
}
