package dao.implement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import template.JDBCTemplate;
import template.StudentResultSetHandleImplement;
import utils.JDBCUtils;
import dao.IStudentDao;
import domain.Student;


public class StudentDaoImplement implements IStudentDao{

	@Override
	public void save(Student obj) {
		
		String sql = "INSERT mystudent(name,department,score,part_id) values(?,?,?,?)";
		
		JDBCTemplate.update(sql,obj.getName(),obj.getDepartment(),obj.getScore(),obj.getEngineerId());
		
	}

	@Override
	public void delete(int id) {
		
			String sql = "DELETE FROM mystudent WHERE id = ?";
			
			JDBCTemplate.update(sql,id);
	}

	@Override
	public void update(Student obj) {
		
		
			String sql = "UPDATE mystudent SET name=?,department=?,score=?,part_id=? WHERE id=?";
			
			JDBCTemplate.update(sql,
					obj.getName(),
					obj.getDepartment(),
					obj.getScore(),
					obj.getEngineerId(),
					obj.getId());
		
	}

	@Override
	public List<Student> query() {

		String sql = "SELECT * FROM mystudent";
	
		return JDBCTemplate.query(sql,new StudentResultSetHandleImplement());
	}

	@Override
	public Student get(int id) {
		String sql = "SELECT * FROM mystudent WHERE id = ?";
		
		return JDBCTemplate.query(sql,new StudentResultSetHandleImplement(),id).get(0);
	}
}