package com.tz.inter;
//没有实现借口的抽象方法，那么就可以加abstract 给子类去实现
//public abstract  class InterFaceImp implements  InterFaceDemo{	
//}

/*
 * abstract 抽象的
 * interface 接口
 * implements 实现
 * final 最终的
 */
public class InterFaceImp implements  InterFaceDemo{

	@Override //覆盖抽象方法
	public int add(int a, int b) {
		// TODO Auto-generated method stub
		return a+b;
	}

	@Override //覆盖抽象方法 
	public int sub(int a, int b) {
		// TODO Auto-generated method stub
		return a+b;
	}
	
	public static void main(String[] args) {
		//只能拿到父类的，因为是父类的引用
		InterFaceDemo interFaceDemo = new InterFaceImp();
		
		System.out.print(interFaceDemo.add(10,20));
	}
	
	
	
}
