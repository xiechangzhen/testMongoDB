package com.yymt.modules.controller.sport;

import com.yymt.common.utils.PageUtils;
import com.yymt.common.utils.R;
import com.yymt.common.utils.RWapper;
import com.yymt.service.ColumnService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;



/**
 * 新闻栏目表
 *
 * @author hgq
 * @date 2018-02-10 14:26:32
 */
@RestController
@RequestMapping("mental/column")
//@Api(tags = "栏目")
public class ColumnController extends BaseController{
    @Autowired
    private ColumnService columnService;

    /**
     * 列表
     */
    @PostMapping("/list")
    //@ApiOperation("栏目列表")
    public RWapper list(@RequestBody Map<String, Object> params){
        params.put("limit",Integer.MAX_VALUE);
        PageUtils page = columnService.queryPage(params);
        return RWapper.ok().put("page", page).encode(isEncryption);
    }

}