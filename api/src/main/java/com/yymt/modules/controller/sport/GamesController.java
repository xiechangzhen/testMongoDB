package com.yymt.modules.controller.sport;

import com.yymt.annotation.Login;
import com.yymt.common.exception.RRException;
import com.yymt.common.exception.ResultEnum;
import com.yymt.common.utils.Constant;
import com.yymt.common.utils.PageUtils;
import com.yymt.common.utils.R;
import com.yymt.common.utils.RWapper;
import com.yymt.entity.api.IndexCategory;
import com.yymt.entity.api.TableName;
import com.yymt.entity.sport.CorporationEntity;
import com.yymt.entity.sport.GameSignUpEntity;
import com.yymt.entity.sport.GamesEntity;
import com.yymt.search.LuceneUtils;
import com.yymt.service.CorporationService;
import com.yymt.service.CorporationUserService;
import com.yymt.service.GameSignUpService;
import com.yymt.service.GamesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static com.yymt.modules.controller.sport.NewsController.NEWS_STATUS_AUDITING;


/**
 * 赛事培训表
 *
 * @author cots
 * @date 2018-09-13 10:16:31
 */
@RestController
@RequestMapping("sport/games")
//@Api(tags = "赛事培训")
public class GamesController extends BaseController {
    @Autowired
    private GamesService gamesService;

    @Autowired
    private GameSignUpService gameSignUpService;

    @Autowired
    private CorporationService corporationService;
    @Autowired
    private CorporationUserService corporationUserService;

    /**
     * 获取指定赛事指定用户是否报名
     *
     * @param gameId 赛事标识
     * @param userId 用户标识
     */
    @PostMapping("/getGameIsSignUp/{gameId}/{userId}")
    //@ApiOperation("获取指定赛事指定用户是否报名")
    public RWapper getGameIsSignUp(
            @PathVariable int gameId,
            @PathVariable int userId) {
        boolean result = gamesService.getGameIsSignUp(gameId, userId);
        return RWapper.ok().put("result", result).encode(isEncryption);
    }


    /**
     * 列表
     */
    @Login
    @PostMapping("/listGame")
    //@ApiOperation(value = "赛事培训列表(社团管理员)", response = GamesEntity.class)
    public RWapper listGames(@ApiParam("{\"columnId\":1,\"gameStatus\":2(空串-全部,1-待审核,2-审核通过,3-不通过，4-删除),\"corporationId\",1}") @RequestBody Map<String, Object> params) {
        //查询该用户是否是该社团的管理员

        if (params.get("corporationId") == null) {
            return RWapper.error("社团ID不能为空");
        }
        Long userId = getUserIdByToken();
        boolean isCorporationManager = false;
        List corporations = corporationUserService.listUserCorporation(userId);
        for (int i = 0; i < corporations.size(); i++) {
            if (Integer.parseInt(((Map) corporations.get(i)).get("corporation_id").toString()) == Integer.parseInt(params.get("corporationId").toString())) {
                isCorporationManager = true;
                break;
            }
        }
        if (isCorporationManager) {
            PageUtils page = gamesService.selectGamesListPage(params);
            return RWapper.ok().put("page", page).encode(isEncryption);
        } else {
            return RWapper.error("您不是该社团的管理员");
        }

    }

    /**
     * 列表
     */
    @CrossOrigin
    @PostMapping("/list")
    //@ApiOperation(value = "赛事培训列表", response = GamesEntity.class)
    public RWapper list(@ApiParam("{\"columnId\":1,\"gameFlag\":(1-进行中,2,已结束,不传，查全部}") @RequestBody Map<String, Object> params) {
        params.put("showAppGame", "1");//APP首页赛事不显示社团的培训赛事信息
        PageUtils page = gamesService.selectGamesPage(params);
        return RWapper.ok().put("page", page).encode(isEncryption);
    }

    /**
     * 信息
     */
    @CrossOrigin
    @PostMapping("/info/{id}")
    //@ApiOperation(value = "赛事培训详情", response = GamesEntity.class)
    public RWapper info(@PathVariable("id") Integer id) {
        Map<String, Object> param = new HashedMap();
        param.put("gameId", id);
        param.put("userId", getUserIdByTokenWithoutValidate());
        Map games = gamesService.gameDetail(param);
        if (games == null) {
            return RWapper.error("赛事不存在");
        }
        GamesEntity gamesEntity = new GamesEntity();
        gamesEntity.setId(id);
        gamesEntity.setPageView(Integer.parseInt(games.get("pv").toString()) + 1);
        gamesService.updateById(gamesEntity);

        Map<String, Object> params = new HashedMap();
        params.put("page", 1);
        params.put("limit", 5);
        params.put("id", id);
        params.put("sidx", "signUpTime");
        params.put("order", "desc");
        PageUtils page = gameSignUpService.selectGameSignUpPage(params);
        return RWapper.ok().put("games", games).put("signup", page).encode(isEncryption);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    //@ApiOperation(value = "添加赛事培训详情")
    public RWapper save(@RequestBody GamesEntity games) {
        //社团待审核
        CorporationEntity corporationEntity = corporationService.selectById(games.getCorporationId());
        if(corporationEntity == null){
            throw new RRException(ResultEnum.CORPORATION_NOT_EXIST);
        }
        if(corporationEntity.getCorporationStatus() != Constant.STATUS_PASS){
            throw new RRException(ResultEnum.UNPASS_CORPORATION_CANT_SUBMIT);
        }

        if(games.getGameIsOpen() == 0){//不开启，不保存报名时间
            games.setActivityStartTime(null);
            games.setActivityEndTime(null);
        }

        games.setGameAuthor(getUserIdByToken());
        games.setAuthorType(2);//用户类型
        games.setGameCreateTime(new Date());
        games.setGameUpdateTime(new Date());
        games.setGameStatus(NEWS_STATUS_AUDITING);
        gamesService.insert(games);
        return RWapper.ok();
    }

    /**
     * 修改
     */
    @Login
    //@ApiOperation("")
    @PostMapping("/update")
    public R update(@RequestBody GamesEntity games) throws IOException {
        //社团待审核
        CorporationEntity corporationEntity = corporationService.selectById(games.getCorporationId());
        if(corporationEntity == null){
            throw new RRException(ResultEnum.CORPORATION_NOT_EXIST);
        }
        if(corporationEntity.getCorporationStatus() != Constant.STATUS_PASS){
            throw new RRException(ResultEnum.UNPASS_CORPORATION_CANT_MODIFY);
        }

        if(games.getGameIsOpen() == 0){//不开启，不保存报名时间
            games.setActivityStartTime(null);
            games.setActivityEndTime(null);
        }

        games.setGameStatus(NEWS_STATUS_AUDITING);
        gamesService.updateById(games);
        //修改编程待审核状态,删除索引
        IndexCategory indexCategory
                = IndexCategory.matchCategory(TableName.GAMES, games.getGameColumn());
        Map<String, Object> data = new HashedMap();
        LuceneUtils.deleteIndexItem(indexCategory, games.getId());
        return R.ok();
    }

    /**
     * 删除
     */
    @Login
    @PostMapping("/delete/{id}")
    //@ApiOperation("删除赛事")
    public RWapper delete(@PathVariable("id") Integer id) {

        GamesEntity gamesEntity = gamesService.selectById(id);

        if (gamesEntity == null) {
            return RWapper.error("赛事不存在");
        }
        if (gamesEntity.getGameAuthor().intValue() != getUserIdByToken().intValue()) {
            return RWapper.error("只能删除自己发布的赛事");
        }
        //社团待审核
        CorporationEntity corporationEntity = corporationService.selectById(gamesEntity.getCorporationId());
        if(corporationEntity == null){
            throw new RRException(ResultEnum.CORPORATION_NOT_EXIST);
        }
        if(corporationEntity.getCorporationStatus() != Constant.STATUS_PASS){
            throw new RRException(ResultEnum.UNPASS_CORPORATION_CANT_SUBMIT);
        }
        gamesService.deleteById(id);
        return RWapper.ok();
    }

    @PostMapping("/signUp")
    @Login
    public RWapper signUp(@RequestBody GameSignUpEntity gameSignUpEntity) {
        gameSignUpService.insert(gameSignUpEntity);
        return RWapper.ok();
    }

}
