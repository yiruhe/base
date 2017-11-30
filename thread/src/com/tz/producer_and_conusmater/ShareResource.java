package com.tz.producer_and_conusmater;


public class ShareResource {

    private String name = null;
    private String gender =null;
    private boolean flag = true;

    //用同步代码块/方法,解决性别紊乱的问题，问题出现的原因是，两个线程抢夺cpu的时间片,造成的
     synchronized public void push(String name,String gender){

         while(!flag){ //用while循环，解决某些线程被唤醒向下执行的问题，while使其重新判断一次

             try{

                this.wait();

             }catch(InterruptedException e){

                 e.printStackTrace();
             }

         }

        this.name = name;
        this.gender = gender;
        System.out.println("生产"+Thread.currentThread().getName());

        this.flag = false;
        this.notifyAll();
    }

     synchronized public void shift(){

         while(flag){ //解决虚假唤醒

             try{

                this.wait(); //线程在这里等待,while使其再判断一次

             }catch(InterruptedException e){

                 e.printStackTrace();
             }
         }

        System.out.println(this.name+"-->"+this.gender+Thread.currentThread().getName());

        this.flag = true;
        this.notifyAll();
    }

}
