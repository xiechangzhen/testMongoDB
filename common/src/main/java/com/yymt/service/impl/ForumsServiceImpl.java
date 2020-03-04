package com.yymt.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.SqlHelper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.yymt.common.annotation.DataFilter;
import com.yymt.common.utils.Constant;
import com.yymt.common.utils.PageUtils;
import com.yymt.common.utils.Query;
import com.yymt.dao.sport.ForumsDao;
import com.yymt.entity.sport.ForumsEntity;
import com.yymt.service.ForumsService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("forumsService")
public class ForumsServiceImpl extends ServiceImpl<ForumsDao, ForumsEntity> implements ForumsService {

    @Override
    public Map selectForumsDetailBack(Integer id) {
        return baseMapper.selectForumsDetailBack(id);
    }

    /**
     * 后台获取社区列表
     * @param params
     * @return
     */
    @Override
    @DataFilter(subDept = true, user = false)
    public PageUtils queryPage(Map<String, Object> params) {
        //tabIndex:1举报中;2正常;3被推荐;
        String tabIndex = params.get("tabIndex") == null ? null :params.get("tabIndex").toString();
        if(StringUtils.equals("1",tabIndex)){
            params.put("revealing",true);
        }else if(StringUtils.equals("2",tabIndex)){
            params.put("forumsStatus", Constant.FORUMS_STATUS_NORMAL);
        } else if(StringUtils.equals("3",tabIndex)){
            params.put("isRecommend",1);
        }
        Page<ForumsEntity> page = new Query<ForumsEntity>(params).getPage();
        EntityWrapper entityWrapper = new EntityWrapper<ForumsEntity>();
        SqlHelper.fillWrapper(page, entityWrapper);
        page.setRecords(baseMapper.selectForumsListBack(
                page,
                params
        ));
        return new PageUtils(page);
    }

    @Override
    public Integer countRevealingForums(Map<String, Object> params) {
        return baseMapper.countRevealingForums(params);
    }

    /**
     * APP获取社区列表
     */
    @Override
    public PageUtils selectForumsList(Map<String, Object> params) {
        Page<ForumsEntity> page = new Query<ForumsEntity>(params).getPage();
        EntityWrapper entityWrapper = new EntityWrapper<ForumsEntity>();
        SqlHelper.fillWrapper(page, entityWrapper);
        page.setRecords(baseMapper.selectForumsList(
                page,
                params
        ));
        return new PageUtils(page);
    }

    /**
     * APP获取社区详情
     */
    @Override
    public Map selectForumsDetail(Map<String, Object> params) {
        return baseMapper.selectForumsDetail(params);
    }

    @Override
    public boolean deleteForumsAndCommentsAndGreatsBatch(Integer[] forumsId) {
        return baseMapper.deleteForumsAndCommentsAndGreatsBatch(forumsId);
    }

    /**
     * 获取指定标识集的社区帖子列表
     *
     * @param ids 社区帖子标识集
     */
    @Override
    public List<ForumsEntity> getPostListByIds(List<Integer> ids) {
        return baseMapper.getPostListByIds(ids);
    }

}
