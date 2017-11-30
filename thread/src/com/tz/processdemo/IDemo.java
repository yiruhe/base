package com.tz.processdemo;

/**
 * Created by Administrator on 2017/2/12 0012.
 */
public class IDemo {


    public static void main(String[] args){

        Add run = new Add();

        new Thread(run).start();
        new Thread(run).start();

    }

}

class Add implements Runnable{

    int num;

    @Override
    public void run(){

        for(int i=0;i<50;i++){

            try{
                Thread.sleep(10);
            }catch(InterruptedException e){

                e.printStackTrace();

            }

            this.num++;
        }

        synchronized(this){

            if(num == 100){
                System.out.println(this.num);
            }else{
                System.out.println(this.num);
                System.out.println("false");

            }
        }

    }

}
