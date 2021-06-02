package testJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class test {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //完成连接数据库，或者说一个简单的JDBC操作
        //1.加载驱动
        //Class.forName("com.mysql.jdbc.Driver");
        System.out.println("1 successful");
        //2.获取链接
        Connection conn = DriverManager.getConnection("jdbc:mysql://db-space-connection.c8ohasuinryn.us-east-2.rds.amazonaws.com:3306/maozi", "admin", "Aa12345678");
        //Connection conn = DriverManager.getConnection("jdbc:mysql://db-space-maozi.c8ohasuinryn.us-east-2.rds.amazonaws.com:1433/guest", "admin", "Aa12345678");
        System.out.println("2 successful");
        Statement statement = conn.createStatement();
        System.out.println("3 successful");
        //        4.发送sql
        int n = statement.executeUpdate("insert into maozi.Doctor values (1233443, 'chifu')");
        System.out.println("4 successful");
//        5.处理结果
        if(n>0)
            System.out.println("Successful");
        else
            System.out.println("Failed");
        System.out.println("5 successful");
//        6.关闭资源
        statement.close();
        conn.close();
//
    }

}
