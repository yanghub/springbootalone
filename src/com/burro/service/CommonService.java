package com.burro.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.burro.dao.ICommonDao;
import com.burro.entity.FuncPowerEntity;
import com.burro.entity.MenuEntity;
import com.burro.entity.common.ComboBox;
import com.burro.entity.common.OperationPowers;
import com.power.common.StrUtil;

/**
 * 通用Service实现
 */
@Service
public class CommonService {

	@Resource
	private ICommonDao commonDao;


	public List<ComboBox> listSearchCityByUser(String cityIds) {
		return this.commonDao.listSearchCityByUser(cityIds);
	}

	public List<ComboBox> listEditCityByUser(String cityIds) {
		return this.commonDao.listEditCityByUser(cityIds);
	}

	public List<ComboBox> getSearchRoleList() {
		return this.commonDao.getSearchRoleList();
	}

	public List<ComboBox> getEditRoleList() {
		return this.commonDao.getEditRoleList();
	}

	public List<ComboBox> getSelectCityRoleList() {
		return this.commonDao.getSearchCityRoleList();
	}

	public List<ComboBox> getEditCityRoleList() {
		return this.commonDao.getEditCityRoleList();
	}


	public List<ComboBox> getSelectCityList(String strProv) {
		return this.commonDao.getSelectCityList(strProv);
	}

	public List<ComboBox> getUserProv(String strLoginUserId) {
		return this.commonDao.getUserProv(strLoginUserId);
	}

	public List<ComboBox> getUserCity(String strLoginUserId, String strProvId) {
		return this.commonDao.getUserCity(strLoginUserId, strProvId);
	}

	public List<ComboBox> getCustomerService(String strCityId) {
		return this.commonDao.getCustomerService(strCityId);
	}

	public List<ComboBox> getDictList(String ParaFlag, String ParaType) {
		List<ComboBox> listDict = new ArrayList<ComboBox>();
		if ("SEARCH".equals(ParaFlag)) {
				listDict = this.commonDao.getDictListBySearch(ParaType);
		} else if ("EDIT".equals(ParaFlag)) {
				listDict = this.commonDao.getDictListByEdit(ParaType);
		}
		return listDict;
	}
	
	public List<ComboBox> getSelectSiteList() {
		return this.commonDao.getSelectSiteList();
	}

	public List<ComboBox> getEditSiteList() {
		return this.commonDao.getEditSiteList();
	}

	public List<ComboBox> getSearchSiteByCity(String strCityId) {
		return this.commonDao.getSearchSiteByCity(strCityId);
	}

	public List<ComboBox> getEditSiteByCity(String strCityId) {
		return this.commonDao.getEditSiteByCity(strCityId);
	}

	public List<ComboBox> getSelectAppList() {
		return this.commonDao.getSelectAppList();
	}

	public List<ComboBox> getEditAppList() {
		return this.commonDao.getEditAppList();
	}

	/* 取得所有城市的权限 */

	public String getAllCityList(String strUserId) {
		return this.commonDao.getAllCityList(strUserId).concat(",''");
	}


	public List<ComboBox> getSearchSiteByJoinId(String strJoinId) {
		return this.commonDao.getSearchSiteByJoinId(strJoinId);
	}

	public List<ComboBox> getEditSiteByJoinId(String strJoinId) {
		return this.commonDao.getEditSiteByJoinId(strJoinId);
	}


	

	public List<ComboBox> getSearchVIPLList(String strCityId) {
		return this.commonDao.getSearchVIPLevelList(strCityId);
	}

	public List<ComboBox> getEditVIPLList(String strCityId) {
		return this.commonDao.getEditVIPLevelList(strCityId);
	}

	public List<ComboBox> getSearchDistrictByCity(String strCityId) {
		return this.commonDao.getSearchDistrictByCity(strCityId);
	}

	public List<ComboBox> getEditDistrictByCity(String strCityId) {
		return this.commonDao.getEditDistrictByCity(strCityId);
	}

	public List<ComboBox> getCityDistrictList(String cityId) {
		return this.commonDao.getCityDistrictList(cityId);
	}

	public List<ComboBox> getSearchSpecialType() {
		return this.commonDao.getSearchSpecialType();
	}

	public List<ComboBox> getEditSpecialType() {
		return this.commonDao.getEditSpecialType();
	}

	public List<ComboBox> getSearchSpecialTypeByCity(String strCityId) {
		return this.commonDao.getSearchSpecialTypeByCity(strCityId);
	}

	public List<ComboBox> getEditSpecialTypeByCity(String strCityId) {
		return this.commonDao.getEditSpecialTypeByCity(strCityId);
	}

	/* 根据城市显示客户权限类型(不显示 普通用户 && 同城代码) */

	public List<ComboBox> getEditSpecialTypeRebateByCity(String strCityId) {
		return this.commonDao.getEditSpecialTypeRebateByCity(strCityId);
	}

	public List<ComboBox> getSearchSpecialTypeByCityAndOrderFlag(String cityId, String orderFlag) {
		return this.commonDao.getSearchSpecialTypeByCityAndOrderFlag(cityId, orderFlag);
	}



	public List<ComboBox> getSearchVIPList(String strCityId) {
		return this.commonDao.getSearchVIPList(strCityId);
	}

	public List<ComboBox> getEditVIPList(String strCityId) {
		return this.commonDao.getEditVIPList(strCityId);
	}

	public List<ComboBox> getSearchOrderRewardTypeList(String strCityId) {
		return this.commonDao.getSearchOrderRewardTypeList(strCityId);
	}

	public List<ComboBox> getEditOrderRewardTypeList(String strCityId) {
		return this.commonDao.getEditOrderRewardTypeList(strCityId);
	}

	public List<ComboBox> getDictList(String strParaType) {
		return this.commonDao.getDictList(strParaType);
	}

	public List<ComboBox> getSearchUpperVip() {
		return this.commonDao.getSearchUpperVip();
	}

	public List<ComboBox> getEditUpperVip() {
		return this.commonDao.getEditUpperVip();
	}

	public List<ComboBox> getSearchMenu() {
		return this.commonDao.getSearchMenu();
	}

	public List<ComboBox> getEditMenu() {
		return this.commonDao.getEditMenu();
	}

	public List<ComboBox> getSearchMenuByPid(String strPid) {
		return this.commonDao.getSearchMenuByPid(strPid);
	}

	public List<ComboBox> getEditMenuByPid(String strPid) {
		return this.commonDao.getEditMenuByPid(strPid);
	}


	public List<ComboBox> getSearchUserByCity(String strCityId) {
		return this.commonDao.getSearchUserByCity(strCityId);
	}

	public List<ComboBox> getEditUserByCity(String strCityId) {
		return this.commonDao.getEditUserByCity(strCityId);
	}


	public String getCheckDistrictJoin(String strJoinId) {
		return this.commonDao.getCheckDistrictJoin(strJoinId);
	}

	public List<ComboBox> getSearchAllProvinceList() {
		return this.commonDao.getSearchAllProvinceList();
	}

	public List<ComboBox> getEditAllProvinceList() {
		return this.commonDao.getEditAllProvinceList();
	}

	public List<ComboBox> getSearchAllCityList() {
		return this.commonDao.getSearchAllCityList();
	}

	public List<ComboBox> getEditAllCityList() {
		return this.commonDao.getEditAllCityList();
	}

	public List<ComboBox> getSearchAllOpenCityList() {
		return this.commonDao.getSearchAllOpenCityList();
	}

	public List<ComboBox> getEditAllOpenCityList() {
		return this.commonDao.getEditAllOpenCityList();
	}

	public List<ComboBox> getSearchDictByTypeCode(String typeCode) {
		return this.commonDao.getSearchDictByTypeCode(typeCode);
	}

	public List<ComboBox> getEditDictByTypeCode(String typeCode) {
		return this.commonDao.getEditDictByTypeCode(typeCode);
	}
	
	public OperationPowers listFuncPowerByUrl(String url, String userId, String userRoleId) {
		OperationPowers operationPowers = null;
		MenuEntity menuEntity = this.commonDao.getMenuByUrl(url);
		if (menuEntity != null) {
			// 获取当前用户当前页面权限  并拼接成字符串的形式
			List<FuncPowerEntity> funcPowerEntities = this.commonDao.listFuncPowerByMenuId(menuEntity.getMenuId(),
					userId, userRoleId);
			// 获取全部用户页面权限
			int size = funcPowerEntities.size();
			if (funcPowerEntities != null && size > 0) {
				// 权限类型
				String funcType = null;
				String funcName = null;
				// 查询导出等操作的 权限串
				String condPowers = "";
				// toolbar的 权限串
				String funcPowers = "";
				// 前端显示的权限串 
				String gridPowers ="";
				// excel 表格的权限串
				String excelPowers = "";
				for (int i = 0; i < size; i++) {
					funcType = funcPowerEntities.get(i).getFuncType();
					funcName = funcPowerEntities.get(i).getFuncId();
					if ("0".equals(funcType)) {
						condPowers += funcName + ",";
					} else if ("1".equals(funcType)) {
						funcPowers += funcName + ",";
					} else if ("2".equals(funcType)) {
						gridPowers += funcName + ",";
					} else if ("3".equals(funcType)) {
						excelPowers += funcName + ",";
					}
				}

				// 如果权限串为空 设置为 "none"
				if (StrUtil.isNull(condPowers)) {
					condPowers = "none";
				}
				if (StrUtil.isNull(funcPowers)) {
					funcPowers = "none";
				}
				if (StrUtil.isNull(gridPowers)) {
					gridPowers = "none";
				}
				if (StrUtil.isNull(excelPowers)) {
					excelPowers = "none";
				}
				
				operationPowers = new OperationPowers(condPowers, funcPowers, gridPowers, excelPowers);
			}
		}

		return operationPowers;
	}

	
	
}
