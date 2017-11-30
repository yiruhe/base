package com.test.jdbc;


import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ModifyDemo {


    @Test
    public void testInsert(){

        Connection connection =null;
        Statement statement =null;
        try{


//          注册加载驱动
            Class.forName("com.mysql.jdbc.Driver");
//            利用DriverManager创建连接
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_test","root","root");

            //创建可以发送sql并执行的statement对象,
             statement = connection.createStatement(); //token unexpected

            //
            String sql = "INSERT INTO java_test(id,name) VALUES(1,'jack');";

            //发送执行sql语句
            int num = statement.executeUpdate(sql);

            System.out.println(num);

        }catch(Exception e){

            e.printStackTrace();

        }finally{

            try{
                if(connection != null)connection.close();
                if(statement != null)statement.close();
            }catch(Exception expected){

                expected.printStackTrace();

            }

        }



    }

    @Test
    public void testUpdate(){

        try{


            //加载注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //连接database,利用DriverManager
            Connection connectivity = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_test","root","root");
            //创建statement对象,来发送并执行sql statement;

            Statement statement = connectivity.createStatement();

            //sql
            String sql = "UPDATE java_test SET name = 'katy' WHERE id=1";

            int info = statement.executeUpdate(sql);

            System.out.println(info);

        }catch(Exception e){

            e.printStackTrace();

        }




    }

    @Test
    public void testDelete(){


        Connection connectivity =null;
        Statement statement = null;
        try{


            //register and load driver
            Class.forName("com.mysql.jdbc.Driver");

            //create connectivity database
            connectivity = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_test","root","root");

            //create statement instance; via statement instance send and execute sql

            statement = connectivity.createStatement();

            String sql = "DELETE FROM java_test WHERE id=1";

            statement.executeUpdate(sql);


        }catch(Exception e){

            e.printStackTrace();

        }finally{

            try{

                if(statement != null)statement.close();
                if(connectivity != null)connectivity.close();

            }catch(Exception e){

                e.printStackTrace();

            }
        }

    }


}
