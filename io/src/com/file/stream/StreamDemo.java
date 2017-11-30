package com.file.stream;


import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class StreamDemo {


    public static void main(String[] args) {


        InputStream inputstream = null;

        //创建一个文件输入流引用
        try {
            File file = new File("E:/Java/io/src/com/file/stream/test.txt");

            inputstream = new FileInputStream(file);

            byte[] arr = new byte[20]; //一般1024 -->1kb

            int len;

            while ((len = inputstream.read(arr)) != -1) {

               /*
                0123456789_012345678
                9_0123456789_0123456
                789  {123456789_0123456} 多了 为什么呢？ 因为新的元素没有覆盖到旧元素,把数组里以前的旧元素也一起输出了
               */

                System.out.println(new String(arr,0,len));


            }


        } catch (java.io.IOException e) {

            e.printStackTrace();

        } finally {

            try {

                System.out.println(10/0);

               if(inputstream != null) inputstream.close();//might-->可能  initialize -->初始化

            } catch (java.io.IOException e) {

                e.printStackTrace();


            }


        }


    }


}
