package com.yymt.service;

import com.baomidou.mybatisplus.service.IService;
import com.yymt.common.utils.PageUtils;
import com.yymt.entity.sport.UserFollowEntity;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

/**
 * 用户关注表
 *
 * @author hgq
 * @date 2018-02-10 14:26:32
 */
public interface UserFollowService extends IService<UserFollowEntity> {

    PageUtils queryPage(Map<String, Object> params);
    PageUtils selectUserFollowPage(Map<String, Object> params);

    /**
     * 用户的关注总数，社区好友数，咨询师数量，专家数量
     * @param userId
     * @return
     */
    Map<String, Object> userFriendsCount(Map<String, Object> params);

    List<String> queryFansPushClientId(Long userId);

    Integer isFollowOrFans(Map<String,Object> param);

    PageUtils selectFansList(Map<String, Object> params);

    PageUtils selectFollowList(Map<String, Object> params);
}

