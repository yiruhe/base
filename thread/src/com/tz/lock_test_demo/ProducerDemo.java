package com.tz.lock_test_demo;


public class ProducerDemo implements Runnable {

    private ShareResource share = null;


    @Override
    public void run(){


        for(int i=0;i<5;i++){

                share.push();

        }

    }

    ProducerDemo(){

    }

    ProducerDemo(ShareResource share){

        this.share = share;

    }
}
