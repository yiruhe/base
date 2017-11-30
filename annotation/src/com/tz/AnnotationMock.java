package com.tz;


import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

//定义注解
//注解也会编译成class文件
//注解的使用方式和修饰符一样
//没有元素的注解叫标记注解
//值不能为null, 可以void.class
//获取属性  直接执行这里定义的抽象方法就可以
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface AnnotationMock {
    //注解里面定义的方法称为属性
//    　1.所有基本数据类型（int,float,boolean,byte,double,char,long,short)
//      2.String类型
//　　　　3.Class类型
//　　　　4.enum类型
//　　　　5.Annotation类型
//　　　　6.以上所有类型的数组

    //如果这里只有一个属性并且为value那么就可以不用谢value=
    String level();

    int age() default 20; //定义默认值

    String[] hobby();

    Gender gender() default Gender.NONE ;


}
enum Gender{

    MAN,WOMAN,NONE

}




