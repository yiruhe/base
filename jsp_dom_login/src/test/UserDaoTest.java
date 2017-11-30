package test;


import org.junit.Test;

import dao.implement.UserImplement;
import domain.User;

public class UserDaoTest {

	
	@Test
	public void testName() throws Exception {
		
		UserImplement userDao = new UserImplement();
		
		User user = userDao.getUserByUserName("admin");
		
		System.out.println(user);
	}
}
