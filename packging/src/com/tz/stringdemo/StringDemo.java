package com.tz.stringdemo;

import java.io.UnsupportedEncodingException;

public class StringDemo {

	public static void main(String[] args){
		//java.long 包 默认导入的
		//基础数据类型   
		/* byte(1) short(2) int(4) long(8)
		 * float(4) double(8) boolean(1)
		 * char(2)
		 * 
		 */		
		//引用数据类型

		//比较
			//equals || equalsIgnoreCase || contentEquals


		//包装类    //原始数据类型 当做对象进行操作
//		Byte Short Long
//		Float Double
//		Boolean
//		Integer
//		Character
		
		//包装类的静态方法 valueOf
		String string = "120";
		Byte byte1 = Byte.valueOf(string);
		Short s = Short.valueOf(string);
		Integer i = Integer.valueOf(string);
		Long l = Long.valueOf(string);
		System.out.println(byte1+"==="+s+"=="+i+"=="+l);
		
		Integer a = 10; //装箱
		int b = a;  //拆箱
		
		char c = 'a';
		char cc = '0';
		char ccc = 'A';
		char cccc = 'a';
		//是不是字母
		System.out.println(Character.isLetter(c));
		//是不是数字
		System.out.println(Character.isDigit(cc));
		//是不是大写
		System.out.println(Character.isUpperCase(ccc));
		//是不是小写
		System.out.println(Character.isLowerCase(cccc));
		
		//字符串相关操作
		String str1 = "012";
		String str2 = "345";
		String str3 = "abcdefg";
		String str4 = "Abcdefg";
		//字符串第一个 字符的ascii 码值 计算
		System.out.println(str1.compareTo(str2));
		//StartsWith endsWith
		//以什么开头，以什么结尾
		System.out.println(str1.startsWith("012"));
		System.out.println(str1.endsWith("012"));
		//前向后寻找
		System.out.println(str3.indexOf("bc"));
		//从后面开始找
		System.out.println(str3.lastIndexOf("bc"));
		System.out.println(str3.equalsIgnoreCase(str4));
//		equalsIgnoreCase()
		//字符串是不可改变的
		
		//把字符串变成字节数组
		String string1 = "123456";
		byte[] bt;
			try {
				bt = string1.getBytes("utf-8");//可以传入编码集
				for(int i1=0;i1<bt.length;i1++)
				{
					System.out.println(bt[i1]);
				}
				
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
//			char数组
			char[] ch = string1.toCharArray();
			System.out.println(ch.length);
			for(int j =0;j<ch.length;j++){
				
				System.out.print(ch[j]);
			}
			
		
	}
}
