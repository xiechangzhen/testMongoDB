package com.yymt.modules.controller.sport;

import java.util.Arrays;
import java.util.Map;

import com.yymt.service.sport.EmployService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.yymt.entity.sport.EmployEntity;
import com.yymt.common.utils.PageUtils;
import com.yymt.common.utils.R;



/**
 * 员工信息表
 *
 * @author cots
 * @date 2020-02-02 11:36:17
 */
@RestController
@RequestMapping("employ")
@Api(tags = "员工信息表")
public class EmployController {
    @Autowired
    private EmployService employService;

    /**
     * 信息
     */
    @CrossOrigin
    @PostMapping("/info/{id}")
    @ApiOperation("员工信息")
    public R info(@PathVariable("id") Integer id){
        EmployEntity employ = employService.selectById(id);
        return R.ok().put("employ", employ);
    }
}
