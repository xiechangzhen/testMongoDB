package com.yymt.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.SqlHelper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.yymt.common.annotation.YYTDataFilter;
import com.yymt.common.utils.PageUtils;
import com.yymt.common.utils.Query;
import com.yymt.dao.sport.CorporationDao;
import com.yymt.entity.sport.CorporationEntity;
import com.yymt.service.CorporationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("corporationService")
public class CorporationServiceImpl extends ServiceImpl<CorporationDao, CorporationEntity> implements CorporationService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CorporationEntity> page = this.selectPage(
                new Query<CorporationEntity>(params).getPage(),
                new EntityWrapper<CorporationEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public PageUtils listCorporation(Map<String, Object> params) {
        Page<CorporationEntity> page = new Query<CorporationEntity>(params).getPage();
        EntityWrapper entityWrapper = new EntityWrapper<CorporationEntity>();
        SqlHelper.fillWrapper(page, entityWrapper);
        page.setRecords(baseMapper.listCorporation(
                page,
                params
        ));
        return new PageUtils(page);
    }

    @Override
    public Map corporationDetail(Map<String, Object> param) {
        return baseMapper.corporationDetail(param);
    }

    /**
     * 后台列表
     * @param params
     * @return
     */
    @Override
    @YYTDataFilter(tableAlias = "tc",userId="author",auditPermission = "sport:corporation:audit")
    public PageUtils listCorporationBackgroud(Map<String, Object> params) {
        Page<CorporationEntity> page = new Query<CorporationEntity>(params).getPage();
        EntityWrapper entityWrapper = new EntityWrapper<CorporationEntity>();
        SqlHelper.fillWrapper(page, entityWrapper);
        page.setRecords(baseMapper.listCorporationBackgroud(
                page,
                params
        ));
        return new PageUtils(page);
    }

    /**
     * 后台统计待审核数
     * @param params
     * @return
     */
    @Override
    @YYTDataFilter(userId="author",auditPermission = "sport:corporation:audit")
    public int auditCount(Map<String, Object> params) {
        return baseMapper.auditCount(params);
    }

    @Override
    public boolean deleteCorporationAndReleatedDataBatchs(Integer[] ids) {
        return baseMapper.deleteCorporationAndReleatedDataBatchs(ids);
    }

    /**
     * 获取指定标识集的社团列表
     *
     * @param ids 社团标识集
     */
    @Override
    public List<CorporationEntity> getCorporationListByIds(List<Integer> ids) {
        return baseMapper.getCorporationListByIds(ids);
    }

    @Override
    public Map corporationDetailForBackground(int id) {
        return baseMapper.corporationDetailForBackground(id);
    }

}
