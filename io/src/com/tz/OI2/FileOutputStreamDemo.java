package com.tz.OI2;

/**
 * Created by Administrator on 2017/1/24 0024.
 */

import java.io.FileOutputStream;
import java.io.IOException;
public class FileOutputStreamDemo {


    public static void main(String[] args){
        FileOutputStream fs =null;

        try{

            fs = new FileOutputStream("F:/2.txt");

            String msg = "My name is OK";

            byte[] bytes = msg.getBytes();

            for(byte k:bytes){

            System.out.print(k+"  ");
            }

        }catch(IOException e){

            e.printStackTrace();
        }finally{

        }

    }
}
