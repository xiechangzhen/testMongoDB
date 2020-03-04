package com.yymt.modules.controller.sport;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import com.yymt.annotation.Login;
import com.yymt.service.sport.TemperatureService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.yymt.entity.sport.TemperatureEntity;
import com.yymt.common.utils.PageUtils;
import com.yymt.common.utils.R;



/**
 * 体温上报
 *
 * @author cots
 * @date 2020-02-06 10:05:06
 */
@RestController
@RequestMapping("temperature")
@Api(tags = "体温上报")
public class TemperatureController extends BaseController{
    @Autowired
    private TemperatureService temperatureService;

    /**
     * 列表
     */
    @CrossOrigin
    @PostMapping("/list")
    @Login
    @ApiOperation(value = "体温上报列表",response = TemperatureEntity.class )
    public R list(@ApiParam(value = "{\"queryDate\":\"2019-05-05\"}")@RequestBody Map<String, Object> params){
        params.put("userId",getUserIdByToken());
        PageUtils page = temperatureService.queryListByDate(params);
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @CrossOrigin
    @PostMapping("/info/{id}")
    @Login
    public R info(@PathVariable("id") Integer id){
        TemperatureEntity temperature = temperatureService.selectById(id);
        return R.ok().put("temperature", temperature);
    }

    /**
     * 保存
     */
    @CrossOrigin
    @PostMapping("/save")
    @ApiOperation(value = "体温上报详情",response = TemperatureEntity.class )
//    @Login
    public R save(@RequestBody TemperatureEntity temperature){
        temperature.setUserid(getUserIdByTokenWithoutValidate());
        temperature.setCreatetime(new Date());
		temperatureService.insert(temperature);
        return R.ok();
    }

    /**
     * 修改
     */
    @CrossOrigin
    @PostMapping("/update")
    @Login
    public R update(@RequestBody TemperatureEntity temperature){
		temperatureService.updateById(temperature);
        return R.ok();
    }

    /**
     * 删除
     */
    @CrossOrigin
    @PostMapping("/delete")
    @Login
    @ApiOperation(value = "体温修改")
    public R delete(@RequestBody Integer[] ids){
		temperatureService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

}
