package dao.implement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import page.PageList;
import query.GenericQuery;
import template.IResultSetHandle;
import template.JDBCTemplate;
import template.StudentResultSetHandleImplement;
import dao.IStudentDao;
import domain.Student;


public class StudentDaoImplement implements IStudentDao{

	@Override
	public List<Student> query(GenericQuery obj) {

		String sql = "SELECT * FROM mystudent"+obj.getSQLConditions();
		
		System.out.println(sql);
		
		return JDBCTemplate.query(sql.toString(),
				new StudentResultSetHandleImplement(),
				obj.getParameter().toArray());
	}
	
	
	
	public PageList queryPage(Integer currentPage,Integer pageSize){
		
		String sql = "SELECT * FROM mystudent LIMIT ?,?";
		
		
		List dataList = JDBCTemplate.query(sql,
				new StudentResultSetHandleImplement(),
				(currentPage - 1) * pageSize,
				pageSize);
		
		String coutSQL = "SELECT COUNT(*) FROM mystudent";
		
		Integer total =  JDBCTemplate.query(coutSQL,new IResultSetHandle<Integer>(){

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
			
			
		});
		
		return new PageList(dataList,total,currentPage,pageSize);
	}
	
	
	@Override
	public PageList advancedQuery(GenericQuery obj){
		
		String dataSQL = "SELECT * FROM mystudent"+obj.getSQLConditions()+" LIMIT ?,?";
		
		System.out.println(obj.getParameter());
		//重新设置查询参数
		
		List<Object> list = new ArrayList<>(obj.getParameter());
		
		list.add(obj.getCurrentPage());
		list.add(obj.getPageSize());
		
		
		List<Student> dataList = JDBCTemplate.query(dataSQL, new StudentResultSetHandleImplement(),list.toArray());
		
		String countSQL = "SELECT COUNT(*) FROM mystudent"+obj.getSQLConditions();
		
		Integer total = JDBCTemplate.query(countSQL,new IResultSetHandle<Integer>(){

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
		
		
		
		
	
		return new PageList(dataList,total,obj.getCurrentPage(),obj.getPageSize());
		
	}
	
}