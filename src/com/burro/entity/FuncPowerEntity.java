package com.burro.entity;

import com.framework.core.BaseManageEntity;

/**
 * m_func_power-功能权限表
 */
public class FuncPowerEntity extends BaseManageEntity {

	private String powerType; // 权限类别
	private String powerId; // 权限ID
	private String menuId; // 菜单ID
	private String funcId; // 功能ID
	private String funcType; // 功能类型

	/**
	 * 设定【权限类别】
	 */
	public void setPowerType(String powerType) {
		this.powerType = powerType;
	}

	/**
	 * 取得【权限类别】
	 */
	public String getPowerType() {
		return powerType;
	}

	/**
	 * 设定【权限ID】
	 */
	public void setPowerId(String powerId) {
		this.powerId = powerId;
	}

	/**
	 * 取得【权限ID】
	 */
	public String getPowerId() {
		return powerId;
	}

	/**
	 * 设定【菜单ID】
	 */
	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	/**
	 * 取得【菜单ID】
	 */
	public String getMenuId() {
		return menuId;
	}

	/**
	 * 设定【功能ID】
	 */
	public void setFuncId(String funcId) {
		this.funcId = funcId;
	}

	/**
	 * 取得【功能ID】
	 */
	public String getFuncId() {
		return funcId;
	}

	/**
	 * 设定【功能类型】
	 */
	public String getFuncType() {
		return funcType;
	}

	/**
	 * 取得【功能类型】
	 */
	public void setFuncType(String funcType) {
		this.funcType = funcType;
	}
}
