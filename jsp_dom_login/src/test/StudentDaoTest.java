package test;

import org.junit.Test;

import dao.IStudentDao;
import dao.implement.StudentDaoImplement;


public class StudentDaoTest{
	
	private static IStudentDao dao = new StudentDaoImplement();
	
	@Test
	public void testSave(){
		
	
		
	}
	
	
	@Test
	public void testDalete(){
		
		dao.delete(35);
		
	}
	
	@Test
	public void testGet(){
		
		System.out.println(dao.get(14));
		
	}
	
	@Test
	public void testQuery(){
		
		System.out.print(dao.query());
		
	}
	
	@Test
	public void testUpdate(){
		
	
	}
	
	
}