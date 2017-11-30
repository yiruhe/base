package com.tz.processdemo;

/**
 * Created by Administrator on 2017/2/12 0012.
 */
public class VolatileDemo {

    //volatile的数组只针对数组的引用具有volatile的语义，而不是它的元素
    //volatile的作用：
    //保证内存可见性，防止指令重排序，并不保证操作原子性。
    //运行效率也不高，屏蔽掉了虚拟机的一些优化
    //原子操作指的是在一步之内就完成而且不能被中断。
    //java中的long,float变量不是线程安全的，开发中不影响,因为做了优化
    //volatile 不能保证原子性  ，原子性是指不可中断的一个或一系列操作。，要么读，要么写，就像getter setter

    //双重检查锁，和volatile的实例---饿汉模式
    private static volatile VolatileDemo instance  = null;
    private String name = "A";

    public static VolatileDemo getInstance(){

        if(instance == null){ //进行一次检查,提高效率,以后就不用每次都是用同步代码块了

            synchronized(VolatileDemo.class){

                //只是这样做是由问题的
                //A线程初始haul对象都还未完全初始化完毕，这时B线程就去访问
                //取到的就是状态不正确的对象。
                //使用volatile修饰变量解决执行顺序重排,保证原子性
                if(instance == null){

                    instance = new VolatileDemo();
                }

            }

        }

        return instance;
    }


    public static void main(String[] args){

       System.out.println(VolatileDemo.getInstance().name);

    }

}
