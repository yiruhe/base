package dao.implement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import page.PageList;
import query.GenericQuery;
import query.QueryParameter;
import templet.HandlerImpelement;
import templet.IResultHandler;
import templet.JdbcTemplate;
import dao.IStudentDao;
import domain.Student;

public class StudentDaoImplement implements IStudentDao{

	private HandlerImpelement handle = new HandlerImpelement();


	
	public List<Student> list1(QueryParameter obj) {

		String sql = "SELECT * FROM mystudent"+obj.queryString();
		
		System.out.println(sql);
		
		return JdbcTemplate.query(sql,handle,obj.getParameter().toArray());
	}
	
	
	public PageList PageQuery(GenericQuery obj) {

		String dataSQL = "SELECT * FROM mystudent "+obj.queryString()+" LIMIT ?,?";
		
		System.out.println(dataSQL);
		
		List<Object> parameterList = new ArrayList<>(obj.getParameter());
		
		parameterList.add(obj.getCurrentPage());
		parameterList.add(obj.getPageSize());
		
		List list = JdbcTemplate.query(dataSQL,
				handle,
				parameterList.toArray()
				);
	
		String countSQL = "SELECT COUNT(*) FROM mystudent "+obj.queryString();
		
		Integer totalData = JdbcTemplate.query(countSQL,new IResultHandler<Integer>(){

			@Override
			public Integer handle(ResultSet set) {
				
				try {
					
					if(set.next()){
						
						return set.getInt(1);
						
					}
					
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
				
				return -1;
			}
			
			
		},obj.getParameter().toArray());
		
		return new PageList(list,totalData,obj.getCurrentPage(),obj.getPageSize());
	}
	
	
} 