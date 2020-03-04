package com.yymt.modules.controller.sport;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yymt.entity.sport.HallSportEntity;
import com.yymt.service.HallSportService;
import com.yymt.common.utils.PageUtils;
import com.yymt.common.utils.R;



/**
 * 场馆项目表
 *
 * @author cots
 * @date 2018-09-05 16:23:30
 */
@RestController
@RequestMapping("sport/hallsport")
public class HallSportController {
    @Autowired
    private HallSportService hallSportService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sport:hallsport:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = hallSportService.queryPage(params);
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sport:hallsport:info")
    public R info(@PathVariable("id") Integer id){
        HallSportEntity hallSport = hallSportService.selectById(id);
        return R.ok().put("hallSport", hallSport);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sport:hallsport:save")
    public R save(@RequestBody HallSportEntity hallSport){
		hallSportService.insert(hallSport);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sport:hallsport:update")
    public R update(@RequestBody HallSportEntity hallSport){
		hallSportService.updateById(hallSport);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sport:hallsport:delete")
    public R delete(@RequestBody Integer[] ids){
		hallSportService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

}
