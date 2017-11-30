package com.tz.inside;

/**
 * Created by Administrator on 2017/2/3 0003.
 */
public class Test {


    Test t = new Test(new AA(){

        public void say1(){


        }
        public void say2(){


        }
        public  void say3(){}

        public  void say4(){}

    });

    public Test(AA aa) {


    }
}


interface AA extends BB{
    void say1();
    void say2();

}

interface BB{

    void say3();
    void say4();

}

