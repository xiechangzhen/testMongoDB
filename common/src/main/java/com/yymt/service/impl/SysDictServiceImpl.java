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
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.yymt.common.utils.PageUtils;
import com.yymt.common.utils.Query;
import com.yymt.dao.sys.SysDictDao;
import com.yymt.entity.sys.SysDictEntity;
import com.yymt.service.SysDictService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("sysDictService")
public class SysDictServiceImpl extends ServiceImpl<SysDictDao, SysDictEntity> implements SysDictService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String name = (String)params.get("name");

        Page<SysDictEntity> page = this.selectPage(
                new Query<SysDictEntity>(params).getPage(),
                new EntityWrapper<SysDictEntity>()
                    .like(StringUtils.isNotBlank(name),"name", name)
        );

        return new PageUtils(page);
    }

    /**
     * 基础数据：求助话题类型，擅长领域等
     * @param params
     * @return
     */
    public PageUtils queryBaseDataPage(Map<String, Object> params) {
        String value = null;
        if (params != null) {
            value = (String) params.get("value");
            if(params.get("sidx") == null || StringUtils.isEmpty(params.get("sidx").toString())){
                params.put("sidx","order_num");
            }
        }
        Page<SysDictEntity> page = this.selectPage(
                new Query<SysDictEntity>(params).getPage(),
                new EntityWrapper<SysDictEntity>()
                    .eq("type",params ==null?"":params.get("type"))
                    .like(StringUtils.isNotBlank(value),"`value`", value)
        );

        return new PageUtils(page);
    }
    /**
     * 擅长领域,不分页
     * @return
     */
    public List queryGoodAt() {
        List<SysDictEntity> list = this.selectList(new EntityWrapper<SysDictEntity>()
                    .eq("type","goodAt")
        );
        return list;
    }

}
