package com.yymt.modules.controller.sport;

import com.yymt.common.utils.PageUtils;
import com.yymt.common.utils.R;
import com.yymt.common.utils.RWapper;
import com.yymt.entity.sport.SportsEntity;
import com.yymt.service.SportsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;



/**
 * 运动项目
 *
 * @author cots
 * @date 2018-08-22 08:52:52
 */
@RestController
@RequestMapping("sport/sports")
//@Api(tags = "体育项目")
public class SportsController extends BaseController{
    @Autowired
    private SportsService sportsService;

    /**
     * 列表
     */
    @PostMapping("/list")
    //@ApiOperation(value = "体育项目列表",response = SportsEntity.class)
    public RWapper list(@RequestBody Map<String, Object> params){
        PageUtils page = sportsService.queryPage(params);
        return RWapper.ok().put("page", page).encode(isEncryption);
    }

    /**
     * 列表
     */
    @CrossOrigin
    @PostMapping("/listSports")
    //@ApiOperation(value = "体育项目列表",response = SportsEntity.class)
    public RWapper listSports(@RequestBody Map<String, Object> params){
        PageUtils page = sportsService.listSports(params);
        return RWapper.ok().put("page", page.getList()).encode(isEncryption);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sport:sports:info")
    public R info(@PathVariable("id") Integer id){
        SportsEntity sports = sportsService.selectById(id);
        return R.ok().put("sports", sports);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sport:sports:save")
    public R save(@RequestBody SportsEntity sports){
		sportsService.insert(sports);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sport:sports:update")
    public R update(@RequestBody SportsEntity sports){
		sportsService.updateById(sports);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sport:sports:delete")
    public R delete(@RequestBody Integer[] ids){
		sportsService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

}
