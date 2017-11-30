package connection_pool;


import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;


public class StudentUtilDemo {

    //创建加载properties对象的文件
    private static Properties property = new Properties();
    private static DataSource dataSource = null;


    static{

        try{

            //利用类加载获取inputString
            InputStream  input =  StudentUtilDemo.class.getClassLoader().getResourceAsStream("dbcp.properties");


            property.load(input);

            dataSource = BasicDataSourceFactory.createDataSource(property);

        }catch(Exception e){

            throw new RuntimeException("initialized  failed");

        }

    }


    /**
     * connection database
     * @return void
     */
    public static Connection getConnection(){

        try{

            //usage DriverManager  create  connection  database;
            return dataSource.getConnection();

        }catch(Exception e){

            e.printStackTrace();

        }

        throw new RuntimeException("connection fail");

    }



    public static void dealException(Connection connectivity,Statement statement,ResultSet resultSet){

        try{

            //关闭resultSet的资源引用
            if(resultSet != null)resultSet.close();

        }catch(SQLException e){

            throw  new RuntimeException(" this is  close exception (issue)");

        }finally{

            try{

                //关闭Statement对象的资源
                if(statement != null)statement.close();

            }catch(SQLException e){

               e.printStackTrace();

            }finally{

                try{

                    //关闭数据的连接
                    if(connectivity != null) connectivity.close();

                }catch(Exception e){

                    e.printStackTrace();

                }

            }

        }

    }

}
