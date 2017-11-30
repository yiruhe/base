package com.tz.stringdemo;
import java.util.Scanner;

public class Homework {
		
	public static void main(String[] args){
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入邮箱");
		String inputTextString = scanner.nextLine();
		//调用
		String result = Homework.test(inputTextString);
		
		System.out.println(result);
	}

	public static  String test(String name){
	
			if(name != null && !"".equals(name))
			{
				name = name.trim();
				 int atIndex =  name.indexOf("@");
				 int atLast = name.lastIndexOf("@");
				 int pIndex = name.indexOf(".");
				 int pLastIndex = name.indexOf(".");
				 
				 boolean at = atIndex > 0 && atIndex ==  atLast;
				 boolean p = pIndex == pLastIndex;
				 //判断点是否是最后一个
				 boolean pl = pLastIndex !=  name.length() -1;
				 
				 boolean dis =   atIndex+1 < pIndex;
				 
				 if(at && p && pl && dis ){
					 
					 if(name.endsWith("@sina.com")){
						 
						 return  "正确的邮箱号";
					 }else{
						 
						 return  "正确的新浪邮箱号";
					 }
				 }else{
					 return  "请输入正确的邮箱号";
				 }
			}else{
				
				return  "请输入邮箱号";
				
				}
			}
}
