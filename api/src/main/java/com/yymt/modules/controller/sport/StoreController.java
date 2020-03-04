package com.yymt.modules.controller.sport;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.yymt.annotation.Login;
import com.yymt.common.exception.RRException;
import com.yymt.common.exception.ResultEnum;
import com.yymt.common.utils.Constant;
import com.yymt.common.utils.RWapper;
import com.yymt.entity.api.UserPositionEntity;
import com.yymt.entity.sport.RevealEntity;
import com.yymt.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import com.yymt.entity.sport.StoreEntity;
import com.yymt.common.utils.PageUtils;
import com.yymt.common.utils.R;



/**
 * 店铺表
 *
 * @author cots
 * @date 2018-12-13 08:52:56
 */
@RestController
@RequestMapping("sport/store")
//@Api(tags = "店铺表")
public class StoreController extends BaseController{
    @Autowired
    private StoreService storeService;

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private GoodsTypeService goodsTypeService;

    @Autowired
    private RevealService revealService;

    @Autowired
    private UserPositionService userPositionService;

    /**
     * 列表
     */
    @PostMapping("/list")
    //@ApiOperation(value = "店铺表列表",response = StoreEntity.class )
    @RequiresPermissions("sport:store:list")
    public R list(@RequestBody Map<String, Object> params){
        PageUtils page = storeService.queryPage(params);
        return R.ok().put("page", page);
    }

    /**
     * 列表
     */
    //@Login
    @PostMapping("/listStore")
    //@ApiOperation(value = "店铺表列表",response = StoreEntity.class )
    public RWapper listStore(@ApiParam("sellerId:商家id,storeStatus(0待审核 1审核通过 2审核不通过):店铺审核状态") @RequestBody Map<String, Object> params){
        //判断用户账号是否正常
        getUserInfoByToken();
        PageUtils page = storeService.listStore(params);
        return RWapper.ok().put("page", page).encode(isEncryption);
    }


    /**
     * 信息
     */
    //@Login
    @PostMapping("/info")
    //@ApiOperation(value = "进入店铺详情",response = StoreEntity.class )
    public RWapper info(@ApiParam("shopId:店铺id") @RequestBody Map<String, Object> params){

        String userId = (String)params.get("userId");
        if(!StringUtils.isBlank(userId)){
            //判断用户账号是否正常
            getUserInfoByToken();
        }

        PageUtils page = goodsService.listGoodsByStoreId(params);
        StoreEntity storeEntity = storeService.selectById(Integer.parseInt(params.get("shopId").toString()));
        if (storeEntity == null){
            throw new RRException(ResultEnum.STORE_IS_EXIST);
        }
        if(storeEntity.getStoreStatus() == 1) {
            //更新阅读量
            storeEntity.setPageView(storeEntity.getPageView() + 1);
            storeService.updateById(storeEntity);
        }
        //商品类型
        List list = goodsTypeService.listGoodsType();
        return RWapper.ok().put("store", page).put("goodsType", list).put("storeEntity", storeEntity).encode(isEncryption);
    }

    /**
     * 保存
     */
    @Login
    @PostMapping("/save")
    //@ApiOperation(value = "新增店铺",response = StoreEntity.class )
    public RWapper save(@ApiParam("(latitude 纬度,longitude 经度必填)") @RequestBody StoreEntity store){
        //判断用户身份和状态
        userPosition();
        store.setCreateTime(new Date());
        store.setStoreStatus(Constant.STATUS_AUDIT);
		storeService.insert(store);
        return RWapper.ok().encode(isEncryption);
    }

    /**
     * 修改
     */
    @Login
    @PostMapping("/update")
    //@ApiOperation(value = "修改店铺",response = StoreEntity.class )
    public RWapper update(@RequestBody StoreEntity store){
        //判断该商品是否被举报,被举报的店铺不能修改
        List list = revealService.selectList(new EntityWrapper<RevealEntity>()
                .eq("reveal_type", Constant.STORE_REVEAL)
                .eq("reveal_content_id", store.getId())
                .eq("reveal_status", 0));
        if(list != null && list.size() > 0){
            return RWapper.error("该店铺已被举报,暂时不能修改").encode(isEncryption);
        }
        //判断用户账号是否正常
        userPosition();

        //审核通过后的店铺在进行修改不需要设置位待审核,审核不通过进行修改后店铺改为待审核状态
        StoreEntity storeEntity = storeService.selectById(store.getId());
        if(storeEntity != null && storeEntity.getStoreStatus() == Constant.STATUS_UNPASS){
            store.setStoreStatus(Constant.STATUS_AUDIT);
        }
		storeService.updateById(store);
        return RWapper.ok().encode(isEncryption);
    }

    /**
     * 删除
     */
    @Login
    @PostMapping("/delete/{ids}")
    //@ApiOperation(value = "删除店铺",response = StoreEntity.class )
    @Transactional
    public RWapper delete(@PathVariable("ids") Integer ids){
        //判断用户账号是否正常
        userPosition();
		storeService.deleteById(ids);
		//删除店铺里面的所有商品
		goodsService.deleteByStoreId(ids);
        return RWapper.ok().encode(isEncryption);
    }

    /**
     * 判断用户身份
     * */
    public RWapper userPosition(){
        //判断用户账号是否正常
        getUserInfoByToken();
        //判断用户身份
        UserPositionEntity userPositionEntity = userPositionService.
                selectOne(new EntityWrapper<UserPositionEntity>()
                        .eq("user_id", getUserIdByToken())
                        .eq("user_position", 4));
        if(userPositionEntity == null){
            throw new RRException(ResultEnum.STORE_IS_POSITION);
        }
        return RWapper.ok();
    }

}
