package com.yymt.modules.controller.sport;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.yymt.annotation.Login;
import com.yymt.common.utils.Constant;
import com.yymt.common.utils.RWapper;
import com.yymt.entity.api.CoacherValidate;
import com.yymt.entity.api.SellerValidate;
import com.yymt.entity.api.UserEntity;
import com.yymt.entity.api.UserPositionEntity;
import com.yymt.service.UserPositionService;
import com.yymt.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Date;
import java.util.stream.Collectors;

/**
 * Created by Hakka-River on 2018/12/13.
 */
//@Api(tags = "商家服务")
@RestController
@RequestMapping("seller")
public class SellerController extends BaseController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserPositionService userPositionService;

    @Login
    @PostMapping("/register")
    //@ApiOperation("商家入驻")
    public RWapper register(@Validated({SellerValidate.class}) @RequestBody UserEntity user,
                            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String resultMessages = String.join("；", bindingResult.getAllErrors().stream()
                    .map(oe -> oe.getDefaultMessage()).collect(Collectors.toList()));
            return RWapper.error(resultMessages);
        }

        user.setUserId(getUserIdByToken());

        UserPositionEntity userPositionExisted = userPositionService.selectOne(
                new EntityWrapper<UserPositionEntity>()
                        .eq("user_id", user.getUserId())
                        .eq("user_position", 4)
        );
        if (userPositionExisted != null)
            return RWapper.error("您已入驻，请不要重复入驻。");

        userService.updateById(user);

        UserPositionEntity userPosition = new UserPositionEntity();
        userPosition.setUserId(user.getUserId());
        userPosition.setUserPosition(4);
        userPosition.setPositionStatus(Constant.STATUS_AUDIT);
        userPosition.setCreateTime(new Date());
        userPositionService.insert(userPosition);

        return RWapper.ok().encode(isEncryption);
    }

    @Login
    @PostMapping("/update")
    //@ApiOperation("修改商家入驻信息")
    public RWapper update(@Validated({SellerValidate.class}) @RequestBody UserEntity user,
                          BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String resultMessages = String.join("；", bindingResult.getAllErrors().stream()
                    .map(oe -> oe.getDefaultMessage()).collect(Collectors.toList()));
            return RWapper.error(resultMessages);
        }

        if (user.getUserId() == null)
            user.setUserId(getUserIdByToken());

        UserPositionEntity userPosition = userPositionService.selectOne(
                new EntityWrapper<UserPositionEntity>()
                        .eq("user_id", user.getUserId())
                        .eq("user_position", 4)
        );
        if (userPosition == null)
            return RWapper.error("您当前未入驻，请先入驻。");

        userService.updateById(user);

        userPosition.setModifyTime(new Date());
        if (userPosition.getPositionStatus() == 2)
            userPosition.setPositionStatus(0);
        userPositionService.updateById(userPosition);

        return RWapper.ok().encode(isEncryption);
    }
}
