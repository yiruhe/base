package com.tz.homework;

public class Calculator {
	//名字
	private String name;
	//年龄
	private int age;
	//体重
	private float weight;
	public void eat(){
		
		System.out.println(name+"吃饭");
	}
	public int getAge(){
		
		return age;
	}
	public void setName(String name){
		this.name = name;
	}
}
