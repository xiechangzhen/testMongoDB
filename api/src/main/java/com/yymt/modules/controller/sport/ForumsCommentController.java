package com.yymt.modules.controller.sport;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.yymt.annotation.Login;
import com.yymt.common.utils.Constant;
import com.yymt.common.utils.PageUtils;
import com.yymt.common.utils.R;
import com.yymt.common.utils.RWapper;
import com.yymt.entity.sport.ForumsCommentEntity;
import com.yymt.entity.sport.ForumsEntity;
import com.yymt.service.ForumsCommentService;
import com.yymt.service.ForumsService;
import com.yymt.service.MessageRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;



/**
 * 帖子评论表
 *
 * @author cots
 * @date 2018-09-05 16:23:30
 */
@RestController
@RequestMapping("sport/forumscomment")
//@Api(tags = "帖子评论表")
public class ForumsCommentController extends BaseController{
    @Autowired
    private ForumsCommentService forumsCommentService;
    @Autowired
    private ForumsService forumsService;
    @Autowired
    private MessageRecordService messageRecordService;

    /**
     * 列表
     */
    @CrossOrigin
    @PostMapping("/list")
    //@ApiOperation("帖子评论列表")
    public RWapper list(@RequestBody Map<String, Object> params){
        Long userId = getUserIdByTokenWithoutValidate();
        params.put("userId",userId);
        PageUtils page = forumsCommentService.selectCommentList(params);
        List list = page.getList();
        Map param = new HashedMap();
        for(int i = 0; i < list.size();i++){
            Map map = (Map) list.get(i);
            param.put("parent_id",map.get("id"));
            List childComment =forumsCommentService.selectChildCommentList(Integer.parseInt(map.get("id").toString()),true,getUserIdByTokenWithoutValidate());
            map.put("childComment",childComment);
        }
        return RWapper.ok().put("page", page).encode(isEncryption);
    }

    @PostMapping("/childList")
    //@ApiOperation("获取根评论下的所有评论")
    public RWapper childList(@ApiParam("{\"forumsId\":1,\"rootCommentId\":2}") @RequestBody Map<String, Object> params){

        Long userId = getUserIdByTokenWithoutValidate();
        params.put("userId",userId);
        List data = forumsCommentService.selectChildCommentListWithLevel(params);
        return RWapper.ok().put("childComment",data).encode(isEncryption);
    }


    /**
     * 信息
     */
    @PostMapping("/info/{id}")
    //@ApiOperation("评论详情")
    public RWapper info(@PathVariable("id") Integer id){
        Map forumsComment = forumsCommentService.selectCommentDetail(id);
        List childComment =forumsCommentService.selectChildCommentList(id,false,getUserIdByTokenWithoutValidate());
        return RWapper.ok().put("forumsComment", forumsComment).put("childComment",childComment).encode(isEncryption);
    }

    /**
     * 保存
     */
    @Login
    @PostMapping("/save")
    //@ApiOperation("发布帖子评论/回复评论")
    @Transactional
    public R save(@RequestBody ForumsCommentEntity forumsComment){
        forumsComment.setUserId(getUserIdByToken());
        forumsComment.setCreateTime(new Date());
		forumsCommentService.insert(forumsComment);

		ForumsCommentEntity queryEntity = forumsCommentService.selectById(forumsComment.getId());

        //如果评论的父ID为空，则消息接收方为发布者；如果父ID不空，则消息接收方为当前评论的父ID的评论人。
        Long toUserId;
        String messageContent = "评论了你的文章";
        if(queryEntity.getParentId() != 0){//查询父评论的评论人
            ForumsCommentEntity parentForumsComment = forumsCommentService.selectOne(
                    new EntityWrapper<ForumsCommentEntity>().eq("parent_id",queryEntity.getParentId())
            );
            toUserId = parentForumsComment == null? 0 : parentForumsComment.getUserId();
            messageContent = "回复了你的评论";
        }else {//查询发布者
            ForumsEntity forumsEntity = forumsService.selectById(forumsComment.getForumsId());
            toUserId = forumsEntity.getUserId();
        }
        messageRecordService.insertMsg(queryEntity.getUserId(),toUserId
                , Constant.MESSAGE_TYPE_MSG,Constant.MESSAGE_TAB_COMMENT,Constant.MESSAGE_TAB_TYPE_FORUMS_COMMENT,messageContent,queryEntity.getId());
        return R.ok();
    }

   /**
     * 修改
     *//*
    @Login
    @PostMapping("/update")
    //@ApiOperation("修改帖子")
    public R update(@RequestBody ForumsCommentEntity forumsComment){
		forumsCommentService.updateById(forumsComment);
        return R.ok();
    }*/

    /**
     * 删除
     */
    @Login
    @PostMapping("/delete")
    //@ApiOperation("删除")
    public R delete(@RequestBody Integer[] ids){
		forumsCommentService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

}
