package com.truth.security.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.truth.security.model.Users;
import com.truth.security.service.UsersService;
import com.truth.security.util.WebKeys;

/**
 * 
 * @author liyx14
 *
 */
public class GlobalFilter implements Filter{
	
	Logger log=Logger.getLogger(GlobalFilter.class);
	
	
	
	private UsersService usersService;
	
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
			FilterChain filterChain) throws IOException, ServletException {

		HttpServletRequest  request  = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse)servletResponse;
		
		//在这里做登陆验证，只有通过了才会去进去spring security，否则跳转到/emmanuel/failLogin.do，此URL需要在spring security中屏蔽过滤 
		String requestUrl = request.getRequestURI();
		if(requestUrl!=null && requestUrl.contains("j_spring_security_check")){
			WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
			usersService=(UsersService)webApplicationContext.getBean("UsersService");
			String userName = request.getParameter("j_username");
			String password = request.getParameter("j_password");
			Users loginUser = usersService.findbyUsername(userName);
			if(loginUser != null && loginUser.getPassword()!=null && loginUser.getPassword().equals(password)){
//				EmmanuelConfig emmanuelConfig = new EmmanuelConfig();
//				emmanuelConfig.setUser(loginUser);
//				EmmanuelLocalConfig.initEmmanuelConfigHolder(emmanuelConfig);
				request.getSession().setAttribute(WebKeys.CURRENT_USER, loginUser);
				filterChain.doFilter(request, response);
			}else{
				response.sendRedirect(request.getContextPath()+"/myAccount/failLogin.do");
			}
		}else{
			filterChain.doFilter(request, response);
		}
		
		
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
}
