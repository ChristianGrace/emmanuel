package com.truth.security.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.truth.security.controller.page.PageUrlDefine;
import com.truth.security.util.SessionUtil;

@Controller
public class GlobalPageController {
	
	@RequestMapping(value="/homePage")
	public ModelAndView failLogin(HttpServletRequest req,HttpServletRequest res,final Model model){
		
		
		SessionUtil.getCurrentSession().setAttribute("currentPage","homePage");
		return new ModelAndView(PageUrlDefine.MyAccount.LOGIN_SUCCESS);
	}
	
	@RequestMapping(value="/authorizationConfig")
	public ModelAndView authorizationConfig(HttpServletRequest req,HttpServletRequest res,final Model model){
		
		SessionUtil.getCurrentSession().setAttribute("currentPage","authorizationConfig");
		return new ModelAndView(PageUrlDefine.authorization.AUTHORIZAITON_CONFIG);
	}
}
