package com.burro.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.burro.common.SessionUtil;
import com.burro.entity.RoleEntity;
import com.burro.entity.common.TreeNode;
import com.burro.service.RoleService;
import com.framework.core.BaseManageController;
import com.framework.core.SessionManageEntity;
import com.power.common.StrUtil;

/**
 * 角色controller
 */
@Scope("prototype")
@Controller
@RequestMapping("/roleController")
public class RoleController extends BaseManageController {

	@Resource
	private RoleService roleService;

	/**
	 * 角色页面加载
	 */
	@RequestMapping("/subMain")
	public String subMain() {
		// 初始化帮助信息和功能权限
		super.setCommonAttribute(request);
		return "role/roleList";
	}

	/**
	 * 角色列表查询
	 */
	@RequestMapping("/selectRoleList")
	@ResponseBody
	public Map<String, Object> selectRoleList(RoleEntity paraRole) throws IOException {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", roleService.countRole(paraRole));
		map.put("rows", roleService.listRole(paraRole));
		return map;
	}

	/**
	 * 打开角色编辑页面
	 */
	@RequestMapping("/openEditPage")
	public String openEditPage(ModelMap map,String id) {
		if (StrUtil.isNotNull(id)) {
			map.put("role", roleService.getRoleById(id));
		}
		return "role/roleEdit";
	}

	
	
	/**
	 * 新增角色
	 */
	@RequestMapping("/insertRole")
	@ResponseBody
	public int insertRole(RoleEntity paraRole) throws IOException {
		SessionManageEntity user = SessionUtil.getSession(request);
		paraRole.setCreateBy(user.getUserId());
		paraRole.setUpdateBy(user.getUserId());
		return roleService.insertRole(paraRole);
	}


	/**
	 * 修改角色
	 */
	@ResponseBody
	@RequestMapping(value = { "/updateRole" })
	public long updateUser(RoleEntity paraRole) throws IOException {
		SessionManageEntity user = SessionUtil.getSession(request);
		paraRole.setUpdateBy(user.getUserId());
		return roleService.updateRole(paraRole);
	}

	/**
	 * 删除角色
	 */
	@ResponseBody
	@RequestMapping(value = { "/deleteRole" })
	public long deleteRole(String id,String roleId) throws IOException {
		SessionManageEntity user = SessionUtil.getSession(request);
		String currentUserId = user.getUserId();
		if (roleService.check(roleId)>0) {
			return -1;
		}
		if (StrUtil.isNotNull(id)) {
			return roleService.deleteRoleByIds(id, currentUserId);
		}
		return 0;
	}

	/**
	 * 打开角色编辑页面
	 */
	@RequestMapping("/openPowerPage")
	public String openPowerPage(ModelMap map,String roleId) {
		if (StrUtil.isNotNull(roleId)) {
			map.put("role", roleService.getRoleByRoleId(roleId));
		}
		return "role/rolePowerTree";
	}


	/**
	 * 取角色所有菜单
	 */
	@ResponseBody
	@RequestMapping("/getPowerMenuByRole")
	public List<TreeNode> getPowerMenuByRole(String roleId) {
		return this.roleService.getPowerMenuByRole(roleId);
	}

	@ResponseBody
	@RequestMapping("/updateRolePower")
	public int updateRolePower(String roleId,String menuIds,String funcIds) throws IOException {
		SessionManageEntity user = SessionUtil.getSession(request);
		String currentUserId = user.getUserId();
		return this.roleService.updateRolePower(menuIds, funcIds, roleId, currentUserId);
	}


}
