package com.yymt.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.SqlHelper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.yymt.common.utils.PageUtils;
import com.yymt.common.utils.Query;
import com.yymt.dao.sport.ColumnDao;
import com.yymt.entity.sport.ColumnEntity;
import com.yymt.service.ColumnService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("columnService")
public class ColumnServiceImpl extends ServiceImpl<ColumnDao, ColumnEntity> implements ColumnService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ColumnEntity> page = new Query<ColumnEntity>(params).getPage();
        EntityWrapper entityWrapper = new EntityWrapper<ColumnEntity>();
        SqlHelper.fillWrapper(page, entityWrapper);
        page.setRecords(baseMapper.getChildColumnList(
                page,
                params
        ));
        return new PageUtils(page);
    }

    /**
     * 通过父栏目的标记值获取子栏目
     * @return
     */
    public List getChildColumnByParentValue(String parentValue) {
        return baseMapper.getChildColumnByParentValue(parentValue);
    }
}
