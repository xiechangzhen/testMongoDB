/**
 * Copyright 2018 人人开源 http://www.renren.io
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.yymt.common.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import java.util.Date;

/**
 * 注册表单
 *
 * @author Mark sunlightcs@gmail.com
 * @since 3.1.0 2018-01-25
 */
@ApiModel(value = "注册表单")
public class RegisterForm {
    @ApiModelProperty(value = "手机号")
    @NotBlank(message = "手机号不能为空")
    private String mobile;

    @ApiModelProperty(value = "密码")
    @NotBlank(message = "密码不能为空")
    private String password;

    @ApiModelProperty(value = "昵称")
    @NotBlank(message = "昵称不能为空")
    private String nick;

    @ApiModelProperty(value = "验证码")
    @NotBlank(message = "验证码不能为空")
    private String code;

    @ApiModelProperty(value = "验证码类型")
    @NotBlank(message = "验证码类型不能为空")
    private String codeType;

    /**
     * 生日
     */
    @ApiModelProperty(value = "生日")
    private Date birthday;

    /**
     * 性别(0-女,1-男,其他未知)
     */
    @ApiModelProperty(value = "性别")
    private Integer sex;

    /**
     * 头像地址
     */
    @ApiModelProperty(value = "头像地址")
    private String avatar;

    /**
     * 登录类型（0-普通用户，1-微信用户，2-QQ用户，3-微博用户）
     */
    private Integer loginType;

    /**
     * openId或第三方登录帐号
     */
    private String openId;

    public String getCodeType() {
        return codeType;
    }

    public void setCodeType(String codeType) {
        this.codeType = codeType;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 生日
     */
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * 性别(0-女,1-男,其他未知)
     */
    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * 头像地址
     */
    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    /**
     * 登录类型（0-普通用户，1-微信用户，2-QQ用户，3-微博用户）
     */
    public Integer getLoginType() {
        return loginType;
    }

    public void setLoginType(Integer loginType) {
        this.loginType = loginType;
    }

    /**
     * openId或第三方登录帐号
     */
    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }
}
