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

package com.yymt.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.yymt.common.utils.MyDateUtils;
import com.yymt.dao.api.TokenDao;
import com.yymt.entity.api.TokenEntity;
import com.yymt.service.TokenService;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Date;
import java.util.UUID;


@Service("tokenService")
public class TokenServiceImpl extends ServiceImpl<TokenDao, TokenEntity> implements TokenService {
	/**
	 * 30天后过期
	 */
	private final static int EXPIRE = 30;




	@Override
	public TokenEntity queryByToken(String token) {
		return this.selectOne(new EntityWrapper<TokenEntity>().eq("token", token));
	}

	@Override
	public TokenEntity createToken(long userId) {
		//当前时间
		Date now = new Date();
		//过期时间
		String date = MyDateUtils.getOffsetDateByFormat(EXPIRE,com.yymt.common.utils.DateUtils.DATE_TIME_PATTERN);
		Date expireTime = null;
		try {
			expireTime = DateUtils.parseDate(date, com.yymt.common.utils.DateUtils.DATE_TIME_PATTERN);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		//生成token
		String token = generateToken();

		//保存或更新用户token
		TokenEntity tokenEntity = new TokenEntity();
		tokenEntity.setUserId(userId);
		tokenEntity.setToken(token);
		tokenEntity.setUpdateTime(now);
		tokenEntity.setExpireTime(expireTime);
		this.insertOrUpdate(tokenEntity);

		return tokenEntity;
	}

	@Override
	public void expireToken(long userId){
		Date now = new Date();

		TokenEntity tokenEntity = new TokenEntity();
		tokenEntity.setUserId(userId);
		tokenEntity.setUpdateTime(now);
		tokenEntity.setExpireTime(now);
		this.insertOrUpdate(tokenEntity);
	}

	private String generateToken(){
		return UUID.randomUUID().toString().replace("-", "");
	}
}
