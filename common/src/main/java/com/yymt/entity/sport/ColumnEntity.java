package com.yymt.entity.sport;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 新闻栏目表
 *
 * @author hgq
 * @date 2018-04-28 15:10:49
 */
@TableName("tb_column")
public class ColumnEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 *
	 */
	@TableId
	private Integer id;
	/**
	 * 父栏目
	 */
	private Integer columnParentId;
	/**
	 * 栏目名称
	 */
	private String columnName;
	/**
	 * 栏目标识值
	 */
	private String columnValue;
	/**
	 * 是否显示栏目
	 */
	private Integer columnIsShow;
	/**
	 * 栏目图片
	 */
	private String columnNaviPic;
	/**
	 * 栏目状态
	 */
	private Integer columnStatus;
	/**
	 * 栏目是否删除
	 */
	private Integer columnIsDelete;
	/**
	 * 是否可以删除
	 */
	private Integer canDelete;
	/**
	 * 栏目创建时间
	 */
	private Date columnCreateTime;
	/**
	 * 栏目创建人
	 */
	private Long columnCreateBy;
	/**
	 * 栏目修改时间
	 */
	private Date columnModifyTime;
	/**
	 * 栏目修改人
	 */
	private Long columnModifiedBy;
	/**
	 * 备注
	 */
	private String remark;

	/**
	 * 设置：
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：父栏目
	 */
	public void setColumnParentId(Integer columnParentId) {
		this.columnParentId = columnParentId;
	}
	/**
	 * 获取：父栏目
	 */
	public Integer getColumnParentId() {
		return columnParentId;
	}
	/**
	 * 设置：栏目名称
	 */
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	/**
	 * 获取：栏目名称
	 */
	public String getColumnName() {
		return columnName;
	}
	/**
	 * 设置：栏目标识值
	 */
	public void setColumnValue(String columnValue) {
		this.columnValue = columnValue;
	}
	/**
	 * 获取：栏目标识值
	 */
	public String getColumnValue() {
		return columnValue;
	}
	/**
	 * 设置：是否显示栏目
	 */
	public void setColumnIsShow(Integer columnIsShow) {
		this.columnIsShow = columnIsShow;
	}
	/**
	 * 获取：是否显示栏目
	 */
	public Integer getColumnIsShow() {
		return columnIsShow;
	}
	/**
	 * 设置：栏目图片
	 */
	public void setColumnNaviPic(String columnNaviPic) {
		this.columnNaviPic = columnNaviPic;
	}
	/**
	 * 获取：栏目图片
	 */
	public String getColumnNaviPic() {
		return columnNaviPic;
	}
	/**
	 * 设置：栏目状态
	 */
	public void setColumnStatus(Integer columnStatus) {
		this.columnStatus = columnStatus;
	}
	/**
	 * 获取：栏目状态
	 */
	public Integer getColumnStatus() {
		return columnStatus;
	}
	/**
	 * 设置：栏目是否删除
	 */
	public void setColumnIsDelete(Integer columnIsDelete) {
		this.columnIsDelete = columnIsDelete;
	}
	/**
	 * 获取：栏目是否删除
	 */
	public Integer getColumnIsDelete() {
		return columnIsDelete;
	}
	/**
	 * 设置：是否可以删除
	 */
	public void setCanDelete(Integer canDelete) {
		this.canDelete = canDelete;
	}
	/**
	 * 获取：是否可以删除
	 */
	public Integer getCanDelete() {
		return canDelete;
	}
	/**
	 * 设置：栏目创建时间
	 */
	public void setColumnCreateTime(Date columnCreateTime) {
		this.columnCreateTime = columnCreateTime;
	}
	/**
	 * 获取：栏目创建时间
	 */
	public Date getColumnCreateTime() {
		return columnCreateTime;
	}
	/**
	 * 设置：栏目创建人
	 */
	public void setColumnCreateBy(Long columnCreateBy) {
		this.columnCreateBy = columnCreateBy;
	}
	/**
	 * 获取：栏目创建人
	 */
	public Long getColumnCreateBy() {
		return columnCreateBy;
	}
	/**
	 * 设置：栏目修改时间
	 */
	public void setColumnModifyTime(Date columnModifyTime) {
		this.columnModifyTime = columnModifyTime;
	}
	/**
	 * 获取：栏目修改时间
	 */
	public Date getColumnModifyTime() {
		return columnModifyTime;
	}
	/**
	 * 设置：栏目修改人
	 */
	public void setColumnModifiedBy(Long columnModifiedBy) {
		this.columnModifiedBy = columnModifiedBy;
	}
	/**
	 * 获取：栏目修改人
	 */
	public Long getColumnModifiedBy() {
		return columnModifiedBy;
	}
	/**
	 * 设置：备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：备注
	 */
	public String getRemark() {
		return remark;
	}
}
