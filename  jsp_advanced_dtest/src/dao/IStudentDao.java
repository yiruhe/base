package dao;

import java.util.List;

import domain.Student;

public interface IStudentDao{
	
	
	public abstract void save(Student obj);
	
	
	public abstract void delete(int id);
	
	
	public abstract void update(Student obj);
	
	
	public abstract List<Student> query();
	
	
	public abstract Student get(int id);
	
} 