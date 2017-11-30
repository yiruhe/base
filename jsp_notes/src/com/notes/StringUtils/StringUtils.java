package com.notes.StringUtils;

public class StringUtils {
	
	
	public static boolean isEmpty(String expected){
		
		return  expected == null|| 
				expected.equals("") || 
				expected.matches("\\s*");
	}
	

	
	
	private StringUtils(){
		
	}
}
