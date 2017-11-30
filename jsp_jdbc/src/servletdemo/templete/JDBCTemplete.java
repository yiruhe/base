package servletdemo.templete;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import servletdemo.templete.handler.IResultSetHandler;
import servletdemo.templete.handler.ResultSetHandlerImplement;
import servletdemo.utils.StudentDAOUtils;

public class JDBCTemplete {
	
	
	
	
	public static void updateTable(String sql,Object... parameter){
		
		Connection connection = null;
		PreparedStatement prepared = null;
		//加载驱动
		try{
				
			
			connection = StudentDAOUtils.getConnection();
			
			//预加载sql语句
			prepared = connection.prepareStatement(sql);
	
			//给预加载的语句添加参数
			for(int i=0;i<parameter.length;i++){
				
				//设置参数
				prepared.setObject(i+1,parameter[i]);
				
			}
			
			//执行sql语句
			prepared.executeUpdate();
			
		}catch(Exception e){
			
			e.printStackTrace();
		
		}finally{
		
			StudentDAOUtils.closeResource(connection, prepared,null);
			
		}
	
	}

	public static <T>T query(String sql,IResultSetHandler<T> handler,Object... parameter){
		
		

		Connection connection = null;
		PreparedStatement prepared = null;
		
		ResultSet set = null;
		//加载驱动
		try{
						
			//获取链接对象
			connection = StudentDAOUtils.getConnection();
			
			//预加载sql语句
			prepared = connection.prepareStatement(sql);
			
			for(int i=0;i<parameter.length;i++){
				
				prepared.setObject(i+1,parameter[i]);
			}
	
			//执行sql语句
			set = prepared.executeQuery();
			
			//如果新的当前行有效，则返回 true；如果不存在下一行，则返回 false 
			
			
			
			return handler.handler(set);
			
		}catch(Exception e){
			
			e.printStackTrace();
		
		}finally{
		
			StudentDAOUtils.closeResource(connection, prepared,set);
			
		}
		
		return null;
		
	}
}
