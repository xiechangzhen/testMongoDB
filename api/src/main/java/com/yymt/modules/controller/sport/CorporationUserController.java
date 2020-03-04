package com.yymt.modules.controller.sport;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.yymt.annotation.Login;
import com.yymt.common.utils.RWapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.yymt.entity.sport.CorporationUserEntity;
import com.yymt.service.CorporationUserService;
import com.yymt.common.utils.PageUtils;
import com.yymt.common.utils.R;



/**
 * 用户社团表
 *
 * @author cots
 * @date 2018-09-05 16:23:30
 */
@RestController
@RequestMapping("sport/corporationuser")
//@Api(tags = "用户社团")
public class CorporationUserController extends BaseController{
    @Autowired
    private CorporationUserService corporationUserService;

    /**
     * 列表
     */
    @Login
    @PostMapping("/list")
    //@ApiOperation("通过用户查询社团")
    public RWapper list(){
        List corporations = corporationUserService.listUserCorporation(getUserIdByToken());
        return RWapper.ok().put("corporations", corporations).encode(isEncryption);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sport:corporationuser:info")
    public R info(@PathVariable("id") Integer id){
        CorporationUserEntity corporationUser = corporationUserService.selectById(id);
        return R.ok().put("corporationUser", corporationUser);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sport:corporationuser:save")
    public R save(@RequestBody CorporationUserEntity corporationUser){
		corporationUserService.insert(corporationUser);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sport:corporationuser:update")
    public R update(@RequestBody CorporationUserEntity corporationUser){
		corporationUserService.updateById(corporationUser);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sport:corporationuser:delete")
    public R delete(@RequestBody Integer[] ids){
		corporationUserService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

}
