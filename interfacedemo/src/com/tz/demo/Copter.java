package com.tz.demo;

public class Copter extends Plane {
	
	public Copter(){
		//有隐式的super（）；
		System.out.println("I Am Copter");
	}
	@Override
	protected void fly(){
		System.out.println("直升机起飞了");
	}
	@Override
	public void land(){
		System.out.println("直升机着陆了");
	}

}
