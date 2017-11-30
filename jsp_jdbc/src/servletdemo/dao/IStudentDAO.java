package servletdemo.dao;

import java.util.List;

public interface IStudentDAO<T> {
	
	public abstract void save(String name,String department,String score);
	
	public abstract void delete(Object id);
	
	public abstract List<T> query();
	
	public void update(String id,String name,String department,String score);
	

}
