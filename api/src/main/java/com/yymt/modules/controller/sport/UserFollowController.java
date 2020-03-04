package com.yymt.modules.controller.sport;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.yymt.annotation.Login;
import com.yymt.common.exception.ResultEnum;
import com.yymt.common.utils.PageUtils;
import com.yymt.common.utils.RWapper;
import com.yymt.entity.api.UserEntity;
import com.yymt.entity.sport.UserFollowEntity;
import com.yymt.service.MessageRecordService;
import com.yymt.service.UserFollowService;
import com.yymt.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import static com.yymt.common.utils.Constant.*;


/**
 * 用户关注表
 *
 * @author hgq
 * @date 2018-02-10 14:26:32
 */
@RestController
@RequestMapping("userfollow")
//@Api(tags="用户关注")
public class UserFollowController extends BaseController {
    @Autowired
    private UserFollowService userFollowService;
    @Autowired
    private MessageRecordService messageRecordService;
    @Autowired
    private UserService userService;


    /**
     * 列表
     */
    @Login
    @PostMapping("list")
    //@ApiOperation("我的关注/粉丝列表")
    public RWapper list(@ApiParam(value = "{\"isFollow\",\"true-我的关注,false-我的粉丝\"}") @RequestBody Map<String, Object> params){
        params.put("userId",getToken().getUserId());
        PageUtils page = userFollowService.selectUserFollowPage(params);
        Map counter = userFollowService.userFriendsCount(params);
        return RWapper.ok().put("page", page).put("counter",counter).encode(isEncryption);
    }


    /**
     * 信息
     */
    @PostMapping("info/{id}")
    //@ApiOperation("关注详情")
    public RWapper info(@PathVariable("id") Integer id){
			UserFollowEntity userFollow = userFollowService.selectById(id);
        return RWapper.ok().put("userFollow", userFollow).encode(isEncryption);
    }


    @PostMapping("isfollow")
    //@ApiOperation("是否关注")
    public RWapper isMark(@RequestBody UserFollowEntity userFollowEntity){
         userFollowEntity = userFollowService.selectOne(new EntityWrapper<>(userFollowEntity));
        //查询是否已经收藏
        if(userFollowEntity != null){
            return RWapper.ok().put("isfollow",true).encode(isEncryption);
        }else{
            return RWapper.ok().put("isfollow",false).encode(isEncryption);
        }
    }

    /**
     * 保存
     */
    @Login
    @PostMapping("save")
    //@ApiOperation("添加或取消关注")
    public RWapper save(@RequestBody UserFollowEntity userFollow){
        userFollow.setUserId(getUserIdByToken());
        if(userFollow.getFollowId().equals(userFollow.getUserId())){
            return RWapper.error(ResultEnum.SELF_CAN_NOT_FOLLOW_SELF);
        }
        //账号被禁用
        UserEntity userEntity = userService.selectById(userFollow.getFollowId());
        if(userEntity.getUserStatus() == USER_STATUS_DISABLED){
            return RWapper.error(ResultEnum.USER_FORBID);
        }
        UserFollowEntity userFollowEntity = userFollowService.selectOne(new EntityWrapper<>(userFollow));
        if(userFollowEntity != null){
            return userFollowService.delete(new EntityWrapper<>(userFollow))?RWapper.ok().put("isFollow",false).encode(isEncryption):RWapper.error();
        }else{
            userFollow.setCreateTime(new Date());
            userFollowService.insert(userFollow);
            //增加消息记录
            messageRecordService.insertMsg(userFollow.getUserId(),userFollow.getFollowId(),
                    MESSAGE_TYPE_MSG,MESSAGE_TAB_FOLLOW,MESSAGE_TAB_TYPE_FOLLOW_PERSON,"关注了你",userFollow.getId());
            return RWapper.ok().put("isFollow",true).encode(isEncryption);
        }
    }

    /**
     * 用于注册引导页 推荐关注的用户
     */
    @Login
    @PostMapping("batch")
    //@ApiOperation("批量添加关注")
    public RWapper batch(@RequestBody long[] follows){

        if(follows != null && follows.length>0){
            List<UserFollowEntity> data = parseFollows(follows,getUserIdByToken());
            boolean isSuccess = userFollowService.insertBatch(data);
            if(isSuccess){
                //增加消息记录
                for (UserFollowEntity entity: data) {
                    messageRecordService.insertMsg(entity.getUserId(), entity.getFollowId(),
                            MESSAGE_TYPE_MSG, MESSAGE_TAB_FOLLOW, MESSAGE_TAB_TYPE_FOLLOW_PERSON, "关注了你", entity.getId());
                    return RWapper.ok().put("isFollow", true).encode(true);
                }
            }else{
                return RWapper.error("关注失败");
            }

        }else{
            return RWapper.error("关注ID为空");
        }
        return null;
    }

    private List<UserFollowEntity> parseFollows(long[] follows ,long userid) {
        List<UserFollowEntity> data = new ArrayList<>();
        Date date = new Date();
        for (long follow: follows) {
            UserFollowEntity entity = new UserFollowEntity();
            entity.setUserId(userid);
            entity.setFollowId(follow);
            entity.setCreateTime(date);
            data.add(entity);
        }
        return data;
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sport:userfollow:update")
    public RWapper update(@RequestBody UserFollowEntity userFollow){
			userFollowService.updateById(userFollow);
        return RWapper.ok();
    }

    /**
     * 删除
     */
    @Login
    @PostMapping("delete")
    public RWapper delete(@RequestBody Integer[] ids){
			userFollowService.deleteBatchIds(Arrays.asList(ids));
        return RWapper.ok();
    }


    /**
     * 查询列表
     */
    @Login
    @PostMapping("listFans")
    //@ApiOperation("查询粉丝的粉丝列表")
    public RWapper listFans(@ApiParam(value = "{\"friendId\":11}") @RequestBody Map<String, Object> params){
        params.put("userId",getToken().getUserId());
        PageUtils page = userFollowService.selectFansList(params);
        return RWapper.ok().put("page", page).encode(isEncryption);
    }

    /**
     * 列表
     */
    @Login
    @PostMapping("listFollow")
    //@ApiOperation("查询粉丝的关注列表")
    public RWapper listFollows(@ApiParam(value = "{\"friendId\":11}") @RequestBody Map<String, Object> params){
        params.put("userId",getToken().getUserId());
        PageUtils page = userFollowService.selectFollowList(params);
        return RWapper.ok().put("page", page).encode(isEncryption);
    }

}
