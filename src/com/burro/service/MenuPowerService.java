package com.burro.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.burro.dao.IMenuPowerDao;
import com.burro.entity.MenuPowerEntity;

/**
 * 菜单权限Service实现
 */
@Service
public class MenuPowerService {

	@Resource
	private IMenuPowerDao menuPowerDao;

	/**
	 * 通过条件查询菜单权限
	 */
	
	public List<MenuPowerEntity> listMenuPower(MenuPowerEntity menuPowerEntity) {
		return this.menuPowerDao.list(menuPowerEntity);
	}

	/**
	 * 通过条件统计菜单权限条数
	 */
	
	public long countMenuPower(MenuPowerEntity menuPowerEntity) {
		return this.menuPowerDao.count(menuPowerEntity);
	}

}
