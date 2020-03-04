package com.yymt.modules.controller.sport;

import java.util.*;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.yymt.annotation.Login;
import com.yymt.common.exception.RRException;
import com.yymt.common.exception.ResultEnum;
import com.yymt.common.utils.Constant;
import com.yymt.common.utils.RWapper;
import com.yymt.entity.api.UserEntity;
import com.yymt.entity.sport.HallEntity;
import com.yymt.entity.sport.HallUserEntity;
import com.yymt.entity.sport.RevealEntity;
import com.yymt.entity.sys.SysDictEntity;
import com.yymt.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import com.yymt.entity.sport.HallServeEntity;
import com.yymt.common.utils.PageUtils;
import com.yymt.common.utils.R;



/**
 * 场馆服务表
 *
 * @author cots
 * @date 2018-12-11 11:39:03
 */
@RestController
@RequestMapping("sport/hallserve")
//@Api(tags = "场馆服务表")
public class HallServeController extends BaseController{
    @Autowired
    private HallServeService hallServeService;

    @Autowired
    private SysDictService dictService;

    @Autowired
    private SportsService sportsService;

    @Autowired
    private HallUserService hallUserService;

    @Autowired
    private UserService userService;

    @Autowired
    private HallService hallService;

    @Autowired
    private RevealService revealService;


    /**
     * 列表
     */
    @PostMapping("/list")
    @RequiresPermissions("sport:hallserve:list")
    public R list(@RequestBody Map<String, Object> params){
        PageUtils page = hallServeService.queryPage(params);
        return R.ok().put("page", page);
    }

    /**
     * 列表
     */
    @PostMapping("/listServe")
    //@ApiOperation(value = "场馆服务列表",response = HallServeEntity.class )
    public RWapper listServer(@ApiParam("(serveStatus:0待审核 1审核通过 2审核不通过,hallId:场馆id)") @RequestBody Map<String, Object> params){

        PageUtils page = hallServeService.listHallServe(params);
        return RWapper.ok().put("page", page).encode(isEncryption);
    }


    /**
     * 信息
     */
    @PostMapping("/info/{id}")
    //@ApiOperation(value = "场馆服务详情",response = HallServeEntity.class )
    @Transactional
    public RWapper info(@PathVariable("id") Integer id){
        Map hallServe = hallServeService.hallServeById(id);
        if(hallServe == null){
            throw new RRException(ResultEnum.HALL_SERVE_IS_EXIST);
        }
        Integer status = Integer.parseInt(hallServe.get("serveStatus").toString());
        if(status == 1) {
            hallServe.put("pageView", Integer.parseInt(hallServe.get("pageView").toString()) + 1);
            HallServeEntity serveEntity = new HallServeEntity();
            //更新浏览量
            serveEntity.setId(Integer.parseInt(hallServe.get("id").toString()));
            serveEntity.setPageView(Integer.parseInt(hallServe.get("pageView").toString()));
            hallServeService.updateById(serveEntity);
        }
        Map<String, Object> map = new HashMap<>();
        map.put("sidx", "order_num");
        map.put("order","asc");
        return RWapper.ok().put("hallServe", hallServe).put("listDict",listDict()).put("listSports", listSports(map)).encode(isEncryption);
    }

    /**
     * 保存
     */
    @Login
    @PostMapping("/save")
    //@ApiOperation(value = "新增场馆服务",response = HallServeEntity.class )
    @Transactional
    public RWapper save(@RequestBody HallServeEntity hallServe){

        //判断新增条件
        hallIsNormal(hallServe);

        hallServe.setCreateTime(new Date());
        hallServe.setServeStatus(Constant.STATUS_AUDIT);
        hallServeService.insert(hallServe);

        return RWapper.ok().encode(isEncryption);
    }

    /**
     * 进入新增页面显示服务类型
     * */
    @PostMapping("/intoSave")
    //@ApiOperation(value = "进入新增页面显示服务类型和运动项目",response = HallServeEntity.class)
    public RWapper intoSave(@ApiParam("运动项目排序:{(排序字段)sidx:order_num,(排序方式)order:asc}") @RequestBody Map<String, Object> params){
        return RWapper.ok().put("listServeType",listDict()).put("listSports", listSports(params)).encode(isEncryption);
    }

    /**
     * 修改
     */
    @Login
    @PostMapping("/update")
    //@ApiOperation(value = "修改场馆服务",response = HallServeEntity.class )
    @Transactional
    public RWapper update(@RequestBody HallServeEntity hallServe){
        //判断该场馆服务是否被举报,被举报的店铺不能修改
        List list = revealService.selectList(new EntityWrapper<RevealEntity>()
                .eq("reveal_type", Constant.HALL_SERVE_REVEAL)
                .eq("reveal_content_id", hallServe.getId())
                .eq("reveal_status", 0));
        if(list != null && list.size() > 0){
            return RWapper.error("该场馆服务已被举报,暂时不能修改").encode(isEncryption);
        }
        //判断修改条件
        hallIsNormal(hallServe);

        hallServe.setUpdateTime(new Date());
        hallServe.setServeStatus(Constant.STATUS_AUDIT);
        hallServeService.updateById(hallServe);

        return RWapper.ok().encode(isEncryption);
    }

    /**
     * 删除
     */
    @Login
    @PostMapping("/delete")
    //@ApiOperation(value = "删除场馆服务",response = HallServeEntity.class )
    @Transactional
    public RWapper delete(@RequestBody HallServeEntity hallServe){

        //判断删除条件
        hallIsNormal(hallServe);

        hallServeService.deleteById(Integer.parseInt(hallServe.getId().toString()));

        return RWapper.ok().encode(isEncryption);
    }

    /**
     * 查询场馆服务类型列表
     * */
    public List listDict(){
        List<SysDictEntity> listDict = dictService.selectList(new EntityWrapper<SysDictEntity>().eq("type", Constant.SERVER_TYPE));
        List listServiceType = new ArrayList();
        for(SysDictEntity dict: listDict){
            Map<String, Object> map = new HashMap<>();
            map.put("serveType", Integer.parseInt(dict.getCode()));
            map.put("value", dict.getValue());
            listServiceType.add(map);
        }
        return listServiceType;
    }
    /**
     * 查询运动项目列表
     * */
    public List listSports(Map<String, Object> params){
        PageUtils page = sportsService.listSports(params);
        return page.getList();
    }

    /**
     * 判断场馆是否正常
     * */
    public void hallIsNormal(HallServeEntity hallServe){
        //判断用户账号是否正常
        getUserInfoByToken();

        HallEntity hallEntity = hallService.selectById(hallServe.getHallId());
        //判断场馆是否被删除
        if(hallEntity == null){
            throw new RRException(ResultEnum.HALL_IS_EXIST);
        }

        //判断场馆状态是否正常
        if(hallEntity.getHallStatus() != Constant.STATUS_PASS){
            throw new RRException(ResultEnum.HALL_IS_MODIFY);
        }

        //判断场馆是否正常营业 0停业 1正常
        if(hallEntity.getHallIsOpen() == 0){
            throw new RRException(ResultEnum.HALL_IS_MODIFY);
        }

        //判断该用户是否是该场馆的管理员
        HallUserEntity entity = hallUserService.selectOne(
                new EntityWrapper<HallUserEntity>()
                    .eq("hall_id", hallServe.getHallId())
                    .eq("user_id", hallServe.getCreateUserId().intValue()));
        if(entity == null){
            throw new RRException(ResultEnum.HALL_ISNOT_ADMIN);
        }

    }

}
