package com.javabean;

import org.junit.Test;
import java.beans.*;


public class JavaBeanBasicDemo {


    @Test
    public void  test(){
        //javaBean 是一种JAVA语言写成的可重用组件(类)
        //广义:所有类都是javaBean
        //狭义:遵循某些过饭的类
        //必须遵循的规范:
//        1.类必须使用public修饰,一个文件一个类
//        2.必须保证有公共无参数构造器
//        3.包含了属性的操作手段(给属性赋值,获取属性)

        //javaBean
//            property:属性是由getter,setter方法决定的


//        >2.(introspector)内省机制<获取和操作javaBean的属性>

            try{

                BeanInfo introspector = Introspector.getBeanInfo(BeanTestDemo.class);
                //获取属性描述符数组,每一个属性都有一个描述器
                 PropertyDescriptor[] propertyDescriptor = introspector.getPropertyDescriptors();

                 for(int i=0;i<propertyDescriptor.length;i++){

                     //
                     String programmaticName = propertyDescriptor[i].getName();
                     //这里多获取了一个class,这是Object类对象中的getClass方法
                     System.out.println(programmaticName+"==="+propertyDescriptor[i].getPropertyType());

                 }



            }catch(Exception e){

                e.printStackTrace();

            }



    }
}
