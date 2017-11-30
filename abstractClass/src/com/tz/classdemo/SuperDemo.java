package com.tz.classdemo;

/**
 * Created by Administrator on 2017/2/8 0008.
 */
public class SuperDemo {
        //super 是调用子类被覆盖的方法
        //super 代表当前对象的父类对象
    //this和super不能同时出现在一个构造函数里面，因为this必然会调用其它的构造函数，其它的构造函数必然也会有super语句的存在，所以在同一个构造函数里面有相同的语句，就失去了语句的意义，编译器也不会通过。
    //this()和super()都指的是对象，所以，均不可以在static环境中使用。包括：static变量,static方法，static语句块。
    //从本质上讲，this是一个指向本对象的指针, 然而super是一个Java关键字。


    SuperDemo(){

        System.out.println("**************");
    }

    public static void main(String[] args){
        Son son = new Son();

    }



}


class Son extends SuperDemo {


    Son(){

    }
    Son(String name){
        super();


    }

}
