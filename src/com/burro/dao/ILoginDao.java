package com.burro.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.burro.entity.MenuEntity;
import com.framework.core.SessionManageEntity;

/**
 * 用户登录DAO
 */
public interface ILoginDao {
	/**
	 * 通过用户账号获取用户信息
	 */
	public SessionManageEntity getUserByUserId(String userId);

	/**
	 * 通过用户账号和角色判断用户是否拥有菜单权限
	 */
	public int checkMenuByUserIdAndUserRoleId(@Param("userId") String userId, @Param("userRoleId") String userRoleId);

	/**
	 * 通过用户账号和用户角色获取菜单权限
	 */
	public List<MenuEntity> listMenuByUserIdAndUserRoleId(@Param("userId") String userId, @Param("userRoleId") String userRoleId);
	
	/**
	 * 修改用户最近登录时间
	 */
	public int updateUserLoginDate(SessionManageEntity user);
	
	/**
	 * 修改当前登录用户的用户密码
	 */
	public int updatePasswordById(SessionManageEntity user);

}