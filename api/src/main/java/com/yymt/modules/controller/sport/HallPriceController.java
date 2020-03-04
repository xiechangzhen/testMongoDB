package com.yymt.modules.controller.sport;

import java.util.Arrays;
import java.util.Map;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.yymt.entity.sport.HallPriceEntity;
import com.yymt.service.HallPriceService;
import com.yymt.common.utils.PageUtils;
import com.yymt.common.utils.R;



/**
 * 场馆项目报价表
 *
 * @author cots
 * @date 2018-09-05 16:23:30
 */
@RestController
@RequestMapping("sport/hallprice")
//@Api(tags = "场馆项目价格")
public class HallPriceController {
    @Autowired
    private HallPriceService hallPriceService;

    /**
     * 列表
     */
    @PostMapping("/list")
    //@ApiOperation("场馆项目价格清单")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = hallPriceService.queryPage(params);
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sport:hallprice:info")
    public R info(@PathVariable("id") Integer id){
        HallPriceEntity hallPrice = hallPriceService.selectById(id);
        return R.ok().put("hallPrice", hallPrice);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sport:hallprice:save")
    public R save(@RequestBody HallPriceEntity hallPrice){
		hallPriceService.insert(hallPrice);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sport:hallprice:update")
    public R update(@RequestBody HallPriceEntity hallPrice){
		hallPriceService.updateById(hallPrice);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sport:hallprice:delete")
    public R delete(@RequestBody Integer[] ids){
		hallPriceService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

}
