package com.yymt.modules.common.dao.antiepidemic;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yymt.modules.common.entity.antiepidemic.GridEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 组织结构
 *
 * @author xiezhen
 * @since 2020/2/26 14:11
 */
public interface GridDao extends BaseMapper<GridEntity> {

    /*
     * 根据网格名字获取网格信息
     * */
    List<Map<String, Object>> selGridInfoByGridName(@Param("gridName") String gridName);
}
