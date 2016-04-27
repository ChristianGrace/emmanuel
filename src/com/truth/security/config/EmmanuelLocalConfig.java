package com.truth.security.config;


import com.truth.security.model.Users;


public class EmmanuelLocalConfig {
	
	private static final ThreadLocal<EmmanuelConfig> emmanuelConfigHolder = new ThreadLocal<EmmanuelConfig>();

	public static void initEmmanuelConfigHolder(EmmanuelConfig emmanuelConfig){
		emmanuelConfigHolder.set(emmanuelConfig);
	}
	
	public static Users getCurrentLoginUser(){
		EmmanuelConfig ec = emmanuelConfigHolder.get();
		return ec.getUser();
	}
	
}
