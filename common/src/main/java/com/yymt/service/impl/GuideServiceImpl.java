package com.yymt.service.impl;

import com.baomidou.mybatisplus.mapper.SqlHelper;
import com.yymt.common.annotation.DataFilter;
import com.yymt.common.annotation.YYTDataFilter;
import com.yymt.entity.sport.OrganizationEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.yymt.common.utils.PageUtils;
import com.yymt.common.utils.Query;

import com.yymt.dao.sport.GuideDao;
import com.yymt.entity.sport.GuideEntity;
import com.yymt.service.GuideService;


@Service("guideService")
public class GuideServiceImpl extends ServiceImpl<GuideDao, GuideEntity> implements GuideService {

    @Override
    @DataFilter(subDept = true, user = false)
    public PageUtils queryPage(Map<String, Object> params) {
        boolean isKeywordExist = params.get("name") == null ? false : true;
        Page<GuideEntity> page = this.selectPage(
                new Query<GuideEntity>(params).getPage(),
                new EntityWrapper<GuideEntity>().eq("status",2).like(isKeywordExist, "name", params.get("name") == null ? "" : params.get("name").toString())
        );

        return new PageUtils(page);
    }

    /**
     * 获取指定标识集的指南列表
     *
     * @param ids 指南标识集
     */
    @Override
    public List<GuideEntity> getGuideListByIds(List<Integer> ids) {
        return baseMapper.getGuideListByIds(ids);
    }

    @Override
    @YYTDataFilter(userId="author_id",auditPermission = "sport:guide:audit")
    public PageUtils queryGuidePage(Map<String, Object> param) {
        Page<GuideEntity> page = new Query<GuideEntity>(param).getPage();
        EntityWrapper entityWrapper = new EntityWrapper<GuideEntity>();
        SqlHelper.fillWrapper(page, entityWrapper);
        page.setRecords(baseMapper.queryGuidePage(
                page,
                param
        ));
        return new PageUtils(page);
    }

    @Override

    public void allAudit(List<Integer> ids, Integer status,Long auditorId) {
        baseMapper.allAudit(ids,status,auditorId);
    }

    @Override
    @YYTDataFilter(userId="author_id",auditPermission = "sport:guide:audit")
    public int auditCount(Map<String, Object> params) {
        return baseMapper.auditCount(params);
    }

}
