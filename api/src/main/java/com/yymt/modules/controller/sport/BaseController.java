package com.yymt.modules.controller.sport;

import static com.yymt.common.utils.Constant.USER_STATUS_DELETE;
import static com.yymt.common.utils.Constant.USER_STATUS_DISABLED;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.yymt.common.exception.RRException;
import com.yymt.common.exception.ResultEnum;
import com.yymt.common.utils.Constant;
import com.yymt.common.utils.ConvertUtil;
import com.yymt.common.utils.R;
import com.yymt.common.utils.wechat.WeChatUtil;
import com.yymt.entity.api.TokenEntity;
import com.yymt.entity.api.UserEntity;
import com.yymt.service.TokenService;
import com.yymt.service.UserService;

import net.sf.json.JSONObject;

/**
 * 公共方法 Created by 12018年3月19日
 */
public abstract class BaseController {

	@Autowired
	private TokenService tokenService;
	@Autowired
	private UserService userService;

	private static final Logger LOGGER = LoggerFactory.getLogger(BaseController.class);

	@Value("${data.encryption}")
	public boolean isEncryption;

	/**
	 * 获取请求头中的token
	 * 
	 * @return
	 */
	protected TokenEntity getToken() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		String token = request.getHeader("token");
		TokenEntity tokenEntity = tokenService.queryByToken(token);
		if (tokenEntity == null) {
			throw new RRException(ResultEnum.AUTH_TOKEN_NULL);
		}
		return tokenEntity;
	}

	/**
	 * 根据token获取用户ID
	 * 
	 * @return
	 */
	protected Long getUserIdByToken() {
		return getToken().getUserId();
	}

	/**
	 * 根据token获取用户ID，不校验是否登录
	 * 
	 * @return
	 */
	protected Long getUserIdByTokenWithoutValidate() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		String token = request.getHeader("token");
		TokenEntity tokenEntity = tokenService.queryByToken(token);
		if (tokenEntity != null) {
			return tokenEntity.getUserId();
		}
		return null;
	}

	/**
	 * 根据token获取用户信息
	 * 
	 * @return
	 */
	protected UserEntity getUserInfoByToken() {
		UserEntity userEntity = userService.selectById(getToken().getUserId());
		if (userEntity == null) {
			throw new RRException(ResultEnum.USER_NOT_EXIST);
		}
		if (userEntity.getUserStatus().equals(USER_STATUS_DELETE)) {
			throw new RRException(ResultEnum.USER_DELETED);
		} else if (userEntity.getUserStatus().equals(USER_STATUS_DISABLED)) {
			throw new RRException(ResultEnum.USER_FORBID);
		}
		return userEntity;
	}

	/**
	 * 获取服务器头部URL
	 * 
	 * @return
	 */
	protected String getTopUrl() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		return request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/"
				+ request.getContextPath();
	}

	/**
	 * @describe：微信公众号授权新增或修改用户信息
	 */
	public R saveOrUpdateUserInfo(String code) {
		synchronized (Constant.USER_LOCK) {
			JSONObject jsonObject = WeChatUtil.getUserOpenId(code);
			String errcode = ConvertUtil.objToStrConverNull(jsonObject.get("errcode"));
			String errmsg = "";
			if (errcode == null) {
				String openId = ConvertUtil.objToStrConverNull(jsonObject.get("openid"));
				JSONObject userJsonObject = WeChatUtil.getUserInfo(openId);
				errcode = ConvertUtil.objToStrConverNull(userJsonObject.get("errcode"));
				if (errcode == null && openId != null) {
					String nickName = ConvertUtil.objToStrConverNull(userJsonObject.get("nickname"));
					int sex = ConvertUtil.parseInt(userJsonObject.get("sex"));
					String language = ConvertUtil.objToStrConverNull(userJsonObject.get("language"));
					String city = ConvertUtil.objToStrConverNull(userJsonObject.get("city"));
					String province = ConvertUtil.objToStrConverNull(userJsonObject.get("province"));
					String country = ConvertUtil.objToStrConverNull(userJsonObject.get("country"));
					String headimgurl = ConvertUtil.objToStrConverNull(userJsonObject.get("headimgurl"));
					Date date = new Date();
					UserEntity wechatUserEntity = new UserEntity();
					wechatUserEntity.setOpenId(openId);
					wechatUserEntity.setNickName(nickName);
					wechatUserEntity.setUsername(nickName);
					wechatUserEntity.setUserSex(sex);
					wechatUserEntity.setUserAvatar(headimgurl);
					Map<String, Object> userMap = userService.queryCountByOpenId(openId);
					int count = Integer.parseInt(String.valueOf(userMap.get("count")));
					if (count == 0) {
						wechatUserEntity.setModifyTime(date);
						wechatUserEntity.setCreateTime(date);
						userService.insert(wechatUserEntity);
					} else {
						long userId = Long.parseLong(String.valueOf(userMap.get("user_id")));
						wechatUserEntity.setUserId(userId);
						wechatUserEntity.setModifyTime(date);
						userService.updateById(wechatUserEntity);
					}
					TokenEntity tokenEntity = tokenService.createToken(wechatUserEntity.getUserId());
					return R.ok().put("userInfo", wechatUserEntity).put("data", tokenEntity);
				} else {
					errmsg = String.valueOf(userJsonObject.get("errmsg"));
					return R.error("授权获取用户信息失败：" + errmsg);
				}
			} else {
				errmsg = String.valueOf(jsonObject.get("errmsg"));
				return R.error("授权获取用户信息失败：" + errmsg);
			}
		}
	}

	/**
	 * @describe：微信公众号授权新增或修改用户信息
	 */
	public R saveOrUpdateUserInfo2(String code) {
		synchronized (Constant.USER_LOCK) {
			Map<String, Object> map = WeChatUtil.getSnsapiUserInfo(code);
			int errcode = ConvertUtil.parseInt(map.get("errcode"));
			if (errcode == 0) {
				JSONObject userJsonObject = JSONObject.fromObject(map.get("userInfo"));
				String nickName = ConvertUtil.objToStrConverNull(userJsonObject.get("nickname"));
				int sex = ConvertUtil.parseInt(userJsonObject.get("sex"));
				String language = ConvertUtil.objToStrConverNull(userJsonObject.get("language"));
				String city = ConvertUtil.objToStrConverNull(userJsonObject.get("city"));
				String province = ConvertUtil.objToStrConverNull(userJsonObject.get("province"));
				String country = ConvertUtil.objToStrConverNull(userJsonObject.get("country"));
				String headimgurl = ConvertUtil.objToStrConverNull(userJsonObject.get("headimgurl"));
				String openId = ConvertUtil.objToStrConverNull(userJsonObject.get("openid"));
				Date date = new Date();
				UserEntity wechatUserEntity = new UserEntity();
				wechatUserEntity.setOpenId(openId);
				wechatUserEntity.setNickName(nickName);
				wechatUserEntity.setUsername(nickName);
				wechatUserEntity.setUserSex(sex);
				wechatUserEntity.setUserAvatar(headimgurl);
				Map<String, Object> userMap = userService.queryCountByOpenId(openId);
				int count = Integer.parseInt(String.valueOf(userMap.get("count")));
				if (count == 0) {
					wechatUserEntity.setModifyTime(date);
					wechatUserEntity.setCreateTime(date);
					userService.insert(wechatUserEntity);
				} else {
					long userId = Long.parseLong(String.valueOf(userMap.get("user_id")));
					wechatUserEntity.setUserId(userId);
					wechatUserEntity.setModifyTime(date);
					userService.updateById(wechatUserEntity);
				}
				TokenEntity tokenEntity = tokenService.createToken(wechatUserEntity.getUserId());
				return R.ok().put("userInfo", wechatUserEntity).put("data", tokenEntity);
			} else {
				String errmsg = String.valueOf(map.get("errmsg"));
				return R.error("授权获取用户信息失败：" + errmsg);
			}
		}
	}

}
