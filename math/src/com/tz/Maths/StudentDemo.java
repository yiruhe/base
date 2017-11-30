package com.tz.Maths;

public class StudentDemo {

	private String username;
	
	private int age;
	
	public StudentDemo(){
		
	}
	
	public StudentDemo(String name,Integer age){
		
		this.username = name;
		this.age = age;
	}
	//
	public String getName(){
		
		return username;
	}
	
	public void setName(String name){
		
		this.username = name;
		
	}
	//
	public void setAge(int age){
		
		this.age = age;
		
	}
	
	public int getAge(){
		

		return age;
	}
	@Override
	public String toString(){
		
		return this.username+" "+this.age;
		
	}
	
	@Override
	public boolean equals(Object obj){
		if(obj == null){
			return false;
		}
		if(this == obj){
			
			return true;
		}
		
		if(obj instanceof StudentDemo){
			StudentDemo student = (StudentDemo)obj;
			
			return this.username.equals(student.username) && this.age == student.age;
	
		}else{
			
			return false;
			
		}
		
		
	}
	
	
}
