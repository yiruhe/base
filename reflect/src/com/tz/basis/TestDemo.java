package com.tz.basis;


public class TestDemo {


    public static TestDemo test = new TestDemo();
    public static int a;

    public static int b = 0;


    TestDemo() {

        a++;
        b++;
    }

    public static void main(String args[]) {


        System.out.println(TestDemo.a);
        System.out.println(TestDemo.b);
        System.out.println(1>1);



    }


}
