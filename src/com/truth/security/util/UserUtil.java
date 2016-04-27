package com.truth.security.util;

import org.springframework.security.core.context.SecurityContextHolder;

import com.truth.security.model.UserSecruity;

public class UserUtil {
	
	public static UserSecruity userSecruity = (UserSecruity) SecurityContextHolder.getContext().getAuthentication() .getPrincipal();
	
	public static UserSecruity getCurrentUser(){
		if(userSecruity == null){
			userSecruity = (UserSecruity) SecurityContextHolder.getContext().getAuthentication() .getPrincipal();
		}
		return userSecruity;
	}
}
