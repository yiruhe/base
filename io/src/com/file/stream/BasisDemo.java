package com.file.stream;


import java.util.Properties;
import java.util.Map;
import java.util.Set;

public class BasisDemo {


    //四大基流: 字节/字符-输入输出流(InputStream/OutputStream & Write/Reader)
    //四大基流都是抽象类

    //无论什么流都用close方法,用来关闭资源
        //如果操作文件，就得开通一个流对象关键我们的磁盘文件,如果不关闭资源,那么磁盘的文件一直被程序所占用着.不能删除,也不能更改

        //，长时间不用该文件的输入输出流会默认回收掉
        //用于关闭输出流，释放相关的系统资源（如文件句柄（file handle）或者网络端口）。关闭之后，该输出流不能再被操作或者重新打开，否则抛出异常


        //renameTo
//            失败的原因有三个。
//            1.源文件不存或不可写。
//            2.目标文件已存在。
//            3.源文件和目标不是在同一个盘时，不同的盘的文件格式是否相同。


        public static void main(String[] args){



            Properties properties = System.getProperties(); //系统属性

            Set<Map.Entry<Object,Object>> iterator = properties.entrySet();

            for(Map.Entry<Object,Object> k:iterator){

                System.out.println(k);

            }



        }


}
