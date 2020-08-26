package com.burro.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.burro.entity.UserEntity;
import com.burro.entity.common.TreeNode;
import com.framework.core.IBaseManageDao;

/**
 * 用户管理DAO
 */
public interface IUserDao extends IBaseManageDao<UserEntity> {

	 //验证账号是否存在
	public int checkByUserId(String userId);

	//根据ID获取用户信息
	public UserEntity getByUserId(String userId);

	//通过用户的账号 删除用户菜单权限的个人权限以及角色减权限  
	public int deleteUserPower(@Param("userId") String userId, @Param("updateBy") String updateBy);
		
	//通过用户的账号 删除用户功能权限的个人权限以及角色减权限
	public int deleteFuncPower(@Param("userId") String userId, @Param("updateBy") String updateBy);
	
	//列出当前登录用户可操作的用户权限
	public List<TreeNode> listUserPowerByUserIdChange(@Param("currentUserId") String currentUserId, // 当前登录用户的id
			@Param("currentUserRoleId") String currentUserRoleId, // 当前登录用户的角色id
			@Param("editUserId") String editUserId, // 编辑用户的id
			@Param("editUserRoleId") String editUserRoleId); // 编辑用户的角色id
	//获取选中用户的角色权限的子节点和父节点
	public List<TreeNode> listRolePower(
			@Param("editUserId") String editUserId, // 编辑用户的id
			@Param("editUserRoleId") String editUserRoleId); // 编辑用户的角色id
	//获取选中用户的所有权限的子节点和父节点
	public List<TreeNode> listChecked(
				@Param("editUserId") String editUserId, // 编辑用户的id
				@Param("editUserRoleId") String editUserRoleId); // 编辑用户的角色id
	//获取选中用户的角色权限中减权限(power_type=02)的子节点和父节点
	public List<TreeNode> roleChecked(
			@Param("editUserId") String editUserId, // 编辑用户的id
			@Param("editUserRoleId") String editUserRoleId); // 编辑用户的角色id
}