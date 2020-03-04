package com.yymt.dao.sport;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.yymt.entity.sport.VcodeEntity;

/**
 * 验证码
 * 
 * @author hgq
 * @date 2018-02-26 08:50:41
 */
public interface VcodeDao extends BaseMapper<VcodeEntity> {
	VcodeEntity queryVcodeByPhone(VcodeEntity vcodeEntity);
}
