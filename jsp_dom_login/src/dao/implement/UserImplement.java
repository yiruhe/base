package dao.implement;

import java.sql.ResultSet;
import java.sql.SQLException;

import templet.IResultHandler;
import templet.JdbcTemplate;
import dao.IUserDao;
import domain.User;

public class UserImplement implements IUserDao{

	@Override
	public User getUserByUserName(String userName) {
		
		System.out.println(userName);
		
		String sql = "SELECT * FROM user WHERE username = ?";
		
		return JdbcTemplate.query(sql, new IResultHandler<User>(){
			
			@Override
			public User handle(ResultSet set){
				
				
				try {
					if(set.next()){
					
						User user = new User();
						String name = set.getString("username");
						String password = set.getString("password");
						Integer id = set.getInt("Id");
						
						user.setUserName(name);
						user.setPassword(password);
						user.setId(id);
						return user;
					}
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
				

				return null;
			}
		}, userName);
	}

	
	
}
