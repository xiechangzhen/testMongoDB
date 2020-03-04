package com.yymt.modules.controller.sport;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.yymt.annotation.Login;
import com.yymt.common.utils.RWapper;
import com.yymt.entity.api.TokenEntity;
import com.yymt.service.TokenService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.collections.map.HashedMap;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.yymt.entity.sport.ActivityJoinEntity;
import com.yymt.service.ActivityJoinService;
import com.yymt.common.utils.PageUtils;
import com.yymt.common.utils.R;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;


/**
 * 活动参与表
 *
 * @author hgq
 * @date 2018-03-14 15:07:41
 */
@RestController
@RequestMapping("activityjoin")
//@Api(tags = "参与活动")
public class ActivityJoinController {
    @Autowired
    private ActivityJoinService activityJoinService;
    @Autowired
    private TokenService tokenService;

    /**
     * 列表
     */
    @PostMapping("list")
    //@ApiOperation("获取参与活动人列表")
    public RWapper list(@ApiParam(value = "{\"activityId\",参与活动的Id}") @RequestBody Map<String, Object> params) {
        PageUtils page = activityJoinService.selectJoinUserPage(params);
        return RWapper.ok().put("page", page).encode(true);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sport:activityjoin:info")
    public RWapper info(@PathVariable("id") Long id) {
        ActivityJoinEntity activityJoin = activityJoinService.selectById(id);

        return RWapper.ok().put("activityJoin", activityJoin).encode(true);
    }

    /**
     * 获取总数以及自己是否参与
     */
    @PostMapping("getJoinCount")
    //@ApiOperation("获取总数以及自己是否参与")
    public RWapper getJoinCount(@ApiParam(value = "{\"activityId\",参与活动的Id,\"userId\",1}") @RequestBody Map<String, Object> params) {
        Map page = activityJoinService.getTotal(params);
        return RWapper.ok().put("page", page).encode(true);
    }


    /**
     * 保存
     */
    @Login
    @PostMapping("save")
    //@ApiOperation("我要参与")
    public RWapper save(@RequestBody ActivityJoinEntity activityJoin) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes()).getRequest();
        String token = request.getHeader("token");

        TokenEntity tokenEntity = tokenService.queryByToken(token);
        activityJoin.setJoinUserId(tokenEntity.getUserId());
        ActivityJoinEntity alreadyExist = activityJoinService.selectOne(new EntityWrapper<>(activityJoin));
        Map map = new HashedMap();
        map.put("activityId",activityJoin.getActivityId());
        //判断是否已经参与
        if(alreadyExist != null){
            activityJoinService.deleteById(alreadyExist.getId());
            return RWapper.ok("取消参与活动").put("result",activityJoinService.getTotal(map)).put("joinType",false).encode(true);
        }else{
            activityJoin.setCreateTime(new Date());
            activityJoinService.insert(activityJoin);
            return RWapper.ok("成功参与活动").put("result",activityJoinService.getTotal(map)).put("joinType",true).encode(true);
        }
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sport:activityjoin:update")
    public RWapper update(@RequestBody ActivityJoinEntity activityJoin) {
        activityJoinService.updateById(activityJoin);

        return RWapper.ok().encode(false);
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sport:activityjoin:delete")
    public RWapper delete(@RequestBody Long[] ids) {
        activityJoinService.deleteBatchIds(Arrays.asList(ids));

        return RWapper.ok().encode(false);
    }




}
