package com.tz.ClassDemo;

public class ClassTest {
		//静态  只能调用静态成员
		//非静态成员  可以 调用非静态  和静态
		//this 是指向对象的 ， 不能指代类
		//先执行父类的 静态代码块  -> 子类代码块 --> 父类普通代码块---> 子类代码块
//		静态是和类一起加载的，类加载的时候，对象还没加载。
	
	//抽象类 不可以直接实例化，但是可以具有构造函数
	private int age;
	private String name;
	
	private float money;
	
	public  ClassTest(){
		System.out.println("我是一个无参构造");
	}
	
	public ClassTest(String name,int age,float money){
		this.name = name;
		this.age = age;
		this.money = money;
	}
	
	public void study(){
		
		System.out.println(name+" 学生在学习  年龄是"+age+"   "+money);
	}
	
	public static void main(String[] args){
		
		ClassTest studenTest = new ClassTest("小明",20,10f);
		studenTest.study();
		
	}
}
