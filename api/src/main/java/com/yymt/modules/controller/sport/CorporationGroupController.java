package com.yymt.modules.controller.sport;

import java.util.Arrays;
import java.util.Map;

import com.yymt.common.utils.RWapper;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yymt.entity.sport.CorporationGroupEntity;
import com.yymt.service.CorporationGroupService;
import com.yymt.common.utils.PageUtils;
import com.yymt.common.utils.R;



/**
 * 社团团体会员关系表
 *
 * @author cots
 * @date 2018-09-05 16:23:30
 */
@RestController
@RequestMapping("sport/corporationgroup")
public class CorporationGroupController extends BaseController{
    @Autowired
    private CorporationGroupService corporationGroupService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public RWapper list(@RequestParam Map<String, Object> params){
        PageUtils page = corporationGroupService.queryPage(params);
        return RWapper.ok().put("page", page).encode(isEncryption);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sport:corporationgroup:info")
    public RWapper info(@PathVariable("id") Integer id){
        CorporationGroupEntity corporationGroup = corporationGroupService.selectById(id);
        return RWapper.ok().put("corporationGroup", corporationGroup).encode(isEncryption);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sport:corporationgroup:save")
    public R save(@RequestBody CorporationGroupEntity corporationGroup){
		corporationGroupService.insert(corporationGroup);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sport:corporationgroup:update")
    public R update(@RequestBody CorporationGroupEntity corporationGroup){
		corporationGroupService.updateById(corporationGroup);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sport:corporationgroup:delete")
    public R delete(@RequestBody Integer[] ids){
		corporationGroupService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

}
