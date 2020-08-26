package com.burro.dao;

import org.apache.ibatis.annotations.Param;

import com.burro.entity.MenuPowerEntity;
import com.framework.core.IBaseManageDao;

/**
 * 菜单权限DAO
 */
public interface IMenuPowerDao extends IBaseManageDao<MenuPowerEntity> {
	/**
	 * 通过角色Id删除用户菜单权限
	 */
	public int deleteByRoleId(@Param("roleId") String roleId, @Param("updateBy") String updateBy);
	
	/**
	 * 通过角色Id删除用户菜单权限
	 */
	public int insertByRoleId(@Param("powerType")String powerType,@Param("roleId") String roleId,@Param("menuIds")String[] menuIds,@Param("createBy") String createBy);

	//删除02菜单
	public int deleteByRoleIdChange(@Param("roleId") String roleId, @Param("updateBy") String updateBy);

}
