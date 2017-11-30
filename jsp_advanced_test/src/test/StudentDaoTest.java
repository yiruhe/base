package test;

import java.util.List;

import org.junit.Test;

import page.PageList;
import query.StudentQuery;
import dao.implement.StudentDaoImplement;
import domain.Student;

public class StudentDaoTest{
	
	private static StudentDaoImplement studentDao = new StudentDaoImplement();
	
	

	@Test
	public void testSave(){
		
		Student student = new Student();
		student.setName("某茶");
		student.setDepartment("体育");
		student.setScore(60);
		//studentDao.save(student);
		
		
	}
	
	@Test
	public void testDelete(){
		
	//	studentDao.delete(14);
		
	}
	
	
	@Test
	public void testUpdate(){
		
		Student student = new Student();
		student.setName("逆光");
		student.setDepartment("体育");
		student.setScore(60);
		student.setId(13);
		
		//studentDao.update(student);
	}
	
	@Test
	public void testQuery(){
		
		StudentQuery param = new StudentQuery();
		
		param.setMinScore(60);
		
		List<?> list = studentDao.query(param);
	
		System.out.println(list);
		
	}
	
	
	@Test
	public void testGet(){
		
//		studentDao.queryPage(1,10);
		
		//Student student = studentDao.get(13);
		
		//System.out.println(student);
		
		
		StudentQuery obj = new StudentQuery();
		
		//obj.setMinScore(70);
		
		studentDao.advancedQuery(obj);
		
		
	}
	
}