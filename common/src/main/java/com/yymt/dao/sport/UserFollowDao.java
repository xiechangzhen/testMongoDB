package com.yymt.dao.sport;

import com.baomidou.mybatisplus.mapper.BaseMapper;
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
public interface UserFollowDao extends BaseMapper<UserFollowEntity> {
//    List selectUserFollowPage(RowBounds rowBounds, @Param("id") Long id,@Param("type") String type,@Param("isFollow") boolean isFollow);
    List selectUserFollowPage(RowBounds rowBounds, Map<String, Object> params);

    Map userFriendsCount(Map<String, Object> params);

    List<String> queryFansPushClientId(Long userId);

    Integer isFollowOrFans(Map<String,Object> param);

    List selectFansList(RowBounds rowBounds, Map<String, Object> params);

    List selectFollowList(RowBounds rowBounds, Map<String, Object> params);

}
