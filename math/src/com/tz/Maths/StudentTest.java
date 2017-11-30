package com.tz.Maths;

import java.lang.reflect.Field;
public class StudentTest {
	
	public static void main(String[] args){
		
//		StudentDemo studentone = new StudentDemo("jack",20); 
//		StudentDemo studenttwo = new StudentDemo("jack",20); 
//		
//		System.out.println(studentone.toString());
		StudentDemo studentDemo = new StudentDemo();
		//这个实例属于那个类的
		Class cls =  studentDemo.getClass();
		//只能拿到公有的
//		Field[] fields = cls.getFields();
		Field[] fields = cls.getDeclaredFields();
//		System.out.println(fields);
		for(Field field : fields){
			System.out.println(field);
		}
	}

}
