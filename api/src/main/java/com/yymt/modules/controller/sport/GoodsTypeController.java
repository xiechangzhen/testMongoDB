package com.yymt.modules.controller.sport;

import java.util.Arrays;
import java.util.Map;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yymt.entity.sport.GoodsTypeEntity;
import com.yymt.service.GoodsTypeService;
import com.yymt.common.utils.PageUtils;
import com.yymt.common.utils.R;



/**
 * 商品分类表
 *
 * @author cots
 * @date 2018-12-13 08:52:56
 */
@RestController
@RequestMapping("sport/goodstype")
//@Api(tags = "商品分类表")
public class GoodsTypeController {
    @Autowired
    private GoodsTypeService goodsTypeService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@ApiOperation(value = "商品分类表列表",response = GoodsTypeEntity.class )
    @RequiresPermissions("sport:goodstype:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = goodsTypeService.queryPage(params);
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sport:goodstype:info")
    public R info(@PathVariable("id") Integer id){
        GoodsTypeEntity goodsType = goodsTypeService.selectById(id);
        return R.ok().put("goodsType", goodsType);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@ApiOperation(value = "商品分类表详情",response = GoodsTypeEntity.class )
    @RequiresPermissions("sport:goodstype:save")
    public R save(@RequestBody GoodsTypeEntity goodsType){
		goodsTypeService.insert(goodsType);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sport:goodstype:update")
    public R update(@RequestBody GoodsTypeEntity goodsType){
		goodsTypeService.updateById(goodsType);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sport:goodstype:delete")
    public R delete(@RequestBody Integer[] ids){
		goodsTypeService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

}
