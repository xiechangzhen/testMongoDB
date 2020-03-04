package com.yymt.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.yymt.common.exception.RRException;
import com.yymt.common.exception.ResultEnum;
import com.yymt.common.utils.R;
import com.yymt.common.utils.RWapper;
import com.yymt.common.utils.SendSMS;
import com.yymt.dao.sport.VcodeDao;
import com.yymt.entity.sport.VcodeEntity;
import com.yymt.service.VcodeService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("vcodeService")
public class VcodeServiceImpl extends ServiceImpl<VcodeDao, VcodeEntity> implements VcodeService {

    private static Logger logger = LoggerFactory.getLogger(VcodeServiceImpl.class);

    public RWapper sendVcode(String phone, String type, String url, String accountSid, String authToken, boolean isProxy, String proxyHost, Integer proxyPort){
        try {
            Map<String, Object> resultMap = SendSMS.sendSMS(phone, url,accountSid,authToken,isProxy,proxyHost,proxyPort);
            String sendresult = (String) resultMap.get("resultCode");
            if("00000".equals(sendresult)) {
                String vcode = (String) resultMap.get("vcode");
                VcodeEntity vcodeEntity = new VcodeEntity();
                vcodeEntity.setPhone(phone);
                vcodeEntity.setVcode(vcode);
                vcodeEntity.setType(type);
                vcodeEntity.setTimemillis(System.currentTimeMillis());
                boolean flag = this.insert(vcodeEntity);
                if(flag){
                    return RWapper.ok();
                }
            }
        }catch (Exception e){
            logger.error(e.getMessage());
            throw new RRException(ResultEnum.ERROR);
        }
        return RWapper.error(ResultEnum.VALIDATOR_CODE_SEND_ERROR);
    }

    public RWapper validateVcode(String phone,String vcode,String type){
        try {
            VcodeEntity vcodeEntity = new VcodeEntity();
            vcodeEntity.setPhone(phone);
            vcodeEntity.setType(type);
            VcodeEntity checkEntity = queryVcodeByPhone(vcodeEntity);
            if(checkEntity != null && !StringUtils.isEmpty(checkEntity.getVcode())){
                long timemillis = checkEntity.getTimemillis();
                long currtime = System.currentTimeMillis();
                long between = (currtime-timemillis)/1000/60;
                if(between > 15){//超过15分钟失效
                    this.deleteById(checkEntity.getId());
                    return RWapper.error(ResultEnum.VALIDATOR_CODE_INVALID);
                }else{
                    if(checkEntity.getVcode().equals(vcode)){
                        this.deleteById(checkEntity.getId());
                        return RWapper.ok();
                    }else{//验证失败，验证码不匹配
                        return RWapper.error(ResultEnum.VALIDATOR_CODE_MISTAKE);
                    }
                }
            }
        }catch (Exception e){
            logger.error(e.getMessage());
            throw new RRException(ResultEnum.ERROR);
        }
        return RWapper.error(ResultEnum.VALIDATOR_CODE_INVALID);
    }

    public VcodeEntity queryVcodeByPhone(VcodeEntity vcodeEntity){
        return baseMapper.queryVcodeByPhone(vcodeEntity);
    }
}
