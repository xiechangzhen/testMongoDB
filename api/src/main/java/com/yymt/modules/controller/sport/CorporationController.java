package com.yymt.modules.controller.sport;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.yymt.annotation.Login;
import com.yymt.common.utils.RWapper;
import com.yymt.entity.sport.CorporationGroupMemberEntity;
import com.yymt.service.CorporationGroupService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.collections.map.HashedMap;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.yymt.entity.sport.CorporationEntity;
import com.yymt.service.CorporationService;
import com.yymt.common.utils.PageUtils;
import com.yymt.common.utils.R;



/**
 * 社团信息表
 *
 * @author cots
 * @date 2018-09-05 16:23:30
 */
@RestController
@RequestMapping("sport/corporation")
//@Api(tags = "社团信息")
public class CorporationController extends BaseController{
    @Autowired
    private CorporationService corporationService;

    @Autowired
    private CorporationGroupService corporationGroupService;

    /**
     * 列表
     */
    @PostMapping("/list")
    //@ApiOperation(value = "社团列表",response = CorporationEntity.class)
    public RWapper list(@ApiParam(value = "{\"latitude\":25.832659(必填),\"longitude\":114.985529(必填),\"area\":360702,\"item\":\"赛事类型ID\",\"distance\":1000,\"keyword\":\"搜索字符串\"}") @RequestBody Map<String, Object> params){
        PageUtils page = corporationService.listCorporation(params);
        return  RWapper.ok().put("page", page).encode(isEncryption);
    }

    /**
     * 社团团体会员信息
     */
    @CrossOrigin
    @PostMapping("/listMembers/{id}")
    //@ApiOperation(value = "社团团体会员列表",response = CorporationGroupMemberEntity.class)
    public RWapper list(@PathVariable("id") int id){
        List members = corporationGroupService.listGroupMember(id);
        return  RWapper.ok().put("members", members).encode(isEncryption);
    }

    /**
     * 信息
     */
    @CrossOrigin
    @PostMapping("/info/{id}")
    //@ApiOperation(value = "社团详情",response = CorporationEntity.class)
    public RWapper info(@PathVariable("id") Integer id){

        CorporationEntity entity = corporationService.selectById(id);
        if(entity == null){
            return RWapper.error("社团不存在");
        }
        entity.setPageView(entity.getPageView()+1);
        corporationService.updateById(entity);
        Map<String,Object> param = new HashedMap();
        param.put("id",id);
        param.put("userId",getUserIdByTokenWithoutValidate());
        Map corporation = corporationService.corporationDetail(param);
        return RWapper.ok().put("corporation", corporation).encode(isEncryption);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public R save(@RequestBody CorporationEntity corporation){
		corporationService.insert(corporation);
        return R.ok();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    public R update(@RequestBody CorporationEntity corporation){
		corporationService.updateById(corporation);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
		corporationService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

}
