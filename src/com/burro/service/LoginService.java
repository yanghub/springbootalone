package com.burro.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.burro.dao.ILoginDao;
import com.burro.entity.MenuEntity;
import com.framework.core.SessionManageEntity;

/**
 * 用户登录Service
 */
@Service
public class LoginService {

	@Resource
	private ILoginDao loginDao;

	/**
	 * 通过用户账号获取用户
	 */
	public SessionManageEntity getUserByUserId(String userId) {
		return this.loginDao.getUserByUserId(userId);
	}

	/**
	 * 根据用户Id和用户角色Id，取得权限菜单
	 */
	public List<MenuEntity> listMenuByUserIdAndUserRoleId(String userId, String userRoleId) {
		return this.loginDao.listMenuByUserIdAndUserRoleId(userId,userRoleId);
	}

	/**
	 * 根据用户Id和用户角色Id，判断权限菜单个数
	 */
	public int checkMenuByUserIdAndUserRoleId(String userId, String userRoleId) {
		return this.loginDao.checkMenuByUserIdAndUserRoleId(userId,userRoleId);
	}
	
	/**
	 * 修改当前登录用户的用户密码
	 */
	public int updatePasswordById(SessionManageEntity user) {
		return this.loginDao.updatePasswordById(user);
	}
	
	/**
	 * 修改用户最近登录时间
	 */
	public int updateByUserLoginDate(SessionManageEntity user) {
		return this.loginDao.updateUserLoginDate(user);
	}

}
