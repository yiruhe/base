package test;

import java.util.List;

import org.junit.Test;

import dao.implement.StudentDaoImplement;
import domain.Student;

public class StudentDaoTest{
	
	private static StudentDaoImplement studentDao = new StudentDaoImplement();
	
	

	@Test
	public void testSave(){
		
		Student student = new Student();
		student.setName("某茶");
		student.setEngineerId(4);
		student.setDepartment("体育");
		student.setScore(60);
		studentDao.save(student);
		
		
	}
	
	@Test
	public void testDelete(){
		
		studentDao.delete(14);
		
	}
	
	
	@Test
	public void testUpdate(){
		
		Student student = new Student();
		student.setName("逆光");
		student.setEngineerId(4);
		student.setDepartment("体育");
		student.setScore(60);
		student.setId(13);
		
		studentDao.update(student);
	}
	
	@Test
	public void testQuery(){
		
		List<?> list = studentDao.query();
	
		System.out.println(list);
		
	}
	
	
	@Test
	public void testGet(){
		
		Student student = studentDao.get(13);
		
		System.out.println(student);
	}
	
}