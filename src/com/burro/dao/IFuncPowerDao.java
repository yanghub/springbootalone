package com.burro.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.burro.entity.FuncPowerEntity;

/**
 * 功能权限DAO
 */
public interface IFuncPowerDao {

	/**
	 * 通过角色Id删除用户功能权限
	 */
	public int deleteByRoleId(@Param("roleId") String roleId, @Param("updateBy") String updateBy);

	/**
	 * 新增用户功能权限
	 */
	public int insertByRoleId(@Param("powerType") String powerType, @Param("roleId") String roleId, @Param("funcIdAndMenuIdArrs")String[] funcIdAndMenuIdArrs,
			@Param("createBy") String createBy);

	/**
	 * 通过menuId获取当前操作页面的当前用户的功能权限
	 */
	public List<FuncPowerEntity> listByMenuId(@Param("menuId") String menuId, @Param("userId") String userId,
			@Param("userRoleId") String userRoleId);

}
