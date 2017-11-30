package com.tz.jvm;


public class LoadingTest {

    static{

        System.out.println("I am main"); //回西安加载含有主方法的类
    }

    public static void main(String[] args){

//        System.out.println(Test2.b);
        System.out.println(TestInterface.a);  //静态常量是不会初始化接口的,因为编译时已经确定
        System.out.println(TestInterface.test);



    }





}



class Test1{

    static int b = 2;

    static{

        System.out.println("I am Test1");

    }

}

class Test2 extends Test1{

    static final int a = 1;   //当这里为编译时确定的静态常量的时候不会对类进行初始化

    static {

        System.out.println("I am Test2");

    }



}

interface TestInterface{


    public static final int a = 10;

    public static final Test2 test = new Test2();


}