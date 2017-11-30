package com.tz.lock_test_demo;

/**
 * Created by Administrator on 2017/2/13 0013.
 */
public class LockDemo {

    //wait和notify只能被同步监听对象来调用，否则报错illegalMonitorStateException;
    //lock机制根本没有同步锁，那么也没有自定获取锁，和释放所得概念
    //所以使用condition取代Object的wait等方法

    //发现jvm在执行方法以前，如果发现该方法前面有对象的synchronized关键字，就现在该对象的ID上加锁，当其他线程执行同时执行这个方法时，会检测改对象ＩＤ上是否加锁，如果加锁时就等待锁释放。一个对象的多个同步方法,由于锁是同一个，所以其他线程还是无法进入

    //一个锁wait后，只能被同一个锁唤醒notify;


    //死锁:
    //当线程1吧对象1锁好以后,就想去锁对象2，但是不巧，线程2已经吧对象2锁住了，也正想尝试去锁对象1;



    //使用sleep,当前线程放弃cpu，sleep所在的线程不会获得执行的机会;但是不会释放锁。

    //子线程调用join方法,主线程就放弃执行权，等待调用join的线程执行完毕后再执行主线程
    //在一个线程中启动另外一个线程的join方法，当前线程将会挂起，而执行被启动的线程，知道被启动的线程执行完毕后，当前线程才开始执行。


    public static void main(String[] args){

        SleepDemo s =  new SleepDemo();
        SleepDemo2 s1 =  new SleepDemo2();
        Thread t = new Thread(s,"线程1");
        Thread t1 = new Thread(s1);
        t.start();
        t1.start();
        try{
                t.join();
                t1.join();

        }catch(InterruptedException e){

            e.printStackTrace();
        }

        if(!t.isAlive()){
            System.out.println("yes********************");
        }else{
            System.out.println("no********************");

        }

    }



}

class SleepDemo implements Runnable{

    @Override
    public void run(){
        for(int i=0;i<50;i++){

            System.out.println(Thread.currentThread().getName()+"=="+i);
        }
    }
}
class SleepDemo2 implements Runnable{

    @Override
    public void run() {

        for(int i= 0;i<50;i++){

            System.out.println(Thread.currentThread().getName()+"===="+i);

        }
    }
}


