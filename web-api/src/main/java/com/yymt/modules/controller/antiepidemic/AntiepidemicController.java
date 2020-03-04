package com.yymt.modules.controller.antiepidemic;

import com.yymt.common.utils.DateUtils;
import com.yymt.common.utils.R;
import com.yymt.modules.common.service.antiepidemic.DeviceMongoService;
import com.yymt.modules.common.service.antiepidemic.DeviceService;
import com.yymt.modules.common.service.antiepidemic.GridService;
import com.yymt.modules.common.service.antiepidemic.OrganizationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 抗疫接口
 *
 * @author xiezhen
 * @since 2020/2/26
 */

@RestController
@RequestMapping("actionapi/AntiepidemicApi")
@Api(tags = "抗疫接口")
public class AntiepidemicController {

    @Autowired
    private OrganizationService organizationService;

    @Autowired
    private GridService gridService;

    @Autowired
    private DeviceService deviceService;

    @Autowired
    private DeviceMongoService deviceMongoService;

    @GetMapping("/GetDevices")
    @ApiOperation(value = "获取卡点信息")
    public R getDevices(@ApiParam("小区名称")
                        @RequestParam(value = "name", required = false) String name) {
        Map<String, Object> params = new HashMap<>();
        params.put("Devices", organizationService.queryList(name));
        return R.ok().put("Message", params);
    }

    @GetMapping("/GetGrids")
    @ApiOperation(value = "根据网格名字获取网格信息")
    public R getGrids(@ApiParam("根据网格名字获取网格信息")
                      @RequestParam(value = "name", required = false) String gridName) {

        return R.ok().put("Message", gridService.queryGridInfoByGridName(gridName));
    }

    @GetMapping("/GetCommunities")
    @ApiOperation(value = "根据小区名字查询小区信息")
    public R getCommunities(@ApiParam("根据小区名字查询小区信息")
                            @RequestParam(value = "organizationName", required = false) String organizationName) {

        return R.ok().put("Message",
                organizationService.queryOrganizationInfoByOrganizationName(organizationName));
    }

    @GetMapping("/GetStatisticsByDevID")
    @ApiOperation(value = "按日期和设备编号查询卡点的流量统计")
    public R getGetStatisticsByDevID(@ApiParam("按日期和设备编号查询卡点的流量统计")
                                     @RequestParam(value = "devId") String devId,
                                     @RequestParam(value = "day") String day) {

        Map<String, Object> params = new HashMap<>();
        params.put("devId", devId);
        params.put("day", day);

        return R.ok().put("Message",
                deviceMongoService.queryStatisticsDayAndByDevID(params));
    }

    @GetMapping("/GetAlarmsByTime")
    @ApiOperation(value = "根据小区名和开始结束时间获取告警信息")
    public R getGetStatisticsByDevID(@ApiParam("根据小区名和开始结束时间获取告警信息")
                                     @RequestParam(value = "name",required = false) String name,
                                     @RequestParam(value = "startTime") String startTime,
                                     @RequestParam(value = "endTime") String endTime) {

        Map<String, Object> params = new HashMap<>();
        if(StringUtils.isNotEmpty(name)){
            params.put("orgName", name);
        }
        params.put("startTime", DateUtils.dateToms(startTime));
        params.put("endTime", DateUtils.dateToms(endTime));

        return R.ok().put("Message",
                deviceMongoService.queryInfoByStartTimeAndEndTimeAndOrgName(params));
    }

    @GetMapping("/insertContent")
    @ApiOperation(value = "插入Mongo")
    public R insertContent() {


        return R.ok().put("mongo", deviceService.insertMongo().size());
    }

}
