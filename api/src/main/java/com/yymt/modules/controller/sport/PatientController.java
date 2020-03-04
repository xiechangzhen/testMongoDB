package com.yymt.modules.controller.sport;

import java.util.Arrays;
import java.util.Map;

import com.yymt.entity.sport.PatientEntity;
import com.yymt.service.sport.PatientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.yymt.common.utils.PageUtils;
import com.yymt.common.utils.R;



/**
 * 病历
 *
 * @author cots
 * @date 2020-02-07 17:31:39
 */
@RestController
@RequestMapping("patient")
@Api(tags = "病历")
public class PatientController {
    @Autowired
    private PatientService patientService;

    /**
     * 列表
     */
    @CrossOrigin
    @PostMapping("/list")
    @ApiOperation(value = "病历列表",response = PatientEntity.class )
    public R list(@RequestBody Map<String, Object> params){
        PageUtils page = patientService.queryPage(params);
        return R.ok().put("page", page);
    }


    /**
     * 信息
     *//*
    @PostMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id){
        PatientEntity patient = patientService.selectById(id);
        return R.ok().put("patient", patient);
    }

    *//**
     * 保存
     *//*
    @PostMapping("/save")
    @ApiOperation(value = "病历详情",response = PatientEntity.class )
    public R save(@RequestBody PatientEntity patient){
		patientService.insert(patient);
        return R.ok();
    }

    *//**
     * 修改
     *//*
    @PostMapping("/update")
    public R update(@RequestBody PatientEntity patient){
		patientService.updateById(patient);
        return R.ok();
    }

    *//**
     * 删除
     *//*
    @PostMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
		patientService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
*/
}
