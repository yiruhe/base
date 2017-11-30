package com.tz.inter;
	//接口interface
//实现借口 implements 语法 【访问权限】class 类名 implements 接口
public interface InterFaceDemo {
	//接口只是定义了功能，没有提供实现
		//我们就通过类去实现接口，并覆盖接口中的方法，从而实现接口中定义的方法
		//接口和类是实现关系，用implements表示
        //接口不是类,所以没有继承Object
        //没有构造方法m也不能定义构造器,不能实例化
        //接口中的内部类全是公共静态的,默认是public static

	//抽象方法  接口里面的都是抽象方法
	//默认会有abstract修饰符
	//默认就是public，只能使用public
	// 用static修饰的类是被类去调用的，所以不能添加static，因为抽象方法需要被覆盖
    //接口中的内部类是静态的  public static interface
    //接口没有构造器
        //接口支持多继承，接口只能继承接口
        //接口是一个规范


    //如果使用实例访问静态属性，在生成class字节码的时候还是会使用编译时类型去调用
        //多态是对象级别的，静态是类级别的
    int add(int a, int b);
	 int sub(int a, int b);
	//在接口中默认 是被final修饰的
	//不同包都可以访问，那么也是public修饰的
	//默认使用下面这些修饰符修饰的
	//java只支持单继承
    int c =20;  //全局常量

	//jdk1.8 开始
		// 接口里面可以使用普通方法
		//要定义普通方法就要使用default修饰添加在访问修饰符前
}
