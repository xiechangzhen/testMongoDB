package com.yymt.modules.controller.sport;

import com.yymt.annotation.Login;
import com.yymt.common.exception.RRException;
import com.yymt.common.exception.ResultEnum;
import com.yymt.common.utils.Constant;
import com.yymt.common.utils.PageUtils;
import com.yymt.common.utils.R;
import com.yymt.common.utils.RWapper;
import com.yymt.entity.sport.FeedBackEntity;
import com.yymt.entity.sport.FeedbackMessageEntity;
import com.yymt.service.FeedBackService;
import com.yymt.service.FeedbackMessageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * 意见反馈表
 *
 * @author hgq
 * @date 2018-03-06 10:58:41
 */
@RestController
@RequestMapping("feedback")
@Api(tags = "意见反馈")
public class FeedBackController extends BaseController{

    @Autowired
    private FeedBackService feedBackService;
    @Autowired
    private FeedbackMessageService feedbackMessageService;
    /**
     * 列表
     */
    @Login
    @PostMapping("list")
    @ApiOperation("意见反馈列表")
    public RWapper list(@ApiParam(value = "{\"status\",\"（0未解决 1已解决）\"}") @RequestBody Map<String, Object> params){
        params.put("userId",getUserIdByToken());
        PageUtils page = feedBackService.queryPage(params);
        return RWapper.ok().put("page", page).encode(isEncryption);
    }


    /**
     * 信息
     */
    @Login
    @PostMapping("info/{id}")
    @ApiOperation("意见反馈详情")
    public RWapper info(@PathVariable("id") Integer id){
		Map feedBack = feedBackService.feedbackDetail(id);
        return RWapper.ok().put("feedBack", feedBack).encode(isEncryption);
    }

    /**
     * 保存
     */
    @Login
    @PostMapping("save")
    @ApiOperation("添加反馈")
    public RWapper save(@RequestBody FeedBackEntity feedBack){
        feedBack.setFeedBackCreate(new Date());
        feedBack.setFeedBackStatus(0);
        feedBack.setFeedBackUserId(getUserIdByToken());
		feedBackService.insert(feedBack);
        return RWapper.ok();
    }

    /**
     * 回复反馈
     */
    @Login
    @PostMapping("/reply")
    @ApiOperation("回复反馈")
    @Transactional
    public RWapper reply(@RequestBody FeedbackMessageEntity feedbackMessageEntity){
        feedbackMessageEntity.setReplyTime(new Date());
        feedbackMessageEntity.setUserId(getUserIdByToken());
        feedbackMessageEntity.setUserType(Constant.FEEDBACK_UER_TYPE_USER);
		feedbackMessageService.insert(feedbackMessageEntity);

        //更新反馈表的最后回复人和回复人类型
        FeedBackEntity feedBack = feedBackService.selectById(feedbackMessageEntity.getFeedbackId());
        if(feedBack == null){
            throw new RRException(ResultEnum.DATA_NOT_EXIST);
        }
        feedBack.setFeedBackLastReplyId(getUserIdByToken());
        feedBack.setFeedBackLastReplyType(Constant.FEEDBACK_UER_TYPE_USER);
        feedBackService.updateById(feedBack);

        return RWapper.ok();
    }

    /**
     * 会话列表
     */
    @Login
    @PostMapping("/messageList")
    @ApiOperation("回复会话列表")
    public RWapper messageList(@RequestBody Map<String, Object> params){
        List messageList = feedbackMessageService.messageList(params);
        return RWapper.ok().put("list", messageList).encode(isEncryption);
    }
}
