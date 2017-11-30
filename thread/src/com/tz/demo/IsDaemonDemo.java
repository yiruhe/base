package com.tz.demo;

/**
 * Created by Administrator on 2017/2/14 0014.
 */
public class IsDaemonDemo {

    public static void main(String[] args){

        //主线程
        System.out.println(Thread.currentThread().getName());
        //是否是守护线程
        System.out.println(Thread.currentThread().isDaemon()); //主线程不是后台线程


        //设置线程是否后台，必须在start方法前

        //线程优先级
        //不同的操作系统，支持的线程优先级是不同的,一般就用java自带的常量就可以了
        //每个线程都有默认优先级，主线程的默认优先级是5,,如果a线程创建b线程，那么b线程，具有和a线程相同的优先级

        //yield: 线程礼让
        //yield方法:表示当前线程对象提示调度器自己愿意让出cpu资源，但是调度器可以自由的忽略
        //调用该方法之后，线程对象进入就绪状态，所以完全有可能，某个线程调用了yield()之后,线程调度器
        //又把它调出来重新执行


        //yield方法和sleep方法的区别:
//            1:都能使当前运行的线程放弃cpu,把运行的机会让给其他线程;
            //2:sleep给其他线程运行机会，不考虑线程的优先级,yield方法只能给相同优先级或者跟高优先级的线程运行机会
            //3:调用sleep方法后，线程进入计时等待,而yield方法， 线程进入就绪状态

    }
}
