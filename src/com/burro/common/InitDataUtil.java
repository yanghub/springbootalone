package com.burro.common;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.annotation.Resource;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.burro.dao.ICommonDao;
import com.burro.entity.common.ComboBox;
import com.framework.util.ManageConstants;
import com.framework.util.ManageUtil;
import com.google.common.collect.Maps;
import com.power.common.StrUtil;

/**
 * 常用并且不常修改的数据，加载到内存中
 *
 */
public class InitDataUtil  implements ServletContextListener{

	@Resource
	private ICommonDao commonDao;
	
	/*所有城市列表*/
	private static Map<String, String> mCity = Maps.newHashMap();
	
	/*开通城市列表*/
	private static Map<String, String> mOpenCity = Maps.newHashMap();

	/*字典列表*/
	private static Map<String, String> mDict = Maps.newHashMap();
	
	public void init() {
		dataInit(null);
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent context) {
		
	}
	
	
	@Override
	public void contextInitialized(ServletContextEvent context) {
		
		String basePath = context.getServletContext().getContextPath()+"/";
		Properties properties;
		String staticPath;
		try {
			properties = ManageUtil.ReadProperties("/config.properties");
			staticPath = properties.getProperty("resource.path");
		} catch (IOException e) {
			e.printStackTrace();
		}
		 // TODO:当静态资源改为配置文件设定，则注释掉此句
		staticPath = basePath;
		
		context.getServletContext().setAttribute(ManageConstants.BASE_PATH, basePath);
		context.getServletContext().setAttribute(ManageConstants.STATIC_PATH, staticPath);
		
	}
	
	public void dataInit(String tableName) {
		initOpenCity();
		if (StrUtil.isNull(tableName) || "m_dict".equals(tableName))
			initDictInfo();
		if (StrUtil.isNull(tableName) || "t_city".equals(tableName))
			initCity();
			
	}
	public Map<String, Object> getAll() {
		Map<String, Object> mso = Maps.newHashMap();
		mso.put("head-开通城市", mOpenCity);
		mso.put("head-城市信息", mCity);
		mso.put("head-数据字典", mDict);
		return mso;
	}
	
	/***************************   所有城市信息    ***************************/
	private void initCity() {
		List<ComboBox> listCity = commonDao.getAllCityInfoList();
		if (listCity == null || listCity.size() <= 0) {
			return;
		}
		mCity.clear();
		for (ComboBox ta : listCity) {
			mCity.put(ta.getCODE(), ta.getNAME());
		}
	}
	public static String getCityName(String cityId) {
		if (StrUtil.isNull(cityId)) {
			return null;
		}
		String ta = mCity.get(cityId);
		if (ta == null) {
			ta = "";
		}
		return ta;
	}
	
	/***************************   开通城市信息    ***************************/
	private void initOpenCity() {
		List<ComboBox> listOpenCity = commonDao.getAllOpenCityList();
		if (listOpenCity == null || listOpenCity.size() <= 0) {
			return;
		}
		mOpenCity.clear();
		for (ComboBox ta : listOpenCity) {
			mOpenCity.put(ta.getCODE(), ta.getNAME());
		}
	}
	public static String getAreaName(String cityId) {
		if (StrUtil.isNull(cityId)) {
			return null;
		}
		String ta = mOpenCity.get(cityId);
		if (ta == null) {
			ta = "";
		}
		return ta;
	}
	
	
	/**************************************   数据字典内容    ***************************/
	private void initDictInfo() {
		List<ComboBox> listDict = commonDao.getAllDictList();
		if (listDict == null || listDict.size() <= 0) {
			return;
		}
		mDict.clear();
		for (ComboBox ta : listDict) {
			mDict.put(ta.getCODE(), ta.getNAME());
		}

	}
	
	public static String getDictName(String dictId) {
		if (StrUtil.isNull(dictId)) {
			return null;
		}
		String ta = mDict.get(dictId);
		if (ta == null) {
			ta = "";
		}
		return ta;
	}
	
}
