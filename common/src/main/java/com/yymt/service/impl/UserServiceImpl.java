package com.yymt.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.SqlHelper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.yymt.common.exception.RRException;
import com.yymt.common.exception.ResultEnum;
import com.yymt.common.form.LoginForm;
import com.yymt.common.utils.*;
import com.yymt.common.validator.Assert;
import com.yymt.dao.api.UserDao;
import com.yymt.entity.api.JPushEntity;
import com.yymt.entity.api.TokenEntity;
import com.yymt.entity.api.UserEntity;
import com.yymt.entity.sport.CoachingServiceEntity;
import com.yymt.entity.sport.ForumsEntity;
import com.yymt.service.CoachingServiceService;
import com.yymt.service.ForumsService;
import com.yymt.service.TokenService;
import com.yymt.service.UserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.yymt.common.utils.Constant.USER_STATUS_DELETE;
import static com.yymt.common.utils.Constant.USER_STATUS_DISABLED;
import static com.yymt.common.utils.ToolUtils.encryptBASE64;

/**
 * 用户管理（包括普通用户和专家用户）
 *
 * @author hgq
 * @date 2018-03-09 13:09:51
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDao, UserEntity> implements UserService {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private CoachingServiceService coachingServiceService;
    @Autowired
    private ForumsService forumsService;

    /**
     * 后台普通列表
     *
     * @param params
     * @return
     */
    public PageUtils selectCommonUserList(Map<String, Object> params) {
        Page<UserEntity> page = new Query<UserEntity>(params).getPage();
        EntityWrapper entityWrapper = new EntityWrapper<UserEntity>();
        SqlHelper.fillWrapper(page, entityWrapper);
        page.setRecords(baseMapper.selectCommonUserPage(
                page,
                params
        ));
        return new PageUtils(page);
    }


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String userType = (String) params.get("usertype");//专家类型
        String userLevel = (String) params.get("userlevel");//专家等级
        String userTag = (String) params.get("usertag");//专家领域范围
        String roomId = (String) params.get("roomid");// 心防室
        String userstatus = (String) params.get("userstatus");//用户状态
        Page<UserEntity> page = this.selectPage(
                new Query<UserEntity>(params).getPage(),
                new EntityWrapper<UserEntity>()
                        .where(StringUtils.isNotBlank(userType), "user_type={0}", userType)
                        .where(StringUtils.isNotBlank(userLevel), "expert_level={0}", userLevel)
                        .where(StringUtils.isNotBlank(userstatus), "user_status = {0}", userstatus)
                        .like(StringUtils.isNotBlank(userTag), "expert_tags", userTag)
                        .and(StringUtils.isNotBlank(roomId), "mental_room_id = {0}", roomId)
        );
        return new PageUtils(page);
    }


    @Override
    public Map<String, Object> getExpertDataCount(Long expertId, Long userId) {
        Map data = this.baseMapper.selectExpertDataCount(expertId, userId);
        return data;
    }

    @Override
    public UserEntity queryByMobile(String mobile) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(mobile);
        return baseMapper.selectOne(userEntity);
    }

    @Override
    public Map<String, Object> login(LoginForm form) {
        UserEntity user = queryByMobile(form.getMobile());
        if (user == null) {
            throw new RRException(ResultEnum.USER_NOT_EXIST);
        }
        if (user.getLoginType() != 0) {
            throw new RRException(ResultEnum.MUSTH_FROM_THIRD_PARTY);
        }
        if (user.getUserStatus().equals(USER_STATUS_DELETE)) {
            throw new RRException(ResultEnum.USER_DELETED);
        } else if (user.getUserStatus().equals(USER_STATUS_DISABLED)) {
            throw new RRException(ResultEnum.USER_FORBID);
        }
        Assert.isNull(user, "手机号或密码错误");
        //密码错误
        if (user.getPassword() == null ||
                !user.getPassword().equals(DigestUtils.sha256Hex(form.getPassword()))) {
            throw new RRException(ResultEnum.USERNAME_PASSWORD_ERROR);
        }

        //获取登录token
        TokenEntity tokenEntity = tokenService.createToken(user.getUserId());

        Map<String, Object> map = new HashMap<>(2);
        map.put("token", tokenEntity.getToken());
        map.put("expire", tokenEntity.getExpireTime().getTime() - System.currentTimeMillis());
        map.put("id", tokenEntity.getUserId());
        return map;
    }

    @Override
    public UserEntity getUser(UserEntity userEntity) {
        return baseMapper.selectOne(userEntity);
    }

    /**
     * 后台专家详情
     *
     * @param userId
     * @return
     */
    public Map<String, Object> userDetail(Long userId) {
        return baseMapper.userDetail(userId);
    }

    @Override
    public Map<String, Object> userCounter(Long userId) {
        return baseMapper.userCounter(userId);
    }

    @Override
    public Map<String, Object> userInfoStatistics(Long userId) {
        return baseMapper.userInfoStatistics(userId);
    }

    @Override
    public List<UserEntity> selectExpert(Long mentalRoomId) {
        return baseMapper.selectExpert(mentalRoomId);
    }

    @Override
    public int updateMentalRoomId(Long mentalRoomId) {
        baseMapper.updateMentalRoomId(mentalRoomId);
        return 0;
    }

    @Override
    public List<UserEntity> matchContact(String[] data) {
        return baseMapper.matchContact(data);
    }

    @Override
    public List<UserEntity> queryExpertByTags(String[] data) {
        return baseMapper.queryExpertByTags(data);
    }

    @Override
    public List<UserEntity> queryExpertExceptTags(String[] data) {
        return baseMapper.queryExpertExceptTags(data);
    }

    @Override
    public int updateUserScore(Long userId) {
        return baseMapper.updateUserScore(userId);
    }

    @Override
    public Map<String, Object> loginWithOpenId(String openId) {
        UserEntity user = selectOne(
                new EntityWrapper<UserEntity>()
                        .where("open_id = {0}", openId)
        );

        if (user == null) {
            throw new RRException(ResultEnum.USER_NOT_EXIST);
        }
        if (user.getUserStatus().equals(USER_STATUS_DELETE)) {
            throw new RRException(ResultEnum.USER_DELETED);
        } else if (user.getUserStatus().equals(USER_STATUS_DISABLED)) {
            throw new RRException(ResultEnum.USER_FORBID);
        }

        //获取登录token
        TokenEntity tokenEntity = tokenService.createToken(user.getUserId());

        Map<String, Object> map = new HashMap<>(2);
        map.put("token", tokenEntity.getToken());
        map.put("expire", tokenEntity.getExpireTime().getTime() - System.currentTimeMillis());
        map.put("id", tokenEntity.getUserId());
        return map;
    }

    @Override
    public Map userDetailWithFollow(Map<String, Object> param) {
        return baseMapper.userDetailWithFollow(param);
    }

    /**
     * 解除账号与极光的绑定
     */
    @Override
    public R deleteUserAliases(JPushEntity jPush) {
        Map<String, String> header = new HashMap<>();
        String base64_auth_string = encryptBASE64(jPush.getAppKey() + ":" + jPush.getMasterSecret());
        String authorization = "Basic " + base64_auth_string;
        header.put("Authorization", authorization);
        header.put("Accept", "application/json");
        header.put("Content-Type", "application/json; charset=utf-8");
        String url = jPush.getUrl() + "/" + jPush.getUserId();
        try {
            return HttpUtil.httpDelete(url, header, jPush.isProxy(), jPush.getProxyHost(), jPush.getProxyPort());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return R.ok();
    }

    /**
     * 后台获取入驻教练列表
     *
     * @param params
     * @return
     */
    @Override
    public PageUtils queryCoacherListPage(Map<String, Object> params) {
        Page<UserEntity> page = new Query<UserEntity>(params).getPage();
        EntityWrapper entityWrapper = new EntityWrapper<UserEntity>();
        SqlHelper.fillWrapper(page, entityWrapper);
        page.setRecords(baseMapper.queryCoacherListPage(
                page,
                params
        ));
        return new PageUtils(page);
    }

    /**
     * 后台获取待审核入驻教练数量
     *
     * @param params
     * @return
     */
    @Override
    public int coacherAuditCount(Map<String, Object> params) {
        return baseMapper.coacherAuditCount(params);
    }

    /**
     * 后台获取入驻教练详情
     *
     * @param positionId
     * @return
     */
    @Override
    public UserEntity queryCoacherByPositionId(Integer positionId) {
        return baseMapper.queryCoacherByPositionId(positionId);
    }

    /**
     * 后台获取入驻商家列表
     *
     * @param params
     * @return
     */
    @Override
    public PageUtils querySellerListPage(Map<String, Object> params) {
        Page<UserEntity> page = new Query<UserEntity>(params).getPage();
        EntityWrapper entityWrapper = new EntityWrapper<UserEntity>();
        SqlHelper.fillWrapper(page, entityWrapper);
        page.setRecords(baseMapper.querySellerListPage(
                page,
                params
        ));
        return new PageUtils(page);
    }

    /**
     * 后台获取待审核入驻商家数量
     *
     * @param params
     * @return
     */
    @Override
    public int sellerAuditCount(Map<String, Object> params) {
        return baseMapper.sellerAuditCount(params);
    }

    /**
     * 后台获取入驻商家详情
     *
     * @param positionId
     * @return
     */
    @Override
    public UserEntity querySellerByPositionId(Integer positionId) {
        return baseMapper.querySellerByPositionId(positionId);
    }

    @Override
    public PageUtils queryCoachesWithServiceListPage(Map<String, Object> params) {
        return null;
    }


    /**
     * API获取商城教练服务详情
     *
     * @param userId
     * @return
     */
    @Override
    public UserEntity queryCoachById(Long userId) {
        return baseMapper.queryCoachById(userId);
    }

    @Override
    public boolean deleteAllRelatedDataWithUserId(Long userId) {
        return baseMapper.deleteAllRelatedDataWithUserId(userId);
    }

    /**
     * 处理被举报用户的账号
     *
     * @param handleAccountType 处理措施  2冻结账号 3删除账号
     * @param userId            用户id
     * @param jPush             极光推送实体（解除与极光的绑定）
     * @return
     */
    @Override
    public boolean handleRevealedAccount(Integer handleAccountType, Long userId, JPushEntity jPush) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUserId(userId);
        if (handleAccountType != null && 2 == handleAccountType) {//2冻结账号
            userEntity.setUserStatus(Constant.USER_STATUS_DISABLED);
            baseMapper.updateById(userEntity);
        }
        if (handleAccountType != null && 3 == handleAccountType) {//3删除账号:需要删除与账号相关的所有数据
            List<ForumsEntity> forumsEntityList = forumsService.selectList(new EntityWrapper<ForumsEntity>().eq("user_id", userId));
            Integer[] forumsIds = new Integer[forumsEntityList.size()];
            for (int i = 0; i < forumsEntityList.size(); i++) {
                ForumsEntity deleteForums = forumsEntityList.get(i);
                forumsIds[i] = deleteForums.getId();
            }
            forumsService.deleteForumsAndCommentsAndGreatsBatch(forumsIds);//删除所有被删除用户发布的社区动态及其评论点赞的数据
            deleteAllRelatedDataWithUserId(userId);//删除所有与被删除用户相关的表数据
        }
        deleteUserAliases(jPush);// 解除账号与极光的绑定
        return false;
    }

    /**
     * 删除指定用户的教练入驻头衔、资质信息
     *
     * @param userId
     * @return
     */
    @Override
    public boolean clearCoachIdentificationInfo(Long userId) {
        return baseMapper.clearCoachIdentificationInfo(userId);
    }

    /**
     * 删除指定用户的商家入驻资质信息
     *
     * @param userId
     * @return
     */
    @Override
    public boolean clearSellerIdentificationInfo(Long userId) {
        return baseMapper.clearSellerIdentificationInfo(userId);
    }
    
    @Override
	public Map<String, Object> queryCountByOpenId(String open_id) {
		return baseMapper.queryCountByOpenId(open_id);
	}
    
}
