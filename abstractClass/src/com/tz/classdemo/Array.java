package com.tz.classdemo;

public class Array {
	
	
	//数组初始化后,长度固定,不能改变.数组是定长的
	
	//动态
	// 数据类型[] 名字  =  new 数据类型[size];
	
	//静态
	//数据类型 [] 名字 = new 数据类型[size]{element,element,.......}

	//不能同时使用动态初始化,和静态初始化
	
	//简单写法: 必须声明之后,立即初始化,不能声明后初始化
		int[] num = {1,2,3};
		
		
		
	//二维数组:
		
		int[][] arr = new int[3][];
		int[][] arr2 = new int[][]{{1,2},{2,2}};

	
		//java5:可变参数-->没传值,就是空数组---->可变参数必须是函数参数列表的最后一个,避免歧义(ambiguous)
}
