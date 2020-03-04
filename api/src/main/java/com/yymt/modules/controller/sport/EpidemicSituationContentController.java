package com.yymt.modules.controller.sport;

import com.yymt.common.utils.PageUtils;
import com.yymt.common.utils.R;
import com.yymt.entity.sport.EpidemicSituationContentEntity;
import com.yymt.service.sport.EpidemicSituationContentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 疫情信息
 *
 * @author cots
 * @date 2020-01-28 19:34:48
 */
@RestController
@RequestMapping("epidemicsituationcontent")
@Api(tags = "疫情信息")
public class EpidemicSituationContentController {
    @Autowired
    private EpidemicSituationContentService epidemicSituationContentService;

    /**
     * 列表
     */
    @CrossOrigin
    @PostMapping("/list")
    @ApiOperation(value = "疫情信息列表",response = EpidemicSituationContentEntity.class )
    public R list(@RequestBody Map<String, Object> params){
        PageUtils page = epidemicSituationContentService.queryPage(params);
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @CrossOrigin
    @PostMapping("/info")
    @ApiOperation(value = "疫情信息详情")
    public R info(@RequestBody Map<String, Object> params){
        EpidemicSituationContentEntity epidemicSituationContent = epidemicSituationContentService.selectById(params.get("id").toString());
        return R.ok().put("epidemicSituationContent", epidemicSituationContent);
    }
}
