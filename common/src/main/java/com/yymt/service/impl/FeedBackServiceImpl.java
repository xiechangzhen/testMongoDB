package com.yymt.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.SqlHelper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.yymt.common.utils.PageUtils;
import com.yymt.common.utils.Query;
import com.yymt.dao.sport.FeedBackDao;
import com.yymt.entity.sport.FeedBackEntity;
import com.yymt.service.FeedBackService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("feedBackService")
public class FeedBackServiceImpl extends ServiceImpl<FeedBackDao, FeedBackEntity> implements FeedBackService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {

        if(params.get("status") != null && StringUtils.isNotBlank(params.get("status").toString())) {
            Integer tab = Integer.parseInt(params.get("status").toString());
            params.put("status", filterStatus(tab));//将传过来的status重新更改一下
        }

        Page<FeedBackEntity> page = new Query<FeedBackEntity>(params).getPage();
        EntityWrapper entityWrapper = new EntityWrapper<FeedBackEntity>();
        SqlHelper.fillWrapper(page, entityWrapper);
        page.setRecords(baseMapper.queryFeedbackListApp(
                page,
                params
        ));
        return new PageUtils(page);

    }

    /**
     * app反馈状态(传递的状态：0未解决 1已解决)
     * 状态 0-未处理，1-待解决，2-已解决
     * @param tab
     * @return
     */
    private String[] filterStatus(Integer tab){
        String[] tabs = null;
        if( tab == 0 ){
            tabs = new String[]{"0","1"};
        }else if( tab == 1 ){
            tabs = new String[]{"2"};
        }
        return tabs;
    }

    /**
     * 后台反馈列表
     * @param params
     * @return
     */
    @Override
    public PageUtils queryFeedbackPage(Map<String, Object> params) {
        Page<FeedBackEntity> page = new Query<FeedBackEntity>(params).getPage();
        EntityWrapper entityWrapper = new EntityWrapper<FeedBackEntity>();
        SqlHelper.fillWrapper(page, entityWrapper);
        page.setRecords(baseMapper.queryFeedbackList(
                page,
                params
        ));
        return new PageUtils(page);
    }

    @Override
    public int queryUnhandleFeedbackNum(Map<String, Object> params) {
        return baseMapper.queryUnhandleFeedbackNum(params);
    }

    public Map feedbackDetail(Integer id){
        return baseMapper.feedbackDetail(id);
    }

}
