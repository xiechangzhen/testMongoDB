package com.yymt.dao.sport;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.yymt.entity.sport.TestRecordEntity;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

/**
 * 测试题目记录表
 * 
 * @author hgq
 * @date 2018-04-19 11:29:07
 */
public interface TestRecordDao extends BaseMapper<TestRecordEntity> {
    List selectTestPage(RowBounds rowBounds, Map<String, Object> params);

    Map selectTestRecordDetail(Integer id);
}
