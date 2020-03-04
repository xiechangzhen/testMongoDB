package com.yymt.modules.controller.sport;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.yymt.common.exception.ResultEnum;
import com.yymt.common.utils.Constant;
import com.yymt.common.utils.R;
import com.yymt.common.utils.RWapper;
import com.yymt.entity.api.UserEntity;
import com.yymt.service.UserService;
import com.yymt.service.VcodeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 验证码
 *
 * @author hgq
 * @date 2018-02-26 08:50:41
 */
@RestController
@RequestMapping("vcode")
@Api(tags = "短信验证码")
public class VcodeController extends BaseController {
    @Autowired
    private VcodeService vcodeService;

    @Autowired
    private UserService userService;

    @Value("${sms.url}")
    private String smsUrl;
    @Value("${sms.operation}")
    private String smsOperation;
    @Value("${sms.accountSid}")
    private String accountSid;
    @Value("${sms.authToken}")
    private String authToken;

    //全球眼网络需要配置代理
    @Value("${proxy.isProxy}")
    private boolean isProxy;
    @Value("${proxy.proxyHost}")
    private String proxyHost;
    @Value("${proxy.proxyPort}")
    private Integer proxyPort;

    /**
     * 发送验证码
     */
    @GetMapping("sendVcode/{phone}/{type}")
    @ApiOperation("发送验证码")
    public RWapper sendVcode(@PathVariable("phone") String phone, @PathVariable("type") String type) {
        //验证码类型（0-注册，1-app忘记密码,2-后台忘记密码，3-app修改密码,4-手机绑定）

        UserEntity entity = userService.selectOne(new EntityWrapper<UserEntity>().eq("username", phone));
        int typeInt = Integer.parseInt(type);
        if (typeInt == Constant.VcodeType.REGISTER.getValue() && entity != null) {
            return RWapper.error(ResultEnum.USER_EXIST).encode(isEncryption);
        } else if (typeInt == Constant.VcodeType.APP_FOGET.getValue() && entity == null) {
            return RWapper.error(ResultEnum.USER_NOT_EXIST).encode(isEncryption);
        } else if (typeInt == Constant.VcodeType.APP_UPDATE_PWD.getValue() && entity == null) {
            return RWapper.error(ResultEnum.USER_NOT_EXIST).encode(isEncryption);
        }
        return vcodeService.sendVcode(phone, type,
                smsUrl + smsOperation, accountSid,
                authToken, isProxy, proxyHost, proxyPort
        ).encode(isEncryption);
    }

    /**
     * 验证验证码
     */
    @GetMapping("validateVcode/{phone}/{vcode}/{type}")
    @ApiOperation("验证验证码")
    public RWapper validateVcode(@PathVariable("phone") String phone, @PathVariable("vcode") String vcode, @PathVariable("type") String type) {
        return vcodeService.validateVcode(phone, vcode, type).encode(isEncryption);
    }

}
