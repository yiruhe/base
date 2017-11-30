package com.file.write_stream;


public class BasisDemo {


    public static void main(String[] args){

        //字符流是基于字节流的
        //字符流层次结构的顶层是Reader和Writer抽象类，与字节流中的InputStream、OutputStream相对应。
        //字符流处理的单元为2个字节的Unicode字符，分别操作字符、字符数组或字符串，而字节流处理单元为1个字节，
        //字节流在操作的时候本身是不会用到缓冲区（内存）的，是与文件本身直接操作的，而字符流在操作的时候是使用到缓冲区的
        //输出的文件不存在,默认会自动创建,文件除外


        //计算机只认数字,计算机中一切数据都是以数字来表示
        //中文的最高位是1,,也就是中文的码都是负数
        //ANSI: 是指GB2312 ,中文站两个字节
        // UTF-8+BOM: Microsoft搞出来的编码,默认3个字节
        //通常gbk/gb2312是2个字节，utf-8是3个字节
//        如果不指定encoding则取系统默认的encoding
        //1 byte = 8 bit
        //　char 在java中是2个字节。java采用unicode，2个字节（16位）来表示一个字符。

        //getBytes() 默认用的是项目的编码//String.getBytes()，所谓的“使用平台默认编码”是指，使用(.java)文件所用编码

        //ready是查看流是否已经准备好被读，是一个非阻塞的方法，所以会立刻返回，由于服务器没有准备好被读，所以会立刻返回，所以读取到的都是null。


    }
}
