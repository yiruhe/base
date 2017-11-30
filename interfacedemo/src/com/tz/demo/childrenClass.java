package com.tz.demo;

public class childrenClass extends SuperClass {
	//子类会覆盖父类的同名函数   也称方法重载
	//参数列表不同，函数名相同，就构成了方法重载
	/*
	 * 方法覆盖的出现的前提条件是必须有继承发生的情况下
	 * 要求父类和子类的方法必须是同原型的
	 * 一模一样就是同源型
	 * 返回值也要一样，参数列表一样，子类的访问修饰符要大于等于父类的访问修饰符
	 * 静态的不能被覆盖
	 */
	@Override  //检测是否覆盖父类的方法
	public void run(){
		System.out.print("我是子类，，，");
	}
	
	public static void main(String[] args){
		
//		childrenClass me = new childrenClass();
//		me.run();
		//父类的引用 指向  子类的实例  
		//调用时，如果子类的方法覆盖父类的方法就会调用执行子类的
		
		SuperClass parents = new childrenClass();
		parents.run();
	}
}
