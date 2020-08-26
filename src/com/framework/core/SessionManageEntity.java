package com.framework.core;

import java.io.Serializable;


/**
 * m_user-管控用户信息(用于Session存储)
 */
public class SessionManageEntity implements Serializable{
	private static final long serialVersionUID = -7330089771471386754L;
	/* m_user */
	private String id;
	private String userId; //用户ID
	private String userName; //用户名称
	private String userPassword; //用户密码
	private String userRoleId; //角色ID
	private String userCityId; //城市ID
	private String userJoinId; //加盟ID
	private String userPhone; //手机号
	private String userOptPower; //首页权限
	private String powerType; //权限类别
	private String userLock; //锁定状态
	private String environmentType;//环境类型
	private String roleName;//角色名称
	private String cityName;//城市名称
	private String lockName;//状态名称
	private String joinName;//加盟名称
	private String joinTypeName;//加盟类型名称
	
	private String cityIds = ""; //登录用户的城市权限
	private String joinIds = ""; //登录用户的加盟权限
	
	private String updateBy;
	
	
	
	public String getEnvironmentType() {
		return environmentType;
	}

	public void setEnvironmentType(String environmentType) {
		this.environmentType = environmentType;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	/**
	 * 设定【用户ID】
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * 取得【用户ID】
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * 设定【用户名称】
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * 取得【用户名称】
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * 设定【用户密码】
	 */
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	/**
	 * 取得【用户密码】
	 */
	public String getUserPassword() {
		return userPassword;
	}

	/**
	 * 设定【角色ID】
	 */
	public void setUserRoleId(String userRoleId) {
		this.userRoleId = userRoleId;
	}

	/**
	 * 取得【角色ID】
	 */
	public String getUserRoleId() {
		return userRoleId;
	}

	/**
	 * 设定【城市ID】
	 */
	public void setUserCityId(String userCityId) {
		this.userCityId = userCityId;
	}

	/**
	 * 取得【城市ID】
	 */
	public String getUserCityId() {
		return userCityId;
	}

	/**
	 * 设定【加盟ID】
	 */
	public void setUserJoinId(String userJoinId) {
		this.userJoinId = userJoinId;
	}

	/**
	 * 取得【加盟ID】
	 */
	public String getUserJoinId() {
		return userJoinId;
	}

	/**
	 * 设定【手机号】
	 */
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	/**
	 * 取得【手机号】
	 */
	public String getUserPhone() {
		return userPhone;
	}

	/**
	 * 设定【首页权限】
	 */
	public void setUserOptPower(String userOptPower) {
		this.userOptPower = userOptPower;
	}

	/**
	 * 取得【首页权限】
	 */
	public String getUserOptPower() {
		return userOptPower;
	}

	/**
	 * 设定【权限类别】
	 */
	public void setPowerType(String powerType) {
		this.powerType = powerType;
	}

	/**
	 * 取得【权限类别】
	 */
	public String getPowerType() {
		return powerType;
	}

	/**
	 * 设定【锁定状态】
	 */
	public void setUserLock(String userLock) {
		this.userLock = userLock;
	}

	/**
	 * 取得【锁定状态】
	 */
	public String getUserLock() {
		return userLock;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getLockName() {
		return lockName;
	}

	public void setLockName(String lockName) {
		this.lockName = lockName;
	}

	public String getJoinName() {
		return joinName;
	}

	public void setJoinName(String joinName) {
		this.joinName = joinName;
	}

	public String getJoinTypeName() {
		return joinTypeName;
	}

	public void setJoinTypeName(String joinTypeName) {
		this.joinTypeName = joinTypeName;
	}

	public String getCityIds() {
		return cityIds;
	}

	public void setCityIds(String cityIds) {
		this.cityIds = cityIds;
	}

	public String getJoinIds() {
		return joinIds;
	}

	public void setJoinIds(String joinIds) {
		this.joinIds = joinIds;
	}
	
	

}
