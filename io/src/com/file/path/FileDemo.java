package com.file.path;


import java.io.File;
import java.io.IOException;


public class FileDemo {

//    linux中:号作为分割符
//字符集  gbk:简体+繁体   gb2312  简体   -->都是两个字节
// utf8  可变长度字符集

    public static void main(String[] args){

//        返回的是同一个东西，系统相关的分割符
        String a = File.pathSeparator;
        char  b = File.pathSeparatorChar;


//        File类 -->路径名可以是绝对的(相对于文件系统的根目录)或相对于在该程序正在运行的当前目录。////默认的当前目录是项目根目录

            //没有端口就是3根斜线

//        由File类定义的文件在实际中有可能存在也有可能不存在，有可能是一个目录或者其它非普通文件。

        //这里仅仅表示路径
        File file = new File("F:/a/2.txt");//方式1
        File file1 = new File("F:/a","2.txt");//方式2
        File file2 = new File(new File("F:/a"),"2.txt");//方式3


        String path = file.getAbsolutePath();  //返回字符串路径
        File path1 = file.getAbsoluteFile();  //返回一个File对象


        String parent = file.getParent(); //返回父级目录-->String
        File parent1 = file.getParentFile(); //返回file对象

        System.out.println(file.canExecute());

        String name = file.getName(); //获取文件名
        String path3 = file.getPath();  //获取文件路径 和绝对路径一样

        System.out.println(name+"==="+path3);

        File file3 = new File("F:/a/a.txt");

        if(!file3.exists()){

            try{

            file3.createNewFile();

            }catch(IOException e){

                e.printStackTrace();

            }

        }else{

            file3.renameTo(new File("F:/a/bb.txt"));

        }




    }




}
