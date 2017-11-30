package utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

public class JDBCUtils{
	
	private static DataSource source = null;
	
	static{
		
		//加载驱动
		try {
			
			Properties property = new Properties();
			
			InputStream input = JDBCUtils.class.getClassLoader().getResourceAsStream("db.properties");
			
			property.load(input);
			
			source = DruidDataSourceFactory.createDataSource(property);
				
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException{
		
		return source.getConnection();
	}
	
	public static void release(Connection connection,Statement statement,ResultSet set){
		

		//释放资源
		try{	if(set != null)set.close();	}catch(SQLException e){ e.printStackTrace(); }
		try{	if(statement != null)statement.close();		}catch(SQLException e){ e.printStackTrace(); }
		try{	if(connection != null)connection.close();	}catch(SQLException e){ e.printStackTrace(); }
	}
	
	private JDBCUtils(){}
}
