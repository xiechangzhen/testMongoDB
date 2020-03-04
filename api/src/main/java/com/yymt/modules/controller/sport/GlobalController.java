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

package com.yymt.modules.controller.sport;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.yymt.annotation.Login;
import com.yymt.common.utils.RWapper;
import com.yymt.entity.sys.SysDictEntity;
import com.yymt.service.ColumnService;
import com.yymt.service.SysDictService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 全局方法接口
 *
 * @author hgq
 * @date 2018-3-20 09:26:31
 */
@RestController
@RequestMapping("base")
@Api(tags="全局接口")
public class GlobalController extends BaseController{
    @Autowired
    private SysDictService sysDictService;
    @Autowired
    private ColumnService columnService;

    /**
     * 问题反馈标签列表
     */
    @Login
    @PostMapping("/getFeedbackTags")
    //@ApiOperation("获取问题反馈类型")
    public RWapper getFeedbackTags(){
        List<SysDictEntity> list = sysDictService.selectList(
                new EntityWrapper<SysDictEntity>().eq("type","feedbackType").orderBy("id",true)
        );
        return RWapper.ok().put("list", list).encode(isEncryption);
    }
    /**
     * 求助标签列表
     */
    @PostMapping("/getHelpTags")
    //@ApiOperation("获取求助标签")
    public RWapper getHelpTags(){
        List<SysDictEntity> list = sysDictService.selectList(
                new EntityWrapper<SysDictEntity>().eq("type","helpTag")
        );
        return RWapper.ok().put("list", list).encode(isEncryption);
    }

    /**
     * 擅长领域列表
     */
    @PostMapping("/getGoodAt")
    //@ApiOperation("获取擅长领域")
    public RWapper getGoodAt(){
        return RWapper.ok().put("list", sysDictService.queryGoodAt()).encode(isEncryption);
    }

    /**
     * 获取知识科普、心健康等的子栏目
     */
    @PostMapping("/getChildColumn/{parent}")
    @ApiOperation("获取子栏目")
    public RWapper getChildColumn(@ApiParam(value="父栏目标记，取值：knowledge;health;relax") @PathVariable("parent") String parent){
        return RWapper.ok().put("list", columnService.getChildColumnByParentValue(parent)).encode(isEncryption);
    }
}
