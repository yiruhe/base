package com.tz.TDemo;

public class SingleDemo {
	
	
	//懒汉式
	private static SingleDemo singleClass = null;
	private SingleDemo(){}
	public static SingleDemo getInstance(){
		
		if(SingleDemo.singleClass == null){
			synchronized(SingleDemo.class){
				
				if(SingleDemo.singleClass == null){
					
					SingleDemo.singleClass = new SingleDemo();
				}
			}
		}
		
		
		return SingleDemo.singleClass;
		
	}
	
	public  static void main(String[] args) {
		SingleDemo instance = SingleDemo.getInstance();
		SingleDemo instance1 = SingleDemo.getInstance();
		System.out.println(instance == instance1);
		
		
	}

}
