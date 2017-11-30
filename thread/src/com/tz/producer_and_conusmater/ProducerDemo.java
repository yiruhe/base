package com.tz.producer_and_conusmater;


public class ProducerDemo implements Runnable {

    private ShareResource  share = null;


    @Override
    public void run(){


        for(int i=0;i<5;i++){

            if(i%2==0){

                share.push("帅先生","Man");

            }else{

                share.push("漂亮女士","Woman");

            }
        }

    }

    ProducerDemo(){

    }

    ProducerDemo(ShareResource share){

        this.share = share;

    }
}
