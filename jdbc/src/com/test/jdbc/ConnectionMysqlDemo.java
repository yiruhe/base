package com.test.jdbc;


import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionMysqlDemo {


    @Test
    public void testConnection() {

//        1.加载注册驱动
//        2.利用DriverManager创建连接,并登陆数据库
//        3.利用statement对象创建连接,发送sql语句
        Connection connectivity = null;
        Statement statement = null;

        try {

            Class.forName("com.mysql.jdbc.Driver");

            //利用managerDriver连接数据库
            connectivity = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_test", "root", "root");

            //创建statement对象,将sql语句发送给数据
            statement = connectivity.createStatement();

            //创建sql语句

            String sql = "create table java_test(id int,name char(4));";

            //发送,并执行qsl语句
            statement.executeUpdate(sql);


        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            //关闭流

            try {

                if (statement != null) statement.close();

            } catch (SQLException e) {

                e.printStackTrace();

            } finally {

                try {

                    if (connectivity != null) connectivity.close();

                } catch (SQLException e) {

                    e.printStackTrace();
                }
            }


        }


    }


}
