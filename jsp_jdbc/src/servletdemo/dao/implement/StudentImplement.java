package servletdemo.dao.implement;


import java.util.List;
import servletdemo.dao.IStudentDAO;
import servletdemo.domain.Student;
import servletdemo.templete.JDBCTemplete;
import servletdemo.templete.handler.ResultSetHandlerImplement;

public class StudentImplement implements IStudentDAO<Student>{

	@Override
	public void save(String name,String department,String score) {
	
		String sql = "INSERT INTO mystudent(name,department,score) values(?,?,?)";
		
		JDBCTemplete.updateTable(sql,name,department,score);
		
	}
	
	@Override
	public void delete(Object id) {
		
		String sql = "DELETE FROM mystudent where id=?";
		
		JDBCTemplete.updateTable(sql,id);
		
	}

	@Override
	public List<Student> query() {
		
		String sql = "SELECT * FROM mystudent";
	
	
	return JDBCTemplete.query(sql,new ResultSetHandlerImplement<>(Student.class));
	
	}

	public void update(String id,String name,String department,String score){
		
		String sql = "UPDATE mystudent SET name=?,department=?,score=? WHERE id=?";
		
		JDBCTemplete.updateTable(sql,name,department,score,id);
	}
}
