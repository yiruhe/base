package prepared_statement;


import org.junit.Test;
import java.sql.*;

public class TransactionDemo {

    @Test
    public void test(){

//        事务模板
//        try{
//            //取消事务自动提交(每一个DML语句都是一个事务,默认是自动提交的)
//           more code.....issue
//            connection.setAutoCommit(false)
//
//        }catch(){
//
//            // deal exception
//            //rollback transaction
//
//
//        }finally{
//
//            //释放资源
//
//        }

        //Text(大文本系列)其实就是varchar的增强版
//        TinyText 255字节
//        text:  65535字节 ~64k
//        mediumText: 16M
//        LONGTEXT: ~4G

//        BLOB系列(大二进制) 其实就是BINARY的增强版

//            TinyBlob //255
//            Blob     //65535
//            MediumBlob //16M
//            LOngBLOB   //4G

    }


    @Test
    public void testTransaction(){
        Connection connectivity = null;
        PreparedStatement prepared = null;
        ResultSet set = null;
        try{

            //加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //usage DriverManager
             connectivity = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_test","root","root");

            //ensure balance sql
            String ensureSQL = "SELECT balance FROM java_atm WHERE id = ? AND balance >= ?";

             prepared =  connectivity.prepareStatement(ensureSQL);

             prepared.setInt(1,1);
             prepared.setInt(2,1000);

             set = prepared.executeQuery();

            if(!set.next()){


                throw  new RuntimeException("余额不足");

            }

            connectivity.setAutoCommit(false);

            String fetchSQL = "UPDATE java_atm SET balance = ? WHERE  id = ?";

            prepared = connectivity.prepareStatement(fetchSQL);

            prepared.setInt(1,0);
            prepared.setInt(2,1);

//            int i=1/0;

            //execute
            prepared.executeUpdate();

//            depend occur
            String addSQL = "UPDATE java_atm SET balance = balance + 1000 WHERE id = ?";

            //
            prepared = connectivity.prepareStatement(addSQL);

            prepared.setInt(1,2);

            //execute
            prepared.executeUpdate();

            connectivity.commit();

        }catch(Exception e){

            e.printStackTrace();
            try{


                if(connectivity != null)connectivity.rollback();

            }catch(SQLException issue){

                issue.printStackTrace();
            }

        }finally{

            try{

                if(set != null)set.close();

                if(prepared != null)prepared.close();


                if(connectivity!= null)connectivity.close();

            }catch(Exception e){

                e.printStackTrace();

            }

        }




    }
}
