package com.framework.util;

/**
 * 通用常量类
 */
public class ManageConstants {

	/**
	 * 系统插入DB数据时，操作用户ID
	 */
	public static final String SYSTEM = "system";
	public static final String CURR_REDIS_SESSION = "ManageSessionId";

	/* 导出Excel常量值 */
	public static final int EXCEL_OUTPUT_LIMIT = 20000;// 普通导出限定记录数
	public static final int EXCEL_OUTPUT_LIMIT_FINANCE = 60000;// 财务菜单导出限定记录数

	/* 用于Session常量值 */
	public static final String LOGIN_USER = "LOGIN_USER";// 登录用户信息
	public static final String LOGIN_MENU = "LOGIN_MENU";// 登录菜单结果集
	public static final String LOGIN_MENU_POWER = "LOGIN_MENU_POWER";// 登录菜单权限结果集
	public static final String LOGIN_MENU_JSON = "LOGIN_MENU_JSON";// 登录菜单JSON字符串
	public static final String BASE_PATH = "BASE_PATH";// 基本路径
	public static final String STATIC_PATH = "STATIC_PATH";// 静态资源路径

	/* 对第三方接口提供的常量值 */
	public static final Integer SUCCESS = 0; // 成功
	public static final Integer FAIL = 1001;// 失败
	public static final Integer TOKEN_VALID = 2000;// token有效
	public static final Integer TOKEN_FAIL = 2001;// token无效
	public static final Integer TOKEN_EXPIRE = 2002;// token过期

}
