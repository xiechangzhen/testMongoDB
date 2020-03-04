package com.yymt.modules.controller.sport;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.yymt.annotation.Login;
import com.yymt.common.utils.Constant;
import com.yymt.common.utils.PageUtils;
import com.yymt.common.utils.R;
import com.yymt.common.utils.RWapper;
import com.yymt.entity.sport.ForumsCommentEntity;
import com.yymt.entity.sport.ForumsCommentGreatsEntity;
import com.yymt.entity.sport.ForumsEntity;
import com.yymt.service.ForumsCommentGreatsService;
import com.yymt.service.ForumsCommentService;
import com.yymt.service.ForumsService;
import com.yymt.service.MessageRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Map;



/**
 * 帖子评论点赞表
 *
 * @author cots
 * @date 2018-09-05 16:23:30
 */
@RestController
@RequestMapping("sport/forumscommentgreats")
//@Api(tags = "帖子评论点赞")
public class ForumsCommentGreatsController extends BaseController{
    @Autowired
    private ForumsCommentGreatsService forumsCommentGreatsService;
    @Autowired
    private ForumsCommentService forumsCommentService;
    @Autowired
    private ForumsService forumsService;
    @Autowired
    private MessageRecordService messageRecordService;

    /**
     * 列表
     */
    @RequestMapping("/list")

    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = forumsCommentGreatsService.queryPage(params);
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id){
        ForumsCommentGreatsEntity forumsCommentGreats = forumsCommentGreatsService.selectById(id);
        return R.ok().put("forumsCommentGreats", forumsCommentGreats);
    }

    /**
     * 保存
     */
    @Login
    @PostMapping("/save/{forumsCommentId}")
    //@ApiOperation("评论点赞/取消点赞")
    public RWapper save(@PathVariable("forumsCommentId") Integer forumsCommentId){

        int count = 0;
        ForumsCommentGreatsEntity forumsCommentGreats = new ForumsCommentGreatsEntity();
        forumsCommentGreats.setUserId(getUserIdByToken());
        forumsCommentGreats.setForumsCommentId(forumsCommentId);
        ForumsCommentGreatsEntity queryEntity = forumsCommentGreatsService.selectOne(new EntityWrapper<>(forumsCommentGreats));
        if(queryEntity != null){
            forumsCommentGreatsService.delete(new EntityWrapper<>(queryEntity));
            count = forumsCommentGreatsService.queryGreatCountByForumsId(forumsCommentId);
            return RWapper.ok().put("totalGreat",count).encode(isEncryption);
        }else{
            //查询评论获取帖子id
            ForumsCommentEntity commentEntity = forumsCommentService.selectOne(new EntityWrapper<ForumsCommentEntity>().eq("id",forumsCommentId));
            forumsCommentGreats.setForumsId(commentEntity.getForumsId());
            forumsCommentGreats.setCreateTime(new Date());
            forumsCommentGreatsService.insert(forumsCommentGreats);
            count = forumsCommentGreatsService.queryGreatCountByForumsId(forumsCommentId);
            //增加消息记录
            ForumsEntity forumsEntity = forumsService.selectById(commentEntity.getForumsId());
            messageRecordService.insertMsg(forumsCommentGreats.getUserId(),forumsEntity.getUserId()
                    , Constant.MESSAGE_TYPE_MSG,Constant.MESSAGE_TAB_GREATS,Constant.MESSAGE_TAB_TYPE_GREATS_FORUMS_COMMENT,"赞了你的评论",commentEntity.getId());
            return RWapper.ok().put("totalGreat",count).encode(isEncryption);
        }
    }

//    /**
//     * 修改
//     */
//    @RequestMapping("/update")
//    public R update(@RequestBody ForumsCommentGreatsEntity forumsCommentGreats){
//		forumsCommentGreatsService.updateById(forumsCommentGreats);
//        return R.ok();
//    }
//
//    /**
//     * 删除
//     */
//    @RequestMapping("/delete")
//    public R delete(@RequestBody Integer[] ids){
//		forumsCommentGreatsService.deleteBatchIds(Arrays.asList(ids));
//        return R.ok();
//    }

}
