package com.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

	
	public static void main(String[] args){
		
		//asdasd213213
		
		//表达式对象
		//字符串的\是需要转义的 所以需要两个 
		Pattern p = Pattern.compile("\\w+");
		
		//创建Matcher
		Matcher m = p.matcher("asdasd213213");
		
		boolean b= m.matches();
		
		System.out.println(b);
		
		

		
	}
	
}
