package com.yymt.modules.controller.sport;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import com.yymt.entity.sport.EmployEntity;
import com.yymt.service.sport.EmployReportService;
import com.yymt.service.sport.EmployService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.yymt.entity.sport.EmployReportEntity;
import com.yymt.common.utils.R;



/**
 * 员工信息上报
 *
 * @author cots
 * @date 2020-02-02 11:36:17
 */
@RestController
@RequestMapping("employreport")
@Api(tags = "员工信息上报")
public class EmployReportController {
    @Autowired
    private EmployReportService employReportService;

    @Autowired
    private EmployService employService;

    /**
     * 保存
     */
    @CrossOrigin
    @PostMapping("/save")
    @ApiOperation(value = "员工信息上报详情",response = EmployReportEntity.class )
    public R save(@RequestBody EmployReportEntity employReport){

        if(employReport.getEmployid() == null){
            return R.error("员工工号不能为空");
        }

        EmployEntity employEntity = employService.selectById(employReport.getEmployid());

        if(employEntity == null){
            return R.error("工号不存在");
        }
        employReport.setCreatetime(new Date());
		employReportService.insert(employReport);
        return R.ok();
    }
}
