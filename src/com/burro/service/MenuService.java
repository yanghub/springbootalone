package com.burro.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.burro.dao.IMenuDao;
import com.burro.entity.BaseFuncEntity;
import com.burro.entity.MenuEntity;
import com.burro.entity.MenuFuncEntity;
import com.burro.entity.common.TreeNode;

/**
 * 菜单Service实现
 */
@Service
public class MenuService {
	
	@Resource
	private IMenuDao menuDao;

	/**
	 * 通过条件查询菜单
	 */
	
	public List<MenuEntity> list(MenuEntity menuEntity) {
		return menuDao.list(menuEntity);
	}

	/**
	 * 根据条件统计菜单条数
	 */
	
	public long count(MenuEntity menuEntity) {
		return this.menuDao.count(menuEntity);
	}

	/**
	 * 新增菜单
	 */
	
	public int insertMenu(MenuEntity menuEntity) {
		return this.menuDao.insert(menuEntity);
	}

	/**
	 * 更新菜单
	 */
	
	public long updateMenu(MenuEntity menuEntity) {
		return this.menuDao.update(menuEntity);
	}

	/**
	 * 通过id删除菜单
	 */
	
	public int deleteMenuById(String menuIds, String updateBy) {
		int ret = 0;

		String[] arrMenuIds = menuIds.split(",");
		if (arrMenuIds.length > 0) {
			for (int i = 0; i < arrMenuIds.length; i++) {
				int tmpRet = this.menuDao.deleteById(arrMenuIds[i], updateBy);
				ret = ret + tmpRet;
			}
		}
		return ret;
	}

	/**
	 * 通过id获取菜单信息
	 */
	
	public MenuEntity getMenuById(String menuId) {
		return this.menuDao.getById(menuId);
	}

	/**
	 * 查询基本功能信息设置
	 */
	
	public List<TreeNode> listBaseFunc(String strMenuId) {
		// 查询基本功能信息列表
		List<BaseFuncEntity> baseFuncList = this.menuDao.listBaseFunc(new BaseFuncEntity());

		// 查询菜单下的基本功能信息列表
		List<MenuFuncEntity> menuFuncList = this.menuDao.listMenuFuncById(strMenuId);

		int baseFuncListSize = baseFuncList.size();
		int menuFuncListSize = menuFuncList.size();
		if (baseFuncListSize > 0) {
			for (int i = 0; i < baseFuncListSize; i++) {
				BaseFuncEntity baseFuncBean = baseFuncList.get(i);
				for (int m = 0; m < menuFuncListSize; m++) {
					MenuFuncEntity menuFuncBean = menuFuncList.get(m);
					// 设置选中状态
					if (menuFuncBean.getFuncId().equals(baseFuncBean.getFuncId())) {
						baseFuncBean.setChecked(true);
					}
				}
			}
		}
		// new一个TreeNode列表返回页面显示zTree树
		List<TreeNode> treeNodes = new ArrayList<TreeNode>();

		for (int i = 0; i < baseFuncList.size(); i++) {
			TreeNode treeNode = new TreeNode();
			treeNode.setId(baseFuncList.get(i).getFuncId());
			treeNode.setName(baseFuncList.get(i).getFuncName());
			treeNode.setChecked(baseFuncList.get(i).getChecked() + "");
			treeNodes.add(treeNode);
		}

		return treeNodes;
	}

	/**
	 * 新增菜单功能
	 */
	
	public int insertMenuFunc(String loginUserId, String strMenuId, String strMenuFuncIds) throws IOException {
		// 删除菜单下的所有基本功能信息
		this.menuDao.deleteMenuFuncByMuneId(strMenuId, loginUserId);

		// 插入菜单下的选中的所有基本功能信息
		int status = 0;
		String[] strMenuFuncs = strMenuFuncIds.split(",");
		MenuFuncEntity insertmenuFunc = new MenuFuncEntity();
		insertmenuFunc.setMenuId(strMenuId);
		insertmenuFunc.setCreateBy(loginUserId);
		insertmenuFunc.setUpdateBy(loginUserId);
		if (strMenuFuncs.length > 0) {
			for (int i = 0; i < strMenuFuncs.length; i++) {
				insertmenuFunc.setFuncId(strMenuFuncs[i]);
				status = this.menuDao.insertMenuFunc(insertmenuFunc);
			}
		}
		return status;
	}

}
