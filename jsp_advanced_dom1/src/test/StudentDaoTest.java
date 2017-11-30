package test;


import org.junit.Test;

import query.QueryParameter;
import dao.IStudentDao;
import dao.implement.StudentDaoImplement;
import domain.Student;


public class StudentDaoTest{
	
	private static IStudentDao dao = new StudentDaoImplement();
	
	@Test
	public void testSave(){
		
	
		
	}
	
	
	@Test
	public void testDalete(){
		
		//dao.delete(35);
		
	}
	
	@Test
	public void testGet(){
		
		//System.out.println(dao.get(14));
		
		QueryParameter obj = new QueryParameter();
		
		obj.setCurrentPage(2);
		obj.setPageSize(10);
		
		//new StudentDaoImplement().PageQuery(obj);
	}
	
	@Test
	public void testQuery(){
		
		//List<Student> list = dao.list(null,60,80);
		
		QueryParameter param = new QueryParameter();
	
		param.setName("一");
	
		param.setMaxScore(80);
		
		param.setMinScore(0);
		

		for(Student key:dao.list1(param)){
			
			System.out.println(key);
		}
			
		
		
	}
	
	@Test
	public void testUpdate(){
		
	
	}
	
	
}