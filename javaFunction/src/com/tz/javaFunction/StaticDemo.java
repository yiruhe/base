package com.tz.javaFunction;

public class StaticDemo {

//		static 可以将其声明为静态成员变量也叫做类变量
	private int num;
	private static int num2;
	public StaticDemo sum(){
		int a = StaticDemo.sum(1, 2); //调用非静态
		System.out.println("调用了"+a);
		return this;
	}
	public static int sum(int a,int b){
		
		return a+b;
	}
	public static void main(String[] args){
		
		StaticDemo demo = new StaticDemo();
		StaticDemo demo1 = new StaticDemo();
		System.out.println(StaticDemo.num2++);
		System.out.println(StaticDemo.num2++);
		demo.sum().sum().sum().sum();
	}
}
