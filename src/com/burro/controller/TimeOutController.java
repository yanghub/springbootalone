package com.burro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.framework.core.BaseManageController;

@Controller
public class TimeOutController extends BaseManageController {

	@RequestMapping(value = { "/timeOutController" })
	public String subMain() {
		return "timeout/timeout";
	}

	@RequestMapping(value = { "/error404" })
	public String error404() {
		return "timeout/error404";
	}

	@RequestMapping(value = { "/error500" })
	public String error500() {
		return "timeout/error500";
	}

}
