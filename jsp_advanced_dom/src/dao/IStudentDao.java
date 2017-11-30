package dao;

import java.util.List;

import query.QueryParameter;
import domain.Student;

public interface IStudentDao {
	
	
	/**
	 * 
	 * 
	 * 
	 */
	public abstract Student get(int id);
	
	/**
	 * 
	 * 
	 * 
	 */
	public abstract List<Student> query();
	
	
	public abstract List<Student> list(String name,Integer minScore,Integer maxScore);
	
	
	public abstract  List<Student> list1(QueryParameter obj);
}
