package com.truth.security.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.truth.security.model.Users;

public class SessionUtil {
	
	//获取当前session,如果有request那么从request中获取，如果没有就从这里获取
	public static HttpSession getCurrentSession(){
		RequestAttributes ra = RequestContextHolder.getRequestAttributes();  
		HttpServletRequest request = ((ServletRequestAttributes)ra).getRequest(); 
		return request.getSession();
	}
	
	//获取当前user
	public static Users getCurrentUser(){
		return (Users)getCurrentSession().getAttribute(WebKeys.CURRENT_USER);
	}
}
