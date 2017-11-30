package refactor_jdbc_review.utils;


import org.apache.commons.dbcp.BasicDataSourceFactory;
import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {

        //连接池
          private static DataSource pool = null;

    static {

        try{
            Properties properties = new Properties();

            //通过类加载器会文件
            InputStream input = JDBCUtils.class.getClassLoader().getResourceAsStream("re_db.properties");

            //加载文件数据
            properties.load(input);

            //创建连接池
            pool = BasicDataSourceFactory.createDataSource(properties);

        }catch(Exception e){

            e.printStackTrace();

        }
    }


    public static Connection getConnection (){

            try{

                return  pool.getConnection();

            }catch(SQLException e){

                e.printStackTrace();

            }

            throw new RuntimeException("connectivity failed");
    }


    public static void releaseSource(Connection connection,Statement statement,ResultSet set){


        try{    if(set  != null)set.close();   }catch(SQLException e){e.printStackTrace();}
        try{    if(statement  != null)statement.close();   }catch(SQLException e){e.printStackTrace();}
        try{    if(connection != null)connection.close();  }catch(SQLException e){e.printStackTrace();}
    }

}
