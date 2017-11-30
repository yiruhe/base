package utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

public class StudentUtil{
	
	private static DataSource ds = null; 
	
	static{
			
		try{
			
			
			Properties property = new Properties();
			
			InputStream input = StudentUtil.class.getClassLoader().getResourceAsStream("db.properties");
			
			//加载数据
			property.load(input);
			
			ds = DruidDataSourceFactory.createDataSource(property);
			
		}catch(Exception e){
			
			e.printStackTrace();
			
		}
		
		
	}
	
	//获取连接
	public static Connection getConnection() throws SQLException{
		
		return ds.getConnection();
		
	}
	
	//释放资源
	public static void release(ResultSet set,Statement statement,Connection connection){
		try{ 	if(set != null)set.close(); 			}catch(Exception e){ e.printStackTrace(); }
		try{ 	if(statement != null)statement.close(); }catch(Exception e){e.printStackTrace();}
		try{ 	if(connection != null)connection.close(); }catch(Exception e){e.printStackTrace();}
	}
	
	
	//私有化构造器
	private StudentUtil(){}
}