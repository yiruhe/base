package dao;

import java.util.List;

import domain.Engineer;

public interface IEngineerDirDao {


	public abstract List<Engineer> query();
	
	
	public abstract Engineer get(int id);
	
	public abstract Engineer getEnginnerId(int id);
	

}