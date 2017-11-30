package servletdemo.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class StudentDAOUtils {

	private static Properties property= null; 

	static{
	
		try {
			
			property = new Properties();
			
			//把文件作为流导入,property对象
			InputStream  input = StudentDAOUtils.class.getClassLoader().getResourceAsStream("db.properties");
			
			//加载input
			property.load(input);
				
			//加载驱动
			Class.forName(property.getProperty("driver"));
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	
	public static Connection getConnection(){
		
		Connection connection;
		
		try {
			//利用DriverManager连接数据库			
			connection =DriverManager.getConnection(
					property.getProperty("url"),
					property.getProperty("username"),
					property.getProperty("password")
			);
		
			return connection;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		throw new RuntimeException("connection initialize failed");
		
	}
	
	
	public static void closeResource(Connection connection,Statement prepared,ResultSet set){
		
		try{
			//释放资源
			try{ 	if(set != null)connection.close(); }catch(Exception e){ e.printStackTrace(); }
			try{ 	if(prepared != null)prepared.close();	}catch(Exception e){ e.printStackTrace(); }
			try{ 	if(connection != null)connection.close(); }catch(Exception e){ e.printStackTrace(); }
		
		
		}catch(Exception e){
			
			e.printStackTrace();
			
		}
		
	}
		
}
