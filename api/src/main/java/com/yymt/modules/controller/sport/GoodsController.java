package com.yymt.modules.controller.sport;

import java.io.IOException;
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
import com.yymt.entity.api.IndexCategory;
import com.yymt.entity.sport.RevealEntity;
import com.yymt.entity.sport.StoreEntity;
import com.yymt.search.LuceneUtils;
import com.yymt.service.GoodsTypeService;
import com.yymt.service.RevealService;
import com.yymt.service.StoreService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.yymt.entity.sport.GoodsEntity;
import com.yymt.service.GoodsService;
import com.yymt.common.utils.PageUtils;
import com.yymt.common.utils.R;


/**
 * 商品
 *
 * @author cots
 * @date 2018-12-13 08:52:56
 */
@RestController
@RequestMapping("sport/goods")
//@Api(tags = "商品管理")
public class GoodsController extends BaseController {
    @Autowired
    private GoodsService goodsService;

    @Autowired
    private GoodsTypeService goodsTypeService;

    @Autowired
    private StoreService storeService;

    @Autowired
    private RevealService revealService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sport:goods:list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = goodsService.queryPage(params);
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @Login
    @PostMapping("/info/{id}")
    //@ApiOperation(value = "商品详情", response = GoodsEntity.class)
    public RWapper info(@PathVariable("id") Long id) {
        //判断用户账号是否正常
        getUserInfoByToken();

        GoodsEntity goods = goodsService.selectById(id);
        if(goods == null){
            throw new RRException(ResultEnum.GOODS_IS_EXIST);
        }
        //商品类型
        List listGoodsType = goodsTypeService.listGoodsType();
        return RWapper.ok().put("goods", goods).put("goodsType", listGoodsType).encode(isEncryption);
    }

    /**
     * 进入上架商品页面
     */
    @PostMapping("/intoSaveGoods")
    //@ApiOperation(value = "进入新增商品页面", response = GoodsEntity.class)
    public RWapper intoSaveGoods() {
        //商品类型
        List listGoodsType = goodsTypeService.listGoodsType();
        return RWapper.ok().put("goodsType", listGoodsType).encode(isEncryption);
    }

    /**
     * 保存
     */
    @Login
    @PostMapping("/save")
    //@ApiOperation(value = "新增商品", response = GoodsEntity.class)
    public RWapper save(@RequestBody GoodsEntity goods) throws IOException {
        //判断店铺是否存在和用户账号是否正常
        getUserInfoByToken();
        StoreEntity storeEntity = storeService.selectById(goods.getShopId());
        if(storeEntity == null){
            throw new RRException(ResultEnum.STORE_IS_EXIST);
        }

        goods.setGoodsStatus(Constant.STATUS_PASS);
        goods.setCreateTime(new Date());
        goodsService.insert(goods);

        addOrUpdateSearchIndex(goods);

        return RWapper.ok().encode(isEncryption);
    }

    /**
     * 修改
     */
    @Login
    @PostMapping("/update")
    //@ApiOperation(value = "修改商品", response = GoodsEntity.class)
    public RWapper update(@RequestBody GoodsEntity goods) throws IOException {
        //判断该商品是否被举报,被举报的商品不能修改
        List list = revealService.selectList(new EntityWrapper<RevealEntity>()
                .eq("reveal_type", Constant.GOODS_REVEAL)
                .eq("reveal_content_id", goods.getId())
                .eq("reveal_status", 0));
        if(list != null && list.size() > 0){
            return RWapper.error("该商品已被举报,暂时不能修改").encode(isEncryption);
        }
        //判断店铺是否存在和用户账号是否正常
        storeIsDel(goods.getId().intValue());

        goodsService.updateById(goods);

        addOrUpdateSearchIndex(goods);

        return RWapper.ok().encode(isEncryption);
    }

    /**
     * 删除
     */
    @Login
    @PostMapping("/delete/{ids}")
    //@ApiOperation(value = "删除商品", response = GoodsEntity.class)
    public RWapper delete(@PathVariable("ids") Long ids) {
        //判断店铺是否存在和用户账号是否正常
        storeIsDel(ids.intValue());

        goodsService.deleteById(ids);
        return RWapper.ok().encode(isEncryption);
    }

    /**
     * 判断店铺是否存在
     * **/
    public void storeIsDel(Integer goodId){
        //判断用户是否正常
        getUserInfoByToken();

        GoodsEntity goodsEntity = goodsService.selectById(goodId);
        StoreEntity storeEntity = storeService.selectById(goodsEntity.getShopId());
        if(storeEntity == null){
            throw new RRException(ResultEnum.STORE_IS_EXIST);
        }
    }

    private void addOrUpdateSearchIndex(GoodsEntity goods) throws IOException {
        Integer id = ((Number) goods.getId()).intValue();
        LuceneUtils.deleteIndexItem(IndexCategory.GOODS, id);
        LuceneUtils.indexItem(IndexCategory.GOODS, id,
                goods.getGoodsName(), goods.getGoodsDetails());
    }

    private void deleteSearchIndex(Long goodsId) throws IOException {
        Integer id = ((Number) goodsId).intValue();
        LuceneUtils.deleteIndexItem(IndexCategory.GOODS, id);
    }

}
