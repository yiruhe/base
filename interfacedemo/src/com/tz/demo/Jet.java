package com.tz.demo;

public class Jet extends Plane{
	@Override
	public void fly(){
		System.out.println("喷气式起飞了");
	}
	@Override
	public void land(){
		System.out.println("喷气式着陆了");
	}
}
