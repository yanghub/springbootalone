package com.burro.entity.common;

/**
 * 获取用户操作权限
 */
public class OperationPowers {
	/**
	 * 查询 导出 等 权限
	 */
	private String condPowers;

	/**
	 * toorbar里的按钮功能权限
	 */
	private String funcPowers;

	/**
	 * 表格中的显示权限
	 */
	private String gridPowers;

	/**
	 * 导出excel的显示权限
	 */
	private String excelPowers;

	public String getCondPowers() {
		return condPowers;
	}

	public void setCondPowers(String condPowers) {
		this.condPowers = condPowers;
	}

	public String getFuncPowers() {
		return funcPowers;
	}

	public void setFuncPowers(String funcPowers) {
		this.funcPowers = funcPowers;
	}

	public String getGridPowers() {
		return gridPowers;
	}

	public void setGridPowers(String gridPowers) {
		this.gridPowers = gridPowers;
	}

	public String getExcelPowers() {
		return excelPowers;
	}

	public void setExcelPowers(String excelPowers) {
		this.excelPowers = excelPowers;
	}

	public OperationPowers() {
	}

	public OperationPowers(String condPowers, String funcPowers, String gridPowers, String excelPowers) {
		super();
		this.condPowers = condPowers;
		this.funcPowers = funcPowers;
		this.gridPowers = gridPowers;
		this.excelPowers = excelPowers;
	}

	@Override
	public String toString() {
		return "OperationPowers [condPowers=" + condPowers + ", funcPowers=" + funcPowers + ", gridPowers=" + gridPowers
				+ ", excelPowers=" + excelPowers + "]";
	}

}
