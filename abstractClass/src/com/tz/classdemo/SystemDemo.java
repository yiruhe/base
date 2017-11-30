package com.tz.classdemo;


import java.util.Random;

public class SystemDemo {


    public static void main(String[] args){

        //JDK是Java的开发工具，它不仅提供了Java程序运行所需的JRE，还提供了一系列的编译，运行等工具，如javac，java，javaw等。JRE只是Java程序的运行环境，它最核心的内容就是JVM（Java虚拟机）及核心类库。

        //System.gc();
            // 一般不用，强制执行垃圾回收


       //Object
            //垃圾回收器，回收某个对象的之前，会调用这个方法 finalize

        //Runtime  ---> 单列模式--> 在每一个JVM进程里面都会存在一个Runtime对象

        //BigDecimal //用于float和double都不能表达精确,此时使用 --> 使用String做为参数才能表达精确

        //BigInteger //用于long存储不下的时候

//        return语句主要有两个用途:一方面用来表示一个方法返回的值（假定没有void返回值），另一方面是指它导致该方法退出，并返回那个值。根据方法的定义，每一个方法都有返回类型，该类型可以是基本类型，也可以是对象类型，同时每个方法都必须有个结束标志，因此，return起到了这个作用。在返回类型为void的方法里面，有个隐含的return语句，因此，在void方法里面可以省略不写




    }
}
