package com.yymt.modules.controller;


import com.yymt.common.form.LoginForm;
import com.yymt.common.utils.R;
import com.yymt.common.utils.RWapper;
import com.yymt.common.validator.ValidatorUtils;
import com.yymt.entity.api.TokenEntity;
import com.yymt.entity.api.UserEntity;
import com.yymt.modules.controller.sport.BaseController;
import com.yymt.service.CorporationUserService;
import com.yymt.service.TokenService;
import com.yymt.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;
import java.util.Map;

/**
 * 登录接口
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-03-23 15:31
 */
@RestController
@RequestMapping("/api")
@Api(tags = "登录接口/设备绑定接口")
public class ApiLoginController extends BaseController {
    @Autowired
    private UserService userService;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private CorporationUserService corporationUserService;

    @PostMapping("login")
    @ApiOperation("登录")
    public R login(@RequestBody LoginForm form) {
        //表单校验
        ValidatorUtils.validateEntity(form);

        //用户登录
        Map<String, Object> map = userService.login(form);
        //List page = corporationUserService.listUserCorporation(Long.parseLong(map.get("id").toString()));
//        return R.ok(map);
        return R.ok().put("data", map);
    }

    @PostMapping("loginWithOpenId")
    @ApiOperation("第三方登录")
    public RWapper loginWithOpenId(@RequestParam String openId) {
        //用户登录
        Map<String, Object> map = userService.loginWithOpenId(openId);

       // List page = corporationUserService.listUserCorporation(Long.parseLong(map.get("id").toString()));
//        return R.ok(map);
        return RWapper.ok().put("data", map).encode(isEncryption);
    }

    @PostMapping("logout")
    @ApiOperation("退出")
    public RWapper logout(@ApiIgnore @RequestBody String token){
        JSONObject object = JSONObject.fromObject(token);
        TokenEntity tokenEntity = tokenService.queryByToken(object.getString("token"));
        if(tokenEntity != null) {
            Long userId = tokenEntity.getUserId();
            tokenService.expireToken(userId);
            UserEntity userEntity = userService.selectById(userId);
            if (userEntity != null) {
                //清除pushclientId
                userEntity.setPushClientId("");
                userService.updateAllColumnById(userEntity);
            }
        }
        return RWapper.ok();
    }
}
