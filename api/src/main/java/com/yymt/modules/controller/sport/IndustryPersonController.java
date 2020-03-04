package com.yymt.modules.controller.sport;

import java.util.Arrays;
import java.util.Map;

import com.yymt.common.utils.RWapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.yymt.entity.sport.IndustryPersonEntity;
import com.yymt.service.IndustryPersonService;
import com.yymt.common.utils.PageUtils;
import com.yymt.common.utils.R;



/**
 * 行业人员
 *
 * @author cots
 * @date 2018-09-05 16:23:30
 */
@RestController
@RequestMapping("sport/industryperson")
//@Api(tags = "行业人员")
public class IndustryPersonController extends BaseController {
    @Autowired
    private IndustryPersonService industryPersonService;

    /**
     * 列表
     */
    @PostMapping("/list")
    //@ApiOperation(value = "行业人员列表",response = IndustryPersonEntity.class)
    public RWapper list(@ApiParam("{\"type\":\"整型(人员类别(0-运动员,1-教练员,2-裁判员,3-社会指导员))\",\"sportId\":\"整型\",\"levelId\":\"整型\",\"keyword\":\"搜索字符串\"}") @RequestBody Map<String, Object> params){
        PageUtils page = industryPersonService.listIndustryPerson(params);
        return RWapper.ok().put("page", page).encode(isEncryption);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sport:industryperson:info")
    public R info(@PathVariable("id") Integer id){
        IndustryPersonEntity industryPerson = industryPersonService.selectById(id);
        return R.ok().put("industryPerson", industryPerson);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sport:industryperson:save")
    public R save(@RequestBody IndustryPersonEntity industryPerson){
		industryPersonService.insert(industryPerson);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sport:industryperson:update")
    public R update(@RequestBody IndustryPersonEntity industryPerson){
		industryPersonService.updateById(industryPerson);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sport:industryperson:delete")
    public R delete(@RequestBody Integer[] ids){
		industryPersonService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

}
