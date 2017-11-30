package com.tz.demo;

/**
 * Created by Administrator on 2017/2/15 0015.
 */
public class DaemonTest {
    public static void main(String[] args) throws Exception{

        Thread thread = new Thread(new Runnable(){

            @Override
            public void run(){
                for(int i=0;i<200;i++){

                    System.out.println("i am daemon!!!");
                }

            }
        });
        thread.setDaemon(true);
        thread.start();

        Thread.sleep(2200);

    }
}
