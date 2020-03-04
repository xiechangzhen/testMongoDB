package com.yymt.entity.api;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;

/**
 * 用户
 *
 * @author hgq
 * @date 2018-03-30 11:49:26
 */
@TableName("tb_user")
public class UserEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    @TableId
    private Long userId;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    @JsonIgnore
    private String password;
    /**
     * 用户状态（0删除，1正常，2待审核，3审核通过，4审核不通过，5禁用）
     */
    private Integer userStatus;
    /**
     * 昵称
     */
    private String nickName;
    /**
     * 真实姓名
     */
    @NotBlank(message = "真实姓名不能为空")
    private String realName;

    /**
     * 头像
     */
    private String userAvatar;
    /**
     * 用户类型(0-普通用户,1-社团管理员)
     */
    private Integer userType;
    /**
     * 性别(0-女,1-男,其他未知)
     */
    private Integer userSex;
    /**
     * 身份证号
     */
    @NotBlank(message = "身份证号不能为空")
    @Pattern(regexp = "^[1-9]\\d{7}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}$|^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}([0-9]|X|x)$",
            message = "身份证号格式不正确"            
    )
    private String userIdNum;
    /**
     * 出生日期
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    @TableField
    private Date userBirthday;
    /**
     * 个性签名
     */
    private String userSignature;
    /**
     * 身份证正面照
     */
    @NotBlank(message = "身份证正面照不能为空")
    private String idFrontImage;
    /**
     * 身份证背面照
     */
    @NotBlank(message = "身份证背面照不能为空")
    private String idBackImage;
    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date modifyTime;

    /**
     * 推送客户端ID
     */
    private String pushClientId;

    /**
     * 登录类型（0-普通用户，1-微信用户，2-QQ用户，3-微博用户）
     */
    private Integer loginType;

    /**
     * openId或第三方登录帐号
     */
    private String openId;

    /**
     * 融云用户token
     */
    private String rcToken;

    /**
     * 备注
     */
    private String remark;

    private String contact;
    private Integer isHbJourney;
    private String gps;

    private String detailAddress;

    private String address;

    public String getDetailAddress() {
        return detailAddress;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Integer getIsHbJourney() {
        return isHbJourney;
    }

    public void setIsHbJourney(Integer isHbJourney) {
        this.isHbJourney = isHbJourney;
    }

    public String getGps() {
        return gps;
    }

    public void setGps(String gps) {
        this.gps = gps;
    }

    public String getRcToken() {
        return rcToken;
    }

    public void setRcToken(String rcToken) {
        this.rcToken = rcToken;
    }


    /**
     * 获取推送客户端ID
     *
     * @return
     */
    public String getPushClientId() {
        return pushClientId;
    }

    /**
     * 设置推送客户端ID
     */
    public void setPushClientId(String pushClientId) {
        this.pushClientId = pushClientId;
    }

    /**
     * 设置：用户ID
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取：用户ID
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置：用户名
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取：用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置：密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取：密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置：用户状态（0删除，1正常，2待审核，3审核通过，4审核不通过，5禁用）
     */
    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    /**
     * 获取：用户状态（0删除，1正常，2待审核，3审核通过，4审核不通过，5禁用）
     */
    public Integer getUserStatus() {
        return userStatus;
    }

    /**
     * 设置：昵称
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    /**
     * 获取：昵称
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * 设置：真实姓名
     */
    public void setRealName(String realName) {
        this.realName = realName;
    }

    /**
     * 获取：真实姓名
     */
    public String getRealName() {
        return realName;
    }

    /**
     * 设置：头像
     */
    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
    }

    /**
     * 获取：头像
     */
    public String getUserAvatar() {
        return userAvatar;
    }

    /**
     * 设置：用户类型(0-普通用户,1-社团管理员)
     */
    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    /**
     * 获取：用户类型(0-普通用户,1-社团管理员)
     */
    public Integer getUserType() {
        return userType;
    }

    /**
     * 设置：性别(0-女,1-男,其他未知)
     */
    public void setUserSex(Integer userSex) {
        this.userSex = userSex;
    }

    /**
     * 获取：性别(0-女,1-男,其他未知)
     */
    public Integer getUserSex() {
        return userSex;
    }

    /**
     * 设置：身份证号
     */
    public void setUserIdNum(String userIdNum) {
        this.userIdNum = userIdNum;
    }

    /**
     * 获取：身份证号
     */
    public String getUserIdNum() {
        return userIdNum;
    }

    /**
     * 设置：出生日期
     */
    public void setUserBirthday(Date userBirthday) {
        this.userBirthday = userBirthday;
    }

    /**
     * 获取：出生日期
     */
    public Date getUserBirthday() {
        return userBirthday;
    }

    /**
     * 设置：个性签名
     */
    public void setUserSignature(String userSignature) {
        this.userSignature = userSignature;
    }

    /**
     * 获取：个性签名
     */
    public String getUserSignature() {
        return userSignature;
    }

    /**
     * 设置：身份证正面照
     */
    public void setIdFrontImage(String idFrontImage) {
        this.idFrontImage = idFrontImage;
    }

    /**
     * 获取：身份证正面照
     */
    public String getIdFrontImage() {
        return idFrontImage;
    }

    /**
     * 设置：身份证背面照
     */
    public void setIdBackImage(String idBackImage) {
        this.idBackImage = idBackImage;
    }

    /**
     * 获取：身份证背面照
     */
    public String getIdBackImage() {
        return idBackImage;
    }

    /**
     * 设置：创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取：创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }


    /**
     * 获取：修改时间
     *
     * @return
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 设置：修改时间
     *
     * @param modifyTime
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
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

    /**
     * 获取：备注
     *
     * @return
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置：备注
     *
     * @param remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

}
