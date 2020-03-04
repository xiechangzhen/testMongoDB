package com.yymt.modules.controller.sport;

import java.util.Map;

import org.springframework.web.bind.annotation.*;

import com.yymt.common.utils.ConvertUtil;
import com.yymt.common.utils.R;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("wechatuser")
@Api(tags = "微信公众号用户")
public class WechatUserController extends BaseController {

	@CrossOrigin
	@PostMapping("/authorize")
	@ApiOperation("微信公众号用户授权接口")
	public R authorize(@ApiParam(value = "code（微信code）") @RequestBody Map<String, Object> params) throws Exception {
		String code = ConvertUtil.objToStrConverNull(params.get("code"));
		if (code != null) {
			return saveOrUpdateUserInfo2(code);
		} else {
			return R.error("code不能为空");
		}
	}

}
