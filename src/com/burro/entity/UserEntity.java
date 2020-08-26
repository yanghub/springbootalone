package com.burro.entity;

import java.io.Serializable;

import com.framework.core.BaseManageEntity;


/**
 * m_user-管控用户信息(用于Session存储)
 */
public class UserEntity extends BaseManageEntity implements Serializable{
	private static final long serialVersionUID = -7330089771471386754L;
	/* m_user */
	private String id; //ID
	private String userId; //用户ID
	private String userName; //用户名称
	private String userPassword; //用户密码
	private String userRoleId; //角色ID
	private String userCityId; //城市ID
	private String userJoinId; //加盟ID
	private String userStoreId; //站点ID
	private String userPhone; //手机号
	private String userOptPower; //首页权限
	private String powerType; //权限类别
	private String userLock; //锁定状态
	private String userLoginDate; //登录时间
	private String remark; //备注
	private String createBy; //创建人
	private String createDate; //创建时间
	private String updateBy; //修改人  
	private String updateDate; //修改时间
	private String delFlag; //删除状态
	
	
	private String roleName;//角色名称
	private String cityName;//城市名称
	private String lockName;//状态名称
	private String joinName;//加盟名称
	private String joinTypeName;//加盟类型名称
	
	private String cityIds = ""; //登录用户的城市权限
	private String joinIds = ""; //登录用户的加盟权限
	

	/**
	 * 设定【ID】
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 取得【ID】
	 */
	public String getId() {
		return id;
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

	public String getUserStoreId() {
		return userStoreId;
	}

	public void setUserStoreId(String userStoreId) {
		this.userStoreId = userStoreId;
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

	/**
	 * 设定【登录时间】
	 */
	public void setUserLoginDate(String userLoginDate) {
		this.userLoginDate = userLoginDate;
	}

	/**
	 * 取得【登录时间】
	 */
	public String getUserLoginDate() {
		return userLoginDate;
	}

	/**
	 * 设定【备注】
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * 取得【备注】
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * 设定【创建人】
	 */
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	/**
	 * 取得【创建人】
	 */
	public String getCreateBy() {
		return createBy;
	}

	/**
	 * 设定【创建时间】
	 */
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	/**
	 * 取得【创建时间】
	 */
	public String getCreateDate() {
		return createDate;
	}

	/**
	 * 设定【修改人  】
	 */
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	/**
	 * 取得【修改人  】
	 */
	public String getUpdateBy() {
		return updateBy;
	}

	/**
	 * 设定【修改时间】
	 */
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	/**
	 * 取得【修改时间】
	 */
	public String getUpdateDate() {
		return updateDate;
	}

	/**
	 * 设定【删除状态】
	 */
	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

	/**
	 * 取得【删除状态】
	 */
	public String getDelFlag() {
		return delFlag;
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
