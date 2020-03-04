package com.yymt.modules.controller.sport;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.yymt.annotation.Login;
import com.yymt.common.utils.Constant;
import com.yymt.common.utils.PageUtils;
import com.yymt.common.utils.R;
import com.yymt.common.utils.RWapper;
import com.yymt.entity.sport.ForumsEntity;
import com.yymt.entity.sport.ForumsGreatsEntity;
import com.yymt.service.ForumsGreatsService;
import com.yymt.service.ForumsService;
import com.yymt.service.MessageRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Map;



/**
 * 帖子点赞表
 *
 * @author cots
 * @date 2018-09-05 16:23:30
 */
@RestController
@RequestMapping("sport/forumsgreats")
//@Api(tags = "帖子点赞")
public class ForumsGreatsController extends BaseController{
    @Autowired
    private ForumsGreatsService forumsGreatsService;
    @Autowired
    private ForumsService forumsService;
    @Autowired
    private MessageRecordService messageRecordService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sport:forumsgreats:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = forumsGreatsService.queryPage(params);
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sport:forumsgreats:info")
    public R info(@PathVariable("id") Integer id){
        ForumsGreatsEntity forumsGreats = forumsGreatsService.selectById(id);
        return R.ok().put("forumsGreats", forumsGreats);
    }

    /**
     * 保存
     */
    @Login
    @PostMapping("/save")
    //@ApiOperation("帖子点赞/取消点赞")
    public RWapper save(@RequestBody ForumsGreatsEntity forumsGreats){

        int count = 0;
        forumsGreats.setUserId(getUserIdByToken());
        ForumsGreatsEntity queryEntity = forumsGreatsService.selectOne(new EntityWrapper<>(forumsGreats));
        if(queryEntity != null){
            forumsGreatsService.delete(new EntityWrapper<>(queryEntity));
            count = forumsGreatsService.queryGreatCountByForumsId(forumsGreats.getForumsId());
            return RWapper.ok().put("totalGreat",count).encode(isEncryption);
        }else{
            forumsGreats.setCreateTime(new Date());
            forumsGreatsService.insert(forumsGreats);
            count = forumsGreatsService.queryGreatCountByForumsId(forumsGreats.getForumsId());
            //增加消息记录
            ForumsEntity forumsEntity = forumsService.selectById(forumsGreats.getForumsId());
            messageRecordService.insertMsg(forumsGreats.getUserId(),forumsEntity.getUserId()
                    , Constant.MESSAGE_TYPE_MSG,Constant.MESSAGE_TAB_GREATS,Constant.MESSAGE_TAB_TYPE_GREATS_FORUMS,"赞了你的文章",forumsGreats.getForumsId());
            return RWapper.ok().put("totalGreat",count).encode(isEncryption);
        }
    }

    /**
     * 修改
     */
//    @RequestMapping("/update")
//    @RequiresPermissions("sport:forumsgreats:update")
//    public R update(@RequestBody ForumsGreatsEntity forumsGreats){
//		forumsGreatsService.updateById(forumsGreats);
//        return R.ok();
//    }

    /**
     * 删除
     */
//    @RequestMapping("/delete")
//    @RequiresPermissions("sport:forumsgreats:delete")
//    public R delete(@RequestBody Integer[] ids){
//		forumsGreatsService.deleteBatchIds(Arrays.asList(ids));
//        return R.ok();
//    }

    /**
     * 点赞的帖子
     */
    @Login
    @PostMapping("like")
    //@ApiOperation("喜欢的帖子")
    public RWapper like(@ApiParam("{\"isFriend\":true(查询（粉丝或者关注）喜欢false(查询自己),\"friendId\":11)}")@RequestBody Map<String,Object> params){
        Long userId = getUserIdByToken();
        params.put("userId",userId);
        PageUtils page = forumsGreatsService.like(params);
        return RWapper.ok().put("page",page).encode(isEncryption);
    }


}
