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

package com.yymt.common.exception;

/**
 * 自定义异常
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年10月27日 下午10:11:27
 */
public class RRException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	private Integer code;
	private String message;

	public RRException(ResultEnum resultEnum) {
		super(resultEnum.getMsg());
		this.message = resultEnum.getMsg();
		this.code = resultEnum.getCode();
	}
	public RRException(ResultEnum resultEnum,String extra) {
		super(resultEnum.getMsg()+";"+extra);
		this.message = resultEnum.getMsg()+";"+extra;
		this.code = resultEnum.getCode();
	}

	public RRException(ResultEnum resultEnum, Throwable e) {
		super(resultEnum.getMsg(), e);
		this.message = resultEnum.getMsg();
		this.code = resultEnum.getCode();
	}

	//	@Override
	public String getMsg() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

}
