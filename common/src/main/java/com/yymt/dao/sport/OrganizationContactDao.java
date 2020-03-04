package com.yymt.dao.sport;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.yymt.entity.sport.OrganizationContactEntity;
import com.yymt.entity.sport.OrganizationEntity;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

/**
 * 组织机构表
 *
 * @author cots
 * @date 2018-09-05 16:23:30
 */
public interface OrganizationContactDao extends BaseMapper<OrganizationContactEntity> {

}
