package com.yymt.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.SqlHelper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.yymt.common.utils.Constant;
import com.yymt.common.utils.PageUtils;
import com.yymt.common.utils.Query;
import com.yymt.dao.sport.RevealDao;
import com.yymt.entity.sport.RevealEntity;
import com.yymt.service.RevealService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("revealService")
public class RevealServiceImpl extends ServiceImpl<RevealDao, RevealEntity> implements RevealService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<RevealEntity> page = this.selectPage(
                new Query<RevealEntity>(params).getPage(),
                new EntityWrapper<RevealEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    //后台举报列表
    public PageUtils queryRevealPage(Map<String, Object> params){
        Page<RevealEntity> page = new Query<RevealEntity>(params).getPage();
        EntityWrapper entityWrapper = new EntityWrapper<RevealEntity>();
        SqlHelper.fillWrapper(page, entityWrapper);
        page.setRecords(baseMapper.queryRevealPage(
                page,
                params
        ));
        return new PageUtils(page);
    }

    /**
     * 将后台处理数据为正常的举报更新为“无效举报”
     * @param revealType 举报类型
     * @param revealContentId 举报的内容id
     */
    @Override
    public void updateRevealAsInvalid(Integer revealType, Integer revealContentId) {
        //把该条数据之前的举报更新为“无效举报”
        RevealEntity updateEntity = new RevealEntity();//更新的实体
        updateEntity.setRevealStatus(Constant.REVEAL_INVALID);//无效举报

        RevealEntity queryEntity = new RevealEntity();//查询的实体
        queryEntity.setRevealType(revealType);//举报类型
        queryEntity.setRevealContentId(revealContentId);//举报的动态id
        baseMapper.update(updateEntity,new EntityWrapper<>(queryEntity));
    }

}
