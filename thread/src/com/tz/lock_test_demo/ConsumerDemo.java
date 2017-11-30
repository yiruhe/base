package com.tz.lock_test_demo;


public class ConsumerDemo implements Runnable {

    private ShareResource share = null;

    @Override
    public void run(){

        for(int i = 0;i<5;i++){

            share.shift();
        }

    }



    ConsumerDemo(){



    }

    public ConsumerDemo(ShareResource share){

        this.share = share;

    }

}
