package com.tz.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Date2Demo {
	
	public static void main(String[] args) throws Exception{
//
//		Date nowDate = new Date();
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日  HH:mm:ss sss");
//		//格式化
//		String time =  sdf.format(nowDate);
//		System.out.println(time);
//
//		String time1 = "2016年7月1日  01:10:44 088";
//		 SimpleDateFormat  sdf2 = new SimpleDateFormat("yyyy年MM月dd日  HH:mm:ss sss");
//		 System.out.println(sdf2.parse(time1));

		java.text.DateFormat times = java.text.DateFormat.getInstance();
		java.util.Date date = new java.util.Date();

		String t = times.format(date);
        Date ts = times.parse(t);
		System.out.println(ts);

		//自定义模式  SimpleDateFormat
//        E 星期数
        //解析需要和定义的格式相同

        SimpleDateFormat sdf = new SimpleDateFormat();
        sdf.applyPattern("yyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(date));
		 
	}

}


class ATest{

    static void a(){}


}
class BTest extends ATest{

    BTest(){

    }



}
