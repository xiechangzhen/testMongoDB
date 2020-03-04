package com.yymt.service.impl;

import com.baomidou.mybatisplus.mapper.SqlHelper;
import com.yymt.common.annotation.DataFilter;
import com.yymt.common.annotation.YYTDataFilter;
import com.yymt.entity.sport.NewsEntity;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.yymt.common.utils.PageUtils;
import com.yymt.common.utils.Query;

import com.yymt.dao.sport.OrganizationDao;
import com.yymt.entity.sport.OrganizationEntity;
import com.yymt.service.OrganizationService;


@Service("organizationService")
public class OrganizationServiceImpl extends ServiceImpl<OrganizationDao, OrganizationEntity> implements OrganizationService {

    @Override
    @DataFilter(subDept = true, user = false)
    public PageUtils queryPage(Map<String, Object> params) {
        boolean isKeywordExist = params.get("keyword") == null ? false : true;
        Page<OrganizationEntity> page = this.selectPage(
                new Query<OrganizationEntity>(params).getPage(),
                new EntityWrapper<OrganizationEntity>().eq("status",2).like(isKeywordExist, "org_name", params.get("keyword") == null ? "" : params.get("keyword").toString())
        );

        return new PageUtils(page);
    }

    @Override
    public List listOrganazitionContact(int id) {
        return baseMapper.listOrganazitionContact(id);
    }

    /**
     * 获取指定标识集的机构列表
     *
     * @param ids 机构标识集
     */
    @Override
    public List<OrganizationEntity> getOrganizationListByIds(List<Integer> ids) {
        return baseMapper.getOrganizationListByIds(ids);
    }

    @Override
    @YYTDataFilter(userId="author_id",auditPermission = "sport:organization:audit")
    public PageUtils queryOrganizationPage(Map<String, Object> params) {
        Page<OrganizationEntity> page = new Query<OrganizationEntity>(params).getPage();
        EntityWrapper entityWrapper = new EntityWrapper<OrganizationEntity>();
        SqlHelper.fillWrapper(page, entityWrapper);
        page.setRecords(baseMapper.queryOrganizationPage(
                page,
                params
        ));
        return new PageUtils(page);
    }

    @Override
    public Map<String, Object> selectOrgById(Integer id) {
        return baseMapper.selectOrgById(id);
    }

    @Override
    @YYTDataFilter(userId="author_id",auditPermission = "sport:organization:audit")
    public Integer count(Map<String, Object> params) {
        return baseMapper.count(params);
    }

    @Override
    public void deleteOrganizationContactIds(List ids) {
        baseMapper.deleteOrganizationContactIds(ids);
    }

}
