package dao;

import java.util.List;

import domain.Engineer;

public interface IEngineerDirDao {

	
	public abstract void save(Engineer obj);
	
	
	public abstract void delete(int id);
	
	
	public abstract void update(Engineer obj);
	
	
	public abstract List<Engineer> query();
	
	
	public abstract Engineer get(int id);
	
	public abstract Engineer getEnginnerId(int id);
	

}