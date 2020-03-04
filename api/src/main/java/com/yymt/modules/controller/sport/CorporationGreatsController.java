package com.yymt.modules.controller.sport;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.yymt.annotation.Login;
import com.yymt.common.utils.Constant;
import com.yymt.common.utils.PageUtils;
import com.yymt.common.utils.R;
import com.yymt.common.utils.RWapper;
import com.yymt.entity.sport.CorporationEntity;
import com.yymt.entity.sport.CorporationGreatsEntity;
import com.yymt.entity.sport.CorporationUserEntity;
import com.yymt.entity.sport.MessageRecordEntity;
import com.yymt.service.CorporationGreatsService;
import com.yymt.service.CorporationService;
import com.yymt.service.CorporationUserService;
import com.yymt.service.MessageRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * 组织点赞表
 *
 * @author cots
 * @date 2018-09-11 18:54:03
 */
@RestController
@RequestMapping("sport/corporationgreats")
//@Api(tags = "社团点赞")
public class CorporationGreatsController extends BaseController {
    @Autowired
    private CorporationGreatsService corporationGreatsService;

    @Autowired
    private CorporationService corporationService;
    @Autowired
    private CorporationUserService corporationUserService;
    @Autowired
    private MessageRecordService messageRecordService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sport:corporationgreats:list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = corporationGreatsService.queryPage(params);
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sport:corporationgreats:info")
    public R info(@PathVariable("id") Integer id) {
        CorporationGreatsEntity corporationGreats = corporationGreatsService.selectById(id);
        return R.ok().put("corporationGreats", corporationGreats);
    }

    /**
     * 保存
     */
    @Login
    @PostMapping("/save")
    //@ApiOperation("社团点赞")
    public RWapper save(@RequestBody CorporationGreatsEntity corporationGreats) {
        int count = 0;
        corporationGreats.setUserId(getUserIdByToken());
        CorporationGreatsEntity queryEntity = corporationGreatsService.selectOne(new EntityWrapper<>(corporationGreats));
        if (queryEntity != null) {
            corporationGreatsService.delete(new EntityWrapper<>(queryEntity));
            count = corporationGreatsService.queryGreatCountByCorporationId(corporationGreats.getCorporationId());
            return RWapper.ok().put("totalGreat", count).put("isGreat", 0).encode(isEncryption);
        } else {
            int corporationCount = corporationService.selectCount(
                    new EntityWrapper<CorporationEntity>()
                            .eq("id", corporationGreats.getCorporationId())
            );
            if (corporationCount < 1)
                return RWapper.error("该社团不存在");

            corporationGreats.setGreatsTime(new Date());
            corporationGreatsService.insert(corporationGreats);
            CorporationEntity corporationEntity = corporationService.selectById(corporationGreats.getCorporationId());

            //消息发给所有社团管理员
            List<CorporationUserEntity> list = corporationUserService.selectList(
                    new EntityWrapper<CorporationUserEntity>().eq("corporation_id", corporationGreats.getCorporationId())
            );
            Long[] toUserIds = new Long[list.size()];
            for (int i = 0; i < list.size(); i++) {
                CorporationUserEntity cur = list.get(i);
                toUserIds[i] = cur.getUserId();
            }
            List<MessageRecordEntity> messageRecordEntityList = messageRecordService.toUsersList(corporationGreats.getUserId(), toUserIds,
                    Constant.MESSAGE_TYPE_MSG, Constant.MESSAGE_TAB_GREATS, Constant.MESSAGE_TAB_TYPE_GREATS_CORPORATION
                    , "赞了你的社团", corporationGreats.getCorporationId());
            if (messageRecordEntityList != null && messageRecordEntityList.size() != 0) {
                messageRecordService.insertBatch(messageRecordEntityList);//批量发给所有社团管理员
            }
            count = corporationGreatsService.queryGreatCountByCorporationId(corporationGreats.getCorporationId());
            return RWapper.ok().put("totalGreat", count).put("isGreat", 1).encode(isEncryption);
        }
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sport:corporationgreats:update")
    public R update(@RequestBody CorporationGreatsEntity corporationGreats) {
        corporationGreatsService.updateById(corporationGreats);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sport:corporationgreats:delete")
    public R delete(@RequestBody Integer[] ids) {
        corporationGreatsService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

    /**
     * 点赞的社团
     */
    @Login
    @PostMapping("like")
    //@ApiOperation("喜欢的社团")
    public RWapper like(@ApiParam("{\"isFriend\":true(查询（粉丝或者关注）喜欢false(查询自己),\"friendId\":11)}") @RequestBody Map<String, Object> params) {
        Long userId = getUserIdByTokenWithoutValidate();
        params.put("userId", userId);
        PageUtils page = corporationGreatsService.like(params);
        return RWapper.ok().put("page", page).encode(isEncryption);
    }

}
