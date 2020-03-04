package com.yymt.service;

import com.baomidou.mybatisplus.service.IService;
import com.yymt.common.form.LoginForm;
import com.yymt.common.utils.PageUtils;
import com.yymt.common.utils.R;
import com.yymt.entity.api.JPushEntity;
import com.yymt.entity.api.UserEntity;

import java.util.List;
import java.util.Map;

/**
 * 用户管理（包括普通用户和专家用户）
 *
 * @author hgq
 * @date 2018-03-09 13:09:51
 */
public interface UserService extends IService<UserEntity> {

    //后台普通用户列表
    PageUtils selectCommonUserList(Map<String, Object> params);

    UserEntity queryByMobile(String mobile);

    /**
     * 用户登录
     *
     * @param form 登录表单
     * @return 返回登录信息
     */
    Map<String, Object> login(LoginForm form);

    UserEntity getUser(UserEntity userEntity);

    PageUtils queryPage(Map<String, Object> params);

    Map<String, Object> getExpertDataCount(Long expertId, Long userId);

    /**
     * 后台用户详情
     *
     * @param userId
     * @return
     */
    Map<String, Object> userDetail(Long userId);


    /**
     * 用户的关注数，粉丝数，收藏数
     *
     * @param userId
     * @return
     */
    Map<String, Object> userCounter(Long userId);

    /**
     * 后台用户各项信息统计
     *
     * @param userId
     * @return
     */
    Map<String, Object> userInfoStatistics(Long userId);

    List<UserEntity> selectExpert(Long mentalRoomId);

    int updateMentalRoomId(Long mentalRoomId);

    List<UserEntity> matchContact(String[] data);

    List<UserEntity> queryExpertByTags(String[] data);

    List<UserEntity> queryExpertExceptTags(String[] data);

    int updateUserScore(Long userId);

    Map<String, Object> loginWithOpenId(String openId);

    Map userDetailWithFollow(Map<String, Object> param);

    /**
     * 解除账号与极光的绑定
     */
    R deleteUserAliases(JPushEntity jPush);

    /**
     * 后台获取入驻教练列表
     *
     * @param params
     * @return
     */
    PageUtils queryCoacherListPage(Map<String, Object> params);

    /**
     * 后台获取待审核入驻教练数量
     *
     * @param params
     * @return
     */
    int coacherAuditCount(Map<String, Object> params);

    /**
     * 后台获取入驻教练详情
     *
     * @param positionId
     * @return
     */
    UserEntity queryCoacherByPositionId(Integer positionId);

    /**
     * 后台获取入驻商家列表
     *
     * @param params
     * @return
     */
    PageUtils querySellerListPage(Map<String, Object> params);

    /**
     * 后台获取待审核入驻商家数量
     *
     * @param params
     * @return
     */
    int sellerAuditCount(Map<String, Object> params);

    /**
     * 后台获取入驻商家详情
     *
     * @param positionId
     * @return
     */
    UserEntity querySellerByPositionId(Integer positionId);

    /**
     * API获取商城教练和服务
     *
     * @param params
     * @return
     */
    PageUtils queryCoachesWithServiceListPage(Map<String, Object> params);

    /**
     * API获取商城教练服务详情
     *
     * @param userId
     * @return
     */
    UserEntity queryCoachById(Long userId);

    /**
     * 删除所有与被删除用户相关的表数据
     *
     * @param userId
     * @return
     */
    boolean deleteAllRelatedDataWithUserId(Long userId);

    /**
     * 处理被举报用户的账号
     *
     * @param handleAccountType 处理措施
     * @param userId            用户id
     * @param jPush             极光推送实体（解除与极光的绑定）
     * @return
     */
    boolean handleRevealedAccount(Integer handleAccountType, Long userId, JPushEntity jPush);

    /**
     * 删除指定用户的教练入驻头衔、资质信息
     *
     * @param userId
     * @return
     */
    boolean clearCoachIdentificationInfo(Long userId);

    /**
     * 删除指定用户的商家入驻资质信息
     *
     * @param userId
     * @return
     */
    boolean clearSellerIdentificationInfo(Long userId);
    
    Map<String, Object> queryCountByOpenId(String open_id);
    
}

