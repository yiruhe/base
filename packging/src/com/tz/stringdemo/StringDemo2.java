package com.tz.stringdemo;

public class StringDemo2 {

	public static void main(String[] args){
		
		String string = "你好啊";
		String string1 = "在干嘛？";
		System.out.println(string.charAt(2));
		System.out.println(string.substring(0));
		//含头不含尾
		System.out.println(string.substring(0,2));
		System.out.println(string.concat(string1));
		//String 操作的时候会产生新的字符串对象，导致大量内存的耗用
		//构造一个不带字符的字符串缓冲区，初始容量为16个字符
//		1.容器
//		2.可以对字符串内容进行修改
//		3.缓冲区可以存储任意类型的数据
//		4.最终会通过toString方法变成字符串
		
		StringBuffer stringBuffer = new StringBuffer();
		//
		stringBuffer.append("123456");
		
		stringBuffer.insert(2, "你好");
		
		stringBuffer.setCharAt(3,'啊');
		stringBuffer.deleteCharAt(2);
		stringBuffer.delete(2,3);
		stringBuffer.reverse();
		System.out.println(stringBuffer);
	
	}
}
