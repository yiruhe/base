package dao.implement;

import java.util.List;

import templet.HandlerImpelement;
import templet.JdbcTemplate;
import dao.IStudentDao;
import domain.Student;

public class StudentDaoImplement implements IStudentDao{

	@Override
	public int save(Student obj) {
	
		String sql = "INSERT mystudent(name,department,score,part_id) values(?,?,?,?)";
		
		return JdbcTemplate.update(sql,obj.getName(),obj.getDepartment(),obj.getScore(),obj.getDepartmentDirectory().getDepartIndex());
	}

	@Override
	public int update(Student obj) {
		
		String sql = "UPDATE mystudent SET name=?,department=?,score=?,part_id=? WHERE id=?";
		
		return JdbcTemplate.update(sql,obj.getName(),obj.getDepartment(),obj.getScore(),obj.getDepartmentDirectory().getDepartIndex(),obj.getId());
	}
	
	@Override
	public int delete(Integer id) {
		
		String sql = "DELETE FROM mystudent WHERE id= ?";
		
		return JdbcTemplate.update(sql,id);
		
	}

	@Override
	public Student get(int id) {
		
		//sql
		String sql = "SELECT * FROM mystudent WHERE id = ?";
			
		return JdbcTemplate.query(sql,new HandlerImpelement(),id).get(0);
	}

	@Override
	public List<Student> query() {
		
		String sql = "SELECT * FROM mystudent";
		
		return JdbcTemplate.query(sql,new HandlerImpelement());
		
	}
	
	
	
} 