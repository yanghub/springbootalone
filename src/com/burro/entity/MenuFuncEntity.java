package com.burro.entity;

import com.framework.core.BaseManageEntity;

/**
 * m_menu_func-菜单功能
 */
public class MenuFuncEntity extends BaseManageEntity {

	// 菜单代码
	private String menuId;

	// 功能代码
	private String funcId;

	// 备注
	private String remark;

	// 创建人
	private String createBy;

	// 创建时间
	private String createDate;

	// 修改人
	private String updateBy;

	// 修改时间
	private String updateDate;

	// 删除状态
	private String delFlag;


	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	public String getFuncId() {
		return funcId;
	}

	public void setFuncId(String funcId) {
		this.funcId = funcId;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}


}
