package com.tz.TDemo;

/**
 * Created by Administrator on 2017/1/28 0028.
 */
public class PointTest {

    //<T> :代表此方法持有一个类型T
    //T : 返回值的类型为T
    //T的类型有传入的参数决定

    private String name = "done";

    public <T>T get(T c){

        return c;
    }

    class A{

        public void say(){

            System.out.println(PointTest.this.name);
        }
    }

    public static void main(String args[]){

      new PointTest().new A().say();
    }



}
//T 代表类型，<T>相当于形参 使用时添加相当于传参

//？
// ？ extends 类：可以再方法的声明上和参数上使用
// ？ super 类： 设置泛型下限： 方法参数上使用

//泛型接口


//ps：小技巧
//接口名称前加上I;
//抽象类名称前加上Abstract;
//普通类直接命名
//
class Point<T>{
    private T x;
    private T y;

    public void setx(T x){

        this.x = x;
    }

    public void sety(T y){

        this.y =y;
    }

    public T getx(){

        return x;
    }

    public T gety(){

        return y;
    }

}

interface IMessage<T>{



}
//父类没有定义，那么子类就要继续沿用父类的泛型
class A<T> implements IMessage<T>{

}
//这里的父类已经定义了泛型的类型，所以子类就不用继续定义了
class B implements IMessage<String>{
}
