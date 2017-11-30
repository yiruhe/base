package com.tz.demo;
//声明抽象类
public abstract class Plane {
		//被子类覆盖了，这个方法就别子类覆盖了，所以就要定义抽象方法
		//要用抽象方法，就要定义抽象方法
		//构造方法都不能修饰成静态的，因为是由java虚拟机去执行的
		//一般都定义成public的，定义成static的，就变成了类的
		public Plane(){
			//没有继承 super指向的就是Object
			System.out.println("I Am Plane");
		}
		//抽象方法 ： 父级有抽象方法，子类就要去实现
		protected abstract void fly();
		public void land(){
			System.out.println("Plane着陆了");
		}
}
