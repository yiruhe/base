package com.tz.basis;

/**
 * Created by Administrator on 2017/3/5.
 *
 *
 */

import java.lang.reflect.Method;
import java.util.Arrays;

public class MethodDemo {

    public static void main(String[] args) throws Exception {
        //其实Method的invoke方法的参数也是一个可变参数
        // 那么当参数new String[]{"a" ,"b" ,"C"})传给invoke方法时，会自动拆分成3个参数："a" ,"b" ,"c"
        //它参数要求的就是Object数组,内部自动解包

        //获取Person类的字节码对象
        Class<Person> c = Person.class;

        Method method =  c.getMethod("done",String.class);

        method.invoke(c.newInstance(),"done");

        //静态方法没有所属对象的,静态属于类 此时不invoke的第一个参数设置为null就可以了
        Method m = c.getMethod("run");

        m.invoke(null);

        //不知道对象的类型,调用类型的方法
        //创建一个对象
        Object obj = new Person();
        //先拿到对象的字节码对象
        Class clazz = obj.getClass();

        //可变参数原理是数组

        //获取方法对象
        Method doWork =  c.getMethod("doWork",String[].class);
        //调用方法
        doWork.invoke(c.newInstance(),new Object[]{new String[]{"1","2","2","2"}});

        Method dowWork2 = c.getMethod("doWork",int[].class);
        dowWork2.invoke(c.newInstance(),new int[]{1,2,3,4});

    }


}


class Person{

    //可变参数
    public void doWork(String ...args){

        System.out.println(Arrays.toString(args));

    }

    public void doWork(int...args){
        System.out.println(Arrays.toString(args));
    }


    public void done(){

        System.out.println("done");

    }

    public static void run(){

        System.out.println("run");

    }

    public void done(String name){

        System.out.println(name);

    }

    private void say(String name,int age){

        System.out.println(name+"===="+age);

    }

}