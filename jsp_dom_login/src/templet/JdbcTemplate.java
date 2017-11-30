package templet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import utils.StudentUtil;

public class JdbcTemplate{
	
	
	public static int update(String sql,Object...param){
		
		Connection connection = null;
		PreparedStatement statement = null;
		try{
			
			
			//利用DriverManager,连接数据库,
			connection = StudentUtil.getConnection();	
			
			
			//准备sql语句
			statement = connection.prepareStatement(sql);
			
			//设置sql语句参数
			
			for(int i=0;i<param.length;i++){
				
				statement.setObject(i+1,param[i]);
				
			}
			
			return statement.executeUpdate();
			
		}catch(Exception e){
			
			e.printStackTrace();
		
		
		}finally{
			
			//释放资源
			StudentUtil.release(null,statement,connection);
		}
		
		
		return -1;
	}
	
	public static <T>T query(String sql,IResultHandler<T> handle,Object...param){
		
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet set = null;
	
		try{
		
			
			//利用DriverManager,连接数据库
			connection = StudentUtil.getConnection();	
			//预加载sql
			statement = connection.prepareStatement(sql);
		
			//specified value
			if(param.length ==1 && param[0] != null && !"".equals(param[0])){
				
				
				
				statement.setObject(1,param[0]);
			}
		
			//执行sql
			 set = statement.executeQuery();
			 
			 
			return handle.handle(set);
			
		}catch(Exception e){
			
			e.printStackTrace();
			
		}finally{
			
			//释放资源
			StudentUtil.release(set,statement,connection);
		
		
		}
		
		throw new RuntimeException("查询错误");
	}
	
	
} 