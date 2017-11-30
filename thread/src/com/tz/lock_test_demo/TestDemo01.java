package com.tz.lock_test_demo;


public class TestDemo01 {


    public static void main(String args[]){

        ShareResource s = new ShareResource();

        Thread a= new Thread(new ProducerDemo(s),"先生1");
        Thread a2 = new Thread(new ProducerDemo(s),"先生2");
        Thread b = new Thread(new ConsumerDemo(s),"女士1");
        Thread b2 = new Thread(new ConsumerDemo(s),"女士2");
        a.start();
        a2.start();
        b.start();
        b2.start();

    }
}
