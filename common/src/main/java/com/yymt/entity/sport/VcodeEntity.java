package com.yymt.entity.sport;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * 验证码
 * 
 * @author hgq
 * @date 2018-02-26 08:50:41
 */
@TableName("tb_vcode")
public class VcodeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 电话
	 */
	private String phone;
	/**
	 * 验证码
	 */
	private String vcode;
	/**
	 * 验证码类型
	 */
	private String type;
	/**
	 * 发送时间
	 */
	private Long timemillis;

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
	 * 设置：电话
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * 获取：电话
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * 设置：验证码
	 */
	public void setVcode(String vcode) {
		this.vcode = vcode;
	}
	/**
	 * 获取：验证码
	 */
	public String getVcode() {
		return vcode;
	}
	/**
	 * 设置：验证码类型
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取：验证码类型
	 */
	public String getType() {
		return type;
	}
	/**
	 * 设置：发送时间
	 */
	public void setTimemillis(Long timemillis) {
		this.timemillis = timemillis;
	}
	/**
	 * 获取：发送时间
	 */
	public Long getTimemillis() {
		return timemillis;
	}
}
