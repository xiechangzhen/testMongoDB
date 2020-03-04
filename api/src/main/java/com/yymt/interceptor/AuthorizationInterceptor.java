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

package com.yymt.interceptor;

import com.yymt.annotation.Login;
import com.yymt.common.exception.RRException;
import com.yymt.common.exception.ResultEnum;
import com.yymt.common.utils.Constant;
import com.yymt.entity.api.TokenEntity;
import com.yymt.entity.api.UserEntity;
import com.yymt.service.TokenService;
import com.yymt.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 权限(Token)验证
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-03-23 15:38
 */
@Component
public class AuthorizationInterceptor extends HandlerInterceptorAdapter {
	@Autowired
	private TokenService tokenService;

	@Autowired
	private UserService userService;

	public static final String USER_KEY = "userId";

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// //解决跨域
//		System.out.println(request.getRequestURL());
//		if ("OPTIONS".equals(request.getMethod())) {
//			return true;
//		}
		Login annotation;
		if (handler instanceof HandlerMethod) {
			annotation = ((HandlerMethod) handler).getMethodAnnotation(Login.class);
		} else {
			return true;
		}

		if (annotation == null) {
			return true;
		}

		// 从header中获取token
		String token = request.getHeader("token");
		// 如果header中不存在token，则从参数中获取token
		if (StringUtils.isBlank(token)) {
			token = request.getParameter("token");
		}

		// token为空
		if (StringUtils.isBlank(token)) {
			response.setHeader("Access-Control-Allow-Origin", request.getHeader("origin")); //解决跨域访问报错.
			throw new RRException(ResultEnum.AUTH_TOKEN_NULL);
		}

		// 查询token信息
		TokenEntity tokenEntity = tokenService.queryByToken(token);

		if (tokenEntity == null || tokenEntity.getExpireTime().getTime() < System.currentTimeMillis()) {
			response.setHeader("Access-Control-Allow-Origin", request.getHeader("origin")); //解决跨域访问报错
			throw new RRException(ResultEnum.AUTH_TOKEN_INVALID);
		}

		UserEntity userEntity = userService.selectById(tokenEntity.getUserId());

		// 检测用户帐号状态
		if (userEntity == null) {
			response.setHeader("Access-Control-Allow-Origin", request.getHeader("origin")); //解决跨域访问报错
			throw new RRException(ResultEnum.USER_NOT_EXIST);
		}
		if (userEntity.getUserStatus() == Constant.USER_STATUS_DISABLED
				|| userEntity.getUserStatus() == Constant.USER_STATUS_DELETE) {
			response.setHeader("Access-Control-Allow-Origin", request.getHeader("origin")); //解决跨域访问报错.
			throw new RRException(ResultEnum.USER_FORBID);
		}

		// 设置userId到request里，后续根据userId，获取用户信息
		request.setAttribute(USER_KEY, tokenEntity.getUserId());

		return true;
	}
}
