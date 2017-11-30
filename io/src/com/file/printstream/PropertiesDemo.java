package com.file.printstream;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Administrator on 2017/3/1.
 */
public class PropertiesDemo {

    //# 注释
//    加载.properties文件需要用到Properties类


    public static void main(String[] args) throws Exception{


        Properties p = new Properties();

        InputStream in =  new FileInputStream("E:\\Java\\io\\object\\db.properties");
        //数据加载到对象
        p.load(in);

        System.out.println(p.getProperty("username"));
        System.out.println(p.getProperty("password"));

        in.close();



    }
}
