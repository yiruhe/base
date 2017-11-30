package com.tz.abstractdemo;

/**
 *
 * Created by Administrator on 2017/2/2 0002.
 */
public class FinalDemo {
    //final //最终的
//    final的类不能被继承
//    final的方法不能被覆盖
//    final 方法 的目的就是不能被子类覆盖，构造器已经就是最终的了不能被覆盖，构造不能被继承
    // final一个方法的目的是让一个方法不能被子类覆盖，而构造函数是不能被继承的，用final是没有意义的，所以不能别final修饰


	final String name;
	

	final static String age = "10";

	
	{
		this.name = "";
	}
	
	
	

   public  static void main(String[] args){
	   
	   
	   
	   

    }

}
