package com.tz.demo;

/**
 * Created by Administrator on 2017/2/1 0001.
 */
public class NewThreadDemo {//主类
    //多线程启动的唯一方法就是start方法
    //线程只能使用一次
    //如果使用run就相当于普通方法
    //不管什么情况，想启动线程就要使用Thread类
    //Runnable可以使用 多个对象访问同一对象里的资源
    //Thread类是Runnable的子类
    //每一个线程都回去执行run方法

    //Callable<T> 有返回结果  子类要实现call()方法
    //RunnableFuture 也是Runnable的子类
    // FutureTask的构造 接收 Callable
    //通过get()方法获取返回值

   // 该类就定义一个功能。用于存储线程要运行的代码。该存储功能就是run方法
   // 也就是说Thread类中的run方法。用于存储线程要运行的代码。
   // 覆写run的目的：讲自定义代码存储在run方法，让线程运行。


    //线程名字
//    public Thread(Runnable,String name);

//        setName
//        getName
    //获取线程名字有一个问题
    //getName方法是属于Thread类的，如果是线程类（Runnable）子类并没有这个方法
    //所以可以使用Thread.currentThread()方法获取当前线程的对象


    //为什么必须使用start()启动线程

//        if (threadStatus != 0)  //多于1次就抛出此异常
//            throw new IllegalThreadStateException(); //Runtime异常

    //发现 start(), 要去调用start0(); 是根据不同的操作系统去使用的
    //也就是start方法会创建一个执行run方法的线程

    //synchronized 优点: 安全  缺点:降低性能
}

//线程操作主类
class MyTread extends Thread{ //多线程操作类


    @Override
    public void run(){

    }

}
