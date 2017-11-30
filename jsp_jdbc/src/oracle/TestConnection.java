package oracle;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

/**
 * Created by Administrator on 29/10/2017.
 */
public class TestConnection {





    public static void main(String[] args) throws Exception {

        //1.加载驱动
        Class.forName("oracle.jdbc.driver.OracleDriver");

        //获取连接 root实例
        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:root","system","root");

    }


}
