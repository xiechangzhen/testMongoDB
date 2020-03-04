package com.yymt.modules.controller.sport;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.yymt.annotation.Login;
import com.yymt.common.exception.RRException;
import com.yymt.common.exception.ResultEnum;
import com.yymt.common.utils.Constant;
import com.yymt.common.utils.RWapper;
import com.yymt.entity.sport.HallEntity;
import com.yymt.service.HallService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.yymt.entity.sport.HallGreatsEntity;
import com.yymt.service.HallGreatsService;
import com.yymt.common.utils.PageUtils;
import com.yymt.common.utils.R;



/**
 * 场馆点赞表
 *
 * @author cots
 * @date 2018-09-14 11:13:50
 */
@RestController
@RequestMapping("sport/hallgreats")
//@Api(tags = "场馆点赞表")
public class HallGreatsController extends BaseController{
    @Autowired
    private HallGreatsService hallGreatsService;
    @Autowired
    private HallService hallService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sport:hallgreats:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = hallGreatsService.queryPage(params);
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{hallId}")
    @RequiresPermissions("sport:hallgreats:info")
    public R info(@PathVariable("hallId") Integer hallId){
        HallGreatsEntity hallGreats = hallGreatsService.selectById(hallId);
        return R.ok().put("hallGreats", hallGreats);
    }

    /**
     * 保存
     */
    @Login
    @PostMapping("/save")
    //@ApiOperation("场馆点赞")
    public RWapper save(@RequestBody HallGreatsEntity hallGreats){
        int count = 0;
        HallEntity newsEntity = hallService.selectById(hallGreats.getHallId());
        if(newsEntity == null){
            throw new RRException(ResultEnum.HALL_IS_EXIST);
        }

        //判断场馆状态是否正常
        if(newsEntity.getHallStatus() != Constant.STATUS_PASS){
            throw new RRException(ResultEnum.HALL_IS_MODIFY);
        }

        /*
        //判断场馆是否正常营业 0停业 1正常
        if(newsEntity.getHallIsOpen() == 0){
            throw new RRException(ResultEnum.HALL_IS_MODIFY);
        }
        */

        hallGreats.setUserId(getUserIdByToken());
        HallGreatsEntity queryEntity = hallGreatsService.selectOne(new EntityWrapper<>(hallGreats));
        if(queryEntity != null){
            hallGreatsService.delete(new EntityWrapper<>(queryEntity));
            count = hallGreatsService.queryGreatCountByHallId(hallGreats.getHallId());
            return RWapper.ok().put("totalGreat",count).put("isGreat",0).encode(isEncryption);
        }else{
            hallGreats.setCreateTime(new Date());
            hallGreatsService.insert(hallGreats);

           /* if(newsEntity != null && newsEntity.getAuthorType() != 1) {//后台用户添加的不需要消息
                messageRecordService.insertMsg(newsGreats.getUserId(), newsEntity.getNewsAuthor(),
                        MESSAGE_TYPE_MSG, MESSAGE_TAB_GREATS, MESSAGE_TAB_TYPE_GREATS_NEWS, "点赞了你的文章", newsEntity.getId());
            }*/
            count = hallGreatsService.queryGreatCountByHallId(hallGreats.getHallId());
            return RWapper.ok().put("totalGreat",count).put("isGreat",1).encode(isEncryption);
        }

    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sport:hallgreats:update")
    public R update(@RequestBody HallGreatsEntity hallGreats){
		hallGreatsService.updateById(hallGreats);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sport:hallgreats:delete")
    public R delete(@RequestBody Integer[] hallIds){
		hallGreatsService.deleteBatchIds(Arrays.asList(hallIds));
        return R.ok();
    }

    /**
     * 点赞的场馆
     */
    @Login
    @PostMapping("/like")
    //@ApiOperation("喜欢的场馆")
    public RWapper like(@ApiParam("{\"isFriend\":true(查询（粉丝或者关注）喜欢false(查询自己),\"friendId\":11)}")@RequestBody Map<String,Object> params){
        Long userId = getUserIdByTokenWithoutValidate();
        params.put("userId",userId);
        PageUtils page = hallGreatsService.like(params);
        return RWapper.ok().put("page",page).encode(isEncryption);
    }

}
