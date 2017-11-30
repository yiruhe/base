package com.file.printstream;


import java.io.PrintStream;

public class PintStreamDemo {


    public static void main(String[] args){

        //PrintStream:
        // 字节打印流 -->不用刷新,因为并没有使用缓冲区
        //打印流只能是输出流

//        PrintStream pint = new PrintStream();


        //printWriter:
        // 开启了自动刷新,只有调用println(),printf(),format方法才会立马刷新缓冲区

        //System.out == PrintStream

        int age = 10;

        String name = "test";

        float testNumber = 33.333F;

        //%：表示格式说明的起始符号，不可缺少。
        //m.n：m指域宽，即对应的输出项在输出设备上所占的字符数。N指精度。用于说明输出的实型数的小数位数。为指定n时，隐含的精度为n=6位。
        String format = "姓名:%s,年龄:%d";

        System.out.printf(format+"%n",name,age);

        System.out.printf("%-+2.2f%n",testNumber);

        //支持多个参数时，可以在%s之间插入变量编号，1$表示第一个字符串，3$表示第3个字符串
        //s 表示大小写
        System.out.printf("%1$s = %3$s %2$s%n", "Name", "san", "Zhang");


    }
}
