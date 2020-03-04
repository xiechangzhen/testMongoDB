package com.yymt.modules.common.service.antiepidemic.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yymt.modules.common.dao.antiepidemic.GridDao;
import com.yymt.modules.common.entity.antiepidemic.GridEntity;
import com.yymt.modules.common.service.antiepidemic.GridService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 组织结构
 *
 * @author xiezhen
 * @since 2020/2/26 14:16
 */
@Service
public class GridServiceImpl extends ServiceImpl<GridDao, GridEntity> implements GridService {

    @Override
    public Map<String, Object> queryGridInfoByGridName(String gridName) {
        Map<String, Object> params = new HashMap<>();
        params.put("Sum", baseMapper.selGridInfoByGridName(gridName).size());
        params.put("Grids", baseMapper.selGridInfoByGridName(gridName));
        return params;
    }
}
