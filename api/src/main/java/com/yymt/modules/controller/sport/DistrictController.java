package com.yymt.modules.controller.sport;

import com.yymt.common.utils.PageUtils;
import com.yymt.common.utils.R;
import com.yymt.common.utils.RWapper;
import com.yymt.entity.sport.DistrictEntity;
import com.yymt.service.DistrictService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;



/**
 * 中国县以上行政区及行政区代码
 *
 * @author cots
 * @date 2018-09-07 10:00:52
 */
@RestController
@RequestMapping("sport/district")
@Api(tags = "行政区划")
public class DistrictController extends BaseController{
    @Autowired
    private DistrictService districtService;

    /**
     * 列表
     * 更新：根据体育局提供的行政区域和排序返回相关数据 2018年11月28日
     */
    @PostMapping("/list")
    @ApiOperation("行政区划列表")
    public RWapper list(@ApiParam("{\"areaCode\":\"整型(如果只是赣州，传固定360700)\"}") @RequestBody Map<String, Object> params){
        PageUtils page = districtService.queryDistrictByDict(params);
        return RWapper.ok().put("page", page).encode(isEncryption);
    }

    /**
     * 列表
     */
    @CrossOrigin
    @PostMapping("/listDistrict")
    @ApiOperation("行政区划列表")
    public RWapper listDistrict(@ApiParam("{\"areaCode\":\"整型(如果只是赣州，传固定360700)\"}") @RequestBody Map<String, Object> params){
        List page = districtService.listDistrict(params);
        return RWapper.ok().put("page", page).encode(isEncryption);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{code}")
    @RequiresPermissions("sport:district:info")
    public R info(@PathVariable("code") Integer code){
        DistrictEntity district = districtService.selectById(code);
        return R.ok().put("district", district);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sport:district:save")
    public R save(@RequestBody DistrictEntity district){
		districtService.insert(district);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sport:district:update")
    public R update(@RequestBody DistrictEntity district){
		districtService.updateById(district);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sport:district:delete")
    public R delete(@RequestBody Integer[] codes){
		districtService.deleteBatchIds(Arrays.asList(codes));
        return R.ok();
    }

}
