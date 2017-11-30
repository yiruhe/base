package prepared_statement;

import org.junit.Test;

import java.sql.*;

/**
 * Created by Administrator on 2017/3/30.
 */
public class GetPrimaryKey {

    @Test
    public void testGetPrimaryKey(){

        Connection connec = null;
        Statement statement = null;
        ResultSet set = null;
        try{


            //加载驱动
            Class.forName("com.mysql.jdbc.Driver");


            //利用DriverManager 获取连接对象
             connec = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_test","root","root");


            statement = connec.createStatement();

            String sql = "INSERT INTO java_atm(name,balance) values('小卒',10)";

            //只能获取自动增长的键
            statement.executeUpdate(sql,Statement.RETURN_GENERATED_KEYS); //让主键Generator 可获取

            //获取主键
             set = statement.getGeneratedKeys();

            if(set.next()){

                int num = set.getInt(1);

                System.out.println(num);

            }


        }catch(Exception e){

            e.printStackTrace();

        }finally{


            try{
                if(set != null)set.close();

                if(statement != null)statement.close();

                if(connec != null)connec.close();


            }catch(Exception e){

                e.printStackTrace();

            }

        }






    }

    @Test
    public void testGetPrimaryKey1(){

        Connection connec = null;
        PreparedStatement statement = null;
        ResultSet set = null;
        try{


            //加载驱动
            Class.forName("com.mysql.jdbc.Driver");


            //利用DriverManager 获取连接对象
            connec = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_test","root","root");


            String sql = "INSERT INTO java_atm(name,balance) values('小卒',10)";

            //只能获取自动增长的键
            statement = connec.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

            statement.executeUpdate();

            //获取主键
            set = statement.getGeneratedKeys();

            if(set.next()){

                int num = set.getInt(1);

                System.out.println(num);

            }


        }catch(Exception e){

            e.printStackTrace();

        }finally{


            try{
                if(set != null)set.close();

                if(statement != null)statement.close();

                if(connec != null)connec.close();


            }catch(Exception e){

                e.printStackTrace();

            }

        }

    }
}
