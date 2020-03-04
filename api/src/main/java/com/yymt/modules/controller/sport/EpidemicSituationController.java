package com.yymt.modules.controller.sport;

import com.yymt.annotation.Login;
import com.yymt.common.utils.PageUtils;
import com.yymt.common.utils.R;
import com.yymt.entity.sport.EpidemicSituationEntity;
import com.yymt.service.sport.EpidemicSituationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;


/**
 * 疫情上报信息表
 *
 * @author cots
 * @date 2020-01-28 17:28:09
 */
@RestController
@RequestMapping("epidemicsituation")
@Api(tags = "疫情上报信息表")
public class EpidemicSituationController extends BaseController{
    @Autowired
    private EpidemicSituationService epidemicSituationService;

    /**
     * 列表
     */
    @Login
    @CrossOrigin
    @PostMapping("/list")
    @ApiOperation(value = "疫情上报信息表列表",response = EpidemicSituationEntity.class )
    public R list(@RequestParam Map<String, Object> params){
        Long userId = getUserIdByToken();
        params.put("userId",userId);
        PageUtils page = epidemicSituationService.queryPage(params);
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @Login
    @CrossOrigin
    @PostMapping("/info/{id}")
    @ApiOperation("疫情上报信息表详情")
    public R info(@PathVariable("id") Integer id){
        EpidemicSituationEntity epidemicSituation = epidemicSituationService.selectById(id);
        return R.ok().put("epidemicSituation", epidemicSituation);
    }

    /**
     * 保存
     */
    @Login
    @CrossOrigin
    @PostMapping("/save")
    @ApiOperation(value = "疫情上报信息表详情",response = EpidemicSituationEntity.class )
    public R save(@RequestBody EpidemicSituationEntity epidemicSituation){
        epidemicSituation.setUserid(getUserIdByTokenWithoutValidate());
        epidemicSituation.setCreatetime(new Date());
		epidemicSituationService.insert(epidemicSituation);
        return R.ok();
    }

    /**
     * 修改
     */
    @Login
    @CrossOrigin
    @PostMapping("/update")
    public R update(@RequestBody EpidemicSituationEntity epidemicSituation){
		epidemicSituationService.updateById(epidemicSituation);
        return R.ok();
    }

    /**
     * 删除
     */
    @Login
    @CrossOrigin
    @PostMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
		epidemicSituationService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

}
