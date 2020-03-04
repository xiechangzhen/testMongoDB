package com.yymt.modules.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.yymt.common.exception.ResultEnum;
import com.yymt.common.form.LoginForm;
import com.yymt.common.form.RegisterForm;
import com.yymt.common.utils.RWapper;
import com.yymt.entity.api.UserEntity;
import com.yymt.modules.controller.sport.BaseController;
import com.yymt.service.UserService;
import com.yymt.service.VcodeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Map;

/**
 * 注册接口
 *
 * @date 2017-03-26 17:27
 */
@RestController
@RequestMapping("/api")
@Api(tags = "注册接口")
public class ApiRegisterController extends BaseController {
    @Autowired
    private UserService userService;

    @Autowired
    private VcodeService vcodeService;


    @PostMapping("register")
    @ApiOperation("注册")
    public RWapper register(@RequestBody RegisterForm form) {
        //表单校验
//        ValidatorUtils.validateEntity(form);

        UserEntity userEntity = userService.selectOne(new EntityWrapper<UserEntity>().where("nick_name = {0}", form.getNick()));
        if (userEntity != null) {
            return RWapper.error(ResultEnum.NICK_NAME_ALREADY_EXIST).encode(isEncryption);
        }
        //校验验证码是否正确
        RWapper r = vcodeService.validateVcode(form.getMobile(), form.getCode(), form.getCodeType());
        if (r.getCode() == 0) {//返回0验证通过
            UserEntity user = new UserEntity();
            user.setUsername(form.getMobile());
            user.setNickName(form.getNick());
            user.setUserType(0);//普通用户
            user.setPassword(DigestUtils.sha256Hex(form.getPassword()));
            user.setCreateTime(new Date());
            userService.insert(user);
            //用户登录
            LoginForm loginForm = new LoginForm();
            loginForm.setMobile(user.getUsername());
            loginForm.setPassword(form.getPassword());
            Map<String, Object> map = userService.login(loginForm);
            return RWapper.ok().putMap(map).encode(isEncryption);
        } else {
            return r;
        }
    }

    @PostMapping("registerStep1PhoneCode")
    @ApiOperation("注册第一步，手机验证和设置密码")
    public RWapper registerStep1PhoneCode(@RequestBody RegisterForm form) {
        RWapper r = vcodeService.validateVcode(form.getMobile(),
                form.getCode(),
                form.getCodeType()
        ).encode(isEncryption);
        if (r.getCode() != 0)
            return r;

        String username = form.getMobile();
        UserEntity userEntity = userService.selectOne(
                new EntityWrapper<UserEntity>()
                        .where("username = {0}", username)
        );
        if (userEntity != null) {
            return RWapper.error(ResultEnum.USER_EXIST).encode(isEncryption);
        }

        UserEntity user = new UserEntity();
        user.setCreateTime(new Date());
        user.setUsername(username);
        user.setUserType(0);//普通用户

        user.setLoginType(form.getLoginType());
        if (user.getLoginType() == 0) {
            user.setPassword(DigestUtils.sha256Hex(form.getPassword()));
            userService.insert(user);
            //用户登录
            LoginForm loginForm = new LoginForm();
            loginForm.setMobile(user.getUsername());
            loginForm.setPassword(form.getPassword());
            Map<String, Object> map = userService.login(loginForm);
            return RWapper.ok().putMap(map).encode(isEncryption);
        } else {
            user.setOpenId(form.getOpenId());
            userService.insert(user);

            //用户登录
            Map<String, Object> map = userService.loginWithOpenId(user.getOpenId());
            return RWapper.ok().putMap(map).encode(isEncryption);
        }
    }

    @PostMapping("registerStep2BirthdaySex")
    @ApiOperation("注册第二步，生日和性别")
    public RWapper registerStep2BirthdaySex(@RequestBody RegisterForm form) {
        String username = form.getMobile();
        UserEntity user = userService.selectOne(
                new EntityWrapper<UserEntity>()
                        .where("username = {0}", username)
        );
        if (user == null) {
            return RWapper.error(ResultEnum.USER_NOT_EXIST).encode(isEncryption);
        }

        user.setUserBirthday(form.getBirthday());
        user.setUserSex(form.getSex());

        userService.updateById(user);
        return RWapper.ok().put("user", user).encode(isEncryption);
    }

    @PostMapping("registerStep3AvatarNickName")
    @ApiOperation("注册第三步，头像和昵称")
    public RWapper registerStep3AvatarNickName(@RequestBody RegisterForm form) {
        String username = form.getMobile();
        UserEntity user = userService.selectOne(
                new EntityWrapper<UserEntity>()
                        .where("username = {0}", username)
        );
        if (user == null) {
            return RWapper.error(ResultEnum.USER_NOT_EXIST).encode(isEncryption);
        }

        user.setUserAvatar(form.getAvatar());
        user.setNickName(form.getNick());

        userService.updateById(user);
        return RWapper.ok().put("user", user).encode(isEncryption);
    }

}
