package com.burro.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.burro.common.SessionUtil;
import com.burro.entity.common.ComboBox;
import com.burro.service.CommonService;
import com.framework.core.BaseManageController;
import com.framework.core.SessionManageEntity;

@Scope("prototype")
@Controller
@RequestMapping("/commonController")
public class CommonController extends BaseManageController {

	@Resource
	private CommonService commonService;

	/**
	 * 获取角色查询下拉列表
	 */
	@ResponseBody
	@RequestMapping("/getSearchRoleByPowerType")
	public List<ComboBox> getSearchRoleByPowerType(){
		return commonService.getSearchRoleList();

	}

	/**
	 * 获取角色编辑下拉列表
	 */
	@ResponseBody
	@RequestMapping("/getEditRoleByPowerType")
	public List<ComboBox> getEditRoleByPowerType(){
		return commonService.getEditRoleList();
	}

	/**
	 * 获取城市查询列表
	 */
	@ResponseBody
	@RequestMapping("/getSearchCityByUser")
	public List<ComboBox> getSearchCityByUser() throws IOException {
		SessionManageEntity user = SessionUtil.getSession(request);
		return commonService.listSearchCityByUser(user.getCityIds());
	}

	/**
	 * 获取城市编辑列表
	 */
	@ResponseBody
	@RequestMapping("/getEditCityByUser")
	public List<ComboBox> getEditCityByUser() throws IOException {
		SessionManageEntity user = SessionUtil.getSession(request);
		return commonService.listEditCityByUser(user.getCityIds());
	}

	/**
	 * 获取所有省份查询列表
	 */
	@ResponseBody
	@RequestMapping("/getSearchAllProvince")
	public List<ComboBox> getSearchAllProvince(){
		return commonService.getSearchAllProvinceList();
	}

	/**
	 * 获取所有省份编辑列表
	 */
	@ResponseBody
	@RequestMapping("/getEditAllProvince")
	public List<ComboBox> getEditAllProvince(){
		return commonService.getEditAllProvinceList();
	}

	/**
	 * 获取所有城市查询列表
	 */
	@ResponseBody
	@RequestMapping("/getSearchAllCity")
	public List<ComboBox> getSearchAllCity(){
		return commonService.getSearchAllCityList();
	}

	/**
	 * 获取所有城市编辑列表
	 */
	@ResponseBody
	@RequestMapping("/getEditAllCity")
	public List<ComboBox> getEditAllCity(){
		return commonService.getEditAllCityList();
	}

	/**
	 * 获取所有城市查询列表
	 */
	@ResponseBody
	@RequestMapping("/getSearchAllOpenCity")
	public List<ComboBox> getSearchAllOpenCity(){
		return commonService.getSearchAllOpenCityList();
	}

	/**
	 * 获取所有城市编辑列表
	 */
	@ResponseBody
	@RequestMapping("/getEditAllOpenCity")
	public List<ComboBox> getEditAllOpenCity(){
		return commonService.getEditAllOpenCityList();
	}


	/**
	 * 获取全部的一级菜单查询列表
	 */
	@ResponseBody
	@RequestMapping("/getSearchAllMenu")
	public List<ComboBox> getSearchAllMenu(){
		return commonService.getSearchMenu();
	}

	/**
	 * 获取全部的一级菜单编辑列表
	 */
	@ResponseBody
	@RequestMapping("/getEditAllMenu")
	public List<ComboBox> getEditAllMenu(){
		return commonService.getEditMenu();
	}

	/**
	 * 根据传入参数获取字典查询列表
	 */
	@ResponseBody
	@RequestMapping("/getSearchDictByTypeCode")
	public List<ComboBox> getSearchDictByTypeCode(){
		String param = request.getParameter("Para");
		return commonService.getSearchDictByTypeCode(param);
	}

	/**
	 * 根据传入参数获取字典编辑列表
	 */
	@ResponseBody
	@RequestMapping("/getEditDictByTypeCode")
	public List<ComboBox> getEditDictByTypeCode(){
		String param = request.getParameter("Para");
		return commonService.getEditDictByTypeCode(param);
	}

	@RequestMapping("/openTimeOut")
	public String openTimeOut(){
		return "timeout/timeout";
	}

	@ResponseBody
	@RequestMapping("/getUserProv")
	public List<ComboBox> getUserProv() throws IOException {
		SessionManageEntity user = SessionUtil.getSession(request);
		return commonService.getUserProv(user.getUserId());
	}

	@ResponseBody
	@RequestMapping("/getUserCity")
	public List<ComboBox> getUserCity() throws IOException {
		SessionManageEntity user = SessionUtil.getSession(request);
		// 取得参数
		String strPara = request.getParameter("Para");
		return commonService.getUserCity(user.getUserId(), strPara);
	}

	@ResponseBody
	@RequestMapping("/getCustomerService")
	public List<ComboBox> getCustomerService() throws IOException {
		List<ComboBox> list = new ArrayList<ComboBox>();
		SessionManageEntity user = SessionUtil.getSession(request);
		// String cityId = user.getUserCityId();
		String cityIds = user.getCityIds();
		list = commonService.getCustomerService(cityIds);
		return list;
	}

	/**
	 * @param ParaFlag
	 *            --下拉样式(Search/Edit)
	 * @param ParaType
	 *            --字典类别
	 * @return
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping("/getDictList")
	public List<ComboBox> getDictList(String ParaFlag, String ParaType){
		return commonService.getDictList(ParaFlag, ParaType.toUpperCase());
	}

	@ResponseBody
	@RequestMapping("/getSearchSite")
	public List<ComboBox> getSearchSite(){
		return commonService.getSelectSiteList();
	}

	@ResponseBody
	@RequestMapping("/getEditSite")
	public List<ComboBox> getEditSite(){
		return commonService.getEditSiteList();
	}

	@ResponseBody
	@RequestMapping("/getSearchApp")
	public List<ComboBox> getSearchApp(){
		return commonService.getSelectAppList();
	}

	@ResponseBody
	@RequestMapping("/getEditApp")
	public List<ComboBox> getEditApp(){
		return commonService.getEditAppList();
	}

	@ResponseBody
	@RequestMapping("/getSearchSiteByJoinId")
	public List<ComboBox> getSearchSiteByJoinId(){
		// 取得参数
		String strPara = request.getParameter("Para");
		return commonService.getSearchSiteByJoinId(strPara);
	}

	@ResponseBody
	@RequestMapping("/getEditSiteByJoinId")
	public List<ComboBox> getEditSiteByJoinId(){
		// 取得参数
		String strPara = request.getParameter("Para");
		return commonService.getEditSiteByJoinId(strPara);
	}

	@ResponseBody
	@RequestMapping("/getSearchSiteByCity")
	public List<ComboBox> getSearchSiteByCity(){
		// 取得参数
		String strPara = request.getParameter("Para");
		return commonService.getSearchSiteByCity(strPara);
	}

	@ResponseBody
	@RequestMapping("/getEditSiteByCity")
	public List<ComboBox> getEditSiteByCity(){
		// 取得参数
		String strPara = request.getParameter("Para");
		return commonService.getEditSiteByCity(strPara);
	}



	@ResponseBody
	@RequestMapping("/getSearchVIPLByCity")
	public List<ComboBox> getSearchVIPLByCity(){
		// 取得参数
		String strPara = request.getParameter("Para");
		return commonService.getSearchVIPLList(strPara);
	}

	@ResponseBody
	@RequestMapping("/getEditVIPLByCity")
	public List<ComboBox> getEditVIPLByCity(){
		// 取得参数
		String strPara = request.getParameter("Para");
		return commonService.getEditVIPLList(strPara);
	}

	/**
	 * 取得当前日期前10个月的年月列表 如果当前日期大于5日，则列出当前年月；否则不列出
	 */
	@ResponseBody
	@RequestMapping("/getYearMonth")
	public List<ComboBox> getYearMonth(){
		List<ComboBox> listRet = new ArrayList<ComboBox>();
		Date date = new Date();// 当前日期
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");// 格式化对象
		Calendar calendar = Calendar.getInstance();// 日历对象
		calendar.setTime(date);// 设置当前日期

		if (calendar.get(Calendar.DATE) > 5) {
			ComboBox bean = new ComboBox();
			bean.setCODE(sdf.format(calendar.getTime()));
			bean.setNAME(sdf.format(calendar.getTime()));
			listRet.add(bean);
		}
		for (int i = 0; i < 10; i++) {
			calendar.add(Calendar.MONTH, -1);// 月份减一
			ComboBox bean = new ComboBox();
			bean.setCODE(sdf.format(calendar.getTime()));
			bean.setNAME(sdf.format(calendar.getTime()));
			listRet.add(bean);
		}
		return listRet;
	}

	@ResponseBody
	@RequestMapping("/getSearchDistrictByCity")
	public List<ComboBox> getSearchDistrictByCity(){
		// 取得参数
		String strPara = request.getParameter("Para");
		return commonService.getSearchDistrictByCity(strPara);
	}

	@ResponseBody
	@RequestMapping("/getEditDistrictByCity")
	public List<ComboBox> getEditDistrictByCity(){
		// 取得参数
		String strPara = request.getParameter("Para");
		return commonService.getEditDistrictByCity(strPara);
	}

	/**
	 * 取得市区下拉框数据
	 * 
	 * @author zhangbo 2017-11-29
	 */
	@ResponseBody
	@RequestMapping("/getSearchCityDistrictList")
	public List<ComboBox> getSearchCityDistrictList(){
		// 取得参数
		String strPara = request.getParameter("Para");
		List<ComboBox> list = commonService.getCityDistrictList(strPara);
		ComboBox select = new ComboBox();
		select.setCODE("000");
		select.setNAME("所有");
		list.add(0, select);
		return list;
	}

	/**
	 * 取得市区下拉框数据
	 * 
	 * @author zhangbo 2017-11-29
	 */
	@ResponseBody
	@RequestMapping("/getEditCityDistrictList")
	public List<ComboBox> getEditCityDistrictList(){
		// 取得参数
		String strPara = request.getParameter("Para");
		List<ComboBox> list = commonService.getCityDistrictList(strPara);
		ComboBox select = new ComboBox();
		select.setCODE("000");
		select.setNAME("请选择");
		list.add(0, select);
		return list;
	}

	/**
	 * 取得特殊权限种类
	 * 
	 * @param request
	 * @return
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping("/getSearchSpecialType")
	public List<ComboBox> getSearchSpecialType(){
		return commonService.getSearchSpecialType();
	}

	/**
	 * 取得特殊权限种类
	 * 
	 * @param request
	 * @return
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping("/getEditSpecialType")
	public List<ComboBox> getEditSpecialType(){
		return commonService.getEditSpecialType();
	}

	/**
	 * 根据城市取得特殊权限种类
	 * 
	 * @param request
	 * @return
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping("/getSearchSpecialTypeByCity")
	public List<ComboBox> getSearchSpecialTypeByCity(){
		String strPara = request.getParameter("Para");
		return commonService.getSearchSpecialTypeByCity(strPara);
	}

	/**
	 * @Title: getSearchSpecialTypeByCityAndOrderFlag @Description:
	 * 根据城市和订单标识查询特殊权限种类 @param request @return @throws IOException @throws
	 */
	@ResponseBody
	@RequestMapping("/getSearchSpecialTypeByCityAndOrderFlag")
	public List<ComboBox> getSearchSpecialTypeByCityAndOrderFlag(){
		String cityId = request.getParameter("cityId");
		String orderFlag = request.getParameter("orderFlag");
		return commonService.getSearchSpecialTypeByCityAndOrderFlag(cityId, orderFlag);
	}

	/**
	 * 根据城市显示客户权限类型(不显示 普通用户 && 同城代码)
	 * 
	 * @param request
	 * @return
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping("/getEditSpecialTypeRebateByCity")
	public List<ComboBox> getEditSpecialTypeRebateByCity(){
		String strPara = request.getParameter("Para");
		return commonService.getEditSpecialTypeRebateByCity(strPara);
	}

	/**
	 * 根据城市取得特殊权限种类
	 * 
	 * @param request
	 * @return
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping("/getEditSpecialTypeByCity")
	public List<ComboBox> getEditSpecialTypeByCity(){
		String strPara = request.getParameter("Para");
		return commonService.getEditSpecialTypeByCity(strPara);
	}

	@ResponseBody
	@RequestMapping("/getSearchVIPByCity")
	public List<ComboBox> getSearchVIPByCity(){
		// 取得参数
		String strPara = request.getParameter("Para");
		return commonService.getSearchVIPList(strPara);
	}

	@ResponseBody
	@RequestMapping("/getEditVIPByCity")
	public List<ComboBox> getEditVIPByCity(){
		// 取得参数
		String strPara = request.getParameter("Para");
		return commonService.getEditVIPList(strPara);
	}

	@ResponseBody
	@RequestMapping("/getSearchUserLevelByCity")
	public List<ComboBox> getSearchUserLevelByCity(){
		// 取得参数
		String strPara = request.getParameter("Para");
		List<ComboBox> list = commonService.getSearchVIPList(strPara);
		if (list.size() > 0) {
			ComboBox element = new ComboBox();
			element.setCODE("0");
			element.setNAME("普通用户");
			list.add(1, element);
		}
		return list;
	}

	@ResponseBody
	@RequestMapping("/getEditUserLevelByCity")
	public List<ComboBox> getEditUserLevelByCity(){
		// 取得参数
		String strPara = request.getParameter("Para");
		List<ComboBox> list = commonService.getEditVIPList(strPara);
		if (list.size() > 0) {
			ComboBox element = new ComboBox();
			element.setCODE("0");
			element.setNAME("普通用户");
			list.add(1, element);
		}
		return list;
	}

	@ResponseBody
	@RequestMapping("/getSearchOrderRewardTypeByCity")
	public List<ComboBox> getSearchOrderRewardTypeByCity(){
		// 取得参数
		String strPara = request.getParameter("Para");
		return commonService.getSearchOrderRewardTypeList(strPara);
	}

	@ResponseBody
	@RequestMapping("/getEditOrderRewardTypeByCity")
	public List<ComboBox> getEditOrderRewardTypeByCity(){
		// 取得参数
		String strPara = request.getParameter("Para");
		return commonService.getEditOrderRewardTypeList(strPara);
	}

	@ResponseBody
	@RequestMapping("/getDictDataList")
	public List<ComboBox> getDictList(String ParaType){
		return commonService.getDictList(ParaType.toUpperCase());
	}

	@ResponseBody
	@RequestMapping("/getSearchUpperVip")
	public List<ComboBox> getSearchUpperVip(){
		return commonService.getSearchUpperVip();
	}

	@ResponseBody
	@RequestMapping("/getEditUpperVip")
	public List<ComboBox> getEditUpperVip(){
		return commonService.getEditUpperVip();
	}

	@ResponseBody
	@RequestMapping("/getSearchMenuByPid")
	public List<ComboBox> getSearchMenuByPid(){
		// 取得参数
		String strPara = request.getParameter("Para");
		return commonService.getSearchMenuByPid(strPara);
	}

	@ResponseBody
	@RequestMapping("/getEditMenuByPid")
	public List<ComboBox> getEditMenuByPid(){
		// 取得参数
		String strPara = request.getParameter("Para");
		return commonService.getEditMenuByPid(strPara);
	}

	@ResponseBody
	@RequestMapping("/getSearchUserByCity")
	public List<ComboBox> getSearchUserByCity(){
		// 取得参数
		String strPara = request.getParameter("Para");
		return commonService.getSearchUserByCity(strPara);
	}

	@ResponseBody
	@RequestMapping("/getEditUserByCity")
	public List<ComboBox> getEditUserByCity(){
		// 取得参数
		String strPara = request.getParameter("Para");
		return commonService.getEditUserByCity(strPara);
	}
	
}
