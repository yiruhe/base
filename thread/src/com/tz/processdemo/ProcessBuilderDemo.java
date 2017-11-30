package com.tz.processdemo;


import java.io.IOException;

public class ProcessBuilderDemo {


    //在java中，打开一个进程;
    //通过Runtime;
    //用过ProcessBuilder;

    ////每一个JVM进程里面都会有一个RunTime类的对象，RunTime 实例是直接与本地运行有关的所有相关属性的集合，RunTime也使用了单列的设计模式
    public static void main(String[] args){

        ProcessBuilder pb = new ProcessBuilder("calc");
        try{

            pb.start();

        }catch(IOException e){

            e.printStackTrace();
        }

        Runtime rt = Runtime.getRuntime(); //取得RunTime实例

        System.out.println(rt);

    }

}
