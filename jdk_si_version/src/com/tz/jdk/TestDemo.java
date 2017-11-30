package com.tz.jdk;

/**
 * Created by Administrator on 2017/3/6.
 */
public class TestDemo {
    //import 包.*   *并不是说加载当前包下所有类,而是使用到类时才加载--> 也就是用到哪些加载哪些

    //静态导入(语法糖) 编译后就没了  前面自动加上类名

    public static void main(String[] args){

        System.out.println("".equals(null));

        Object i =10; //自动装箱 然后Object
        Double i1 =10.0; //自动装箱


//        枚举: values() 获取当前枚举类中所有的实例  valueOf() //利用字符串寻找对象

        //实例加了{} 就是匿名内部类
        //枚举支持枚举,底层就是采用的枚举的ordinal()

        //ThreadLocalRandom   获取随机数  jdk1.7


    }
}