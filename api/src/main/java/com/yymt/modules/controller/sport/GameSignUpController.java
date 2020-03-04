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

import com.yymt.entity.sport.GameSignUpEntity;
import com.yymt.service.GameSignUpService;
import com.yymt.common.utils.PageUtils;
import com.yymt.common.utils.R;


/**
 * 赛事培训报名表
 *
 * @author cots
 * @date 2018-09-05 16:23:30
 */
@RestController
@RequestMapping("sport/gamesignup")
//@Api(tags = "赛事培训报名")
public class GameSignUpController extends BaseController {
    @Autowired
    private GameSignUpService gameSignUpService;

    @Autowired
    private GamesService gamesService;

    /**
     * 列表
     */
    @PostMapping("/list")
    //@ApiOperation("查询报名列表")
    public RWapper list(@RequestBody Map<String, Object> params) {
        PageUtils page = gameSignUpService.selectGameSignUpPage(params);
        return RWapper.ok().put("page", page).encode(isEncryption);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sport:gamesignup:info")
    public R info(@PathVariable("id") Integer id) {
        GameSignUpEntity gameSignUp = gameSignUpService.selectById(id);
        return R.ok().put("gameSignUp", gameSignUp);
    }

    /**
     * 保存
     */
    @Login
    @PostMapping("/save")
    //@ApiOperation("报名/取消报名")
    public RWapper save(@RequestBody GameSignUpEntity gameSignUp) {
        gameSignUp.setUserId(getUserIdByToken().intValue());
        //判断是否超过人数限制
        GamesEntity gamesEntity = gamesService.selectById(gameSignUp.getGameId());
        if (gamesEntity == null) {
            return RWapper.error("赛事不存在");
        }
        if (gamesEntity.getGamePeopleLimit() > 0) {
            int count = gameSignUpService.querySignupCount(gameSignUp.getGameId());
            if (count >= gamesEntity.getGamePeopleLimit()) {
                return RWapper.error("报名人数已满");
            }
        }
        GameSignUpEntity queryEntity = gameSignUpService.selectOne(new EntityWrapper<>(gameSignUp));
        if (queryEntity != null) {
            gameSignUpService.delete(new EntityWrapper<>(queryEntity));
            return RWapper.ok("取消报名");
        } else {
            gameSignUp.setSignUpTime(new Date());
            gameSignUpService.insert(gameSignUp);
            return RWapper.ok("报名成功");
        }
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sport:gamesignup:update")
    public R update(@RequestBody GameSignUpEntity gameSignUp) {
        gameSignUpService.updateById(gameSignUp);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sport:gamesignup:delete")
    public R delete(@RequestBody Integer[] ids) {
        gameSignUpService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

}
