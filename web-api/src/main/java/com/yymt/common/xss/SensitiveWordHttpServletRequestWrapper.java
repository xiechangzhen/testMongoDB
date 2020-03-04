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

package com.yymt.common.xss;

import com.yymt.common.utils.SensitiveWordUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * XSS过滤处理
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-04-01 11:29
 */
public class SensitiveWordHttpServletRequestWrapper extends HttpServletRequestWrapper {
    //没被包装过的HttpServletRequest（特殊场景，需要自己过滤）
    HttpServletRequest orgRequest;

    private boolean isPass = true;

    public SensitiveWordHttpServletRequestWrapper(HttpServletRequest request) {
        super(request);
        orgRequest = request;
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
        //为空，直接返回
        String json = IOUtils.toString(super.getInputStream(), "utf-8");
        if (StringUtils.isBlank(json)) {
            return super.getInputStream();
        }
        //敏感词过滤
//        isPass = isWordValidate(json);
//        if(!isPass){
//            throw new RRException(ResultEnum.SENSITIVE_WORD);
//        }
        json = replaceWord(json);
        final ByteArrayInputStream bis = new ByteArrayInputStream(json.getBytes("utf-8"));
        return new ServletInputStream() {
            @Override
            public boolean isFinished() {
                return true;
            }

            @Override
            public boolean isReady() {
                return true;
            }

            @Override
            public void setReadListener(ReadListener readListener) {
            }

            @Override
            public int read() throws IOException {
                return bis.read();
            }
        };
    }

    @Override
    public String getParameter(String name) {
        String value = super.getParameter(name);
        if (StringUtils.isNotBlank(value)) {
            //敏感词过滤
//            isPass = isWordValidate(value);
//            if(!isPass){
//                throw new RRException(ResultEnum.SENSITIVE_WORD);
//            }
            value = replaceWord(value);
        }
        return value;
    }

    @Override
    public String[] getParameterValues(String name) {
        String[] parameters = super.getParameterValues(name);
        if (parameters == null || parameters.length == 0) {
            return null;
        }

        for (int i = 0; i < parameters.length; i++) {
            //敏感词过滤
//            isPass = isWordValidate(parameters[i]);
//            if(!isPass){
//                throw new RRException(ResultEnum.SENSITIVE_WORD);
//            }
            parameters[i] = replaceWord(parameters[i]);
        }
        return parameters;
    }

    @Override
    public Map<String,String[]> getParameterMap() {
        Map<String,String[]> map = new LinkedHashMap<>();
        Map<String,String[]> parameters = super.getParameterMap();
        for (String key : parameters.keySet()) {
            String[] values = parameters.get(key);
            for (int i = 0; i < values.length; i++) {
//                isPass = isWordValidate(values[i]);
//                if(!isPass){
//                    throw new RRException(ResultEnum.SENSITIVE_WORD);
//                }
                values[i] = replaceWord(values[i]);
            }
            map.put(key, values);
        }
        return map;
    }

    @Override
    public String getHeader(String name) {
        String value = super.getHeader(name);
        if (StringUtils.isNotBlank(value)) {
            //敏感词过滤
//            isPass = isWordValidate(value);
//            if(!isPass){
//                throw new RRException(ResultEnum.SENSITIVE_WORD);
//            }
            value = replaceWord(value);
        }
        return value;
    }

    private String replaceWord(String input){
        return SensitiveWordUtils.replaceWord(input);
    }

    private boolean isWordValidate(String input) {
        return SensitiveWordUtils.isWordValidate(input);
    }

    /**
     * 获取最原始的request
     */
    public HttpServletRequest getOrgRequest() {
        return orgRequest;
    }

    /**
     * 获取最原始的request
     */
    public static HttpServletRequest getOrgRequest(HttpServletRequest request) {
        if (request instanceof SensitiveWordHttpServletRequestWrapper) {
            return ((SensitiveWordHttpServletRequestWrapper) request).getOrgRequest();
        }
        return request;
    }

}
