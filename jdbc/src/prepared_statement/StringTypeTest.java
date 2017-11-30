package prepared_statement;

import org.junit.Test;

import java.sql.*;
import java.io.*;
import java.util.Properties;


public class StringTypeTest {



    @Test
    public void testSaveImages(){


        Connection connectivity = null;
        PreparedStatement prepared = null;
        InputStream input = null;

        try{


//            load and register
            Class.forName("com.mysql.jdbc.Driver");

            //create  connection
            connectivity =  DriverManager.getConnection("jdbc:mysql://localhost:3306/my_test","root","root");

            //sql

            String sql = "INSERT INTO blob_test(content) values(?)";

            //precompile sql
             prepared = connectivity.prepareStatement(sql);

              input = new FileInputStream("java.png");

             prepared.setBlob(1,input);


             //execute
            prepared.executeUpdate();

        }catch(Exception e){


            e.printStackTrace();

        }finally{


            try{


                if(input != null)input.close();

                if(prepared != null)prepared.close();

                if(connectivity != null)connectivity.close();

            }catch(Exception e){

                e.printStackTrace();

            }


        }



    }


    @Test
    public void testFetchImages(){



        Connection connectivity = null;
        PreparedStatement statement = null;
        ResultSet set =null;
        OutputStream out = null;
        InputStream in = null;

        try{


//            load and register
            Class.forName("com.mysql.jdbc.Driver");

            //create  connection
            connectivity =  DriverManager.getConnection("jdbc:mysql://localhost:3306/my_test","root","root");


            //fetch sql
            String sql = "SELECT content FROM blob_test WHERE id = ?";

            //precompile sql
             statement = connectivity.prepareStatement(sql);

             statement.setInt(1,1);

             //获取结果
             set = statement.executeQuery();

            if(set.next()){ //如果对象存在

                Blob blob = set.getBlob(1);

                 in =  blob.getBinaryStream();

                 out = new BufferedOutputStream(new FileOutputStream("fetch.png"));

                byte[] arr = new byte[1024];

                int len;

                while((len = in.read(arr)) != -1){

                    out.write(arr,0,len);

                }

            }

        }catch(Exception e){


            e.printStackTrace();

        }finally{

            //释放资源
            try{
                if(out!= null)out.close();
                if(in != null)in.close();
                if(set != null)set.close();
                if(statement != null)statement.close();
                if(connectivity != null)connectivity.close();

            }catch(Exception e){

                e.printStackTrace();

            }

        }

    }

}
