package com.test.jdbc;


import org.junit.Test;
import java.sql.DriverManager;

public class BasicDemo {



    @Test
    public void testConnectivity(){
    //格式: jdbc:mysql://主机ip:端口号/数据库名字
    //jdbc 在JDK中(接口),自己没有实现,实现由数据库的实现包实现
    //java.sql就是JDBC的API


//        1.注册驱动
//            Class.forName("com.mysql.jdbc.Driver");
//                1.1 加载瑾JVM,并初始化,会执行静态代码块的语句
//                1.2 创建驱动对象,并且注册

//        java6可(JDBC4)可以不再加载注册驱动


        try{
//          1.加载注册驱动 域名.项目.类
            Class.forName("com.sql.jdbc.Driver");

//          2.使用DriverManager来连接数据库

            //jdbc:数据库名:******
            DriverManager.getConnection("jdbc:mysql://localhost:3306/my_test","root","root");


        }catch(Exception e){

            e.printStackTrace();

        }


    }


}
