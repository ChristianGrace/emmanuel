package com.truth.security.util;

import java.util.ArrayList;
import java.util.List;

public class StringUtil {
	
	public static List<String> getListByStringSplitBySymbol(String args,String symbol){
		if(isEmpty(args)||isEmpty(symbol)){
			return null;
		}
		
		List<String> list = new ArrayList<String>();
		String powerIds = args;
		String[] powerIdsArray = powerIds.split(symbol);
		for(int i=0;i< powerIdsArray.length;i++){
			list.add(powerIdsArray[i]);
		}
		return list;
	}
	
	public static boolean isEmpty(String arg){
		if(arg == null || arg.equals("")){
			return true;
		}else{
			return false;
		}
	}
}
