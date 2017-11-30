package com.tz.timerdemo;


import java.util.Timer;
import java.util.TimerTask;
public class TimerDemo {

    //线程组:ThreadGroup;
    //用户创建线程对象时,可以通过指定其所属的线程组

    //如果A线程创建B线程,B线程没有设置分组,那么B线程和A线程同组
    //一旦线程创建课某个线程组，线程就一直存在该线程组中直到死亡,不能在中途修改线程的分组
//    ---------------
    //当java程序运行时,JVM会创建main的线程组，默认情况下，所有线程都改在该组下;

    public static void main(String[] args) throws Exception{


         Timer timer = new Timer(true); //默认false,true为守护线程
        TimerTask t =new TimerTask(){

            @Override
            public void run(){

                System.out.println("我在这里呀!");

                //这里不能使用this,this指的就是这个匿名内部类，如果调用cancel,就是调用的TimerTask类的cancel
                System.out.println(this);
            }


        };


        timer.schedule(t,2,20);

        for(int i=0;i<200;i++){

            System.out.println(i);
        }



    }
}
