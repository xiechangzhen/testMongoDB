package com.yymt.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.SqlHelper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.yymt.common.annotation.YYTDataFilter;
import com.yymt.common.utils.PageUtils;
import com.yymt.common.utils.Query;
import com.yymt.dao.sport.HallDao;
import com.yymt.entity.sport.HallEntity;
import com.yymt.entity.sport.HallUserEntity;
import com.yymt.service.HallService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("hallService")
public class HallServiceImpl extends ServiceImpl<HallDao, HallEntity> implements HallService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<HallEntity> page = this.selectPage(
                new Query<HallEntity>(params).getPage(),
                new EntityWrapper<>()
        );

        return new PageUtils(page);
    }

    @Override
    public PageUtils listHall(Map<String, Object> params) {
        Page<HallEntity> page = new Query<HallEntity>(params).getPage();
        EntityWrapper entityWrapper = new EntityWrapper<HallEntity>();
        SqlHelper.fillWrapper(page, entityWrapper);
        page.setRecords(baseMapper.listHall(
                page,
                params
        ));
        return new PageUtils(page);
    }

    @Override
    public Map hallDetail(Map<String, Object> params) {
        return baseMapper.hallDetail(params);
    }

    @Override
    @YYTDataFilter(tableAlias = "th",userId="author",auditPermission = "sport:hall:audit")
    public PageUtils listHallForBackgroud(Map<String, Object> param) {
        Page<HallEntity> page = new Query<HallEntity>(param).getPage();
        EntityWrapper entityWrapper = new EntityWrapper<HallEntity>();
        SqlHelper.fillWrapper(page, entityWrapper);
        page.setRecords(baseMapper.listHallForBackgroud(
                page,
                param
        ));
        return new PageUtils(page);
    }

    /**
     * 获取指定标识集的场馆列表
     *
     * @param ids 场馆标识集
     */
    @Override
    public List<HallEntity> getHallsListByIds(List<Integer> ids) {
        return baseMapper.getHallsListByIds(ids);
    }

    @Override
    public Map hallDetailForBackground(int id) {
        return baseMapper.hallDetailForBackground(id);
    }

    @Override
    @YYTDataFilter(tableAlias = "th",userId="author",auditPermission = "sport:hall:audit")
    public int auditCount(Map<String, Object> params) {
        return baseMapper.auditCount(params);
    }

    /**
     * 查询未入驻某场馆的账号
     *
     * @param hallId 场馆id
     */
    @Override
    public List<Map<String,Object>> getUnbindUserByHallId(Integer hallId) {
        return baseMapper.getUnbindUserByHallId(hallId);
    }
    /**
     * 查询入驻某场馆的账号
     *
     * @param hallId 场馆id
     */
    @Override
    public List<Map<String,Object>> getBindUserByHallId(Integer hallId) {
        return baseMapper.getBindUserByHallId(hallId);
    }

    @Override
    public void deleteByHlllId(Integer hallId) {
        baseMapper.deleteByHlllId(hallId);
    }

    @Override
    public List<Integer> selectListUserId() {
        return baseMapper.selectListUserId();
    }

    @Override
    public List<Integer> selectListUserPosition() {
        return baseMapper.selectListUserPosition();
    }
    /**
     * 分页查询某场馆的入驻账号
     * */
    public PageUtils getBindUserByHallIdPage(Map<String, Object> params){
        Page page = new Query<HallUserEntity>(params).getPage();
        EntityWrapper entityWrapper = new EntityWrapper();
        SqlHelper.fillWrapper(page,entityWrapper);
        page.setRecords(baseMapper.getBindUserByHallIdPage(page,params));
        return new PageUtils(page);
    }

    @Override
    public void deleteHall(Integer[] ids) {
        baseMapper.deleteHall(ids);
    }
}
