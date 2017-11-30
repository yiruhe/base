package com.javabean;

import org.junit.Test;

import java.beans.*;
import java.lang.reflect.Method;
import java.util.*;

public class JavaBeanTest {


    //bean转Map
    public Map<String,Object> beanInvertMap(Object obj)  {

            //创建一个Map对象
           Map<String,Object> map = new HashMap<String,Object>();

           try{

               //获取BeanInfo对象并获取忽略Object的getClass Method;
                BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass(),Object.class);

                //获取这个类的属性描述符数组
                PropertyDescriptor[] propertyDescriptorArray = beanInfo.getPropertyDescriptors();

                for(int i=0;i<propertyDescriptorArray.length;i++){

                     Method method = propertyDescriptorArray[i].getReadMethod();

                     String propertyName = propertyDescriptorArray[i].getName();

                     //利用反射获取实例属性的信息
                     Object programmaticInfo = method.invoke(obj);

                     map.put(propertyName,programmaticInfo);
                }

                System.out.println(map);


           }catch(Exception e){

               e.printStackTrace();

           }


           return map;
    }

    //map转bean

    public <T> T mapInvertBean(Map<String,Object> bean,Class<T> clazz){

            //利用字节码获取这个类的实例对象;
            T obj =null;
        try{
            obj = clazz.newInstance();

            BeanInfo beanInfo =  Introspector.getBeanInfo(clazz,Object.class);

            //获取属性描述符
            PropertyDescriptor[] propertyDescriptor = beanInfo.getPropertyDescriptors();



            for(int i=0;i<propertyDescriptor.length;i++){


//                System.out.println(propertyDescriptor[i]);

                String name = propertyDescriptor[i].getName();

                 Object value = bean.get(name);

                propertyDescriptor[i].getWriteMethod().invoke(obj,value);

            }



        }catch(Exception e){

            e.printStackTrace();
        }

        return obj;

    }

    @Test
    public void testInvert() throws Exception{

        BeanTestDemo testObject = new BeanTestDemo("Jack","MAN",18);

        Map<String,Object> map = new JavaBeanTest().beanInvertMap(testObject);

        new JavaBeanTest().mapInvertBean(map,BeanTestDemo.class);

    }

}
