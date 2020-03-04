package com.yymt.modules.controller.sport;

import java.util.Arrays;
import java.util.Map;

import com.yymt.common.utils.RWapper;
import com.yymt.entity.sport.SportsmanEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.yymt.entity.sport.SportsmanLevelEntity;
import com.yymt.service.SportsmanLevelService;
import com.yymt.common.utils.PageUtils;
import com.yymt.common.utils.R;



/**
 * 运动员等级
 *
 * @author cots
 * @date 2018-09-05 16:23:30
 */
@RestController
@RequestMapping("sport/sportsmanlevel")
//@Api(tags = "运动员、裁判员、教练员、社会指导员等级")
public class SportsmanLevelController extends  BaseController{
    @Autowired
    private SportsmanLevelService sportsmanLevelService;

    /**
     * 列表
     */
    @PostMapping("/list")
    //@ApiOperation(value = "运动员、裁判员、教练员、社会指导员等级列表等级类型(0-运动员,1-教练员,2-裁判员,3-社会指导员)",response = SportsmanEntity.class)
    public RWapper list(@RequestBody Map<String, Object> params){
        PageUtils page = sportsmanLevelService.queryPage(params);
        return RWapper.ok().put("page", page).encode(isEncryption);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sport:sportsmanlevel:info")
    public R info(@PathVariable("id") Integer id){
        SportsmanLevelEntity sportsmanLevel = sportsmanLevelService.selectById(id);
        return R.ok().put("sportsmanLevel", sportsmanLevel);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sport:sportsmanlevel:save")
    public R save(@RequestBody SportsmanLevelEntity sportsmanLevel){
		sportsmanLevelService.insert(sportsmanLevel);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sport:sportsmanlevel:update")
    public R update(@RequestBody SportsmanLevelEntity sportsmanLevel){
		sportsmanLevelService.updateById(sportsmanLevel);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sport:sportsmanlevel:delete")
    public R delete(@RequestBody Integer[] ids){
		sportsmanLevelService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

}
