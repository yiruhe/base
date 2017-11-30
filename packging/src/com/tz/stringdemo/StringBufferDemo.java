package com.tz.stringdemo;

public class StringBufferDemo {

	public static void main(String[] args){


		//String 是不可变得，每次改变都会new
		//耗时： String > StringBuffer > StringBuilder

        //缓存区类部实现:
        // new StringBuilder()  会调用父类构造  默认会创造一个长度为16的char数组，超过就扩容
        // 自动扩容的大小是 原数组size的2倍+2； //使用默认性能也不高
        //所以可以预估size

        //deleteCharAt
		StringBuffer sBuffer = new StringBuffer();
		sBuffer.append("123");
		sBuffer.insert(1, "6666");
		sBuffer.delete(2,5);
		sBuffer.reverse();
//		System.out.println(sBuffer.length());
		System.out.println(sBuffer);
		
		
	}
}
