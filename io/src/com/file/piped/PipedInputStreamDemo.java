package com.file.piped;


import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipedInputStreamDemo {

    //实现线程之间的通信
    //java的管道输入与输出实际上使用的是一个循环缓冲数组来实现，这个数组默认大小为1024字节。输入流PipedInputStream从这个循环缓冲数组中读数据，输出流PipedOutputStream往这个循环缓冲数组中写入数据。


    public static void main(String[] args){

        A a = new A();
        B b = new B(a);
        a.start();
        b.start();




    }



}


class A extends Thread{

    private PipedOutputStream out = new PipedOutputStream();



    public void run(){

        try{

            for(int i= 48;i<60;i++){

                out.write(i);

            }

            out.close();
        }catch(Exception e){

            e.printStackTrace();
        }


    }


    public PipedOutputStream getPiped(){

        return this.out;
    }






}


class B extends Thread {

    PipedInputStream in;

    public void run() {
        try {


            int len;
            while ((len = in.read()) != -1) {

                System.out.println(len);

            }

            in.close();


        }catch(Exception e){

            e.printStackTrace();
         }
    }

    B(A out)  {

        try{

        this.in = new PipedInputStream(out.getPiped());

        }catch(Exception e){


            e.printStackTrace();

        }


    }



}
