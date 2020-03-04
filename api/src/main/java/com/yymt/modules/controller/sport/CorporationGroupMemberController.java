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

import com.yymt.entity.sport.CorporationGroupMemberEntity;
import com.yymt.service.CorporationGroupMemberService;
import com.yymt.common.utils.PageUtils;
import com.yymt.common.utils.R;



/**
 * 团体会员信息表
 *
 * @author cots
 * @date 2018-09-05 16:23:30
 */
@RestController
@RequestMapping("sport/corporationgroupmember")
public class CorporationGroupMemberController {
    @Autowired
    private CorporationGroupMemberService corporationGroupMemberService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sport:corporationgroupmember:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = corporationGroupMemberService.queryPage(params);
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sport:corporationgroupmember:info")
    public R info(@PathVariable("id") Integer id){
        CorporationGroupMemberEntity corporationGroupMember = corporationGroupMemberService.selectById(id);
        return R.ok().put("corporationGroupMember", corporationGroupMember);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sport:corporationgroupmember:save")
    public R save(@RequestBody CorporationGroupMemberEntity corporationGroupMember){
		corporationGroupMemberService.insert(corporationGroupMember);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sport:corporationgroupmember:update")
    public R update(@RequestBody CorporationGroupMemberEntity corporationGroupMember){
		corporationGroupMemberService.updateById(corporationGroupMember);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sport:corporationgroupmember:delete")
    public R delete(@RequestBody Integer[] ids){
		corporationGroupMemberService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

}
