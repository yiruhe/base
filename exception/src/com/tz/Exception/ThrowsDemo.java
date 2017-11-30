package com.tz.Exception;

import java.util.Scanner;
public class ThrowsDemo {

		public static void main(String[] args){
			Scanner in = new Scanner(System.in);
			System.out.println("输入你的用户名");
			String username = in.nextLine();
			System.out.println("输入你的年龄");
			int age = in.nextInt();
			Student student = new Student();
			student.setUserName(username);
			try{
				student.setAge(age);
				
			}catch(AgeException e){
				e.printStackTrace();
				
			}
			System.out.println("名字"+student.getUserName()+"==="+student.getAge());
			
		}
}

class Student  {
	private String username;
	private int age;
	public String getUserName(){
		return username;
	}
	public int getAge(){
		return age; 
	}
	
	public void setUserName(String username){
		this.username = username;
	}
	//谁调用我  就把错误抛给谁  ---> throws
	public void setAge(int age) throws AgeException{
		if(age <0 || age > 130){
					
			throw new AgeException("请输入正确的年龄");
		}
		this.age = age;
	}
	
}
