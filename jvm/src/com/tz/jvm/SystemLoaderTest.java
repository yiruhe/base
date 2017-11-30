package com.tz.jvm;


public class SystemLoaderTest {



    public static void main(String[] args) throws Exception {


        ClassLoader loader = ClassLoader.getSystemClassLoader();

        //加载字节码 并不会初始化类
        Class<?> clazz = loader.loadClass("com.tz.jvm.LoaderTest");

        System.out.println("----------------------------");

        Class.forName("com.tz.jvm.LoaderTest");


    }

}


class LoaderTest{


    static{

        System.out.println("delegation(委托)");

    }


}