package com.tz.inter;

/**
 * Created by Administrator on 2017/1/31 0031.
 */
public class interTest {


    public static void main(String args[]){

        A a = new X();
        a.funA();
    }



}

interface A{
    void funA();

    abstract class B{ //这里相当于又是一个新的类，所以可以不用必须去实现

        public abstract void funB(); //这里是一个抽象内部类

    }
}

class X implements A{

    public void funA(){

        System.out.println("=================");
    }


}


