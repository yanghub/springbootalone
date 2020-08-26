package com.burro.controller;

import java.io.IOException;
import java.util.ArrayList;
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
import com.burro.entity.MenuEntity;
import com.burro.entity.common.TreeNode;
import com.burro.service.CommonMethodService;
import com.burro.service.MenuService;
import com.framework.core.BaseManageController;
import com.framework.core.SessionManageEntity;
import com.power.common.StrUtil;
import com.power.entity.ExcelHeadInfo;

/**
 * 菜单管理模块
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/menuController")
public class MenuController extends BaseManageController {

	@Resource
	private MenuService menuService;
	@Resource
	private CommonMethodService commonMethodService;
	
	@RequestMapping(value = { "/subMain" })
	public String menuMain() {
		// 初始化帮助信息 和 功能权限
		super.setCommonAttribute(request);
		return "menu/menuList";
	}

	/**
	 * 查询菜单列表
	 */
	@ResponseBody
	@RequestMapping(value = { "/selectMenuList" })
	public Map<String, Object> selectMenuList(MenuEntity paraMenu){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", menuService.count(paraMenu));
		map.put("rows", menuService.list(paraMenu));
		return map;
	}

	/**
	 * 新增菜单
	 */
	@ResponseBody
	@RequestMapping(value = { "/insertMenu" })
	public int insertMenu(MenuEntity paraMenu) throws IOException {
		SessionManageEntity user = SessionUtil.getSession(request);
		paraMenu.setCreateBy(user.getUserId());
		paraMenu.setUpdateBy(user.getUserId());
		return menuService.insertMenu(paraMenu);
	}

	/**
	 * 修改菜单
	 */
	@ResponseBody
	@RequestMapping(value = { "/updateMenu" })
	public long updateMenu(MenuEntity paraMenu) throws IOException {
		SessionManageEntity user = SessionUtil.getSession(request);
		paraMenu.setUpdateBy(user.getUserId());
		return menuService.updateMenu(paraMenu);
	}

	/**
	 * 删除菜单
	 * @throws IOException 
	 */
	@ResponseBody
	@RequestMapping(value = { "/deleteMenu" })
	public int deleteMenu(String menuIds) throws IOException{
		SessionManageEntity user = SessionUtil.getSession(request);
		if (StrUtil.isNotNull(menuIds)) {
			return menuService.deleteMenuById(menuIds, user.getUserId());
		}
		return 0;
	}

	/**
	 * 打开编辑页
	 */
	@RequestMapping(value = { "/openEditPage" })
	public String openEditPage(ModelMap map,String id) throws IOException {
		if (StrUtil.isNotNull(id)) {
			map.put("menu", menuService.getMenuById(id));
		}
		return "menu/menuEdit";
	}

	/**
	 * 打开设置菜单基本功能信息设置页面
	 */
	@RequestMapping(value = { "/openBaseFuncPage" })
	public String openBaseFuncPage(ModelMap map, String strMenuId) throws IOException {
		map.put("strMenuId", strMenuId);
		return "menu/baseFuncMenu";
	}

	/**
	 * 获取所有功能菜单基本功能信息设置
	 */
	@RequestMapping("/getBaseFuncList")
	@ResponseBody
	public List<TreeNode> getBaseFuncList(String strMenuId) {
		return menuService.listBaseFunc(strMenuId);
	}

	/**
	 * 保存所有功能菜单基本功能信息设置
	 */
	@RequestMapping(value = { "/saveBaseFunc" })
	@ResponseBody
	public int saveBaseFunc(String strMenuId, String strMenuFuncIds) throws IOException {
		SessionManageEntity user = SessionUtil.getSession(request);
		
		return this.menuService.insertMenuFunc(user.getUserId(), strMenuId, strMenuFuncIds);
	}


}
