package com.yymt.modules.common.service.antiepidemic;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yymt.modules.common.entity.antiepidemic.GridEntity;

import java.util.List;
import java.util.Map;

/**
 * 组织结构
 *
 * @author xiezhen
 * @since 2020/2/26 14:15
 */
public interface GridService extends IService<GridEntity> {

    /*
     * 根据网格名字获取网格信息
     * */
    Map<String, Object> queryGridInfoByGridName(String gridName);
}
