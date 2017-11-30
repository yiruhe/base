package test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import domain.Student;
import template.IResultSetHandle;
import template.JDBCTemplate;
import template.StudentResultSetHandleImplement;

public class PageTest {

	
	
	@Test
	public void testPage(){
		
		//每页的数据数量
		Integer pageSize = Integer.valueOf(3);
		//当前页
		Integer currentPage = Integer.valueOf(3);
		
		String sql = "SELECT * FROM mystudent LIMIT ?,?";
		
		List<Student> list = JDBCTemplate.query(sql,
				new StudentResultSetHandleImplement(),
				currentPage -1,
				pageSize				
				);
		
		for(Student student:list){
			
			System.out.println(student);
			
		}
		
		
		//查询总数
		String countSQL = "SELECT COUNT(*) FROM mystudent";
		
		Integer total = JDBCTemplate.query(countSQL,new IResultSetHandle<Integer>(){

			@Override
			public Integer handle(ResultSet set) {
				
				try {
					if(set.next()){
						
						
						Integer total = set.getInt(1);
						
						return total;
					}
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
				
				return -1;
			}
			
		});
		
		
		System.out.println(total);
		
	}
	
	
}
