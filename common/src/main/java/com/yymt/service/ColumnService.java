package com.yymt.service;

import com.baomidou.mybatisplus.service.IService;
import com.yymt.common.utils.PageUtils;
import com.yymt.entity.sport.ColumnEntity;

import java.util.List;
import java.util.Map;

/**
 * 新闻栏目表
 *
 * @author hgq
 * @date 2018-02-10 14:26:32
 */
public interface ColumnService extends IService<ColumnEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List getChildColumnByParentValue(String parent);
}

