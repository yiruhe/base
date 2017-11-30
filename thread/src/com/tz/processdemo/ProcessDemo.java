package com.tz.processdemo;


public class ProcessDemo {
    //主线程，// 子线程一旦创建权利一样

    //在线程的run方法不能throws，只能try/catch来处理
        //原因是：子类覆盖父类的方法，不能大于父类的异常，父类都没有throws，子类就更不能了


    //同步代码块
        //任何对象都可以作为同步监听对象，谁拿到锁，谁就进入，其他线程就等待，直到这个线程做完事



    public static void main(String[] args){

        A a = new A();
        //线程不安全  一个数字被使用多次
        new Thread(a,"小花").start();
        new Thread(a,"小李").start();
        new Thread(a,"小和").start();


    }


}

class A implements Runnable{

    int num = 50;
    public void run(){
        for(int i=0;i<50;i++){

            //同步代码块
            synchronized(this){ //使用当前对象作为锁
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

    }




}


