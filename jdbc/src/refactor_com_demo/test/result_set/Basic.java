package refactor_com_demo.test.result_set;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Basic {



    @Test
    public void test(){
//        a table of date representing a database result set;
        //光标指向哪一行,就可以取出当前行的数据(与游标相似)
        //最好根据columnLabel来取值,

        Connection connectivity =null;
        Statement statement = null;
        ResultSet resultSet = null;

        try{

            //register and load Driver
            Class.forName("com.mysql.jdbc.Driver");

            //use ManagerDriver  connection  database

             connectivity = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_test","root","root");

            //statement Statement instance


             statement =  connectivity.createStatement();


            String sql = "select name from java_test";

            //returns a single ResultSet Object;
            resultSet = statement.executeQuery(sql);

            //moves the cursor forward one row

            while(resultSet.next()){

                String name = resultSet.getString("name");

                System.out.println(name);

            }


        }catch(Exception e){

            e.printStackTrace();

        }finally{


            try{
                if(resultSet != null)resultSet.close();
                if(connectivity != null)connectivity.close();
                if(statement != null)statement.close();

            }catch(Exception e){

                e.printStackTrace();

            }



        }




    }


}
