package dao;

import java.util.List;

import domain.Student;

public interface IStudentDao {
	
	/**
	 * 
	 */
	public abstract int save(Student obj);
	
	/**
	 * 
	 * 
	 * 
	 */
	public abstract int delete(Integer id);
	
	
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
	
	/**
	 * 
	 */
	public abstract int update(Student obj);

}
