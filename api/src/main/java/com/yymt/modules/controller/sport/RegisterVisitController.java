package com.yymt.modules.controller.sport;

import java.util.Date;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yymt.common.utils.R;
import com.yymt.entity.sport.RegisterVisitEntity;
import com.yymt.service.sport.RegisterVisitService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 登记拜访表
 *
 * @author xiaojin
 * @date 2020-02-21 11:43:31
 */
@RestController
@RequestMapping("registervisit")
@Api(tags = "登记拜访")
public class RegisterVisitController extends BaseController{
	@Autowired
	private RegisterVisitService registerVisitService;

	/**
	 * 保存
	 */
	@PostMapping("/save")
	@ApiOperation(value = "保存登记拜访", response = RegisterVisitEntity.class)
	@RequiresPermissions("registervisit:save")
	public R save(@RequestBody RegisterVisitEntity registerVisit) {
		Long userId = getUserIdByToken();
		registerVisit.setUserId(userId);
		registerVisit.setVisitTime(new Date());
		registerVisitService.insert(registerVisit);
		return R.ok();
	}
	
	

}
