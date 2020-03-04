package com.yymt.service;

import com.baomidou.mybatisplus.service.IService;
import com.yymt.common.utils.PageUtils;
import com.yymt.entity.sport.RevealEntity;

import java.util.Map;

/**
 * 举报记录表
 *
 * @author hgq
 * @date 2018-03-14 11:21:26
 */
public interface RevealService extends IService<RevealEntity> {

    PageUtils queryPage(Map<String, Object> params);

    PageUtils queryRevealPage(Map<String, Object> params);

    /**
     * 将后台处理数据为正常的举报更新为“无效举报”
     * @param revealType 举报类型
     * @param revealContentId 举报的内容id
     */
    void updateRevealAsInvalid(Integer revealType,Integer revealContentId);
}

