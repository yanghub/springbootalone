package com.burro.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.burro.entity.BaseFuncEntity;
import com.burro.entity.MenuEntity;
import com.burro.entity.MenuFuncEntity;
import com.framework.core.IBaseManageDao;

/**
 * 菜单操作DAO
 */
public interface IMenuDao extends IBaseManageDao<MenuEntity>{
	
	/**
	 * 通过菜单的url 获取菜单信息
	 */
	public MenuEntity getByUrl(@Param("menuUrl")String url);
	
	/**
	 * 通过条件查询基本功能信息列表
	 */
	public List<BaseFuncEntity> listBaseFunc(BaseFuncEntity baseFuncEntity);

	/**
	 * 通过Id查询菜单下的基本功能信息列表
	 */
	public List<MenuFuncEntity> listMenuFuncById(@Param("menuId")String menuId);

	/**
	 * 通过菜单id删除菜单下的所有基本功能信息
	 */
	public int deleteMenuFuncByMuneId(String strMenuId, String updateBy);

	/**
	 * 新增
	 */
	public int insertMenuFunc(MenuFuncEntity menuFuncEntity);
}