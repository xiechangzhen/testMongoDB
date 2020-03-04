package com.yymt.modules.controller.antiepidemic;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yymt.common.exception.RRException;
import com.yymt.common.exception.ResultEnum;
import com.yymt.common.utils.Constant;
import com.yymt.common.utils.DateUtils;
import com.yymt.common.utils.R;
import com.yymt.modules.common.entity.antiepidemic.DeviceEntity;
import com.yymt.modules.common.entity.antiepidemic.FaceAlarmInfoEntity;
import com.yymt.modules.common.service.antiepidemic.FaceAlarmInfoService;
import com.yymt.modules.common.service.antiepidemic.OrganizationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import net.bytebuddy.implementation.bytecode.Throw;
import org.apache.commons.collections.map.LinkedMap;
import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.*;

import java.nio.file.OpenOption;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 告警接口
 *
 * @author xielin
 * @since 2020/2/26
 */

@RestController
@RequestMapping("actionapi/FaceAlarmInfo")
@Api(tags = "告警接口")
public class FaceAlarmInfoController {

    @Autowired
    private FaceAlarmInfoService faceAlarmInfoService;
    @PostMapping("/AlarmIndex")
    @ApiOperation(value = "根据小区名和开始结束时间获取告警页面信息")
    public R getAlarmIndex(@ApiParam("orgName(小区名),startTime（查询开始日期）,endTime（查询结束日期）")
                           @RequestBody Map<String, Object> param){
        if (param.get("startTime") != null && param.get("endTime") != null) {
            param.put("startTime", DateUtils.dateToms(param.get("startTime").toString()));
            param.put("endTime",DateUtils.dateToms(param.get("endTime").toString()));
        }
        return R.ok().put("message",faceAlarmInfoService.queryInfoByStartTimeAndEndTimeAndOrgName(param));
    }

    @PostMapping("/AlarmInfo/{id}")
    @ApiOperation(value = "根据告警编号（Id）查询详情")
    public R getAlarmInfo(@ApiParam("id（告警编号）") @PathVariable String id){
        return R.ok().put("message",faceAlarmInfoService.queryInfoById(id));
    }

}
