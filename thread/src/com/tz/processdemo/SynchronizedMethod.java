package com.tz.processdemo;

/**
 * Created by Administrator on 2017/2/4 0004.
 */
public class SynchronizedMethod {

    //同步方法
        // synchronized public void say(){}
        // 对于非static方法，同步锁就是this
        //对于static方法，我们使用方法所在类的字节码对象(类.class)

    //使用synchronized修饰run方法的时候
        //当某个线程获取权限进入，由于是同步，其他线程就在外面等待，直到这个线程把run方法执行完毕

    //synchronized 利与弊：
        //好处:保证了多线程并发访问时的同步操作
        //弊: 使用了synchronized后性能不高


        public static void main(String[] args){

                AA aa = new AA();

                new Thread(aa,"小A").start();
                new Thread(aa,"小B").start();
                new Thread(aa,"小C").start();




        }



}

class AA implements Runnable{

    int num = 50;
     public void run(){
        for(int i=0;i<50;i++){

            eat();
        }
    }

    //同步监听器为this
    synchronized private void eat(){
        try{

            Thread.sleep(10);
        }catch(InterruptedException e){

            e.printStackTrace();
        }

        if(num > 0){

            System.out.println(Thread.currentThread().getName()+"==========="+num--);

        }
    }




}
