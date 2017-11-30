package refactor_jdbc_review.test.connection_test;


import org.junit.Test;

import java.sql.*;

public class JDBCView {


    @Test
    public void testStaticSQL(){


        Connection connection = null;

        Statement statement = null;

        try{

            //利用类加载器加载注册驱动
            Class.forName("com.mysql.jdbc.Driver");

            //利用DriverManager连接数据库
            connection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/my_test","root","root");


            statement = connection.createStatement();

            String sql = "INSERT INTO java_test(name,department,score) values('jack','chinese',60)";

            //执行语句
            statement.executeUpdate(sql);

        }catch(Exception e){

            e.printStackTrace();

        }finally{

            //release source
            try{   if(statement != null)connection.close();    }catch(SQLException e){e.printStackTrace();}
            try{   if(connection != null)connection.close();    }catch(SQLException e){e.printStackTrace();}



        }
    }


    @Test
    public void testDynamicSQL(){

        Connection connection = null;

        PreparedStatement prepared = null;


        try{

            //加载注册驱动
            Class.forName("com.mysql.jdbc.Driver");

            //利用驱动管理员连接数据库
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_test","root","root");

            String sql = "INSERT INTO java_test(name,department,score) values(?,?,?)";

            //precompile
            prepared = connection.prepareStatement(sql);

            prepared.setString(1,"jame");
            prepared.setString(2,"math");
            prepared.setInt(3,80);

            //这里是不需要传递参数的,如果传递那么就是使用的父级的方法
            prepared.executeUpdate();


        }catch(Exception e){

            e.printStackTrace();

        }finally{

            try{

                if(prepared != null)prepared.close();
                if(connection != null)connection.close();

            }catch(SQLException e){

                e.printStackTrace();


            }
        }



    }

    @Test
    public void testQuery(){

        Connection connection = null;
        PreparedStatement statement =null;
        ResultSet set = null;

        try{

            //加载注册驱动
            Class.forName("com.mysql.jdbc.Driver");

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_test","root","root");

            String sql = "SELECT * FROM java_test";

            //precompile
            statement = connection.prepareStatement(sql);

            //execute
            set = statement.executeQuery();

            while(set.next()){

                String name = set.getString("name");

                System.out.println(name);

            }

        }catch(Exception e){

            e.printStackTrace();

        }finally{

            try{

                if(set != null)set.close();
                if(statement != null)statement.close();
                if(connection != null)connection.close();


            }catch(SQLException e){

                e.printStackTrace();

            }

        }
    }
}
