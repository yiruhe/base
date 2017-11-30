package com.tz.demo;

public class InputOutputDemo {
	
	//同一个锁上被等待的线程，可以被同一个锁的notify所唤醒
	// 唤醒和等待 是同一把锁
	
	public static void main(String[] args){
		
		
		
	}
	

}
class Resourse{
	String name;
	String sex;
	
}
class Input implements Runnable{
	private Resourse resourse;
	public Input(Resourse r){
		this.resourse = r;
	}
	
	@Override
	public void run(){
		resourse.name = "TDS";
		resourse.sex = "男";
		
		
	}
}
class Output implements Runnable{
	private Resourse resourse;
	
	public Output(Resourse r){
		this.resourse = r;
	}
	
	@Override
	public void run(){
		
	}
	
}

	
