package com.file.ramdom_access;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileDemo {


    public static void main(String[] args){

//        EOF:End Of File;

        try{

            RandomAccessFile file = new RandomAccessFile("E:/Java/io/object/Access.txt","rw");


//            void write(int d)
//            该方法会根据当前指针所在位置处写入一个字节，是将参数int的”低8位”写出
             /*向文件中写入一个int最大值
         * 01111111 11111111 11111111 11111111
         * write(int a)写出的是二进制的“低8位”(最大值255)
         * */
            //void writeInt(int a)连续写出4个字节，将“int值对应的二进制”全部写出

            int testInt = 1;
            file.write(testInt>>24); //读取高8位依次读取8位数据
            file.write(testInt>>16);
            file.write(testInt>>8);
            file.write(testInt);

//            写入字符串
            file.writeUTF("风");
            System.out.println(file.getFilePointer());
            file.seek(0);
            file.skipBytes(4); //一个int站4个字节
            System.out.println(file.readUTF());
            System.out.println(file.getFilePointer()); //此时文件指针在最后,需要调回初始位置
            file.writeUTF("风");  //每次写入字符,都会先写两个字节,在写入真正的字符
            System.out.println(file.getFilePointer()); //此时文件指针在最后,需要调回初始位置

            file.seek(0); //文件指针回到0的位置
            /*
                int read()
                该方法会从文件中读取一个byte(8位) 填充到int的低八位, 高24位为0, 返回值范围正数: 0~255,
            */

            System.out.println(file.readInt());




            file.close();
        }catch(IOException e){

            e.printStackTrace();

        }
    }


}
