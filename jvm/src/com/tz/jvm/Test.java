package com.tz.jvm;


public class Test {


    public static void main(String[] args){


        //Parent..............
        //4
        //子类并没有初始化
        //只有当程序访问的静态变量或静态方法确实在当前类或者接口中定义时,才可以认为是对类或者接口的主动使用
        //定义这父类中,通过子类访问,但没有放在子类中,只会对变量存在的这个类的初始化
        System.out.println(Son.i);

    }


}



class Parent{

    static int i = 4;

    static{

        System.out.println("Parent..............");


    }



}

class Son extends Parent{


    static{

        System.out.println("Son................");

    }


}

