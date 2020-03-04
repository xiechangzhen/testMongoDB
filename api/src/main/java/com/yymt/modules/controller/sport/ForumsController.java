package com.yymt.modules.controller.sport;

import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.yymt.annotation.Login;
import com.yymt.common.exception.RRException;
import com.yymt.common.exception.ResultEnum;
import com.yymt.common.utils.*;
import com.yymt.entity.api.IndexCategory;
import com.yymt.entity.api.UserEntity;
import com.yymt.entity.sport.*;
import com.yymt.search.LuceneUtils;
import com.yymt.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 社区论坛帖子表
 *
 * @author cots
 * @date 2018-09-05 16:23:30
 */
@RestController
@RequestMapping("sport/forums")
//@Api(tags = "帖子")
public class ForumsController extends BaseController {
    @Autowired
    private ForumsService forumsService;
    @Autowired
    private ForumsGreatsService forumsGreatsService;
    @Autowired
    private ForumsCommentService forumsCommentService;
    @Autowired
    private ForumsCommentGreatsService forumsCommentGreatsService;
    @Autowired
    private UserFollowService userFollowService;

    @Autowired
    private JPushClient jPushClient;

    /**
     * 社区列表
     */
    @PostMapping("/list")
    //@ApiOperation("帖子列表")
    public RWapper list(@ApiParam(value = "{\"tab\":\"1-关注 2-推荐 3-运动健身 4-营养\"}") @RequestBody Map<String, Object> params) {
        Long loginUserId = getUserIdByTokenWithoutValidate();
        if (loginUserId == null) {//用户未登陆时，赋值-1，用于将结果返回为未点赞
            loginUserId = -1L;
        }
        params.put("loginUserId", loginUserId);

        if (params.get("tab") != null) {
            Integer tab = Integer.parseInt(params.get("tab").toString());
            if (tab == 1) {//关注:包括自己发的和关注人发的
                List<UserFollowEntity> list = userFollowService.selectList(new EntityWrapper<UserFollowEntity>().eq("user_id", loginUserId));
                Long[] follows = new Long[list.size() + 1];
                follows[0] = loginUserId;
                for (int i = 0; i < list.size(); i++) {
                    UserFollowEntity tmp = list.get(i);
                    follows[i + 1] = tmp.getFollowId();
                }
                params.put("follows", follows);
            } else if (tab == 2) {//推荐
                params.put("isRecommend", 1);
            } else if (tab == 3) {//运动健身
                params.put("forumsType", Constant.FORUMS_TYPE_SPORT);
            } else if (tab == 4) {//营养
                params.put("forumsType", Constant.FORUMS_TYPE_NUTRITION);
            }
        }
        PageUtils page = forumsService.selectForumsList(params);
        return RWapper.ok().put("page", page).encode(isEncryption);
    }

    /**
     * 社区列表
     */
    @Login
    @PostMapping("/listFriendForums")
    //@ApiOperation("获取粉丝或者关注的帖子列表")
    public RWapper listFansOrFollowForums(@ApiParam("{\"userId\":11}") @RequestBody Map<String, Object> params) {
        Long loginUserId = getUserIdByToken();
        params.put("loginUserId", loginUserId);
        /*//判断该用户是否关注此ID的用户
        Integer count = userFollowService.isFollowOrFans(params);
        if (count == 0) {
            return RWapper.error("不允许访问");
        }*/
        PageUtils page = forumsService.selectForumsList(params);
        return RWapper.ok().put("page", page).encode(isEncryption);
    }


    /**
     * 我的帖子列表
     * 需要登录
     */
    @Login
    @PostMapping("/myList")
    //@ApiOperation("我的帖子列表")
    public RWapper myList(@RequestBody Map<String, Object> params) {
        Long userId = getUserIdByToken();
        params.put("userId", userId);
        params.put("loginUserId", userId);
        PageUtils page = forumsService.selectForumsList(params);
        return RWapper.ok().put("page", page).encode(isEncryption);
    }

    /**
     * 信息
     */
    @CrossOrigin
    @PostMapping("/info/{id}")
    //@ApiOperation("帖子详情")
    public RWapper info(@PathVariable("id") Integer id) {

        ForumsEntity entity = forumsService.selectById(id);
        if (entity == null) {
            throw new RRException(ResultEnum.DATA_NOT_EXIST);
        }
        entity.setPageView(entity.getPageView() + 1);
        forumsService.updateById(entity);//增加访问数

        Map<String, Object> params = new HashMap<>();
        Long loginUserId = getUserIdByTokenWithoutValidate();
        if (loginUserId == null) {//用户未登陆时，赋值-1，用于将结果返回为未点赞
            loginUserId = -1L;
        }
        params.put("loginUserId", loginUserId);
        params.put("forumsId", id);
        params.put("followId", entity.getUserId());//帖子发布人
        Map forums = forumsService.selectForumsDetail(params);

        return RWapper.ok().put("forums", forums).encode(isEncryption);
    }

    /**
     * 保存
     */
    @Login
    @PostMapping("/save")
    //@ApiOperation("发布帖子")
    public RWapper save(@RequestBody ForumsEntity forums) throws IOException {
        forums.setUserId(getUserIdByToken());
        forums.setCreateTime(new Date());
        boolean isSuccess = forumsService.insert(forums);
        if (isSuccess) {
            //发布帖子才推送群消息
            List<String> clientIdList = userFollowService.queryFansPushClientId(getUserIdByToken());
            PushResult pushResult = null;
            if (clientIdList != null && clientIdList.size() != 0) {
                try {
                    UserEntity userEntity = getUserInfoByToken();
                    pushResult = jPushClient.sendPush(JPushUtils.buildPushAlertObject("您关注的好友 " + userEntity.getNickName() + " 发布了新的帖子<<" + forums.getContent() + ">>", Constant.PUSH_TYPE_FORUMS, forums.getId(), clientIdList));
                    System.out.println("Result :" + pushResult);
                } catch (APIConnectionException e) {
                    e.printStackTrace();
                } catch (APIRequestException e) {
                    e.printStackTrace();
                    System.out.println("HTTP Status: " + e.getStatus());
                    System.out.println("Error Code: " + e.getErrorCode());
                    System.out.println("Error Message: " + e.getErrorMessage());
                }
            }

            addOrUpdateSearchIndex(forums);

        }
        return RWapper.ok().put("forumsId", forums.getId()).encode(isEncryption);
    }

    private void addOrUpdateSearchIndex(ForumsEntity forums) throws IOException {
        IndexCategory category;
        if (forums.getForumsType() == Constant.FORUMS_TYPE_SPORT) {
            category = IndexCategory.EXERCISE_FITNESS;
        } else if (forums.getForumsType() == Constant.FORUMS_TYPE_NUTRITION) {
            category = IndexCategory.NUTRITION;
        } else {
            category = IndexCategory.OTHER_FORUMS_TYPE;
        }

        LuceneUtils.deleteIndexItem(category, forums.getId());
        LuceneUtils.indexItem(category, forums.getId(), "", forums.getContent());
    }

    /**
     * 修改
     */
//    @RequestMapping("/update")
//    public R update(@RequestBody ForumsEntity forums){
//		forumsService.updateById(forums);
//        return R.ok();
//    }

    /**
     * 删除
     */
    @Login
    @PostMapping("delete/{id}")
    //@ApiOperation("删除帖子")
    @Transactional
    public R delete(@PathVariable("id") Integer id) throws IOException {
        //需要删除点赞、评论

        ForumsEntity forums = forumsService.selectById(id);

        forumsGreatsService.delete(new EntityWrapper<ForumsGreatsEntity>().eq("forums_id", id));
        forumsCommentService.delete(new EntityWrapper<ForumsCommentEntity>().eq("forums_id", id));
        forumsCommentGreatsService.delete(new EntityWrapper<ForumsCommentGreatsEntity>().eq("forums_id", id));
        forumsService.deleteById(id);

        IndexCategory category;
        if (forums.getForumsType() == Constant.FORUMS_TYPE_SPORT) {
            category = IndexCategory.EXERCISE_FITNESS;
        } else if (forums.getForumsType() == Constant.FORUMS_TYPE_NUTRITION) {
            category = IndexCategory.NUTRITION;
        } else {
            category = IndexCategory.OTHER_FORUMS_TYPE;
        }
        LuceneUtils.deleteIndexItem(category, forums.getId());

        return R.ok();
    }

}
