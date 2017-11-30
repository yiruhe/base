package com.tz.abstractdemo;

/**
 * Created by Administrator on 2017/1/31 0031.
 */
public class TestA {

	// 关于构造块的一些解释
	// 定义在普通代码块中的语句，在javac的时候，实际——代码块中的代码会被第一在构造器所有代码的前面
	// 普通代码块只是一个假象
	// 类里面不允许出现语句，语句只能出现在代码块中
	// 构造没有执行之前 a 都是默认值 0;
	//所有的非static字段,都是在构造器中进行初始化赋值的,并且会放在构造器的代码之前

	//---------------------------
		//如果一个类用public 修饰，那么编译出构造器也会加上public
		//没有修饰的类，构造器也没有public修饰
		//也就是构造器是跟着类走的

	// 1
	// 2
	// SuperClass构造器
	// SubClass构造器
	// TestA构造器
	// 3
	// Hello world
	
	//这里存在一个问题:
		//同时存在两个类,会先加载哪一个类呢？
		//会先加载所依赖的类   TestA 依赖 SubClass 先初始化SubClass

	// 表面
	private static TestA d = new TestA(); // 依赖自己

	// 底层
	// private static TestA d= null;

	// 表面
	private SubClass t = new SubClass(); // 依赖SubClass //先加载依赖
	// 底层
	// 1. private SubClass t = null;

	// 结论：
	// 静态成员是通过 静态代码块初始化的
	// 实际上所有的非static 属性赋值其实是在构造中进行的，并在构造里所有代码的前面

	static {

		// d= new TestA(); //这里会去先初始化TestA
		// -------------------

		System.out.println("3");

	}

	void TestA() {

		// 2. t =new SubClass();
		// ---------------------------------
		System.out.println("TestA构造器");
	}

	public static void main(String[] args) {

		System.out.println("Hello world");

	}

}

class SuperClass {

	static {
		System.out.println("1");
	}

	SuperClass(){

		System.out.println("SuperClass构造器");
	}

}

class SubClass extends SuperClass {
	static {
		System.out.println("2");
	}

	SubClass() { // 构造器没有返回值

		System.out.println("SubClass构造器");
	}

}
