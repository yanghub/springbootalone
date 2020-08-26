package com.burro.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.burro.common.SessionUtil;
import com.burro.entity.MenuEntity;
import com.burro.service.CommonService;
import com.burro.service.LoginService;
import com.framework.core.BaseManageController;
import com.framework.core.SessionManageEntity;
import com.framework.util.ManageConstants;

@Scope("prototype")
@Controller
public class LoginController extends BaseManageController {

	@Resource
	private LoginService loginService;

	@Resource
	private CommonService commonService;

	@RequestMapping(value = { "/login" })
	public String index() {
		return "login/index";
	}

	@ResponseBody
	@RequestMapping("/checkUser")
	public String checkUser() throws IOException {
		// 取得参数
		String strUserId = request.getParameter("USERID");
		String strPasswd = request.getParameter("PASSWORD");
		SessionManageEntity userBean = loginService.getUserByUserId(strUserId);
		if (userBean == null) {// 未找到用户
			return "NONE";
		} else if (!userBean.getUserPassword().equals(strPasswd)) {// 密码不正确
			return "PASSERR";
		} 
		// m_user表中记录当前用户的登陆时间
		loginService.updateByUserLoginDate(userBean);

		// 设定工程路径
		SessionUtil.setBasePath(request);

		// 用户对象与菜单列表存入Session
		request.getSession().setAttribute(ManageConstants.LOGIN_USER, userBean);
		// 设定Redis权限对象
		SessionUtil.setSession(request,userBean);

		 String testFlag = "0";
		 testFlag=userBean.getEnvironmentType();
		 request.getSession().setAttribute("testFlag", testFlag);
		return "OK";

	}

	@RequestMapping(value = "/queryUserMenuList")
	public @ResponseBody List<MenuEntity> queryUserMenuList() throws IOException {
		SessionManageEntity user = SessionUtil.getSession(request);
		List<MenuEntity> userMenuList = new ArrayList<MenuEntity>();
		try {
			// 取得用户对应菜单项
			userMenuList = loginService.listMenuByUserIdAndUserRoleId(user.getUserId(),user.getUserRoleId());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return userMenuList;
	}
	
	@RequestMapping("/welcome")
	public String welcome() {
		return "home/homeWelcome";
	}

	@RequestMapping("/")
	public String home() throws IOException {
		SessionManageEntity user = SessionUtil.getSession(request);
		if (user == null) {
			return "login/index";
		} else {
			return "home/homeMain";
		}

	}

	@RequestMapping(value = { "/openPassReset" })
	public String openPassReset() throws IOException{
		SessionManageEntity user = SessionUtil.getSession(request);
		request.setAttribute("userId", user.getUserId());
		request.setAttribute("userName", user.getUserName());
		return "home/passReset";
	}

	/**
	 * 首页导出队列
	 */
	@RequestMapping(value = { "/exportQueueListController" })
	public String exportQueueListController() throws IOException {
		return "home/exportQueueListList";
	}

	/**
	 * 点击导出Excel进入输入导出文件名字的页面 共通方法
	 */
	@RequestMapping(value = { "/exportExcel" })
	public String exportExcel() throws IOException {
		String documentName = request.getParameter("documentName");
		request.setAttribute("documentName", documentName);
		return "exportExcel/exportExcel";
	}

	@RequestMapping(value = { "/openHelpInfo" })
	public String openHelpInfo() throws IOException {
		return "help/helpMain";
	}

	@ResponseBody
	@RequestMapping(value = { "/savePassword" })
	public int savePassword(String password) throws IOException {
		SessionManageEntity user = SessionUtil.getSession(request);
		user.setUserPassword(password);
		return loginService.updatePasswordById(user);
	}

	@ResponseBody
	@RequestMapping("/logout")
	public String logout(Model model) throws IOException {
		request.getSession().removeAttribute(ManageConstants.LOGIN_USER);
		
		return "";
	}

	@RequestMapping(value = { "/openDownload" })
	public String openDownload() throws IOException {
		return "home/download";
	}

}
