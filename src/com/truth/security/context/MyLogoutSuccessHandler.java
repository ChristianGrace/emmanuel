package com.truth.security.context;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;
import org.springframework.stereotype.Service;


/**
 * 
 * @author liyx14
 *
 */
@Service("myLogoutSuccessHandler")
public class MyLogoutSuccessHandler extends SimpleUrlLogoutSuccessHandler{
	
	/**
	 * 重写onLogoutSuccess方法
	 */
	 public void onLogoutSuccess(HttpServletRequest request,   
			 HttpServletResponse response,   
			 Authentication authentication  
			 ) throws IOException, ServletException {
		 
		 /**
		  * logout逻辑在这里
		  */
		 request.getSession().removeAttribute("isLogin");
		 super.onLogoutSuccess(request, response, authentication); 
		 
	 }
}
