package com.yymt.modules.controller.sport;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.yymt.common.exception.RRException;
import com.yymt.common.exception.ResultEnum;
import com.yymt.common.utils.Constant;
import com.yymt.common.utils.PageUtils;
import com.yymt.common.utils.RWapper;
import com.yymt.entity.api.UserEntity;
import com.yymt.entity.sport.CoachingServiceEntity;
import com.yymt.entity.sport.GoodsEntity;
import com.yymt.entity.sport.GoodsTypeEntity;
import com.yymt.entity.sys.SysDictEntity;
import com.yymt.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author keep
 *         体育商城首页页面接口及有关首页的其他接口
 * @date 2018/12/19 10:25
 */
@RestController
@RequestMapping("sports/store")
//@Api(tags = "体育商城")
public class SportsStoreController extends BaseController {

    @Autowired
    private GoodsTypeService goodsTypeService;

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private HallServeService hallServeService;

    @Autowired
    private HallService hallService;

    @Autowired
    private StoreService storeService;

    @Autowired
    private SportsService sportsService;

    @Autowired
    private SysDictService dictService;

    @Autowired
    private UserService userService;

    @Autowired
    private CoachingServiceService coachingServiceService;

    //首页页面接口及有关首页的其他接口
    @PostMapping("/index")
    //@ApiOperation(value = "体育商城首页", response = SportsStoreController.class)
    public RWapper index(@ApiParam(value = "latitude:纬度,longitude:经度,必填,(附近的场馆:distance不为空即可)") @RequestBody Map<String, Object> params) {
        //商品类型
        List<GoodsTypeEntity> goodsType = goodsTypeService.listGoodsType();
        //上新商品
        Map<String, Object> maps = new HashMap<>();
        maps.put("sidx", "tg.create_time");
        maps.put("order", "desc");
        maps.put("limit", 3);
        PageUtils page = goodsService.listGoods(maps);

        //附近的场馆
        params.put("limit", 3);
        PageUtils listHall = hallServeService.nearHall(params);

        return RWapper.ok().put("goodsType", goodsType).put("goods", page.getList())
                .put("nearHall", listHall.getList()).encode(isEncryption);
    }

    @PostMapping("/nearHallServe")
    //@ApiOperation(value = "附近的场馆服务")
    public RWapper nearHallServe(@ApiParam(value = "latitude:纬度,longitude:经度,必填,(sportId:运动类型id)") @RequestBody Map<String, Object> params) {
        PageUtils listHall = hallServeService.nearHall(params);
        PageUtils listHallServe = null;
        if (listHall.getList() != null && listHall.getList().size() > 0) {
            for (int i = 0; i < listHall.getList().size(); i++) {
                Map map = (Map) listHall.getList().get(i);
                params.put("hallId", map.get("hallId"));
                params.put("sidx", "create_time");
                params.put("order", "desc");
                listHallServe = hallServeService.nearHallserve(params);
                map.put("listHallServe", listHallServe.getList());
            }
        }

        Map<String, Object> map = new HashMap<>();
        map.put("sidx", "order_num");
        map.put("order", "asc");
        PageUtils page = sportsService.listSports(map);
        return RWapper.ok().put("listHall", listHall).put("listSports", page.getList()).encode(isEncryption);
    }

    @PostMapping("/moreGoods")
    //@ApiOperation(value = "上新商品(和商品分类同一个接口)")
    public RWapper moreGoods(@ApiParam(value = "categoryId:商品类别id") @RequestBody Map<String, Object> params) {
        params.put("sidx", "tg.create_time");
        params.put("order", "desc");
        PageUtils pageUtils = goodsService.listGoods(params);
        return RWapper.ok().put("listGoods", pageUtils).encode(isEncryption);
    }

    @PostMapping("/nearStore")
    //@ApiOperation(value = "附近商店")
    public RWapper nearStore(@ApiParam(value = "latitude:纬度,longitude:经度,必填") @RequestBody Map<String, Object> params) {
        params.put("hallLatitude", params.get("latitude"));
        params.put("hallLongitude", params.get("longitude"));
        PageUtils listStore = storeService.nearHallStore(params);
        return RWapper.ok().put("nearListStore", listStore).encode(isEncryption);
    }

    @PostMapping("/reveal")
    //@ApiOperation(value = "举报类型列表")
    public RWapper reveal() {
        List<SysDictEntity> listDict = dictService.selectList(new EntityWrapper<SysDictEntity>().eq("type", Constant.MALL_REVEAL));

        return RWapper.ok().put("listDict", listDict).encode(isEncryption);
    }

    @PostMapping("/coachesWithService")
    //@ApiOperation("教练服务列表")
    public RWapper coachesWithService(@ApiParam(value = "{sportName:体育项目名称}")
                                      @RequestBody Map<String, Object> params) {
        if (params.get("sidx") == null) {
            params.put("sidx", "create_time");
            params.put("order", "desc");
        }
        PageUtils pagedCoaches = userService.queryCoachesWithServiceListPage(params);

        return RWapper.ok().put("pagedCoaches", pagedCoaches).encode(isEncryption);
    }

    @PostMapping("/queryCoachingServiceList")
    //@ApiOperation("教练服务列表查询")
    public RWapper queryCoachingServiceList(@ApiParam("{\"userId\":教练标识, \"serviceStatus\":（0：待审核；1：审核通过；2：未通过；不传，查全部）}")
                                            @RequestBody Map<String, Object> params) {
        if (params.get("sidx") == null) {
            params.put("sidx", "create_time");
            params.put("order", "desc");
        }

        PageUtils page = coachingServiceService.listCoachingService(params);

        return RWapper.ok().put("page", page).encode(isEncryption);
    }

    @PostMapping("/queryCoachById/{userId}")
    //@ApiOperation("商城教练详情")
    public RWapper queryCoachById(@PathVariable Long userId) {
        UserEntity coach = userService.queryCoachById(userId);

        return RWapper.ok().put("coach", coach).encode(isEncryption);
    }

    @PostMapping("/queryCoachingServiceById/{serviceId}")
    //@ApiOperation("教练服务详情")
    public RWapper queryCoachingServiceById(@PathVariable Integer serviceId) {
        CoachingServiceEntity coachingService
                = coachingServiceService.queryCoachingServiceById(serviceId);

        if (coachingService == null)
            return RWapper.error("该教练服务不存在");

        CoachingServiceEntity cs = new CoachingServiceEntity();
        cs.setId(coachingService.getId());
        cs.setPageView(Optional.ofNullable(coachingService.getPageView()).orElse(0) + 1);
        coachingServiceService.updateById(cs);

        return RWapper.ok().put("coachingService", coachingService).encode(isEncryption);
    }

    @PostMapping(value = "/selectGoodsById/{goodsId}")
    //@ApiOperation("根据商品id查详情")
    public RWapper selectGoodsById(@PathVariable Integer goodsId) {
        Map<String, Object> goodsStore = goodsService.selectGoodsById(goodsId);
        if(goodsStore == null){
            throw new RRException(ResultEnum.GOODS_IS_EXIST);
        }
        goodsStore.put("pageView", Integer.parseInt(goodsStore.get("pageView").toString()) + 1);
        //更新浏览量
        GoodsEntity goodsEntity = new GoodsEntity();
        goodsEntity.setId(Long.parseLong(goodsStore.get("id").toString()));
        goodsEntity.setPageView(Integer.parseInt(goodsStore.get("pageView").toString()));
        goodsService.updateById(goodsEntity);
        goodsStore.remove("realName");
        goodsStore.remove("createTime");
        return RWapper.ok().put("goodsStore", goodsStore).encode(isEncryption);
    }
}

