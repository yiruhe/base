package test;

import org.junit.Test;

import dao.IPartNameDao;
import dao.implement.DepartNameImplement;

public class PartNameDaoTest {

	private static IPartNameDao PartNameDao = new DepartNameImplement();
	
	@Test
	public void testSave(){
		
		
		
		
		
		
	}
	
	
	@Test
	public void testDelete(){
		
		
		
	}
	
	@Test
	public void testGet(){
		
		
		System.out.println(PartNameDao.get(4));
		
	}
	
	@Test
	public void testList(){
		
		
		System.out.println(PartNameDao.query());
		
	}
	
	@Test
	public void testUpdate(){
		
		//System.out.println(PartNameDao.update(new DepartmentName(1,"建筑系",5)));
		
	}
	
}
