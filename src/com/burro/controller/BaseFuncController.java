package com.burro.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.burro.common.SessionUtil;
import com.burro.entity.BaseFuncEntity;
import com.burro.service.BaseFuncService;
import com.framework.core.BaseManageController;
import com.framework.core.SessionManageEntity;
import com.framework.util.StringUtil;

/**
 * 功能管理模块
 */
@Scope("prototype")
@Controller
@RequestMapping("/baseFuncController")
public class BaseFuncController extends BaseManageController {

	@Resource
	private BaseFuncService baseFuncService;

	/**
	 * 入口
	 */
	@RequestMapping(value = { "/subMain" })
	public String subMain() {
		// 初始化帮助信息和功能权限
		super.setCommonAttribute(request);
		return "baseFunc/baseFuncList";
	}

	/**
	 * 功能管理信息列表
	 */
	@ResponseBody
	@RequestMapping(value = { "/selectBaseFuncList" })
	public Map<String, Object> selectMenuList(BaseFuncEntity baseFuncEntity){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", baseFuncService.countBaseFunc(baseFuncEntity));
		map.put("rows", baseFuncService.listBaseFunc(baseFuncEntity));
		return map;
	}

	/**
	 * 新增功能管理
	 */
	@ResponseBody
	@RequestMapping(value = { "/insertBaseFunc" })
	public int insertMenu(BaseFuncEntity baseFuncEntity) throws IOException {
		SessionManageEntity user = SessionUtil.getSession(request);
		baseFuncEntity.setCreateBy(user.getUserId());
		baseFuncEntity.setUpdateBy(user.getUserId());
		return baseFuncService.insertBaseFunc(baseFuncEntity);
	}

	/**
	 * 修改功能管理
	 */
	@ResponseBody
	@RequestMapping(value = { "/updateBaseFunc" })
	public long updateMenu(BaseFuncEntity baseFuncEntity) throws IOException {
		SessionManageEntity user = SessionUtil.getSession(request);
		baseFuncEntity.setUpdateBy(user.getUserId());
		return baseFuncService.updateBaseFunc(baseFuncEntity);
	}

	/**
	 * 逻辑删除功能管理
	 */
	@ResponseBody
	@RequestMapping(value = { "/deleteBaseFunc" })
	public long deleteMenu(String ids) throws IOException{
		SessionManageEntity user = SessionUtil.getSession(request);
		if (StringUtil.isNotNull(ids)) {
			return baseFuncService.deleteBaseFuncByIds(ids, user.getUserId());
		}
		return 0;
	}

	/**
	 * 开启窗口
	 */
	@RequestMapping(value = { "/openEditPage" })
	public String openEditPage(ModelMap map,String id){
		if (StringUtil.isNotNull(id)) {
			map.put("baseFunc", baseFuncService.getBaseFuncById(id));
		}
		return "baseFunc/baseFuncEdit";
	}

}
