package template;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import page.PageList;
import domain.Student;
import utils.JDBCUtils;

public class JDBCTemplate{
	
	
	public static void update(String sql,Object...obj){
		
		Connection connection = null;
		PreparedStatement statement = null;
		
		try{
			
			//获取连接对象
			connection = JDBCUtils.getConnection();
			
			statement = connection.prepareStatement(sql);
			
			//给sql设置参数
			
			for(int i=0;i<obj.length;i++){
				
				statement.setObject(i+1,obj[i]);
			}
			
			//执行sql
			statement.executeUpdate();
			
		}catch(Exception e){
			
			e.printStackTrace();
		
		}finally{
			
		
			JDBCUtils.release(connection,statement,null);
		}
		
		
	}
	

	public static <T>T query(String sql,IResultSetHandle<T> handle,Object...obj){
		
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet set = null;
		
		
		try{
			
			//获取连接对象
			connection = JDBCUtils.getConnection();
			
			statement = connection.prepareStatement(sql);
			
			System.out.println(sql);
			
			for(int i=0;i<obj.length;i++){
				
				statement.setObject(i+1,obj[i]);
			}
		
			//执行sql
			set = statement.executeQuery();
			
			return handle.handle(set);
		}catch(Exception e){
			
			e.printStackTrace();
		
		}finally{
			
			JDBCUtils.release(connection,statement,set);
		}
		
		throw new RuntimeException("查询出错");
		
		
	}
	
	
	
	
}