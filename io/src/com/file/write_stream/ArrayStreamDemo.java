package com.file.write_stream;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.StringReader;
import java.io.StringWriter;

public class ArrayStreamDemo {


//    memory

    public static void main(String[] args) throws Exception{


        //字节数组流/内存流 和字符数组流
        //字节数组输出流:程序--> 内存
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        //存入数组中
        bos.write("ABCDEF".getBytes());
        //使用存储的临时数据
        byte[] buffer = bos.toByteArray();


        //读取程序中的数据,存入ArrayInputStream中
        ByteArrayInputStream in = new ByteArrayInputStream(buffer);

        int len;
        while((len = in.read()) != -1){

            System.out.println((char)len);


        }

        //字符串流(内存流) StringReader StringWriter 底层StringBuffer

        StringWriter str = new StringWriter();

        //写入内存中
        str.write("Hello World!");

        System.out.println(str.toString());

        StringReader strIn = new StringReader(str.toString());

        char[] charArr = new char[1024];

        int length;

        while((length = strIn.read(charArr)) != -1){

            System.out.println(new String(charArr,0,length));

        }





    }
}
