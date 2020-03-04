package com.yymt.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.SqlHelper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.yymt.common.utils.PageUtils;
import com.yymt.common.utils.Query;
import com.yymt.dao.sport.MessageRecordDao;
import com.yymt.entity.sport.MessageRecordEntity;
import com.yymt.service.MessageRecordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


@Service("messageRecordService")
public class MessageRecordServiceImpl extends ServiceImpl<MessageRecordDao, MessageRecordEntity> implements MessageRecordService {

    private static final Logger logger = LoggerFactory.getLogger(MessageRecordServiceImpl.class);

    /**
     * 查询收到的关注
     * @param params
     * @return
     */
    @Override
    public PageUtils queryFocusPage(Map<String, Object> params) {
        Page<MessageRecordEntity> page = new Query<MessageRecordEntity>(params).getPage();
        Wrapper<MessageRecordEntity> wrapper = new EntityWrapper<MessageRecordEntity>();
        SqlHelper.fillWrapper(page, wrapper);
        page.setRecords(baseMapper.queryReceivedFocusList(
                page,
                params
        ));
        return new PageUtils(page);
    }
    /**
     * 查询收到的评价
     * @param params
     * @return
     */
    @Override
    public PageUtils queryCommentPage(Map<String, Object> params) {
        Page<MessageRecordEntity> page = new Query<MessageRecordEntity>(params).getPage();
        Wrapper<MessageRecordEntity> wrapper = new EntityWrapper<MessageRecordEntity>();
        SqlHelper.fillWrapper(page, wrapper);
        page.setRecords(baseMapper.queryReceivedCommentList(
                page,
                params
        ));
        return new PageUtils(page);
    }

    /**
     * 查询收到的赞
     * @param params
     * @return
     */
    @Override
    public PageUtils queryGreatPage(Map<String, Object> params) {
        Page<MessageRecordEntity> page = new Query<MessageRecordEntity>(params).getPage();
        Wrapper<MessageRecordEntity> wrapper = new EntityWrapper<MessageRecordEntity>();
        SqlHelper.fillWrapper(page, wrapper);
        page.setRecords(baseMapper.queryReceivedGreatList(
                page,
                params
        ));
        return new PageUtils(page);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {

        Page<MessageRecordEntity> page = new Query<MessageRecordEntity>(params).getPage();
        Wrapper<MessageRecordEntity> wrapper = new EntityWrapper<MessageRecordEntity>();
        SqlHelper.fillWrapper(page, wrapper);
        page.setRecords(baseMapper.queryMsgList(
                page,
                params
        ));
        return new PageUtils(page);
    }

    public Map countMsgList(Map<String, Object> params){
        return baseMapper.countMsgList(params);
    }

    @Override
    public boolean insertMsg(Long fromUserId,Long toUserId,Integer messageType,Integer messageTab,Integer messageTabType,String messageContent,Integer recordId){
        if(fromUserId.equals(toUserId)){//自己给自己点赞、评论，不加消息
            return false;
        }
        MessageRecordEntity messageRecordEntity = new MessageRecordEntity();
        messageRecordEntity.setCreateTime(new Date());
        messageRecordEntity.setIsRead(0);
        messageRecordEntity.setFromUserId(fromUserId);
        messageRecordEntity.setToUserId(toUserId);
        messageRecordEntity.setMessageType(messageType);
        messageRecordEntity.setMessageTab(messageTab);
        messageRecordEntity.setMessageTabType(messageTabType);
        messageRecordEntity.setMessageContent(messageContent);
        messageRecordEntity.setRecordId(recordId);
        int row = baseMapper.insert(messageRecordEntity);
        return row>0;
    }

    /**
     * 批量发送消息给多个用户
     * @param fromUserId
     * @param toUserIds
     * @param messageType
     * @param messageTab
     * @param messageTabType
     * @param messageContent
     * @param recordId
     * @return
     */
    public List<MessageRecordEntity> toUsersList(Long fromUserId, Long[] toUserIds, Integer messageType, Integer messageTab, Integer messageTabType, String messageContent, Integer recordId){
        List<MessageRecordEntity> list = new ArrayList<>();
        Date date = new Date();
        for (Long toUserId : toUserIds) {
            if(!fromUserId.equals(toUserId)) {//自己给自己点赞、评论，不加消息
                MessageRecordEntity messageRecordEntity = new MessageRecordEntity();
                messageRecordEntity.setCreateTime(date);
                messageRecordEntity.setIsRead(0);
                messageRecordEntity.setFromUserId(fromUserId);
                messageRecordEntity.setToUserId(toUserId);
                messageRecordEntity.setMessageType(messageType);
                messageRecordEntity.setMessageTab(messageTab);
                messageRecordEntity.setMessageTabType(messageTabType);
                messageRecordEntity.setMessageContent(messageContent);
                messageRecordEntity.setRecordId(recordId);
                list.add(messageRecordEntity);
            }
        }
        return list;
    }

    @Override
    public Map messageStatus(Long userId) {
        return baseMapper.messageStatus(userId);
    }

    @Override
    public Integer changeMessageStatus(Map<String, Object> params) {
        return baseMapper.changeMessageStatus(params);
    }
}
