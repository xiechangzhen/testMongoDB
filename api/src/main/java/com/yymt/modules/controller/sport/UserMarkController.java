package com.yymt.modules.controller.sport;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.yymt.annotation.Login;
import com.yymt.common.utils.PageUtils;
import com.yymt.common.utils.R;
import com.yymt.common.utils.RWapper;
import com.yymt.entity.sport.UserMarkEntity;
import com.yymt.service.UserMarkService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.collections.map.HashedMap;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Map;


/**
 * 用户收藏表
 *
 * @author hgq
 * @date 2018-02-10 14:26:32
 */
@RestController
@RequestMapping("usermark")
//@Api(tags = "收藏")
public class UserMarkController extends BaseController {

    @Autowired
    private UserMarkService userMarkService;

    /**
     * 列表
     */
    @Login
    @PostMapping("list")
    //@ApiOperation("收藏列表")
    public RWapper list(@ApiParam(value = "{\"markType\":\"(0：文章,1:心健康，2:心情,3:求助,4:FM)\"}") @RequestBody Map<String, Object> params){
        params.put("userId",getUserIdByToken());
        PageUtils page = null;
        switch (Integer.parseInt(params.get("markType").toString())){
            case 2:
                page = userMarkService.selectFeelingsPage(params);
                break;
            case 3:
                page = userMarkService.selectHelpPage(params);
                break;
            case 0:
            case 4:
                page = userMarkService.selectNewsPage(params);
                break;
        }
        return RWapper.ok().put("page", page).encode(true);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sport:usermark:info")
    public R info(@PathVariable("id") Integer id){
			UserMarkEntity userMark = userMarkService.selectById(id);

        return R.ok().put("userMark", userMark);
    }
/*


    @PostMapping("ismark")
    //@ApiOperation("是否收藏")
    public R isMark(@RequestBody UserMarkEntity userMark){
        UserMarkEntity userMarkEntity = userMarkService.selectOne(new EntityWrapper<>(userMark));
        //查询是否已经收藏
        if(userMarkEntity != null){
            return R.ok().put("isMark",true);
        }else{
            return R.ok().put("isMark",false);
        }
    }
*/

    /**
     * 保存
     */
    @Login
    @PostMapping("save")
    //@ApiOperation("收藏")
    public R save(@RequestBody UserMarkEntity userMark){
        userMark.setUserId(getUserIdByToken());

        UserMarkEntity userMarkEntity = userMarkService.selectOne(new EntityWrapper<>(userMark));
        //查询是否已经收藏
        if(userMarkEntity != null){
            Map<String,Object> data = new HashedMap();
            data.put("id",userMark.getMarkId());
            data.put("type",userMark.getMarkType());
            return userMarkService.delete(new EntityWrapper<>(userMark))?R.ok().put("isMark",false).put("mark",userMarkService.queryCountById(data)):R.error();
        }else{
            userMark.setCreateTime(new Date());
            userMarkService.insert(userMark);
            Map<String,Object> data = new HashedMap();
            data.put("id",userMark.getMarkId());
            data.put("type",userMark.getMarkType());
            return R.ok().put("isMark",true).put("mark",userMarkService.queryCountById(data));
        }


    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sport:usermark:update")
    public R update(@RequestBody UserMarkEntity userMark){
			userMarkService.updateById(userMark);

        return R.ok();
    }

    /**
     * 删除
     */
    @Login
    @PostMapping("delete/{id}")
    //@ApiOperation("取消收藏")
    public R delete(@PathVariable("id") Long id,@PathVariable("type") Integer type){
        UserMarkEntity entity = new UserMarkEntity();
        entity.setMarkId(id);
        entity.setUserId(getUserIdByToken());
        entity.setMarkType(type);
        userMarkService.cancelMark(entity);
        return R.ok();
    }

}
