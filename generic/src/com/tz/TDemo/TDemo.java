package com.tz.TDemo;

import java.util.List;

import javax.lang.model.element.VariableElement;

import java.util.ArrayList; 

public class TDemo {
	
	public static void main(String[] args) {
		//List<T> T 只能是类
		//List<String> list = new ArrayList<String>();
		
		MyThreadOne one = new MyThreadOne();
		one.setPriority(Thread.MAX_PRIORITY);
		MyThreadTwo two = new MyThreadTwo();
		Thread thread = new Thread(two);
		thread.setPriority(Thread.MIN_PRIORITY);
		//启动线程
		one.start();
		thread.start();
		
	}

}

//偶数类
class MyThreadOne extends Thread{
	
	public void run(){
		for(int i=0;i<=100;i+=2){
			
			System.out.println("偶数"+i);
		}
		
	}
	
}
//奇数 
class MyThreadTwo implements Runnable{
	@Override
	public void run(){
		
		for(int i=1;i<100;i+=2){
			
			System.out.println("奇数"+i);
		}
		
	}
} 


