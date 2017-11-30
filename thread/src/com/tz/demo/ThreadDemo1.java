package com.tz.demo;

/**
 *
 * Created by Administrator on 2017/1/26 0026.
 */
public class ThreadDemo1 {
    //抢占式
    //线程离不开进程
    //线程：
    // 实现Runnable
    //继承Thread类
    //并行  //同一时刻
    //并发  //同一时间段

    public static void main(String[] args){


        Thread a = new A();

        a.start();

        System.out.print(Thread.currentThread().getName());

        try{

        Thread.sleep(2000);

        }catch(InterruptedException e){

            e.printStackTrace();
        }
        System.out.print(Thread.currentThread().getName());

        System.out.print("I am done......");

    }


}

class A extends Thread{

    public void run(){

        for(int i=0;i<10;i++){
            System.out.println(Thread.currentThread().getName());

            System.out.println(i);
        }

    }

}
