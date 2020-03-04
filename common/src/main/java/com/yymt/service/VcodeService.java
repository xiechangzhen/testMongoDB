package com.yymt.service;

import com.baomidou.mybatisplus.service.IService;
import com.yymt.common.utils.R;
import com.yymt.common.utils.RWapper;
import com.yymt.entity.sport.VcodeEntity;

/**
 * 验证码
 *
 * @author hgq
 * @date 2018-02-26 08:50:41
 */
public interface VcodeService extends IService<VcodeEntity> {

    RWapper sendVcode(String phone, String type, String url, String accountSid, String authToken, boolean isProxy, String proxyHost, Integer proxyPort);

    RWapper validateVcode(String phone, String vcode, String type);

    VcodeEntity queryVcodeByPhone(VcodeEntity vcodeEntity);
}

