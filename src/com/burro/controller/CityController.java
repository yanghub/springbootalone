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
import com.burro.entity.CityEntity;
import com.burro.service.CityService;
import com.burro.service.CommonMethodService;
import com.framework.core.BaseManageController;
import com.framework.core.SessionManageEntity;
import com.power.common.StrUtil;
import com.power.entity.ExcelHeadInfo;

/**
 * 加盟城市管理模块
 */
@Scope("prototype")
@Controller
@RequestMapping("/cityController")
public class CityController extends BaseManageController {

	@Resource
	private CityService cityService;
	
	@Resource
	private CommonMethodService commonMethodService;
	/**
	 * 入口
	 */
	@RequestMapping(value = { "/subMain" })
	public String subMain() {
		// 初始化帮助信息和功能权限
		super.setCommonAttribute(request);
		return "city/cityList";
	}

	/**
	 * 查询区域列表
	 */
	@ResponseBody
	@RequestMapping(value = { "/selectCityList" })
	public Map<String, Object> selectCityList(CityEntity paramCity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", cityService.count(paramCity));
		map.put("rows", cityService.list(paramCity));
		return map;

	}

	/**
	 * 打开区域编辑页面
	 */
	@RequestMapping(value = { "/openEditPage" })
	public String openEditPage(ModelMap modelMap,String cityKey) {
		if (StrUtil.isNotNull(cityKey)) {
			modelMap.put("city", cityService.getCityById(cityKey));
		}
		return "city/cityEdit";
	}

	/**
	 * 修改区域
	 * @throws IOException 
	 */
	@ResponseBody
	@RequestMapping(value = { "/updateCity" })
	public long updateCity(CityEntity paramCity) throws IOException {
		SessionManageEntity user = SessionUtil.getSession(request);
		paramCity.setUpdateBy(user.getUserId());
		return cityService.updateCity(paramCity);
	}
}
