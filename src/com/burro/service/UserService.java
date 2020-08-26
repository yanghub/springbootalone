package com.burro.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.burro.dao.IFuncPowerDao;
import com.burro.dao.IMenuPowerDao;
import com.burro.dao.IUserDao;
import com.burro.entity.UserEntity;
import com.burro.entity.common.TreeNode;

/**
 * 用户信息 service
 */
@Service
public class UserService {

	@Resource
	private IUserDao userDao;

	@Resource
	private IMenuPowerDao menuPowerDao;

	@Resource
	private IFuncPowerDao funcPowerDao;

	/**
	 * 新增用户
	 */
	public int insertUser(UserEntity user) {
		int result = 0;

		if (this.userDao.checkByUserId(user.getUserId()) <= 0) {
			result = this.userDao.insert(user);
		} else {
			result = -1;
		}

		return result;
	}

	/**
	 * 通过id查询用户
	 */

	public UserEntity getUserById(String id) {
		return this.userDao.getById(id);
	}

	/**
	 * 通过条件查询多个用户
	 */

	public List<UserEntity> listUser(UserEntity user) {
		return this.userDao.list(user);
	}

	/**
	 * 通过条件统计用户
	 */

	public long countUser(UserEntity user) {
		return this.userDao.count(user);
	}

	/**
	 * 更新用户
	 */

	public long updateUser(UserEntity user) {
		return this.userDao.update(user);
	}

	/**
	 * 批量删除用户
	 */

	public int deleteUserByIds(String userIds,String editUserIds,String updateBy) {
		int result = 0;

		String[] arrayUserIds = userIds.split(",");
		if (arrayUserIds.length > 0) {
			for (int i = 0; i < arrayUserIds.length; i++) {
				int tmpResult = this.userDao.deleteById(arrayUserIds[i], updateBy);
				result = result + tmpResult;
			}
		}
		result=result+userDao.deleteUserPower(editUserIds, updateBy)+userDao.deleteFuncPower(editUserIds, updateBy);
		return result;
	}

	/**
	 * 通过账号获取用户
	 */

	public UserEntity getUserByUserId(String userId) {
		return this.userDao.getByUserId(userId);
	}
	
	
	/**
	 * 增减权限按钮：列出当前登录用户可操作的用户权限以及角色权限
	 */
	public List<TreeNode> listUserPowerByUserIdChange(String currentUserId, // 当前登录用户的id
			String currentUserRoleId, // 当前登录用户的角色id
			String editUserId, // 编辑用户的id
			String editUserRoleId) { // 编辑用户的角色id
		//获取当前用户所能操作的菜单 功能列表   
		List<TreeNode> list = userDao.listUserPowerByUserIdChange(currentUserId, currentUserRoleId, editUserId, editUserRoleId);
		//获取选中用户的角色权限的子节点和父节点 
		List<TreeNode> role = userDao.listRolePower(editUserId, editUserRoleId);
		//获取选中用户的所有权限的子节点和父节点
		List<TreeNode> checked = userDao.listChecked(editUserId, editUserRoleId);
		//获取选中用户的角色权限中减权限(power_type=02)的子节点和父节点
		List<TreeNode> roleChecked = userDao.roleChecked(editUserId, editUserRoleId);
		//roleFlag字段判断是否为角色权限   指定用户权限在当前登录用户权限下的角色权限，将其对应的roleFlag字段设置为true
		for (TreeNode roles : role) {
			for (TreeNode lists : list) {
				if (roles.getId().equals(lists.getId())&&roles.getpId().equals(lists.getpId())) {
					lists.setRoleFlag("true");
				}
			}
		}
		//checked字段为判断是否勾选，指定用户权限在当前登录用户权限下的所有权限，将其对应的checked字段设置为true
		for (TreeNode checkeds : checked) {
			for (TreeNode lists : list) {
				if (checkeds.getId().equals(lists.getId())&&checkeds.getpId().equals(lists.getpId())) {
					lists.setChecked("true");
				}
			}
		}
		//checked字段为判断是否勾选，指定用户权限在当前登录用户权限下的减权限(power_type=02)，将其对应的checked字段设置为false
		for (TreeNode roleCheckeds : roleChecked) {
			for (TreeNode lists : list) {
				if (roleCheckeds.getId().equals(lists.getId())&&roleCheckeds.getpId().equals(lists.getpId())) {
					lists.setChecked("false");
				}
			}
		}
		return list;
	}
	
	
	public int updateUserPower(String userId,String menuIds, String funcIds,String currentUserId) {
		int count = 0;
		// 更新菜单权限 先删除之前的用户菜单权限
		count += this.menuPowerDao.deleteByRoleId(userId, currentUserId);
		// 插入新的用户菜单
		if (menuIds != "" && menuIds.endsWith(",")) {
			menuIds = menuIds.substring(0, menuIds.lastIndexOf(","));
			String[] menuIdArr = menuIds.split(",");
			count += this.menuPowerDao.insertByRoleId("01", userId, menuIdArr, currentUserId);
		} else {
			count += this.menuPowerDao.deleteByRoleId(userId, userId);
		}
		// 更新功能权限 先删除之前用户的功能权限
		count += this.funcPowerDao.deleteByRoleId(userId, currentUserId);
		// 插入新的用户功能权限
		if (!("".equals(funcIds.trim())) && funcIds.endsWith(",")) {
			funcIds = funcIds.substring(0, funcIds.lastIndexOf(","));
			String[] funcIdAndMenuIdArrs = funcIds.split(",");
			// 插入新的功能权限
			count += this.funcPowerDao.insertByRoleId("01", userId, funcIdAndMenuIdArrs, currentUserId);
		}
		return count;
	}
	
	
	/**
	 * 增减权限按钮：修改当前登录用户可操作的用户权限以及角色权限
	 */
	public int updateUserPowerChange(String userId,String roleMenuIds,String roleFuncIds,String currentUserId) {
		int count = 0;
		// 更新菜单权限    先删除之前的角色002菜单权限
		//	count += this.menuPowerDao.deleteByRoleIdChange(userId, currentUserId);
		// 插入新的用户菜单
		if (roleMenuIds != "" && roleMenuIds.endsWith(",")) {
			roleMenuIds = roleMenuIds.substring(0, roleMenuIds.lastIndexOf(","));
			String[] menuIdArr = roleMenuIds.split(",");
			count += this.menuPowerDao.insertByRoleId("02", userId, menuIdArr, currentUserId);
		} else {
			count += this.menuPowerDao.deleteByRoleIdChange(userId, userId);
		}
		// 更新功能权限 先删除之前角色002的功能权限
		//	count += this.funcPowerDao.deleteByRoleIdChange(userId, currentUserId);
		// 插入新的用户功能权限
		if (!("".equals(roleFuncIds.trim())) && roleFuncIds.endsWith(",")) {
			roleFuncIds = roleFuncIds.substring(0, roleFuncIds.lastIndexOf(","));
			String[] funcIdAndMenuIdArrs = roleFuncIds.split(",");
			// 插入新的功能权限
			count += this.funcPowerDao.insertByRoleId("02", userId, funcIdAndMenuIdArrs, currentUserId);
		}
		return count;
	}
	
	
}