package com.tz.producer_and_conusmater;


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
