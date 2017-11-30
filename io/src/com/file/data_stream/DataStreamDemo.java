package com.file.data_stream;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Created by Administrator on 2017/3/1.
 */
public class DataStreamDemo {


    public static void main(String[] args){
        //读取任意数据类型数据流
        //DataOutputStream: 提供了 writeXXX(XXX)
        //DataInputStream: 提供了readXXX();
        //write和read要一一对应,避免出错

        //DataOutputStream 也使用装饰者模,所以只需要关闭最外层就可以了



        try{

            DataOutputStream data = new DataOutputStream(new FileOutputStream("E:/Java/io/object/dataTest.txt"));

            data.writeByte(1);
            data.writeUTF("test");


            DataInputStream dataIn = new DataInputStream(new FileInputStream("E:/Java/io/object/dataTest.txt"));

            System.out.println(dataIn.readByte());
            System.out.println(dataIn.readUTF());



        }catch(Exception e){

            e.printStackTrace();

        }


    }
}
