package com.tz.jdk;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by Administrator on 2017/3/7.
 */
public class LambdaTest {


    public static void main(String[] args){
        //参数列表-> 表达式

        //lambda 中的this 指向 方法的this ,而不是匿名内部类

//        引用静态方法	ContainingClass::staticMethodName
//        引用某个对象的实例方法	containingObject::instanceMethodName
//        引用某个类型的任意对象的实例方法	ContainingType::methodName
//        引用构造方法	ClassName::new


        //只有一个抽象方法的接口称为函数式接口
        //可以通过@functionalInterface 标识

        //函数式接口，有且仅有一个抽象方法，Object的public方法除外

        //方法引用  也是一种lambda  对象::compare   //引用这个方法  去实现要实现的方法

        //this::compare

        //方法引用 需要参数列表相同   返回值相同


        //接口
        // 接口中方法冲突   子类必须实现冲突方法,并指定调用的方法   接口.super.方法
        //父类和接口有相同的方法,那么调用父类的
        //接口里面可以使用static,



        List<Integer> list = Arrays.asList(1,2,3,4,5);

        //1:
//        list.forEach(new Consumer<Integer>(){
//
//            public void accept(Integer x){
//
//                System.out.println(x);
//
//            }
//
//        });

        //2:编译器可以根据接收变量的类型,推导出我要实现的类
//        list.forEach(
//            (Integer x) -> {
//
//                System.out.println(x);
//
//            });

        //3: 可推到出参数的类型
//        list.forEach( x -> System.out.println(x));

        //4: 可以引用 println方法区去实现accept
        list.forEach(System.out::println);


        test01();


    }


    public static void test01 (){






    }
}


interface A{


    default void run(){

    }


}
