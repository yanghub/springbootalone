package com.burro.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.burro.entity.RoleEntity;
import com.burro.entity.common.TreeNode;
import com.framework.core.IBaseManageDao;

/**
 * 角色操作DAO
 */
public interface IRoleDao extends IBaseManageDao<RoleEntity>{

	//通过角色id查询单个角色
		public RoleEntity getByRoleId(@Param("roleId") String roleId);

		//根据角色加载菜单和功能
		public List<TreeNode> listMenuPowerByRoleId(@Param("roleId") String roleId);

		//取得所有操作权限
		public List<TreeNode> listAllOptPower();
		
		//取得当前角色下用户数量
		public long check(@Param("roleId") String roleId);

}