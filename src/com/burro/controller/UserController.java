package com.burro.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.burro.common.SessionUtil;
import com.burro.entity.UserEntity;
import com.burro.entity.common.TreeNode;
import com.burro.service.UserService;
import com.framework.core.BaseManageController;
import com.framework.core.SessionManageEntity;
import com.power.common.StrUtil;

@Scope("prototype")
@Controller
@RequestMapping("/userController")
public class UserController extends BaseManageController {

	@Resource
	private UserService userService;

	/**
	 * 打开首页
	 * @throws IOException 
	 */
	@RequestMapping(value = { "/subMain" })
	public String subMain() throws IOException {
		// 初始化帮助信息和功能权限信息
		super.setCommonAttribute(request);
		return "user/userList";
	}

	/**
	 * 打开编辑页
	 * @throws IOException 
	 */
	@RequestMapping(value = { "/openEditPage" })
	public String openEditPage(String id) throws IOException {
		SessionManageEntity user = SessionUtil.getSession(request);
		String currentUserRoleId = user.getUserRoleId();
		UserEntity editUser = null;
		if (StrUtil.isNotNull(id)) {
			editUser = userService.getUserById(id);
		}
		request.setAttribute("editUser", editUser);
		request.setAttribute("currentUserRoleId", currentUserRoleId);
		return "user/userEdit";
	}

	/**
	 * 查询用户列表
	 * @throws IOException 
	 */
	@ResponseBody
	@RequestMapping(value = { "/selectUserList" })
	public Map<String, Object> selectUserList(UserEntity paraUser) throws IOException {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", userService.countUser(paraUser));
		map.put("rows", userService.listUser(paraUser));
		return map;
	}

	/**
	 * 新增用户
	 */
	@ResponseBody
	@RequestMapping(value = { "/insertUser" })
	public int insertUser(UserEntity paraUser) throws IOException {
		SessionManageEntity user = SessionUtil.getSession(request);
		paraUser.setCreateBy(user.getUserId());
		paraUser.setUpdateBy(user.getUserId());
		return userService.insertUser(paraUser);
	}

	/**
	 * 修改用户
	 */
	@ResponseBody
	@RequestMapping(value = { "/updateUser" })
	public long updateUser(UserEntity paraUser) throws IOException {
		SessionManageEntity user = SessionUtil.getSession(request);
		paraUser.setUpdateBy(user.getUserId());
		return userService.updateUser(paraUser);
	}
	
	
	/**
	 * 删除用户
	 */
	@ResponseBody
	@RequestMapping(value = { "/deleteUser" })
	public int deleteUser(Model model,String userIds,String editUserIds) throws IOException {
		SessionManageEntity user = SessionUtil.getSession(request);
		String currentUserId = user.getUserId();
		if (StrUtil.isNotNull(userIds)) {
			return userService.deleteUserByIds(userIds,editUserIds, currentUserId);
		}
		return 0;
	}
	
	
	/**
	 * 增减权限按钮 打开增减权限用户权限编辑页
	 */
	@RequestMapping(value = { "/openUserPowerPageChange" })
	public String openUserPowerPageChange(String editUserId, String editUserRoleId) {
		request.setAttribute("editUserId", editUserId);
		request.setAttribute("editUserRoleId", editUserRoleId);
		return "user/userPowerTreeChange";
	}
	
	
	/**
	 * 增减权限按钮：在当前用户所能操作的菜单 功能列表   查询指定用户的菜单功能权限 以及当前用户角色权限 
	 */
	@ResponseBody
	@RequestMapping("/listUserPowerByUserIdChange")
	public List<TreeNode> listUserPowerByUserIdChange(String editUserId,String editUserRoleId) throws IOException {
		SessionManageEntity user = SessionUtil.getSession(request);
		return this.userService.listUserPowerByUserIdChange(user.getUserId(), user.getUserRoleId(), editUserId, editUserRoleId);
	}
	
	
	/**
	 * 增减权限按钮： 保存用户权限  保存选中个人权限  未选中的角色权限
	 */
	@ResponseBody
	@RequestMapping(value = { "/updateUserPowerChange" })
	public int saveUserPowerChange(String userId, String menuIds,String funcIds,String roleMenuIds,String roleFuncIds) throws IOException {
		SessionManageEntity user = SessionUtil.getSession(request);
		String currentUserId = user.getUserId();
		return this.userService.updateUserPower( userId,menuIds, funcIds, currentUserId)+this.userService.updateUserPowerChange(userId,roleMenuIds,roleFuncIds, currentUserId);
				
	}
}
