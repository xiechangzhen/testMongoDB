package com.yymt.dao.sport;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.yymt.entity.sport.ColumnEntity;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

/**
 * 新闻栏目表
 * 
 * @author hgq
 * @date 2018-02-10 14:26:32
 */
public interface ColumnDao extends BaseMapper<ColumnEntity> {
    List getChildColumnByParentValue(@Param("parentValue") String parentValue);
    //后台子栏目列表
    List getChildColumnList(RowBounds rowBounds, Map<String, Object> params);
}
