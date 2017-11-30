package prepared_statement;

import org.junit.Test;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Administrator on 2017/3/31.
 */
public class BatchTest {


    @Test
    public void test(){

//        batch(批量操作)

//        addBatch()     //添加批量处理sql语句
//        executeBatch() //执行处理语句
//        clearBatch()  //清除缓存

//        Statement  //系统初始化的时候使用(创建表,创建数据等)

        //rewriteBatchedStatement = true参数
        //优化支持的版本: 5.1.13   //因为Innodb的表是按照主键排序的,所以要加主键才支持优化
    }


    @Test
    public void testBatch(){

        Connection connectivity = null;

        PreparedStatement statement = null;

        try{
        // add and register
            Class.forName("com.mysql.jdbc.Driver");

            //get Connection
            connectivity = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_test?useServerPrepStmts=true&rewriteBatchedStatement=true","root","root");


            String sql = "INSERT INTO java_batch(age) values(?)";

            statement = connectivity.prepareStatement(sql);

            long startTime = System.currentTimeMillis();

            for(int i=1;i<5000;i++){

                statement.setInt(1,i);

                if(i % 200 == 0){

                    statement.executeBatch();

                    statement.clearBatch();

                    statement.clearParameters();

                }

            }


            long endTime = System.currentTimeMillis();

            System.out.println(endTime - startTime);

        }catch(Exception e){

            e.printStackTrace();

        }finally{

                try{    if(statement != null)statement.close();         }catch(SQLException e){e.printStackTrace();}

                try{    if(connectivity != null)connectivity.close();   }catch(SQLException e){e.printStackTrace();}


        }

    }

}
