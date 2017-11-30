package com.tz.OI2;

/**
 * Created by Administrator on 2017/1/24 0024.
 *
 */

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class BufferedDemo {
    /*
        字节
        BufferedInputStream
        BufferedOutputStream
        字符
        BufferedReader
        BufferedWrite
        //缓冲区大小 8kb
        java.io.BufferedReader和java.io.BufferedWriter类各拥有8192字符的缓冲区
         java.io.BufferedReader和java.io.BufferedWriter类各拥有8192字符的缓冲区。当BufferedReader在读取文本文件时，会先尽量从文件中读入字符数据并置入缓冲区，而之后若使用read()方法，会先从缓冲区中进行读取。如果缓冲区数据不足，才会再从文件中读取，使用BufferedWriter时，写入的数据并不会先输出到目的地，而是先存储至缓冲区中。如果缓冲区中的数据满了，才会一次对目的地进行写出。
         就需要手动刷新flush

         只要是处理纯文本数据，就要优先考虑使用字符流，除此之外都要用字节流。

     */
    public static void main(String[] args) {

        //节点流
        // FileReader fr = new FileReader("f:/2.txt");
        //包装流
        //BufferedReader br = new BufferedReader(fr);
        try {

            BufferedReader br = new BufferedReader(new FileReader("f:/2.txt"));

        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}
