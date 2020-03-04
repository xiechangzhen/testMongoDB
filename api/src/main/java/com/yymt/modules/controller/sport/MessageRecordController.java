package com.yymt.modules.controller.sport;

import com.yymt.annotation.Login;
import com.yymt.common.utils.PageUtils;
import com.yymt.common.utils.R;
import com.yymt.common.utils.RWapper;
import com.yymt.entity.sport.MessageRecordEntity;
import com.yymt.service.MessageRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;



/**
 * 消息记录表
 *
 * @author hgq
 * @date 2018-03-20 19:24:00
 */
@RestController
@RequestMapping("messagerecord")
@Api(tags = "消息")
public class MessageRecordController extends BaseController{
    @Autowired
    private MessageRecordService messageRecordService;


    @Login
    @PostMapping("/receivedFocusList")
    //@ApiOperation("收到的关注")
    public RWapper receivedFocusList(
                      @RequestBody Map<String, Object> params){
        params.put("userId",getUserIdByToken());
        PageUtils page = messageRecordService.queryFocusPage(params);
        return RWapper.ok().put("page", page).encode(isEncryption);
    }

    @Login
    @PostMapping("/receivedCommentList")
    //@ApiOperation(value = "收到的评价",notes = "messageTabType:5-社区评论8-社区评论的回复")
    public RWapper receivedCommentList(
                      @RequestBody Map<String, Object> params){
        params.put("userId",getUserIdByToken());
        PageUtils page = messageRecordService.queryCommentPage(params);
        return RWapper.ok().put("page", page).encode(isEncryption);
    }

    @Login
    @PostMapping("/receivedGreatList")
    //@ApiOperation(value = "收到的赞",notes="messageTabType:2-社团点赞3-社区点赞4-社区评论点赞")
    public RWapper receivedGreatList(
                      @RequestBody Map<String, Object> params){
        params.put("userId",getUserIdByToken());
        PageUtils page = messageRecordService.queryGreatPage(params);
        return RWapper.ok().put("page", page).encode(isEncryption);
    }

    @Login
    @PostMapping("/messageStatus")
    //@ApiOperation("是否有未读消息")
    public RWapper messageStatus(){
        Map result = messageRecordService.messageStatus(getUserIdByToken());
        return RWapper.ok().put("count", result).encode(isEncryption);
    }

    /**
     * 标志所有已读
     */
    @Login
    @PostMapping("/changeStatus/{messageType}")
    //@ApiOperation("标志所有已读")
    public RWapper changeStatus(@ApiParam("（赞-1，评论-2，关注-3）")@PathVariable("messageType") Integer messageType){
        Map param = new HashedMap();
        param.put("userId",getUserIdByToken());
        param.put("messageType",messageType);
        messageRecordService.changeMessageStatus(param);
        return RWapper.ok();
    }




    /**
     * 信息
     */
    @PostMapping("/info/{id}")
    public RWapper info(@PathVariable("id") Integer id){
			MessageRecordEntity messageRecord = messageRecordService.selectById(id);
        return RWapper.ok().put("messageRecord", messageRecord).encode(isEncryption);
    }

    /**
     * 更改消息阅读状态
     */
    @Login
    @PostMapping("/read/{id}")
    //@ApiOperation("查看消息")
    public R read(@PathVariable("id") Integer id){
        MessageRecordEntity messageRecordEntity = new MessageRecordEntity();
        messageRecordEntity.setId(id);
        messageRecordEntity.setIsRead(1);
		messageRecordService.updateById(messageRecordEntity);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
			messageRecordService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
