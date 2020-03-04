package com.yymt.modules.controller.sport;

import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.yymt.annotation.Login;
import com.yymt.common.exception.ResultEnum;
import com.yymt.common.utils.Constant;
import com.yymt.common.utils.JPushUtils;
import com.yymt.common.utils.PageUtils;
import com.yymt.common.utils.R;
import com.yymt.entity.api.UserEntity;
import com.yymt.entity.sport.MessageEntity;
import com.yymt.service.MessageRecordService;
import com.yymt.service.MessageService;
import com.yymt.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.collections.map.HashedMap;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import static com.yymt.common.utils.Constant.*;


/**
 * 互动留言表
 *
 * @author hgq
 * @date 2018-03-14 15:07:41
 */
@RestController
@RequestMapping("message")
@Api(tags = "互动留言")
public class MessageController  extends BaseController{
    @Autowired
    private MessageService messageService;
    @Autowired
    private MessageRecordService messageRecordService;
    @Autowired
    private UserService userService;

    @Autowired
    private JPushClient jPushClient;

    private static final int LIMIT_NORMAL_USER_MESSAGE_COUNT = 10;

    /**
     * 列表
     */
    @Login
    @PostMapping("list")
    //@ApiOperation("留言列表")
    public R list(@ApiParam(value = "{\"userId2\":\"对方用户聊天ID\"}") @RequestBody Map<String, Object> params) {
        params.put("userId1",getUserIdByToken());
        PageUtils page = messageService.selectMessagePage(params);
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sport:message:info")
    public R info(@PathVariable("id") Long id) {
        MessageEntity message = messageService.selectById(id);
        return R.ok().put("message", message);
    }

    @Login
    @PostMapping("limit/{userid}")
    //@ApiOperation("获取剩余留言条数")
    public R messageLimit(@PathVariable("userid") Long userid){
        UserEntity userEntity = getUserInfoByToken();
        Map<String,Object> param = new HashedMap();
        param.put("fromUserId",userEntity.getUserId());
        param.put("toUserId",userid);
        int count = messageService.queryMessageCountByDay(param);
        return  R.ok().put("limit",LIMIT_NORMAL_USER_MESSAGE_COUNT-count);
    }

    /**
     * 保存
     */
    /*@Login
    @PostMapping("pushReceipt/{toUserId}")
    //@ApiOperation("推送回执")
    public R pushReceipt(@PathVariable("toUserId") Long toUserId){
        UserEntity fromUserId = getUserInfoByToken();
        UserEntity userEntity = userService.selectById(toUserId);
        if(userEntity == null){
            return R.error(ResultEnum.USER_NOT_EXIST);
        }else{
            PushResult pushResult = null;
            try {
                String name = fromUserId.getUserType()== 0?fromUserId.getNickName():fromUserId.getNickName();
                        pushResult = jPushClient.sendPush(JPushUtils.buildPushObject(name+" 已经查看了您的留言","{\"status\":\"readedReceipt\",\"fromUserId\":"+fromUserId+"}",Arrays.asList(userEntity.getUsername())));
                System.out.println("Result :"+pushResult);
            } catch (APIConnectionException e) {
                e.printStackTrace();
            } catch (APIRequestException e) {
                e.printStackTrace();
                System.out.println("HTTP Status: " + e.getStatus());
                System.out.println("Error Code: " + e.getErrorCode());
                System.out.println("Error Message: " + e.getErrorMessage());
            }
            return R.ok().put("pushResult",pushResult);
        }
    }
*/

    /**
     * 保存
     */
    @Login
    @PostMapping("save")
    //@ApiOperation("添加留言")
    public R save(@RequestBody MessageEntity message) {

        //判断普通用户发送数量是否chao超出每天20条
        UserEntity entity = getUserInfoByToken();
        Integer count = 0;
        if(entity.getUserType() == 0){
            Map<String,Object> param = new HashedMap();
            param.put("fromUserId",entity.getUserId());
            param.put("toUserId",message.getToUserId());
            count =  messageService.queryMessageCountByDay(param);
            if(count >= LIMIT_NORMAL_USER_MESSAGE_COUNT ){
                return R.error(ResultEnum.OVER_LIMIT_MESSAGE_COUNT);
            }
        }

        long userId = getUserIdByToken();
        if(userId == message.getToUserId()){
            //自己不能给自己留言
            return R.error(ResultEnum.CAN_NOT_REPLY_SELF);
        }

        //账号被禁用
        UserEntity userEntity = userService.selectById(message.getToUserId());
        if (userEntity == null) return R.error("目标用户不存在");
        if(userEntity.getUserStatus() == USER_STATUS_DISABLED){
            return R.error(ResultEnum.USER_FORBID);
        }

        message.setFromUserId(userId);
        message.setCreateTime(new Date());
        messageService.insert(message);
        //增加消息记录
        //查询是否有留言记录
        MessageEntity messageEntity = messageService.selectOne(
                new EntityWrapper<MessageEntity>().eq("from_user_id",message.getFromUserId()).eq("to_user_id",message.getToUserId())
        );
        String messageContent;
        if(messageEntity == null){//不存在表示第一次留言
            messageContent = "对你留言了";
        }else {//回复留言
            messageContent = "回复了你";
        }
//        messageRecordService.insertMsg(message.getFromUserId(),message.getToUserId(),
//                MESSAGE_TYPE_WORDS,MESSAGE_TAB_WORDS,MESSAGE_TAB_TYPE_WORDS,messageContent,message.getId().intValue());

        UserEntity toUserEntity = userService.selectById(message.getToUserId());
        if(toUserEntity == null){
            return R.error("目标用户不存在");
        }
        PushResult pushResult = null;
        try {
            String name = userEntity.getUserType()==1?userEntity.getRealName():userEntity.getNickName();
            pushResult = jPushClient.sendPush(JPushUtils.buildPushObject( "{\"message\":\""+name+":"+message.getLeaveMessage()+"\",\"fromUserId\":"+message.getFromUserId()+",\"toUserId\":"+message.getToUserId()+"}",Arrays.asList(toUserEntity.getUsername())));
            System.out.println("Result :"+pushResult);
             pushResult = jPushClient.sendPush(JPushUtils.buildPushAlertObjectToIOS( "您有新的消息",Constant.PUSH_TYPE_MESSAGE,message.getId(),Arrays.asList(toUserEntity.getUsername())));
             System.out.println("Result :"+pushResult);
        } catch (APIConnectionException e) {
            e.printStackTrace();
        } catch (APIRequestException e) {
            e.printStackTrace();
            System.out.println("HTTP Status: " + e.getStatus());
            System.out.println("Error Code: " + e.getErrorCode());
            System.out.println("Error Message: " + e.getErrorMessage());
        }
        return entity.getUserType() != 0 ? R.ok():R.ok().put("limit",(LIMIT_NORMAL_USER_MESSAGE_COUNT-count-1));//-1 count是在本次未发之前查询出来的
    }


    /**
     * 修改
     */
    @Login
    @PostMapping("update")
    //@ApiOperation("修改消息状态")
    public R update(@RequestBody MessageEntity message) {
        //更新数据
        message.setToUserId(getUserIdByToken());
        message.setStatus(MessageStatus.TRUE.getValue());

        //查询的数据
        MessageEntity queryEntity = new MessageEntity();
        queryEntity.setToUserId(getUserIdByToken());
        queryEntity.setFromUserId(message.getFromUserId());

        messageService.update(message,new EntityWrapper<>(queryEntity));
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sport:message:delete")
    public R delete(@RequestBody Long[] ids) {
        messageService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

}
