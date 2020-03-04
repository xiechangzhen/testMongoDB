package com.yymt.service.impl;

import com.baomidou.mybatisplus.mapper.SqlHelper;
import com.yymt.common.annotation.DataFilter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.yymt.common.utils.PageUtils;
import com.yymt.common.utils.Query;

import com.yymt.dao.sport.CoachingServiceDao;
import com.yymt.entity.sport.CoachingServiceEntity;
import com.yymt.service.CoachingServiceService;


@Service("coachingServiceService")
public class CoachingServiceServiceImpl extends ServiceImpl<CoachingServiceDao, CoachingServiceEntity> implements CoachingServiceService {

    @Override
    @DataFilter(subDept = true, user = false)
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CoachingServiceEntity> page = this.selectPage(
                new Query<CoachingServiceEntity>(params).getPage(),
                new EntityWrapper<CoachingServiceEntity>()
        );

        return new PageUtils(page);
    }

    /**
     * 分页查询教练服务
     *
     * @param params
     * @return
     */
    @Override
    public PageUtils listCoachingService(Map<String, Object> params) {
        Page<CoachingServiceEntity> page = new Query<CoachingServiceEntity>(params).getPage();
        EntityWrapper entityWrapper = new EntityWrapper<CoachingServiceEntity>();
        SqlHelper.fillWrapper(page, entityWrapper);
        page.setRecords(baseMapper.listCoachingService(
                page,
                params
        ));
        return new PageUtils(page);
    }

    /**
     * 教练服务详情查询
     *
     * @param serviceId
     * @return
     */
    @Override
    public CoachingServiceEntity queryCoachingServiceById(Integer serviceId) {
        return baseMapper.queryCoachingServiceById(serviceId);
    }

    /**
     * 后台获取教练服务列表
     *
     * @param params
     * @return
     */
    @Override
    public PageUtils queryCoachingServiceListPage(Map<String, Object> params) {
        Page<CoachingServiceEntity> page = new Query<CoachingServiceEntity>(params).getPage();
        EntityWrapper entityWrapper = new EntityWrapper<CoachingServiceEntity>();
        SqlHelper.fillWrapper(page, entityWrapper);
        page.setRecords(baseMapper.queryCoachingServiceListPage(
                page,
                params
        ));
        return new PageUtils(page);
    }

    /**
     * 后台获取待审核教练服务数量
     *
     * @param params
     * @return
     */
    @Override
    public int coachingServiceAuditCount(Map<String, Object> params) {
        return baseMapper.coachingServiceAuditCount(params);
    }

    /**
     * 后台获取被举报教练服务数量
     *
     * @param params
     * @return
     */
    @Override
    public int coachingServiceRevealCount(Map<String, Object> params) {
        return baseMapper.coachingServiceRevealCount(params);
    }

    /**
     * 获取指定标识集的教练服务列表
     *
     * @param ids
     * @return
     */
    @Override
    public List<CoachingServiceEntity> getCoachingServiceListByIds(List<Integer> ids) {
        return baseMapper.getCoachingServiceListByIds(ids);
    }

}
