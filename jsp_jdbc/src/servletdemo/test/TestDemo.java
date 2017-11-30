package servletdemo.test;

import servletdemo.dao.implement.StudentImplement;

public class TestDemo {

	public static void main(String[] args){
		
		System.out.println(new StudentImplement().query());
		
	}
	
}
