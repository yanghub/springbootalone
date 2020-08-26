package com.burro.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.burro.dao.IFuncPowerDao;
import com.burro.dao.IMenuDao;
import com.burro.entity.FuncPowerEntity;
import com.burro.entity.MenuEntity;
/**
 * 功能权限service实现类
 */
@Service
public class FuncPowerService {
	
	@Resource
	private IFuncPowerDao funcPowerDao;
	
	@Resource
	private IMenuDao menuDao;

	
	public String listByUrl(String url, String userId, String userRoleId) {
		String result="";
		
		MenuEntity menuEntity = this.menuDao.getByUrl(url);
		if (menuEntity!=null) {
			// 获取当前用户当前页面权限  并拼接成字符串的形式
			List<FuncPowerEntity> funcPowerEntities = this.funcPowerDao.listByMenuId(menuEntity.getMenuId(), userId, userRoleId);
			if (funcPowerEntities!=null&&funcPowerEntities.size()>0) {
				for (int i = 0; i < funcPowerEntities.size(); i++) {
					result += funcPowerEntities.get(i).getFuncId()+",";
				}
			}
		}
		
		return result;
	}

}
