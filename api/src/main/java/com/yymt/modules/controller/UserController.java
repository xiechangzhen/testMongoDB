package com.yymt.modules.controller;

import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.yymt.annotation.Login;
import com.yymt.common.form.ForgotPwdForm;
import com.yymt.common.utils.*;
import com.yymt.common.validator.ValidatorUtils;
import com.yymt.entity.api.IndexCategory;
import com.yymt.entity.api.RCloudTokenEntity;
import com.yymt.entity.api.UserEntity;
import com.yymt.entity.api.UserPositionEntity;
import com.yymt.modules.controller.sport.BaseController;
import com.yymt.search.LuceneUtils;
import com.yymt.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.collections.map.HashedMap;
import org.apache.lucene.queryparser.classic.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;


/**
 * 用户
 *
 * @author hgq
 * @date 2018-02-25 14:15:37
 */
@RestController
@RequestMapping("/user")
@Api(tags = "用户接口")
public class UserController extends BaseController {
    @Autowired
    private UserService userService;
    @Autowired
    private VcodeService vcodeService;
    @Autowired
    private CorporationUserService corporationUserService;
    @Autowired
    private ForumsService forumsService;

    @Autowired
    private UserFollowService userFollowService;
    @Autowired
    private UserPositionService userPositionService;

    @Value("${rcloud.appKey}")
    private String appkey;

    @Value("${rcloud.appSecret}")
    private String appSecret;

    @Value("${rcloud.url}")
    private String rcloudUrl;

    //全球眼网络需要配置代理
    @Value("${proxy.isProxy}")
    private boolean isProxy;
    @Value("${proxy.proxyHost}")
    private String proxyHost;
    @Value("${proxy.proxyPort}")
    private Integer proxyPort;

    /**
     * 列表
     */
//    @Login
    @PostMapping("list")
    public RWapper list(@ApiParam(value = "{\"usertype\":\"(0-普通用户,1-咨询师，2-专家)\",\"userlevel\":\"(2-国家咨询师二级,3-国家咨询师三级)\",\"usertag\":\"专家标签\",\"roomid\":\"1\",\"userstatus\":\"0\"}") @RequestBody Map<String, Object> params) {
        PageUtils page = userService.queryPage(params);
        return RWapper.ok().put("page", page).encode(isEncryption);
    }


    /**
     * 通过token获取用户信息
     */
    @CrossOrigin
    @Login
    @PostMapping("getInfoByToken")
    @ApiOperation("通过token获取用户信息")
    public R getInfoByToken() {
        UserEntity user = getUserInfoByToken();
        return R.ok().put("user", user);
    }


    /**
     * 通过token获取用户信息
     */
    @CrossOrigin
    @Login
    @PostMapping("getUserInfo/{userId}")
    //@ApiOperation("获取粉丝、关注的个人信息")
    public RWapper getInfoByToken(@PathVariable("userId") Long userId) {
        Map<String, Object> param = new HashedMap();
        param.put("userId", userId);
        param.put("loginUserId", getUserIdByToken());
        Map user = userService.userDetailWithFollow(param);
        Map<String, Object> counter = userService.userCounter(userId);
        PageUtils page = forumsService.selectForumsList(param);
        return RWapper.ok().put("user", user).put("counter", counter).put("forums", page).encode(isEncryption);
    }

    /**
     * 通过token获取用户信息
     */
    @PostMapping("getFansOrFollow")
    //@ApiOperation("获取粉丝、关注列表")
    public RWapper getFansOrFollow(@ApiParam(value = "{\"isFollow\",\"true-我的关注,false-我的粉丝\",\"userId\":}") @RequestBody Map<String, Object> params) {
        PageUtils page = userFollowService.selectUserFollowPage(params);
        return RWapper.ok().put("user", page).encode(isEncryption);
    }


    /**
     * 保存
     */
    @CrossOrigin
    @Login
    @PostMapping("save")
    @ApiOperation("用户添加")
    public RWapper save(@RequestBody UserEntity user) {
        userService.insert(user);
        return RWapper.ok().encode(isEncryption);
    }

    /**
     * 修改
     */
    @CrossOrigin
    @Login
    @PostMapping("update")
    @ApiOperation("用户修改")
    public RWapper update(@RequestBody UserEntity user) {
        UserEntity userEntity = getUserInfoByToken();
        user.setUserId(userEntity.getUserId());
        if (userEntity.getRealName() != null && StringUtils.isEmpty(user.getRealName())) {//原来不空的数据改为空
            user.setRealName(" ");
        }
        if (userEntity.getUserIdNum() != null && StringUtils.isEmpty(user.getUserIdNum())) {//原来不空的数据改为空
            user.setUserIdNum(" ");
        }
        userService.updateById(user);
        return RWapper.ok();
    }


    /**
     * 删除
     */
    @Login
    @PostMapping("delete")
    @ApiOperation("用户删除")
    public RWapper delete(@RequestBody Long[] userIds) {
        userService.deleteBatchIds(Arrays.asList(userIds));
        return RWapper.ok();
    }

    @PostMapping("forgotPwd")
    @ApiOperation("忘记密码")
    public RWapper forgotPwd(@RequestBody ForgotPwdForm form) {
        //表单校验
        ValidatorUtils.validateEntity(form);
        //校验验证码是否正确
        RWapper r = vcodeService.validateVcode(form.getMobile(), form.getCode(), form.getCodeType());
        if (r.getCode() == 0) {//返回0验证通过
            UserEntity user = new UserEntity();
            user.setUsername(form.getMobile());
            user.setPassword(DigestUtils.sha256Hex(form.getPassword()));
            userService.update(user, new EntityWrapper<UserEntity>().where("username = {0}", form.getMobile()));
            return RWapper.ok();
        } else {
            return r;
        }
    }

    @PostMapping("search")
    @ApiOperation("用户搜索")
    public RWapper search(@ApiParam(value = "{\"pageNum\":1,\"pageSize\":10,\"searchString\":\"\"}") @RequestBody Map<String, Object> params) throws IOException, ParseException {
        return RWapper.ok().put("page", LuceneUtils.searcher(IndexCategory.USER, params.get("searchString").toString(), (int) params.get("pageNum"), (int) params.get("pageSize"))).encode(isEncryption);
    }


    @PostMapping("match")
    @ApiOperation("用户匹配")
    public RWapper match(@RequestBody String[] mobiles) {
        if (mobiles != null && mobiles.length > 0) {
            List<UserEntity> data = userService.matchContact(mobiles);
            return RWapper.ok().put("contact", data).encode(isEncryption);

        } else {
            return RWapper.error("联系人为空");
        }
    }

    @Login
    @PostMapping("getRCToken")
    @ApiOperation("获取token")
    public RWapper token() {
        UserEntity userEntity = getUserInfoByToken();
        //如果数据库已经存在token，则直接返回
        if (userEntity.getRcToken() != null && !"".equals(userEntity.getRcToken())) {
            return RWapper.ok().put("rc_token", userEntity.getRcToken()).encode(isEncryption);
        }
        Map<String, Object> header = new HashedMap();
        String uuid = UUID.randomUUID().toString();
        long timestamp = System.currentTimeMillis();
        header.put("App-Key", appkey);
        header.put("Nonce", uuid);
        header.put("Timestamp", String.valueOf(timestamp));
        header.put("Signature", getSignature(header));
        //如果是咨询师，显示真名，否则显示昵称
        String param = "userId=" + userEntity.getUserId() + "&name=" + (userEntity.getUserType() == 1 ? userEntity.getRealName() : userEntity.getNickName()) + "&portraitUri=";
        String result = null;
        try {
            result = HttpUtil.sendPost(header, rcloudUrl, param, isProxy, proxyHost, proxyPort);
            if (result != null) {
                RCloudTokenEntity entity = GsonUtil.GsonToBean(result, RCloudTokenEntity.class);
                if (entity.getCode() == 200) {//正常返回状态
                    //更新userToken
                    userEntity.setRcToken(entity.getToken());
                    userService.updateById(userEntity);
                    return RWapper.ok().put("rc_token", entity.getToken()).encode(isEncryption);
                } else {
                    return RWapper.error("获取token失败");
                }
            } else {
                return RWapper.error("获取token失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return RWapper.error();
    }

    @CrossOrigin
    @Login
    @PostMapping("/info/{userId}")
    @ApiOperation("获取指定用户")
    public RWapper getUserById(@PathVariable Long userId) {
        UserEntity user = userService.selectById(userId);
        return RWapper.ok().put("info", user).encode(isEncryption);
    }

    @CrossOrigin
    @Login
    @PostMapping("/getUserByOpenId/{openId}")
    @ApiOperation("获取第三方登录用户信息")
    public RWapper getUserByOpenId(@PathVariable String openId) {
        UserEntity userEntity = userService.selectOne(
                new EntityWrapper<UserEntity>()
                        .where("open_id = {0}", openId)
                        .and("user_status = 1")
        );
        return RWapper.ok().put("info", userEntity).encode(isEncryption);
    }


    public String getSignature(Map<String, Object> header) {
        StringBuffer sb = new StringBuffer();
        sb.append(appSecret);
        sb.append(header.get("Nonce"));
        sb.append(header.get("Timestamp"));
        return DigestUtils.shaHex(sb.toString());
    }
}
