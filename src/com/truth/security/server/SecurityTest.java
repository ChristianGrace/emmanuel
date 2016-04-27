package com.truth.security.server;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.truth.security.config.EmmanuelLocalConfig;
import com.truth.security.dao.SecurityTestInterface;
import com.truth.security.model.UserSecruity;
import com.truth.security.model.Users;
import com.truth.security.service.UsersService;
import com.truth.security.util.SessionUtil;
import com.truth.security.util.UserUtil;
import com.truth.security.util.WebKeys;

/**
 * 
 * @author liyx14
 * add for test Controller
 *
 */
@Controller
public class SecurityTest {
	Logger log=Logger.getLogger(SecurityTest.class);
	
	
	
	@Resource
	private SecurityTestInterface dao;
	
	@Resource
	private UsersService usersService;
	
	@RequestMapping(value="/jsp/getinput")//查看最近收入
	@ResponseBody
	public boolean getinput(HttpServletRequest req,HttpServletRequest res){
		boolean b=dao.getinput();
		return b;
	}
	
	
	
	
	
	@RequestMapping(value="/jsp/getoutput")//查看最近支出
	@ResponseBody
	public boolean geoutput(HttpServletRequest req,HttpServletRequest res){
		boolean b=dao.geoutput();
		return b;
	}
	
	@RequestMapping(value="/jsp/addreport_admin")//添加报表管理员
	@ResponseBody
	public boolean addreport_admin(HttpServletRequest req,HttpServletRequest res){
		boolean b=dao.addreport_admin();
		return b;
	}
	
	@RequestMapping(value="/jsp/deletereport_admin")//删除报表管理员
	@ResponseBody
	public boolean deletereport_admin(HttpServletRequest req,HttpServletRequest res){
		boolean b=dao.deletereport_admin();
		
		Users user = SessionUtil.getCurrentUser();
		Users user1 = (Users)req.getSession().getAttribute(WebKeys.CURRENT_USER);
		
		
		return b;
	}
	
	@RequestMapping(value="/jsp/user")//普通用户登录
	public ModelAndView user_login(HttpServletRequest req,HttpServletRequest res){
		dao.user_login();
		UserSecruity userSecruity = UserUtil.getCurrentUser();
		Users user = (Users)req.getSession().getAttribute(WebKeys.CURRENT_USER);
		
		return new ModelAndView("user");
	}
	
}
