package com.truth.security.util;

import java.util.Locale;
import java.util.ResourceBundle;


public class EmmanuelResourceBundle {
	
	public static String BASE_NAME = "messages/messages";
	
	public static String getString(String resourceKey,String baseName, Locale locale) {
		
		ResourceBundle bundle = ResourceBundle.getBundle(BASE_NAME, locale);	
		String message = bundle.getString(resourceKey);
		return message;
		
	}
	
	public static String getCurrentLocaleString(String resourceKey,String baseName) {
		
		Locale local = Locale.getDefault();
		return getString(resourceKey,baseName,local);
		
	}
}
