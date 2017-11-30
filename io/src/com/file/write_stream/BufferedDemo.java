package com.file.write_stream;


import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

public class BufferedDemo {

//         默认的缓冲大小是8192字节
      // BufferedInputStream 会根据“缓冲区大小”来逐次的填充缓冲区；
      // 即，BufferedInputStream填充缓冲区，用户读取缓冲区，读完之后，BufferedInputStream会再次填充缓冲区。如此循环，直到读完数据...

                //java默认提供了8k的缓冲区,第一次读取就会读取8k的数据到内存中,然后程序每次操作都去缓冲区里取
                //同理输出也是,先输出到内存中,等满8k的时候再一次性写入文件中


                //字符创建的是字符缓冲区,字节创建的字节缓冲区


                //包装流使用装饰者模式,所以只需要关闭最外面一层就可以了



                //flush将缓冲数据写入到输出流中。


    public static void main(String[] args){

        //包装流(流对象):

        try{

        BufferedOutputStream bufferedOut = new BufferedOutputStream(new FileOutputStream("test.txt"));

        }catch(java.io.IOException e){

            e.printStackTrace();

        }



    }



}
