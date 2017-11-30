package refactor_jdbc_2.dao_demo.dao.implement;

import refactor_jdbc_2.dao_demo.dao.IStudentDAO;
import refactor_jdbc_2.dao_demo.domain.StudentDemo;
import refactor_jdbc_2.template.BeanHandler;
import refactor_jdbc_2.template.IResultSetHandlerStandard;
import refactor_jdbc_2.template.TemplateJDBC;
import refactor_jdbc_2.util.StudentUtilDemo;
import refactor_jdbc_2.template.BeanHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class StudentImplementDemo implements IStudentDAO {

    //这里的连接数据库都是一样的,最终的结果都是要一个Connection instance;

    @Override
    public void save(StudentDemo student){

        String sql = "INSERT INTO java_test(id,name,department,score) values(?,?,?,?)";

        TemplateJDBC.updateTable(sql,student.getId(),student.getName(),student.getDepartment(),student.getScore());


    }


    @Override
    public void delete(Integer id){

        String sql = "DELETE FROM java_test WHERE id =?";

        TemplateJDBC.updateTable(sql,id);
    }


    @Override
    public void update(StudentDemo student){

        String sql = "UPDATE java_test SET name=?,department=?,score=? WHERE id = ?";

        TemplateJDBC.updateTable(sql,student.getName(),student.getDepartment(),student.getScore(),student.getId());
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

        String sql = "SELECT * FROM mystudent";


        BeanHandler<StudentDemo>  handler = new BeanHandler<>(StudentDemo.class);


        IResultSetHandlerStandard<List<StudentDemo>>  rest = new BeanHandler<>(StudentDemo.class);


        return TemplateJDBC.queryTable(sql,handler);



    }



}