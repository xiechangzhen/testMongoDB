package com.yymt.modules.controller.sport;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.yymt.common.utils.RWapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.yymt.entity.sport.OrganizationEntity;
import com.yymt.service.OrganizationService;
import com.yymt.common.utils.PageUtils;
import com.yymt.common.utils.R;



/**
 * 组织机构表

 *
 * @author cots
 * @date 2018-09-05 16:23:30
 */
@RestController
@RequestMapping("sport/organization")
//@Api(tags = "体育组织机构信息")
public class OrganizationController extends BaseController{
    @Autowired
    private OrganizationService organizationService;

    /**
     * 列表
     */
    @PostMapping("/list")
    //@ApiOperation(value = "组织机构列表",response = OrganizationEntity.class)
    public RWapper list(@ApiParam("{\"keyword\":\"搜索字符串\"}") @RequestBody Map<String, Object> params){
        PageUtils page = organizationService.queryPage(params);
        return RWapper.ok().put("page", page).encode(isEncryption);
    }


    /**
     * 信息
     */
    @PostMapping("/info/{id}")
    //@ApiOperation("详情")
    public RWapper info(@PathVariable("id") Integer id){
        OrganizationEntity organization = organizationService.selectById(id);
        List contact = organizationService.listOrganazitionContact(id);
        return RWapper.ok().put("organization", organization).put("contact",contact).encode(isEncryption);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sport:organization:save")
    public R save(@RequestBody OrganizationEntity organization){
		organizationService.insert(organization);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sport:organization:update")
    public R update(@RequestBody OrganizationEntity organization){
		organizationService.updateById(organization);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sport:organization:delete")
    public R delete(@RequestBody Integer[] ids){
		organizationService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

}
