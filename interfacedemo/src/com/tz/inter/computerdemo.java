package com.tz.inter;

/**
 * Created by Administrator on 2017/1/31 0031.
 */
public class computerdemo {


    public static void main(String[] args){
        Computer com = new Computer();
        com.run(new Flash());
        com.run(new Print());
    }

}

class Computer{

    public void run(USB device){

        device.start();
        device.stop();
    }
}

interface USB{
    void start();

    void stop();
}

class Flash implements USB{
    public void start(){
        System.out.println("U盘插入");
    }
    public void stop(){
        System.out.println("U盘移除");
    }
}

class Print implements USB{

    public void start(){
        System.out.println("打印机插入");
    }

    public void stop(){
        System.out.println("打印机移除");
    }

}
