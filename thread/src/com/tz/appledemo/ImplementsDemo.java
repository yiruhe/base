package com.tz.appledemo;

public class ImplementsDemo {

    public static  void main(String[] args){

        //这里其实接收的是一个匿名类,多态的体现
        Runnable runnable = new Runnable(){

            int num =50;

            public void run(){


                for(int i=0;i<50;i++){

                    synchronized(this){

                        if(num !=0){

                                System.out.println(Thread.currentThread().getName()+"吃了编号"+(num--)+"的苹果");
                        }

                    }
                }
            }

        };

        System.out.println(runnable);
        new Thread(runnable,"小A").start();
        new Thread(runnable,"小B").start();
        new Thread(runnable,"小C").start();

    }

}

