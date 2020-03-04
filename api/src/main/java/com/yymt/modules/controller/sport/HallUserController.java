package com.yymt.modules.controller.sport;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.yymt.common.utils.RWapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.yymt.entity.sport.HallUserEntity;
import com.yymt.service.HallUserService;
import com.yymt.common.utils.PageUtils;
import com.yymt.common.utils.R;



/**
 * 用户管理的场馆表
 *
 * @author cots
 * @date 2018-12-11 11:39:03
 */
@RestController
@RequestMapping("sport/halluser")
//@Api(tags = "用户管理的场馆")
public class HallUserController extends BaseController{
    @Autowired
    private HallUserService hallUserService;

    /**
     * 用户管理的场馆表列表
     */
    @PostMapping("/list")
    @RequiresPermissions("sport:halluser:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = hallUserService.queryPage(params);
        return R.ok().put("page", page);
    }
    /**
     * 用户管理的场馆表列表
     * */
    @PostMapping("/listHallUser")
    //@ApiOperation(value = "用户管理的场馆列表",response = HallUserEntity.class )
    @RequiresPermissions("sport:halluser:list")
    public RWapper listHallUser(@ApiParam("(用户id:userId)") @RequestBody Map<String, Object> params){
        //判断用户账号是否正常
        getUserInfoByToken();
        PageUtils pageUtils = hallUserService.listHallUser(params);
        return RWapper.ok().put("listHall",pageUtils).encode(isEncryption);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sport:halluser:info")
    public R info(@PathVariable("id") Integer id){
        HallUserEntity hallUser = hallUserService.selectById(id);
        return R.ok().put("hallUser", hallUser);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sport:halluser:save")
    public R save(@RequestBody HallUserEntity hallUser){
		hallUserService.insert(hallUser);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sport:halluser:update")
    public R update(@RequestBody HallUserEntity hallUser){
		hallUserService.updateById(hallUser);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sport:halluser:delete")
    public R delete(@RequestBody Integer[] ids){
		hallUserService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

}
