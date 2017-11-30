package com.tz.lock_test_demo;


import java.util.concurrent.locks.*;


public class ShareResource {


    private int count = 0;
    private boolean flag = true;
    private Lock lock = new ReentrantLock();
    //lock的等待唤醒机制
    private Condition condition = lock.newCondition();

    //用同步代码块/方法,解决性别紊乱的问题，问题出现的原因是，两个线程抢夺cpu的时间片,造成的
    public void push() {


        lock.lock();  //获取锁；

        try {

            while (!flag) { //用while循环，解决某些线程被唤醒向下执行的问题，while使其重新判断一次

                condition.await();
            }


            System.out.println(Thread.currentThread().getName()+"生产"+count);

            flag = false;

            condition.signalAll(); //唤醒消费者


        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            lock.unlock();
        }

    }

    public void shift() {

        lock.lock();

        try{

            while (flag) {

                condition.await(); //线程在这里等待,while使其再判断一次

            }

            System.out.println(Thread.currentThread().getName()+"消费"+(count++));

            this.flag = true;

            condition.signalAll(); //唤醒生产者

        }catch(InterruptedException e){

            e.printStackTrace();

        }finally{

            lock.unlock();

        }

    }

}
