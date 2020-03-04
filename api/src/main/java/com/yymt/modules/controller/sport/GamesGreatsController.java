package com.yymt.modules.controller.sport;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.yymt.annotation.Login;
import com.yymt.common.utils.RWapper;
import com.yymt.entity.sport.GamesEntity;
import com.yymt.service.GamesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.yymt.entity.sport.GamesGreatsEntity;
import com.yymt.service.GamesGreatsService;
import com.yymt.common.utils.PageUtils;
import com.yymt.common.utils.R;



/**
 * 赛事点赞
 *
 * @author cots
 * @date 2018-09-14 11:13:50
 */
@RestController
@RequestMapping("sport/gamesgreats")
//@Api(tags = "赛事点赞")
public class GamesGreatsController extends BaseController{
    @Autowired
    private GamesGreatsService gamesGreatsService;

    @Autowired
    private GamesService gamesService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@ApiOperation(value = "赛事点赞列表",response = GamesGreatsEntity.class )
    @RequiresPermissions("sport:gamesgreats:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = gamesGreatsService.queryPage(params);
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{gameId}")
    @RequiresPermissions("sport:gamesgreats:info")
    public R info(@PathVariable("gameId") Integer gameId){
        GamesGreatsEntity gamesGreats = gamesGreatsService.selectById(gameId);
        return R.ok().put("gamesGreats", gamesGreats);
    }

    /**
     * 保存
     */
    @Login
    @PostMapping("/save")
    //@ApiOperation(value = "赛事点赞",response = GamesGreatsEntity.class )
    public RWapper save(@RequestBody GamesGreatsEntity gamesGreats){
        int count = 0;
        gamesGreats.setUserId(getUserIdByToken());
        GamesGreatsEntity queryEntity = gamesGreatsService.selectOne(new EntityWrapper<>(gamesGreats));
        if(queryEntity != null){
            gamesGreatsService.deleteById(queryEntity);
            count = gamesGreatsService.queryGreatCountByGameId(gamesGreats.getGameId());
            return RWapper.ok().put("totalGreat",count).encode(isEncryption);
        }else{
            gamesGreats.setCreateTime(new Date());
            gamesGreatsService.insert(gamesGreats);
            GamesEntity gamesEntity = gamesService.selectById(gamesGreats.getGameId());
           /* if(newsEntity != null && newsEntity.getAuthorType() != 1) {//后台用户添加的不需要消息
                messageRecordService.insertMsg(newsGreats.getUserId(), newsEntity.getNewsAuthor(),
                        MESSAGE_TYPE_MSG, MESSAGE_TAB_GREATS, MESSAGE_TAB_TYPE_GREATS_NEWS, "点赞了你的文章", newsEntity.getId());
            }*/
            count = gamesGreatsService.queryGreatCountByGameId(gamesGreats.getGameId());
            return RWapper.ok().put("totalGreat",count).encode(isEncryption);
        }
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sport:gamesgreats:update")
    public R update(@RequestBody GamesGreatsEntity gamesGreats){
		gamesGreatsService.updateById(gamesGreats);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sport:gamesgreats:delete")
    public R delete(@RequestBody Integer[] gameIds){
		gamesGreatsService.deleteBatchIds(Arrays.asList(gameIds));
        return R.ok();
    }

}
