package test;

import org.junit.Test;



import dao.IEngineerDirDao;
import dao.implement.EngineerDaoImplement;
import domain.Engineer;

public class EngineerDaoTest {

	private IEngineerDirDao engineerDao = new EngineerDaoImplement();
	
	@Test
	public void testSave(){
		
		Engineer engineer = new Engineer();
		
		engineer.setEngineerId(6);
		engineer.setEngineerName("文学");
		
		engineerDao.save(engineer);
		
	}
	
	
}
