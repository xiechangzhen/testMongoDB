package com.yymt.modules.controller.sport;

import com.yymt.common.utils.Constant;
import com.yymt.common.utils.PageUtils;
import com.yymt.common.utils.RWapper;
import com.yymt.entity.sport.HallEntity;
import com.yymt.service.HallPriceService;
import com.yymt.service.HallServeService;
import com.yymt.service.HallService;
import com.yymt.service.StoreService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



/**
 * 场馆表
 *
 * @author cots
 * @date 2018-08-27 11:44:46
 */
@RestController
@RequestMapping("sport/hall")
//@Api(tags = "场馆")
public class HallController extends BaseController{
    @Autowired
    private HallService hallService;

    @Autowired
    private HallPriceService hallPriceService;

    @Autowired
    private HallServeService hallServeService;

    @Autowired
    private StoreService storeService;

    /**
     * 列表
     */
    @PostMapping("/list")
    //@ApiOperation(value = "场馆列表",response = HallEntity.class)
    public RWapper list(@ApiParam(value = "{\"latitude\":25.832659(必填),\"longitude\":114.985529(必填),\"area\":360702,\"item\":\"赛事类型ID\",\"distance\":1000,\"keyword\":\"搜索字符串\"}") @RequestBody Map<String, Object> params){
        PageUtils page = hallService.listHall(params);
        return RWapper.ok().put("page", page).encode(isEncryption);
    }


    /**
     * 信息
     */
    @CrossOrigin
    @PostMapping("/info/{id}")
    //@ApiOperation(value = "场馆详情",response = HallEntity.class)
    public RWapper info(@PathVariable("id") Integer id){
        HallEntity entity = hallService.selectById(id);
        if(entity == null){
            return RWapper.error("场馆不存在");
        }
        entity.setPageView(entity.getPageView()+1);
        hallService.updateById(entity);
        Map param = new HashedMap();
        param.put("userId",getUserIdByTokenWithoutValidate());
        param.put("hallId",id);
        Map hall = hallService.hallDetail(param);

        //场馆服务项目
        Map map = new HashMap();
        map.put("hallId", id);
        map.put("serveStatus", Constant.STATUS_PASS);
        map.put("sidx", "create_time");
        map.put("order","desc");
        map.put("limit", 3);
        PageUtils page = hallServeService.listHallServe(map);
        //附近商家
        HallEntity hallEntity = hallService.selectById(id);
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("hallLatitude", hallEntity.getHallLatitude());
        params.put("hallLongitude", hallEntity.getHallLongitude());
        params.put("limit", 3);
        PageUtils listStore = storeService.nearHallStore(params);

        List price = hallPriceService.listHallPrice(id);
        return RWapper.ok().put("hall",hall).put("price",price).put("hallServe",page.getList()).put("nearListStore",listStore.getList()).encode(isEncryption);
    }

    @PostMapping("/hallServe/{hallId}")
    //@ApiOperation(value = "场馆服务项目列表")
    public RWapper hallServe(@ApiParam(value = "hallId:场馆id") @PathVariable("hallId") Integer hallId){
        Map map = new HashMap();
        map.put("hallId", hallId);
        map.put("serveStatus", Constant.STATUS_PASS);
        PageUtils page = hallServeService.listHallServe(map);
        return RWapper.ok().put("listHallServe", page.getList());
    }

    /**
     * 保存
     *//*
    @RequestMapping("/save")
    public R save(@RequestBody HallEntity hall){
		hallService.insert(hall);
        return R.ok();
    }

    *//**
     * 修改
     *//*
    @RequestMapping("/update")
    public R update(@RequestBody HallEntity hall){
		hallService.updateById(hall);
        return R.ok();
    }

    *//**
     * 删除
     *//*
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
		hallService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }*/

}
