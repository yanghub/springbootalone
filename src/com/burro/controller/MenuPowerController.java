package com.burro.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.burro.common.SessionUtil;
import com.burro.entity.MenuPowerEntity;
import com.burro.service.MenuPowerService;
import com.framework.core.BaseManageController;
import com.framework.core.SessionManageEntity;

@Scope("prototype")
@Controller
@RequestMapping("/menuPowerController")
public class MenuPowerController extends BaseManageController{
	
	@Resource
	private MenuPowerService menuPowerService;
	
	@RequestMapping(value={"/subMain"})
	public String subMain(){
		// 初始化帮助信息和功能权限
		return "menuPower/menuPowerList";
	}
	
	@ResponseBody
	@RequestMapping(value={"/selectMenuPowerList"})
	public Map<String,Object> selectPowerSearchList(MenuPowerEntity menuPowerEntity) throws IOException{
		SessionManageEntity user = SessionUtil.getSession(request);
		menuPowerEntity.setCityIds(user.getCityIds());
		menuPowerEntity.setJoinIds(user.getJoinIds());
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("total", menuPowerService.countMenuPower(menuPowerEntity));
		map.put("rows", menuPowerService.listMenuPower(menuPowerEntity));
		return map;
	}		
}
