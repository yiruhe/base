package com.tz.utils;

import java.util.Date;
import java.util.Calendar;
public class DateDemo {

	public static void main(String[] args){
		
//		Date data = new Date();
//		System.out.println(data.getTime());
		//抽象类  getInstance() 返回Calendar 类；
		Calendar calendar = Calendar.getInstance();
		
		
		//get 方法
		System.out.println(calendar);
		System.out.println(calendar.get(Calendar.YEAR));
		System.out.println(calendar.get(Calendar.MONTH)+1);
		System.out.println(calendar.get(Calendar.DATE));
		System.out.println(calendar.get(Calendar.HOUR_OF_DAY));
		System.out.println(calendar.get(Calendar.MINUTE));
		System.out.println(calendar.get(Calendar.SECOND));
		System.out.println(calendar.get(Calendar.DAY_OF_WEEK)-1);
		System.out.println(calendar.get(Calendar.WEEK_OF_YEAR));
	} 
}
