package com.yymt.modules.controller.sport;

import com.yymt.annotation.Login;
import com.yymt.common.exception.RRException;
import com.yymt.common.exception.ResultEnum;
import com.yymt.common.utils.Constant;
import com.yymt.common.utils.PageUtils;
import com.yymt.common.utils.RWapper;
import com.yymt.entity.sport.*;
import com.yymt.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Map;



/**
 * 举报记录表
 *
 * @author hgq
 * @date 2018-03-14 11:21:26
 */
@RestController
@RequestMapping("reveal")
//@Api(tags = "举报")
public class RevealController  extends BaseController{
    @Autowired
    private RevealService revealService;
    @Autowired
    private ForumsService forumsService;
    @Autowired
    private StoreService storeService;
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private HallServeService hallServeService;
    @Autowired
    private CoachingServiceService coachingServiceService;
    /**
     * 列表
     */
    @Login
    @PostMapping("list")
    //@ApiOperation("举报列表")
    public RWapper list(@RequestParam Map<String, Object> params){
        PageUtils page = revealService.queryPage(params);
        return RWapper.ok().put("page", page).encode(isEncryption);
    }


//    /**
//     * 信息
//     */
//    @RequestMapping("/info/{id}")
//    @RequiresPermissions("sport:reveal:info")
//    public RWapper info(@PathVariable("id") Integer id){
//			RevealEntity reveal = revealService.selectById(id);
//        return RWapper.ok().put("reveal", reveal).encode(isEncryption);
//    }

    /**
     * 保存
     */
    @Login
    @PostMapping("save")
    //@ApiOperation("举报")
    @Transactional
    public RWapper save(@RequestBody RevealEntity reveal){
        /*if(reveal.getRevealType() == 1){
            ForumsEntity forumsEntity = new ForumsEntity();
            forumsEntity.setId(reveal.getRevealContentId());
            ForumsEntity cur = forumsService.selectById(reveal.getRevealContentId());
            if(cur == null){
                throw new RRException(ResultEnum.DATA_NOT_EXIST);
            }
            if(cur.getForumsStatus() != Constant.FORUMS_STATUS_REVEAL) {//更新动态的状态为被举报
                forumsEntity.setForumsStatus(Constant.FORUMS_STATUS_REVEAL);
                forumsService.updateById(forumsEntity);
            }
        }*/
        switch (reveal.getRevealType()){
            case 1:
                ForumsEntity forumsEntity = forumsService.selectById(reveal.getRevealContentId());
                if(forumsEntity == null){
                    throw new RRException(ResultEnum.CORPORATION_NOT_EXIST);
                }
                break;
            case 2:
                StoreEntity storeEntity = storeService.selectById(reveal.getRevealContentId());
                if (storeEntity == null){
                    throw new RRException(ResultEnum.STORE_IS_EXIST);
                }
                break;
            case 3:
                GoodsEntity goodsEntity = goodsService.selectById(reveal.getRevealContentId());
                if (goodsEntity == null){
                    throw new RRException(ResultEnum.GOODS_IS_EXIST);
                }
                break;
            case 4:
                HallServeEntity hallServeEntity = hallServeService.selectById(reveal.getRevealContentId());
                if (hallServeEntity == null){
                    throw new RRException(ResultEnum.HALL_SERVE_IS_EXIST);
                }
                break;
            case 5:
                CoachingServiceEntity coachingServiceEntity = coachingServiceService.selectById(reveal.getRevealContentId());
                if (coachingServiceEntity == null){
                    throw new RRException(ResultEnum.COACHING_SERVICE_IS_NOT_EXIST);
                }
                break;
        }
        reveal.setRevealUserId(getUserIdByToken());
        reveal.setCreateTime(new Date());
		revealService.insert(reveal);
        return RWapper.ok();
    }

//    /**
//     * 修改
//     */
//    @RequestMapping("/update")
//    @RequiresPermissions("sport:reveal:update")
//    public RWapper update(@RequestBody RevealEntity reveal){
//			revealService.updateById(reveal);
//        return RWapper.ok();
//    }
//
//    /**
//     * 删除
//     */
//    @RequestMapping("/delete")
//    @RequiresPermissions("sport:reveal:delete")
//    public RWapper delete(@RequestBody Integer[] ids){
//			revealService.deleteBatchIds(Arrays.asList(ids));
//        return RWapper.ok().encode(false);
//    }

}
