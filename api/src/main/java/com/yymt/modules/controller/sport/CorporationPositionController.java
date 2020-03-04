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

import com.yymt.entity.sport.CorporationPositionEntity;
import com.yymt.service.CorporationPositionService;
import com.yymt.common.utils.PageUtils;
import com.yymt.common.utils.R;



/**
 * 社团职位表
 *
 * @author cots
 * @date 2018-09-05 16:23:30
 */
@RestController
@RequestMapping("sport/corporationposition")
public class CorporationPositionController {
    @Autowired
    private CorporationPositionService corporationPositionService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sport:corporationposition:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = corporationPositionService.queryPage(params);
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sport:corporationposition:info")
    public R info(@PathVariable("id") Integer id){
        CorporationPositionEntity corporationPosition = corporationPositionService.selectById(id);
        return R.ok().put("corporationPosition", corporationPosition);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sport:corporationposition:save")
    public R save(@RequestBody CorporationPositionEntity corporationPosition){
		corporationPositionService.insert(corporationPosition);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sport:corporationposition:update")
    public R update(@RequestBody CorporationPositionEntity corporationPosition){
		corporationPositionService.updateById(corporationPosition);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sport:corporationposition:delete")
    public R delete(@RequestBody Integer[] ids){
		corporationPositionService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

}
