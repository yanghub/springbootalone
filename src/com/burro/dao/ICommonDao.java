package com.burro.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.burro.entity.FuncPowerEntity;
import com.burro.entity.MenuEntity;
import com.burro.entity.common.ComboBox;

/**
 * 通用 DAO
 */
public interface ICommonDao {

	/* 执行sql语句 */
	public int executeSql(Map<String, Object> params);

	/* 获取区域查询下拉列表 */
	public List<ComboBox> getSearchCityList(String strUserId);

	/* 获取区域编辑下拉列表 */
	public List<ComboBox> getEditCityList(String userId);
	
	/* 获取区域查询下拉列表 */
	public List<ComboBox> listSearchCityByUser(@Param("cityIds")String cityIds);
	
	/* 获取区域编辑下拉列表 */
	public List<ComboBox> listEditCityByUser(@Param("cityIds")String cityIds);


	/* 获取权限查询下拉列表 */
	public List<ComboBox> getSearchRoleList();

	/* 获取权限编辑下拉列表 */
	public List<ComboBox> getEditRoleList();

	/* //TODO 根据用户权限获取权限查询下拉列表 */
	public List<ComboBox> getSearchCityRoleList();

	/* //TODO 根据用户权限获取权限编辑下拉列表 */
	public List<ComboBox> getEditCityRoleList();


	/* 取得所有城市列表 */
	public String getAllCityList(String strUserId);

	/* 获取所有省份查询下拉列表 */
	public List<ComboBox> getSearchAllProvinceList();

	/* 获取所有省份编辑下拉列表 */
	public List<ComboBox> getEditAllProvinceList();

	/* 获取所有城市查询下拉列表 */
	public List<ComboBox> getSearchAllCityList();

	/* 获取所有城市编辑下拉列表 */
	public List<ComboBox> getEditAllCityList();

	/* 获取所有已开通城市查询下拉列表 */
	public List<ComboBox> getEditAllOpenCityList();

	/* 获取所有已开通城市编辑下拉列表 */
	public List<ComboBox> getSearchAllOpenCityList();

	/* 获取角色类型查询下拉列表 */
	public List<ComboBox> getSearchDictByTypeCode(@Param("typeCode")String typeCode);

	/* 获取角色类型编辑下拉列表 */
	public List<ComboBox> getEditDictByTypeCode(@Param("typeCode")String typeCode);
	
	// XXX
	// ------------------------------------------------------------------------------------------------------ 

	public List<ComboBox> getSelectCityList(String strProv);

	public List<ComboBox> getUserProv(String strLoginUserId);

	public List<ComboBox> getUserCity(String strLoginUserId, String strProv);

	public List<ComboBox> getCustomerService(String strCityId);

	public List<ComboBox> getDictListBySearch(String strDictType);

	public List<ComboBox> getDictListByEdit(String strDictType);
	
	public List<ComboBox> getDictListByCustomTranSearch();

	public List<ComboBox> getDictListByCustomTranEdit();

	public List<ComboBox> getSelectSiteList();

	public List<ComboBox> getEditSiteList();

	public List<ComboBox> getSelectAppList();

	public List<ComboBox> getEditAppList();

	public List<ComboBox> getCityDistrictList(String cityId);


	/* 取得区域下站点列表-查询 */
	public List<ComboBox> getSearchSiteByCity(String strCityId);

	/* 取得区域下站点列表-编辑 */
	public List<ComboBox> getEditSiteByCity(String strCityId);

	/* 取得区域下站点列表-查询 */
	public List<ComboBox> getSearchSiteByJoinId(String strJoinId);

	/* 取得区域下站点列表-编辑 */
	public List<ComboBox> getEditSiteByJoinId(String strJoinId);

	/* 取得VIP等级列表 -查询 */
	public List<ComboBox> getSearchVIPLevelList(String strCityId);

	/* 取得VIP等级列表 -编辑 */
	public List<ComboBox> getEditVIPLevelList(String strCityId);

	/* 取得城市下市区列表-查询 */
	public List<ComboBox> getSearchDistrictByCity(String strCityId);

	/* 取得城市下市区列表-编辑 */
	public List<ComboBox> getEditDistrictByCity(String strCityId);

	/* 取得特殊权限种类列表 -查询 */
	public List<ComboBox> getSearchSpecialType();

	/* 取得特殊权限种类列表 -编辑 */
	public List<ComboBox> getEditSpecialType();

	/* 根据城市取得特殊权限种类列表 -查询 */
	public List<ComboBox> getSearchSpecialTypeByCity(String strCityId);

	/* 根据城市取得特殊权限种类列表 -编辑 */
	public List<ComboBox> getEditSpecialTypeByCity(String strCityId);

	/* 根据城市显示客户权限类型(不显示 普通用户 && 同城代码) */
	public List<ComboBox> getEditSpecialTypeRebateByCity(String strCityId);

	/* 根据城市和订单标识取得特殊权限种类列表 -查询 */
	public List<ComboBox> getSearchSpecialTypeByCityAndOrderFlag(String cityId, String orderFlag);

	/* 取得VIP等级列表 -查询 */
	public List<ComboBox> getSearchVIPList(String strCityId);

	/* 取得VIP等级列表 -编辑 */
	public List<ComboBox> getEditVIPList(String strCityId);

	/* 取得订单奖励类型列表 -查询 */
	public List<ComboBox> getSearchOrderRewardTypeList(String strCityId);

	/* 取得订单奖励类型列表 -编辑 */
	public List<ComboBox> getEditOrderRewardTypeList(String strCityId);

	/* 取得字典结果集 */
	public List<ComboBox> getDictList(String strDictType);

	/* 取得客户高等级列表 -查询 */
	public List<ComboBox> getSearchUpperVip();

	/* 取得客户高等级列表 -编辑 */
	public List<ComboBox> getEditUpperVip();

	/* 取得一级菜单列表 -查询 */
	public List<ComboBox> getSearchMenu();

	/* 取得一级菜单列表 -编辑 */
	public List<ComboBox> getEditMenu();

	/* 取得二级菜单列表 -查询 */
	public List<ComboBox> getSearchMenuByPid(String strPid);

	/* 取得二级菜单列表 -编辑 */
	public List<ComboBox> getEditMenuByPid(String strPid);

	public List<ComboBox> getSearchUserByCity(String strCityId);

	public List<ComboBox> getEditUserByCity(String strCityId);



	/* 验证是否配置区县加盟 */
	public String getCheckDistrictJoin(String strJoinId);
	
	/*取得所有城市列表*/
	public List<ComboBox> getAllCityInfoList();
	
	/*取得所有开通城市列表*/
	public List<ComboBox> getAllOpenCityList();
	
	/*取得所有字典列表*/
	public List<ComboBox> getAllDictList();

	/* 获取url获取操作菜单 */
	public MenuEntity getMenuByUrl(String url);

	/* 获取指定菜单下的用户权限  */
	public List<FuncPowerEntity> listFuncPowerByMenuId(@Param("menuId")String menuId, @Param("userId")String userId, @Param("userRoleId")String userRoleId);
	

	
}