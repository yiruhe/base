package com.notes.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

public class ConnectionUtils {
	
	
	static{
		//加载驱动
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
		
		}catch(ClassNotFoundException e){
			
			e.printStackTrace();
		}
		
	}
	
	/**
	 *connection  database 
	 * @return
	 */
	public static Connection getConnection(){
		
		try{
			return  DriverManager.getConnection("jdbc:mysql://localhost:3306/my_test","root","root");
			
		}catch(SQLException e){
			
			e.printStackTrace();
		}
		
		throw new RuntimeException("connection failed");
	}
	
	/**
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	
	public static boolean isContainUser(String username,String password){
		
		Connection connection = ConnectionUtils.getConnection();
		Statement statement = null;
		ResultSet set = null;
		
		try{
			
			statement = connection.createStatement();
			
			String sql = "SELECT username,password FROM my_user WHERE username='"+username+"' AND password='"+password+"'";
		
			set = statement.executeQuery(sql);
			
			
			return  set.next();
			
		}catch(Exception e){
			
			e.printStackTrace();
		}finally{
			
			//release source
			try{	if(set != null)set.close(); 				}catch(SQLException e){ e.printStackTrace(); };
			try{	if(statement != null)statement.close(); 	}catch(SQLException e){ e.printStackTrace(); };
			try{	if(connection != null)connection.close(); 	}catch(SQLException e){ e.printStackTrace(); };
			
		}
		
		return false;
	}

}
