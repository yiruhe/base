package com.tz.Exception;

import java.util.Scanner;

import java.io.IOException;
public class Throws {

	//非检查异常RuntimeException运行时异常 -->java.long.Throwable
	//检查异常  checked Exception--> java.long.Throwable
	//PrintStackTrace();
	//级别越低，越在上面，级别越高越在后面

	//吧原始异常包装成新的异常类，多个异常有序排放，查看causeed by

	//java7增强了throw  处理异常更加精细，java7以前，捕获到异常的类型，再抛出必须是一样的
	//return 返回一个值,而throw返回一个错误,错误返回给方法的调用者

	//java7中的多异常捕获，默认final修饰 不能重新赋值，更改 ，子类不能和父类平级


	//java7的自动关闭，必须实现AutoCloseable

	//getMessage(描述信息)
	//toString
	//printStackTrace()


	//RunTimeException 自成一派  其他都是checkedException

	//throws: 运用于方法声明上面,用于表示当前方法不处理异常,而是提醒调用者处理
	//throw:方法内部,给调用者返回一个异常对象

	public void  run() throws IOException { //java7 可以   java6以及之前不能


		try{

		}catch(Exception e){

			e.printStackTrace();

			throw e;

		}

	}

	int test(){
		int a = 1;

		try{

			return a;  //这里返回的是1,因为代码执行到这里的时候,读取到的a就是1

		}finally{

			++a;

		}

	}

	public static void main(String[] args){
		try{
			
			Scanner in = new Scanner(System.in);
			int age = Integer.parseInt(in.nextLine());
			if(age <0 || age>130){
				//抛出这个异常
				throw new AgeException("不合法");
			}
			//捕获这个异常
		}catch(AgeException e){
			e.printStackTrace();
			System.out.print(e.getMessage());
		}
		
	}
}

class AgeException extends Exception{
	
	public  AgeException(){
		
	}
	
	public AgeException(String message){
	        super(message);

    }
}
