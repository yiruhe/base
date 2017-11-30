package refactor_jdbc_review.dao.implement;


import refactor_jdbc_review.dao.IStudentDAO;
import refactor_jdbc_review.domian.Student;
import refactor_jdbc_review.template.handler.ResultSetHandler;
import refactor_jdbc_review.template.jdbcTemplate;

import java.sql.*;
import java.util.List;

public class StudentDAOImplement implements IStudentDAO {


    @Override
    public void save(Student student) {

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            //load and register Driver
            Class.forName("com.mysql.jdbc.Driver");

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_test", "root", "root");

            String sql = "INSERT INTO java_test(name,department,score) values(?,?,?)";

            //precompile
            statement = connection.prepareStatement(sql);

            //setting student data
            statement.setString(1, student.getName());
            statement.setString(2, student.getDepartment());
            statement.setInt(3, student.getScore());

            //execute
            statement.executeUpdate();

        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            try {
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (statement != null) statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }


        }
    }

    @Override
    public void update(Student student) {

        String sql = "UPDATE INTO java_test(name,department,score) values(?,?,?)";

        jdbcTemplate.updateTable(sql, student.getName(), student.getDepartment(), student.getScore());

    }


    @Override
    public void delete(int id) {


    }

    @Override
    public Student queryStudent(int id) {


        return null;
    }

    @Override
    public List<Student> queryStudentList() {

        String sql = "SELECT * FROM java_test";


        return jdbcTemplate.queryTable(sql,new ResultSetHandler<>(Student.class));

    }
}
