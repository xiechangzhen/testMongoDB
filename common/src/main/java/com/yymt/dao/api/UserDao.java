/**
 * Copyright 2018 人人开源 http://www.renren.io
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.yymt.dao.api;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.yymt.entity.api.UserEntity;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

/**
 * 用户
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-03-23 15:22:06
 */
public interface UserDao extends BaseMapper<UserEntity> {
    List selectCommonUserPage(RowBounds rowBounds, Map<String, Object> params);

    Map selectExpertDataCount(@Param("expertId") Long expertId, @Param("userId") Long userId);

    Map userDetail(Long userId);

    Map userCounter(Long userId);

    //后台用户信息统计
    Map userInfoStatistics(Long userId);

    List<UserEntity> selectExpert(Long mentalRoomId);

    int updateMentalRoomId(Long mentalRoomId);

    List<UserEntity> matchContact(String[] data);

    List<UserEntity> queryExpertByTags(String[] data);

    List<UserEntity> queryExpertExceptTags(String[] data);

    int updateUserScore(Long userId);

    Map userDetailWithFollow(Map<String, Object> param);

    /**
     * 后台获取入驻教练列表
     *
     * @param rowBounds
     * @param params
     * @return
     */
    List<UserEntity> queryCoacherListPage(RowBounds rowBounds, Map<String, Object> params);

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
     * @param rowBounds
     * @param params
     * @return
     */
    List<UserEntity> querySellerListPage(RowBounds rowBounds, Map<String, Object> params);

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
     * API获取商城教练
     *
     * @param rowBounds
     * @param params
     * @return
     */
    List<UserEntity> queryCoachesListPageForStore(RowBounds rowBounds, Map<String, Object> params);

    /**
     * API获取商城教练服务详情
     *
     * @param userId
     * @return
     */
    UserEntity queryCoachById(Long userId);

    /**
     * 删除所有与被删除用户相关的表数据
     * @param userId
     * @return
     */
    boolean deleteAllRelatedDataWithUserId(@Param("userId") Long userId);

    boolean clearCoachIdentificationInfo(Long userId);

    boolean clearSellerIdentificationInfo(Long userId);
    
    Map<String, Object> queryCountByOpenId(@Param("open_id") String open_id);
    
    
}
