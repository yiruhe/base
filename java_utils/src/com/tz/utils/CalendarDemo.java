package com.tz.utils;


import java.util.Calendar;

public class CalendarDemo {
        //Calendar //是一个抽象类  //可以通过方法实例化//实例方法其实是实例的子类

//        get();返回给定日历字段(日历字段：年，月，日，时分，秒字段，也就是这个类里面对应的常量)的值
        //System.out.println(Calendar.YEAR); //这里只是获取了这个常量的值

        //
        public static void main(String[] args){
            Calendar calendar = Calendar.getInstance();
            int c = calendar.get(1); //Calendar.YEAR =1;

            System.out.println(c);

            calendar.add(Calendar.YEAR,1); //根据给定是日历字段，添加减去时间

//            getTime //将calendar转化为 Date
            System.out.println(calendar.getTime().toLocaleString()); //2018-
            //setTime()//使用给定的 Date 设置此 Calendar 的时间。


        }
}