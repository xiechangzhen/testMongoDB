package com.yymt.modules.controller.sport;

import java.util.Date;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yymt.common.utils.ConvertUtil;
import com.yymt.common.utils.R;
import com.yymt.entity.api.UserEntity;
import com.yymt.entity.sport.OutenterRegisterEntity;
import com.yymt.service.UserService;
import com.yymt.service.sport.OutenterRegisterService;
import com.yymt.service.sport.PreventControlReportService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 出入登记表
 *
 * @author xiaojin
 * @date 2020-02-11 14:57:10
 */
@RestController
@RequestMapping("outenterregister")
@Api(tags = "出入登记")
public class OutenterRegisterController extends BaseController {
	@Autowired
	private OutenterRegisterService outenterRegisterService;
	@Autowired
	private PreventControlReportService preventControlReportService;
	@Autowired
	private UserService userService;

	/**
	 * 保存
	 */
	@PostMapping("/save")
	@ApiOperation(value = "出入登记保存", response = OutenterRegisterEntity.class)
	@RequiresPermissions("outenterregister:save")
	public R save(@ApiParam(value = "userId：用户id，registerTime：出入登记时间，registerType：登记类型，userName：姓名，phoneNumber：联系方式，"
			+ "identityCard：身份证号码，communityLocation：社区所在地，personnelNature：人员性质，with_relationship：与您关系：1表示本人，2表示亲属，3表示朋友，4表示同事，5表示其他") @RequestBody OutenterRegisterEntity outenterRegister) {
		String identityCard = ConvertUtil.objToStrConverNull(outenterRegister.getIdentityCard());
		if (identityCard == null) {
			return R.error("身份证号不能为空");
		}
		int personnel_nature = ConvertUtil.parseInt(outenterRegister.getPersonnelNature());
		if (personnel_nature == 1) {
			int with_relationship = ConvertUtil.parseInt(outenterRegister.getWithRelationship());
			if (with_relationship == 1) {
				UserEntity userEntity = userService.selectById(getUserIdByToken());
				String userIdNo = ConvertUtil.objToStrConverNull(userEntity.getUserIdNum());
				if (userIdNo == null) {
					return R.error(2,"您未填个人身份证信息");
				}
				if (!identityCard.equals(userIdNo)) {
					return R.error("身份证号与个人填写的身份证号信息不一致");
				}
			}
		} else if (personnel_nature == 2) {
			String whereGo = preventControlReportService.queryWhereGo(identityCard);
			if (whereGo == null) {
				return R.error(3,"该用户未填写最新防控报备到哪里去信息");
			}
			whereGo = ConvertUtil.objToStrConverSpace(whereGo);
			String communityLocation = ConvertUtil.objToStrConverSpace(outenterRegister.getCommunityLocation());
			if (!whereGo.equals(communityLocation)) {
				return R.error("所在社区与该用户填写最新防控报备到哪里去不一致");
			}
		} else {
			return R.error("人员性质不能为空");
		}
		outenterRegister.setUserId(getUserIdByToken());
		outenterRegister.setRegisterTime(new Date());
		outenterRegisterService.insert(outenterRegister);
		return R.ok();
	}

	// /**
	// * 根据身份证查询用户是否填写防控报备信息
	// */
	// @PostMapping("/getWhereGo")
	// @ApiOperation(value = "根据身份证查询用户是否填写防控报备信息")
	// @RequiresPermissions("outenterregister:getWhereGo")
	// public R save(@ApiParam(value = "identityCard：身份证号码") @RequestBody
	// Map<String, Object> params) {
	// String identityCard =
	// ConvertUtil.objToStrConverNull(params.get("identityCard"));
	// String whereGo = preventControlReportService.queryWhereGo(identityCard);
	// whereGo = ConvertUtil.objToStrConverNull(whereGo);
	// if (whereGo == null) {
	// return R.error("您未填写最新防控报备信息或报备的到哪里去地点错误");
	// } else {
	// return R.ok();
	// }
	// }

}
