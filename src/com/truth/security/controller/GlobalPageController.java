package com.truth.security.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.truth.security.controller.page.PageUrlDefine;
import com.truth.security.model.ResourceModel;
import com.truth.security.model.RoleModel;
import com.truth.security.model.Users;
import com.truth.security.service.ResourceService;
import com.truth.security.service.RoleService;
import com.truth.security.service.UsersService;
import com.truth.security.util.SessionUtil;

@Controller
public class GlobalPageController {
	
	@Resource
	private ResourceService resourceService;
	
	@Resource
	private RoleService roleService;
	
	@Resource
	private UsersService usersService;
	
	
	@RequestMapping(value="/homePage")
	public ModelAndView failLogin(HttpServletRequest req,HttpServletRequest res,final Model model){
		
		
		SessionUtil.getCurrentSession().setAttribute("currentPage","homePage");
		return new ModelAndView(PageUrlDefine.MyAccount.LOGIN_SUCCESS);
	}
	
	@RequestMapping(value="/authorizationConfig")
	public ModelAndView authorizationConfig(HttpServletRequest req,HttpServletRequest res,final Model model){
		
		List<ResourceModel> resourceList = resourceService.getAllResources();
		List<RoleModel> roleList = roleService.getAllRoles();
		List<Users> userList = usersService.getAllUsers();
		model.addAttribute("resourceList", resourceList);
		model.addAttribute("roleList", roleList);
		model.addAttribute("userList", userList);
		SessionUtil.getCurrentSession().setAttribute("currentPage","authorizationConfig");
		return new ModelAndView(PageUrlDefine.authorization.AUTHORIZAITON_CONFIG);
	}
}
