package refactor_com_demo.dao_demo.dao.implement;

import refactor_com_demo.dao_demo.dao.IStudentDAO;
import refactor_com_demo.dao_demo.domain.StudentDemo;
import refactor_com_demo.util.StudentUtilDemo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;



public class StudentImplementDemo implements IStudentDAO {

    //这里的连接数据库都是一样的,最终的结果都是要一个Connection instance;

    @Override
    public void save(StudentDemo student){

        Connection connectivity = null;
        PreparedStatement prepared= null;

        try{

            connectivity = StudentUtilDemo.getConnection();

            String sql = "INSERT INTO java_test(id,name,department,score) values(?,?,?,?)";

             //precompile
             prepared = connectivity.prepareStatement(sql);

            prepared.setInt(1,student.getId());
            prepared.setString(2,student.getName());
            prepared.setString(3,student.getDepartment());
            prepared.setInt(4,student.getScore());

            //execute  statement ps:说了多少次这里不能带参数...
             int num = prepared.executeUpdate();

             System.out.println(num);

        }catch(Exception e){

            e.printStackTrace();

        }finally{

            //deal exception
            StudentUtilDemo.dealException(connectivity,prepared,null);

        }

    }


    @Override
    public void delete(Integer id){

        Connection connectivity = null;

        PreparedStatement statement = null;
        try{

            //regardless or whether, usage create connection

            connectivity  = StudentUtilDemo.getConnection();


            String sql = "DELETE FROM java_test WHERE id =?";

            statement = connectivity.prepareStatement(sql);

            statement.setInt(1,id);

            statement.executeUpdate();

        }catch(Exception e){

            e.printStackTrace();

        }finally{

            //deal exception
            StudentUtilDemo.dealException(connectivity,statement,null);

        }

    }


    @Override
    public void update(StudentDemo student){

        Connection connectivity = null;
        PreparedStatement statement = null;

        try{

            connectivity = StudentUtilDemo.getConnection();

            //获取Statement,发送sql,执行sql

            String sql = "UPDATE java_test SET name=?,department=?,score=? WHERE id = ?";

            //预编译
            statement = connectivity.prepareStatement(sql);

            //
            statement.setString(1,student.getName());
            statement.setString(2,student.getDepartment());
            statement.setInt(3,student.getScore());
            statement.setInt(4,student.getId());

            //execute
            statement.executeUpdate();

        }catch(Exception e){
            e.printStackTrace();
        }finally{

            StudentUtilDemo.dealException(connectivity,statement,null);

        }

    }

    @Override
    public StudentDemo getStudentInformation(Integer id){

        Connection connectivity = null;
        PreparedStatement statement = null;
        ResultSet resultSet =null;
        StudentDemo student =  new StudentDemo();

        try{

            connectivity = StudentUtilDemo.getConnection();

            String sql = "SELECT * FROM java_test WHERE id = ?";

            //预编译
            statement = connectivity.prepareStatement(sql);

            //设置参数
            statement.setInt(1,id);

            //获取结果集
            resultSet = statement.executeQuery();

            //判断是否有下一个
            if(resultSet.next()){

                //把结果注入student类,并返回
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setDepartment(resultSet.getString("department"));
                student.setScore(resultSet.getInt("score"));

            }

        }catch(Exception e){

            e.printStackTrace();

        }finally{

            StudentUtilDemo.dealException(connectivity,statement,resultSet);

        }

        return student;

    }


    @Override
    public List<StudentDemo> getStudentInformationArray(){

        //创建一个list集合存放结果集
        List<StudentDemo> list = new ArrayList<StudentDemo>();
        Connection connectivity = null;
        PreparedStatement statement = null;
        ResultSet resultSet =null;

        try{

            //usage Driver Manager create connection;
            connectivity = StudentUtilDemo.getConnection();

            //创建statement对象,发送sql并执行(create Statement Instance  sent sql and execute)
            String sql = "SELECT * FROM java_test";

            statement = connectivity.prepareStatement(sql);

            //获取游标
            resultSet = statement.executeQuery();

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

            StudentUtilDemo.dealException(connectivity,statement,resultSet);

        }

        return list;
    }
}
