package com.yymt.modules.controller.sport;

import com.yymt.common.utils.R;
import com.yymt.entity.sport.UserShareEntity;
import com.yymt.service.UserShareService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;



/**
 * 用户分享表
 *
 * @author hgq
 * @date 2018-06-22 11:25:35
 */
//@Api(tags = "用户分享")
@RestController
@RequestMapping("usershare")
public class UserShareController extends BaseController{
    @Autowired
    private UserShareService userShareService;
    /**
     * 保存
     */
//    @Login
    @PostMapping("save")
    //@ApiOperation("分享")
    public R save(@RequestBody UserShareEntity userShare){
        userShare.setUserId(getUserIdByTokenWithoutValidate());
        userShare.setCreateTime(new Date());
		userShareService.insert(userShare);
		Map<String,Object> data = new HashMap<>();
        data.put("id",userShare.getShareId());
        data.put("type",userShare.getShareType());//分享类型(0：新闻,1:赛事,2:场馆,3:社团4人员5指南6机构7社区)
        return R.ok().put("share",userShareService.queryCountById(data));
    }

}
