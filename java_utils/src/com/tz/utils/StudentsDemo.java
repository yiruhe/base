package com.tz.utils;

public class StudentsDemo {
	private String username;
	private int age;
	
	public StudentsDemo(){
		
		System.out.println("构造函数....");
	}
	public  StudentsDemo(String name,int age){
		
		this.username = name;
		this.age = age;
		
	}
	
	public void setName(String name){
		
		this.username = name;
	}
	
	public void   setAge(int age){
		this.age = age;
	}
	
	public int getAge(){
		
		return this.age;
	}
	
	public String getName(){
		
		return this.username;
	}
	
}
