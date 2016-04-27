package com.truth.security.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.truth.security.controller.page.PageUrlDefine;
import com.truth.security.model.Users;
import com.truth.security.util.EmmanuelResourceBundle;
import com.truth.security.util.WebKeys;


/**
 * 
 * @author liyx14
 * MyAccountController
 *
 */
@Controller
@RequestMapping(value="/myAccount")
public class MyAccountController {

	
	@RequestMapping(value="/failLogin")
	public ModelAndView failLogin(HttpServletRequest req,HttpServletRequest res,final Model model){
		
		//在这里写返回到前台页面的信息
		model.addAttribute("loginErrorMessage", "login failed");
		return new ModelAndView(PageUrlDefine.MyAccount.LOGIN_SUCCESS);
	}
	
	@RequestMapping(value="/testAjax")
	@ResponseBody
	public Map<String, Object> testAjax(HttpServletRequest request,HttpServletResponse response) throws IOException{
		System.out.println(1);
		String id = request.getParameter("id");
		response.setCharacterEncoding("utf-8");	
		Users user = (Users)request.getSession().getAttribute(WebKeys.CURRENT_USER);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("user", user);
		return map;
		
		
	}
	
	@RequestMapping(value="/login")
	public ModelAndView startLogin(HttpServletRequest req,HttpServletRequest res,final Model model){
		
		Users user = (Users)req.getSession().getAttribute(WebKeys.CURRENT_USER);
		//model.addAttribute("currentUser",true);
		model.addAttribute("currentPage","homePage");
		model.addAttribute("isLogin",true);
		String testMessage = EmmanuelResourceBundle.getCurrentLocaleString("emmanuel.myAccount.emmanuel", EmmanuelResourceBundle.BASE_NAME);
		System.out.println(testMessage);
		return new ModelAndView(PageUrlDefine.MyAccount.LOGIN_SUCCESS);
	}
	
}
