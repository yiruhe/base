package prepared_statement;


import org.junit.Test;
import refactor_com_demo.util.StudentUtilDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class BasicDemo {




    @Test
    public void test(){
        //Statement  是执行静态sql的


        //preparedStatement  precompiled SQL  statement(预编译sql语句)
        //? 占位符(index begin 1)
        //execute not have parameter of preparedStatement
        //优点:
        // 1.可读性,可维护性
//         2.最大可能提高性能(mysql不支持)
//         3.保证安全性


//        把SQL sent database server 会发生下面的内容
//                1:安全性分析
//                2.语法分析
//                3.语法编译
//                4.选择并执行一个计划
//                5.返回result

//        某一些数据库服务器:存在预编译池
//                预先判断当前发送到DBMS的sql是否存在于预编译中
//                  有就直接执行4

//                不存在,就执行1-2-3-4-5再把改SQL存储在预编译池中

        //

    	//新版要加上 
    	//SSL"jdbc:mysql://127.0.0.1:3306/world?useUnicode=true&characterEncoding=utf-8&useSSL=false


        //编写通用结果集必须要制定规范:
//            表的field要和instance 的field相同

    }


    @Test
    public void testConnection(){

        Connection connectivity = null;
        PreparedStatement prepared = null;

        try{

            //usage reflect load  Driver
            //Class.forName("com.mysql.jdbc.Driver");

            connectivity= StudentUtilDemo.getConnection();

            //获取连接
           // connectivity = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_test","root","root");


            String sql = "UPDATE java_test SET name = ? WHERE id = ?";

            //把sql放进method中进行预编译
            prepared = connectivity.prepareStatement(sql);

            //index = 1;
            prepared.setString(1,"kath");
            prepared.setInt(2,1);

            //执行sql语句,ps:这里不能不带参数,带有参数就会调用父类的方法
            prepared.executeUpdate();


        }catch(Exception e){

            e.printStackTrace();

        }finally{

            try{

                if(prepared != null)prepared.close();

                if(connectivity != null)connectivity.close();

            }catch(Exception e){

                e.printStackTrace();

            }

        }

    }




}
