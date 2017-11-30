package connection_pool;

import org.junit.Test;

import java.sql.*;
import connection_pool.StudentUtilDemo;

public class BasicDemo {


    @Test
    public void test(){



        //connection pool 直接可数据库交互
        //所以connection pool具有具有连接数据库的功能
        //驱动类名/账户/密码/url


//        连接池概述:
//            好处:重复利用了per a connection,节约性能开销
//        Java，连接池使用javax.sql.DataSource接口来表示连接池/数据源.
//        注意:DataSource和JDBC仅仅是一个接口,由各大服务商来实现

//        DataSource(数据源)和连接池(connection Pool)是同一个

        //区别
//        没有连接池:通过DriverManager来获取,直接和DBMS连接
//        存在连接池:直接通过连接池获取连接对象

//        释放连接对象:
//        没有连接池:和数据库服务器断开连接
//        存在连接池:把connection对象归还给连接池,并没有和DBMS断开


        //设置db.properties的属性是根据javaBean的,所以setUrl 属性就是 Url;


        //Druid  //类似于DBCP


    }


    @Test
    public void testConnection(){

        Connection connection = null;
        PreparedStatement prepared = null;
        ResultSet set = null;

        try{


            connection = StudentUtilDemo.getConnection();


            String sql = "SELECT * from java_atm";

            //precompile  sql
             prepared = connection.prepareStatement(sql);


            //exec sql   ps:这里不能带参数,因为statement 是他的父类
             set = prepared.executeQuery();

            while(set.next()){

                int id = set.getInt("id");

                String name = set.getString("name");

                int balance = set.getInt("balance");

                System.out.println(id+"===="+name+"===="+balance);
            }

        }catch(Exception e){


            e.printStackTrace();

        }finally{

            try{ if(set != null)set.close();               }catch(SQLException e){  e.printStackTrace();      }
            try{ if(prepared != null)prepared.close();     }catch(SQLException e){  e.printStackTrace();      }
            try{ if(connection != null)connection.close(); }catch(SQLException e){  e.printStackTrace();      }

        }

    }


}


