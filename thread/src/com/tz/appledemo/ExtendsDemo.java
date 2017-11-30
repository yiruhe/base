package com.tz.appledemo;


public class ExtendsDemo {


    public static void main(String[] args){

        Apple a = new Apple("小A");
        Apple b = new Apple("小B");
        Apple c = new Apple("小C");
        a.start();
        b.start();
        c.start();

    }

}

class Apple extends Thread{

    int num = 50;
    public void run(){

        for(int i=0;i<50;i++){

            System.out.println(getName()+"吃了编号为"+(num--)+"的苹果");

        }

    }

    Apple(){

    }
    Apple(String name){
        super(name);

    }
}