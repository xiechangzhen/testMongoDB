package com.yymt.service.impl;

import com.baomidou.mybatisplus.mapper.SqlHelper;
import com.yymt.common.annotation.DataFilter;
import com.yymt.common.annotation.YYTDataFilter;
import com.yymt.entity.sport.GuideEntity;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.yymt.common.utils.PageUtils;
import com.yymt.common.utils.Query;

import com.yymt.dao.sport.IndustryPersonDao;
import com.yymt.entity.sport.IndustryPersonEntity;
import com.yymt.service.IndustryPersonService;


@Service("industryPersonService")
public class IndustryPersonServiceImpl extends ServiceImpl<IndustryPersonDao, IndustryPersonEntity> implements IndustryPersonService {

    @Override
    @DataFilter(subDept = true, user = false)
    public PageUtils queryPage(Map<String, Object> params) {
        boolean isKeywordExist = params.get("keyword") == null ? false : true;
        String keyword = isKeywordExist ? params.get("keyword").toString() : "";
        Page<IndustryPersonEntity> page = this.selectPage(
                new Query<IndustryPersonEntity>(params).getPage(),
                new EntityWrapper<IndustryPersonEntity>().like(isKeywordExist, "real_name", keyword)
        );
        return new PageUtils(page);
    }

    @Override
    public PageUtils listIndustryPerson(Map<String, Object> params) {
        Page<IndustryPersonEntity> page = new Query<IndustryPersonEntity>(params).getPage();
        EntityWrapper entityWrapper = new EntityWrapper<IndustryPersonEntity>();
        SqlHelper.fillWrapper(page, entityWrapper);
        page.setRecords(baseMapper.listIndustryPerson(
                page,
                params
        ));
        return new PageUtils(page);
    }

    public Map<String, Object> selectInfoById(Integer id) {
        return baseMapper.selectInfoById(id);
    }

    /**
     * 分页查询行业人员
     *
     * @param params
     * @return
     */
    @Override
    @YYTDataFilter(tableAlias = "ip",
            userId = "author_id",
            auditPermission = "sport:industryperson:audit")
    public PageUtils getIndustryPersonListPage(Map<String, Object> params) {
        Page<IndustryPersonEntity> page = new Query<IndustryPersonEntity>(params).getPage();
        EntityWrapper entityWrapper = new EntityWrapper<IndustryPersonEntity>();
        SqlHelper.fillWrapper(page, entityWrapper);
        page.setRecords(baseMapper.getIndustryPersonListPage(
                page,
                params
        ));
        return new PageUtils(page);
    }

    /**
     * 获取指定标识的行业人员
     *
     * @param id 行业人员标识
     * @return
     */
    @Override
    public IndustryPersonEntity getIndustryPersonById(Integer id) {
        return baseMapper.getIndustryPersonById(id);
    }

    /**
     * 获取指定标识集的行业人员列表
     *
     * @param ids 行业人员标识集
     */
    @Override
    public List<IndustryPersonEntity> getIndustryPersonListByIds(List<Integer> ids) {
        return baseMapper.getIndustryPersonListByIds(ids);
    }

    /**
     * 获取所有已审核通过的行业人员列表
     *
     * @return
     */
    @Override
    public List<IndustryPersonEntity> getIndustryPersonListAll() {
        return baseMapper.getIndustryPersonListAll();
    }

    /**
     * 获取待审核的行业人员数量
     *
     * @return
     */
    @Override
    public int auditCount() {
        return baseMapper.auditCount();
    }

    /**
     * 获取相关参数的待审核的行业人员数量
     *
     * @param params 相关查询参数
     * @return
     */
    @Override
    public int auditCount(Map<String, Object> params) {
        return baseMapper.auditCount(params);
    }
}
