package com.tz.javaFunction;

public class FunctionReset {
	/*方法的重载
	 * 1.参数的不同
	 * 数量不同
	 * 类型不同
	 * 顺序不同（参数类型不一样的）
	 * 2.同一作用域下
	 * 返回的值不同，不构成方法重载
	 * 
	 * this调用构造方法 就只能写在第一行
	 * */
	
	private int age;
	private String name;
	private float money;
	//和类名是一样的
	public FunctionReset(){
		//this(30,"小辉");
		System.out.print("这是个无惨构造。。");
	}
	public FunctionReset(int age,String name){
		this();
		this.name = name;
		this.age = age;
//		System.out.print("这是个无惨构造5666。。");
	}
	//方法是所用对象共有的
	public void study(){
		
		System.out.println(name+"==="+age);
	}
	public static void main(String[] args){

		FunctionReset student = new FunctionReset(23,"夏天");
		student.study();
	}
}
