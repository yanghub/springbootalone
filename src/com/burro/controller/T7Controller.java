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

import com.burro.entity.Entity;
import com.burro.service.CommonMethodService;
import com.burro.service.T7Service;
import com.framework.core.BaseManageController;
import com.framework.util.StringUtil;
import com.power.common.CommonUtil;
import com.power.common.StrUtil;
/**
 * T7管理
 * @author DG
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/T7Controller")
public class T7Controller extends BaseManageController {
	@Resource
	private T7Service service;
	@Resource
	private CommonMethodService commonMethodService;
	/**
	 * 打开首页
	 * @throws IOException 
	 */
	@RequestMapping(value = { "/subMain" })
	public String subMain() throws IOException {
		// 初始化帮助信息和功能权限信息
		super.setCommonAttribute(request);
		return "T7/list";
	}

	/**
	 * 查询T7列表
	 * @throws IOException 
	 */
	@ResponseBody
	@RequestMapping(value = { "/selectList" })
	public Map<String, Object> selectUserInfoList(Entity entity) throws IOException {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", service.count(entity));
		map.put("rows", service.list(entity));
		return map;
	}
	
	

	/**
	 * 打开T7编辑页面
	 */
	@RequestMapping(value = { "/openEdit" })
	public String openEditPage(ModelMap modelMap,String id) {
		if (StrUtil.isNotNull(id)) {
			modelMap.put("entity", service.getById(id));
		}
		return "T7/edit";
	}
	
	/**
	 * 新增T7
	 */
	@ResponseBody
	@RequestMapping(value = { "/insert" })
	public int insert(Entity entity) throws IOException {
		entity.setId(CommonUtil.getUuid());
		return service.insert(entity);
	}

	/**
	 * 修改T7
	 */
	@ResponseBody
	@RequestMapping(value = { "/update" })
	public long update(Entity entity) throws IOException {
		return service.update(entity);
	}

	/**
	 * 批量逻辑删除T7
	 */
	@ResponseBody
	@RequestMapping(value = { "/delete" })
	public long delete(String ids) throws IOException {
		if (StringUtil.isNotNull(ids)) {
			// 执行删除
			return service.delete(ids,"");
		}
		return 0;
	}
	
	
	/**
	 * 批量物理删除T7
	 */
	@ResponseBody
	@RequestMapping(value = { "/drop" })
	public long drop(String ids) throws IOException {
		if (StringUtil.isNotNull(ids)) {
			// 执行删除
			return service.drop(ids,"");
		}
		return 0;
	}
	
}
