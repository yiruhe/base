package com.tz.producer_and_conusmater;


public class TestDemo {


    public static void main(String args[]){

        ShareResource share = new ShareResource();
        Thread a1= new Thread(new ProducerDemo(share),"生产1");
        Thread a2 = new Thread(new ProducerDemo(share),"生产2");
        Thread b1 = new Thread(new ConsumerDemo(share),"消费1");
        Thread b2 = new Thread(new ConsumerDemo(share),"消费2");
        a1.start();
        a2.start();
        b1.start();
        b2.start();

    }
}
