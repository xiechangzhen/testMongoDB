package com.yymt.service;

import com.baomidou.mybatisplus.service.IService;
import com.yymt.common.utils.PageUtils;
import com.yymt.entity.sport.MessageRecordEntity;

import java.util.List;
import java.util.Map;

/**
 * 消息记录表
 *
 * @author hgq
 * @date 2018-03-20 19:24:00
 */
public interface MessageRecordService extends IService<MessageRecordEntity> {

    /**
     * 查询收到的关注
     * @param params
     * @return
     */
    PageUtils queryFocusPage(Map<String, Object> params);

    /**
     * 查询收到的评价
     * @param params
     * @return
     */
    PageUtils queryCommentPage(Map<String, Object> params);
    /**
     * 查询收到的赞
     * @param params
     * @return
     */
    PageUtils queryGreatPage(Map<String, Object> params);

    PageUtils queryPage(Map<String, Object> params);

    Map countMsgList(Map<String, Object> params);

    /**
     * @param fromUserId 发送人
     * @param toUserId 接收人
     * @param messageType 消息类型
     * @param messageTab 消息栏目（赞-1，评论-2，关注-3）
     * @param messageTabType 消息栏目再细分（1-社区点赞2-新闻点赞3-赛事培训点赞4-社区评论点赞5-社区评论6-关注个人7-关注社团）
     * @param messageContent 消息内容
     * @param recordId 消息进行跳转的记录ID
     * @return boolean
     */
    boolean insertMsg(Long fromUserId, Long toUserId, Integer messageType, Integer messageTab, Integer messageTabType, String messageContent, Integer recordId);

    List<MessageRecordEntity> toUsersList(Long fromUserId, Long[] toUserIds, Integer messageType, Integer messageTab, Integer messageTabType, String messageContent, Integer recordId);

    Map messageStatus(Long userId);

    Integer changeMessageStatus(Map<String, Object> params);
}

