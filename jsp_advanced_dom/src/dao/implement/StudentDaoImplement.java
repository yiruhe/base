package dao.implement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import query.QueryParameter;
import templet.HandlerImpelement;
import templet.JdbcTemplate;
import dao.IStudentDao;
import domain.Student;

public class StudentDaoImplement implements IStudentDao{

	private HandlerImpelement handle = new HandlerImpelement();
	
	@Override
	public Student get(int id) {
		
		//sql
		String sql = "SELECT * FROM mystudent WHERE id = ?";
			
		return JdbcTemplate.query(sql,handle,id).get(0);
	}

	@Override
	public List<Student> query() {
		
		String sql = "SELECT * FROM mystudent";
		
		return JdbcTemplate.query(sql,handle);
		
	}

	@Override
	public List<Student> list(String name, Integer minScore, Integer maxScore) {
		
		StringBuilder sql = new StringBuilder("SELECT * FROM mystudent");
		
		//问题:查询参数太多,参数列表太长
		//解决:封装成对象
		boolean flag = true;
		
		List<Object> list = new ArrayList<>();
		
		if(name != null && !"".equals(name)){
			
			if(flag){
				sql.append(" WHERE ");
				
				flag = false;
				
			}else{
				
				sql.append(" AND ");
				
			}
			
			sql.append(" name = ?");
			
			list.add(name);
		}
		
		if(minScore != null){
			
			if(flag){
				sql.append(" WHERE ");
				
				flag = false;
				
			}else{
				
				sql.append(" AND ");
				
			}
			
			sql.append("score >=?");
			
			list.add(minScore);
		}
		
		if(maxScore != null){
			
			if(flag){
				sql.append(" WHERE ");
				
				flag = false;
				
			}else{
				
				sql.append(" AND ");
				
			}
			
			sql.append("score <= ?");
			
			list.add(maxScore);
		}
		
		System.out.println(sql);
		
		return JdbcTemplate.query(sql.toString(),handle,list.toArray());
	}
	
	
	public List<Student> list1(QueryParameter obj) {

		String sql = "SELECT * FROM mystudent"+obj.queryString();
		
		//System.out.println(Arrays.toString(obj.getParameter().toArray())) ;
		System.out.println(sql);
		
		return JdbcTemplate.query(sql,handle,obj.getParameter().toArray());
	}
	
} 