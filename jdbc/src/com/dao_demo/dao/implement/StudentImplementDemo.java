package com.dao_demo.dao.implement;

import com.dao_demo.dao.*;
import com.dao_demo.domain.*;
import java.util.List;

import java.sql.*;
import java.util.ArrayList;


public class StudentImplementDemo implements IStudentDAO{


    @Override
    public void save(StudentDemo student){


        Connection connectivity = null;
        Statement statement = null;

        try{

            //usage reflect register and load Driver
            Class.forName("com.mysql.jdbc.Driver");

            //usage DriverManager  create  connection  database;
            connectivity = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_test","root","root");

            //create statement  sent sql and execute;
             statement = connectivity.createStatement();

             String sql = "INSERT INTO java_test(id,name,department,score) values("+student.getId()+",'"+student.getName()+"',"+student.getDepartment()+","+student.getScore()+")";

             System.out.println(sql);

             int num = statement.executeUpdate(sql);

             System.out.println(num);

        }catch(Exception e){

            e.printStackTrace();

        }finally{

            try{


                if(connectivity != null)connectivity.close();

            }catch(SQLException e){


                e.printStackTrace();

            }finally{

                try{

                    if(statement != null) statement.close();

                }catch(SQLException e){

                    e.printStackTrace();

                }

            }



        }

    }


    @Override
    public void delete(Integer id){

        Connection conectivity = null;

        Statement statement = null;
        try{

            //usage reflect register and load Driver
            Class.forName("com.mysql.jdbc.Driver");

            //regardless or whether, usage create connection

            conectivity  = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_test","root","root");

            statement = conectivity.createStatement();

            String sql = "DELETE FROM java_test WHERE id ="+id+"";

            statement.executeUpdate(sql);

        }catch(Exception e){

            e.printStackTrace();

        }finally{



        }



    }


    @Override
    public void update(StudentDemo student){

        Connection connectivity = null;
        Statement statement = null;

        try{


            Class.forName("com.mysql.jdbc.Driver");

            connectivity = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_test","root","root");

            statement = connectivity.createStatement();

            String sql = "UPDATE java_test SET name='"+student.getName()+"',department='"+student.getDepartment()+"',score="+student.getScore()+" WHERE id="+student.getId()+"";

            System.out.println(sql);

            statement.executeUpdate(sql);

        }catch(Exception e){
            e.printStackTrace();
        }finally{

            try{

                if(connectivity != null)connectivity.close();
                if(statement != null)statement.close();

            }catch(Exception e){

                e.printStackTrace();
            }

        }



    }

    @Override
    public StudentDemo getStudentInformation(Integer id){

        Connection connection = null;
        Statement statement = null;
        StudentDemo student = null;
        ResultSet resultSet =null;

        try{


            Class.forName("com.mysql.jdbc.Driver");

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_test","root","root");

            statement = connection.createStatement();

            String sql = "SELECT * FROM java_test WHERE id = "+id+"";


            //获取结果集
            resultSet = statement.executeQuery(sql);

            //判断是否有下一个
            if(resultSet.next()){

                //把结果注入student类,并返回
                student =  new StudentDemo(resultSet.getInt("id"),resultSet.getString("name"),resultSet.getString("department"),resultSet.getInt("score"));

            }


        }catch(Exception e){

            e.printStackTrace();

        }finally{

            try{

                if(resultSet != null)resultSet.close();
                if(statement != null)statement.close();
                if(connection != null)connection.close();
            }catch(Exception e){

                e.printStackTrace();

            }

        }


        return student;

    }


    @Override
    public List<StudentDemo> getStudentInformationArray(){

        //创建一个list集合存放结果集
        List<StudentDemo> list = new ArrayList<StudentDemo>();
        Connection connectivity = null;
        Statement statement = null;
        ResultSet resultSet =null;

        try{


            //regardless and whether ... usage register and load Driver;
            Class.forName("com.mysql.jdbc.Driver");

            //usage Driver Manager create connection;
            connectivity = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_test","root","root");

            //创建statement对象,发送sql并执行(create Statement Instance  sent sql and execute)
            statement = connectivity.createStatement();

            String sql = "SELECT * FROM java_test";

            //获取游标
            resultSet = statement.executeQuery(sql);

            while(resultSet.next()){

                list.add(new StudentDemo(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("department"),
                        resultSet.getInt("score")
                ));

            }



        }catch(Exception e){

            e.printStackTrace();

        }finally{


            try{
                if(resultSet != null)resultSet.close();

                if(statement != null)statement.close();

                if(connectivity != null)connectivity.close();
            }catch(Exception e){

                e.printStackTrace();

            }


        }

        return list;
    }
}
