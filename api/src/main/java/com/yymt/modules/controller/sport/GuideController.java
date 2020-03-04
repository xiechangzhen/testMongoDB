package com.yymt.modules.controller.sport;

import java.util.Arrays;
import java.util.Map;

import com.yymt.common.utils.RWapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.yymt.entity.sport.GuideEntity;
import com.yymt.service.GuideService;
import com.yymt.common.utils.PageUtils;
import com.yymt.common.utils.R;



/**
 * 指南
 *
 * @author cots
 * @date 2018-09-13 20:54:42
 */
@RestController
@RequestMapping("sport/guide")
//@Api(tags = "指南")
public class GuideController extends BaseController{
    @Autowired
    private GuideService guideService;

    /**
     * 列表
     */
    @PostMapping("/list")
    //@ApiOperation(value = "指南列表",response = GuideEntity.class )
    public RWapper list(@ApiParam("{\"keyword\":\"搜索字符串\"}") @RequestBody Map<String, Object> params){
        PageUtils page = guideService.queryPage(params);
        return RWapper.ok().put("page", page).encode(isEncryption);
    }


    /**
     * 信息
     */
    @PostMapping("/info/{id}")
    //@ApiOperation(value = "详情")
    public RWapper info(@PathVariable("id") Integer id){
        GuideEntity guide = guideService.selectById(id);
        if(guide == null){
            return RWapper.error("指南不存在").encode(isEncryption);
        }
        return RWapper.ok().put("guide", guide).encode(isEncryption);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody GuideEntity guide){
		guideService.insert(guide);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sport:guide:update")
    public R update(@RequestBody GuideEntity guide){
		guideService.updateById(guide);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sport:guide:delete")
    public R delete(@RequestBody Integer[] ids){
		guideService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

}
