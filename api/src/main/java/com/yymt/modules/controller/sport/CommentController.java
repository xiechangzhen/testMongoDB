package com.yymt.modules.controller.sport;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yymt.entity.sport.CommentEntity;
import com.yymt.service.CommentService;
import com.yymt.common.utils.PageUtils;
import com.yymt.common.utils.R;



/**
 * 评论表
 *
 * @author hgq
 * @date 2018-02-10 14:26:32
 */
@RestController
@RequestMapping("mental/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sport:comment:list")
    public R list(@RequestBody Map<String, Object> params){
        PageUtils page = commentService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sport:comment:info")
    public R info(@PathVariable("id") Integer id){
			CommentEntity comment = commentService.selectById(id);

        return R.ok().put("comment", comment);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sport:comment:save")
    public R save(@RequestBody CommentEntity comment){
			commentService.insert(comment);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sport:comment:update")
    public R update(@RequestBody CommentEntity comment){
			commentService.updateById(comment);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sport:comment:delete")
    public R delete(@RequestBody Integer[] ids){
			commentService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
