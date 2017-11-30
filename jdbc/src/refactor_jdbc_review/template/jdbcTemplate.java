package refactor_jdbc_review.template;


import refactor_jdbc_review.template.handler.IResultSetHandlerStandard;
import refactor_jdbc_review.utils.JDBCUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class jdbcTemplate {



    public static void  updateTable(String sql,Object...obj) {


        Connection connection = null;
        PreparedStatement statement = null;

        try {

            connection = JDBCUtils.getConnection();

            //precompile
            statement = connection.prepareStatement(sql);

            //setting student data
            for (int i = 0; i < obj.length; i++) {

                statement.setObject(i + 1, obj[i]);

            }

            //execute
            statement.executeUpdate();

        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            JDBCUtils.releaseSource(connection, statement, null);

        }
    }


    public static <T>T queryTable(String sql, IResultSetHandlerStandard<T> handler, Object...obj){

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet set = null;

        try{

            //获取连接对象,连入数据库
            connection = JDBCUtils.getConnection();

            //precompile
            statement = connection.prepareStatement(sql);

            //execute
            set = statement.executeQuery();

            //将set集合传入handler中处理,并返回list集合
            return handler.deal(set);

        }catch(Exception e){

            e.printStackTrace();

        }finally{

            //释放资源
            JDBCUtils.releaseSource(connection,statement,set);

        }

        return null;
    }


    private jdbcTemplate(){}


}
