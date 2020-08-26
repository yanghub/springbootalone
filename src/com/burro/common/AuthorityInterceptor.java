package com.burro.common;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.burro.controller.LoginController;
import com.burro.controller.TimeOutController;
import com.burro.entity.common.OperationPowers;
import com.burro.service.CommonService;
import com.framework.core.SessionManageEntity;
import com.framework.util.ManageConstants;
import com.power.common.StrUtil;

/**
 * 拦截器 判断session,用户权限
 */
public class AuthorityInterceptor implements HandlerInterceptor {

	/**
	 * MD5验签key集合
	 */
	//	private Map<String, String> keys = null;
	@Resource
	private CommonService commonService;

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object obj, Exception exp)
			throws Exception {

	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object arg2, ModelAndView arg3)
			throws Exception {

	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		HandlerMethod handlerMethod = (HandlerMethod) arg2;
		// 1.判断静态资源路径是否存在
		if (request.getSession().getAttribute(ManageConstants.BASE_PATH) == null
				|| request.getSession().getAttribute(ManageConstants.STATIC_PATH) == null) {
			SessionUtil.setBasePath(request);
		}
		//TODO 曹世达  测试反射调用service 修改拦截器  
		if (handlerMethod.getBean() instanceof LoginController || handlerMethod.getBean() instanceof TimeOutController// 登录和超时页不判断
//				|| handlerMethod.getBean() instanceof ServiceReflectController // 通用调用service方法接口

		) {

		} else {
			//取得访问路径
			String strSubMain = handlerMethod.getMethodAnnotation(RequestMapping.class).value()[0].toString();
			if (strSubMain != null && !"".equals(strSubMain)) {
				SessionManageEntity user = SessionUtil.getSession(request);
				if (user == null) {
					if (request.getHeader("x-requested-with") != null
							&& request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")) { // 如果是ajax请求响应头会有，x-requested-with
						// 不再进行Ajax进一步处理，在响应头设置session状态
						response.setHeader("sessionstatus", "timeout");// 
					} else {
						String basePath = request.getScheme() + "://" + request.getServerName() + ":"
								+ request.getServerPort() + request.getContextPath() + "/timeOutController";
						// 显示超时页面
						response.sendRedirect(basePath);

					}
					return false;
				}
				//TODO:是否需要根据菜单，取得权限？
				else {
					if (strSubMain.contains("/subMain") || strSubMain.contains("/open")) {// 访问路径为二级菜单主页面或打开子菜单
						String url = (String) request
								.getAttribute("org.springframework.web.servlet.HandlerMapping.bestMatchingPattern");
						if (!StrUtil.isNull(url)) {
							url = url.substring(1);
							OperationPowers operationPowers = commonService.listFuncPowerByUrl(url, user.getUserId(),
									user.getUserRoleId());
						
							if (null != operationPowers) {
								request.setAttribute("funcPowers", operationPowers.getFuncPowers());
								request.setAttribute("condPowers", operationPowers.getCondPowers());
								request.setAttribute("gridPowers", operationPowers.getGridPowers());
								request.setAttribute("excelPowers", operationPowers.getExcelPowers());
							}

						}

					} else {//二级菜单或子窗口以外：ajax请求等
							// 取得权限对象

					}
				}
			}
		}

		return true;
	}
}
