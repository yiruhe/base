package refactor_jdbc_2.template;

import refactor_jdbc_2.dao_demo.domain.StudentDemo;
import refactor_jdbc_2.util.StudentUtilDemo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class TemplateJDBC {


    public static void updateTable(String sql,Object... infoArray){


        Connection connectivity = null;
        PreparedStatement prepared= null;

        try{

            connectivity = StudentUtilDemo.getConnection();



            //precompile
            prepared = connectivity.prepareStatement(sql);

            for(int i=0;i<infoArray.length;i++){

                prepared.setObject(i+1,infoArray[i]);

            }

            //execute  statement ps:说了多少次这里不能带参数...
            int num = prepared.executeUpdate();

            System.out.println(num);

        }catch(Exception e){

            e.printStackTrace();

        }finally{

            //deal exception
            StudentUtilDemo.dealException(connectivity,prepared,null);

        }

    }


    /**
     *
     * @param sql  you want to execute sql
     * @param handler you custom yourself handle Object
     * @param parameterArr you require execute of parameter
     * @return object
     */
    //这里泛型参照这个接口指定的泛型,因为定义的这个接口时有泛型的,那么这里的泛型就会引用这个接口定义的泛型
    //这里的类型已经决定了,但是这个类型的泛型还没有确定,这里的泛型就是这个类型就是给定的泛型
    //T:ArrayList
    public static <T>T  queryTable(String sql,IResultSetHandlerStandard<T> handler,Object... parameterArr){

        Connection connectivity = null;
        PreparedStatement statement = null;
        ResultSet resultSet =null;
        try{

            connectivity = StudentUtilDemo.getConnection();

            statement = connectivity.prepareStatement(sql);

            //setting query parameters
            for(int i=0;i<parameterArr.length;i++){

                statement.setObject(i+1,parameterArr[i]);
            }

            //execute sql and returned result set
            resultSet = statement.executeQuery();


            //returned  after deal of ResultSet from handler
            return handler.deal(resultSet);

        }catch(Exception e){

            e.printStackTrace();

        }finally{

            StudentUtilDemo.dealException(connectivity,statement,resultSet);
        }

        return null;
    }


    //私有化构造器
    private TemplateJDBC(){

    }

}
