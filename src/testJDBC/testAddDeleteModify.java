package testJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//另一种处理异常

public class testAddDeleteModify {
    public static void main(String[] args)  {
        String drive;
        String url = "jdbc:mysql://db-space-connection.c8ohasuinryn.us-east-2.rds.amazonaws.com:3306/maozi";
        String username= "admin";
        String password="Aa12345678";

        //完成连接数据库，或者说一个简单的JDBC操作
        //1.加载驱动
        //Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Drive load successfully");
        //2.获取链接
        Connection conn = null;
        Statement statement = null;
        try {
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("2 successful");
            statement = conn.createStatement();
            System.out.println("Dialog created successfully");
            //        4.发送sql
            //int n = statement.executeUpdate("insert into maozi.Doctor values (1233444, 'guodong')");
            //再测试一个修改的
            int n = statement.executeUpdate("update maozi.Doctor set DoctorName ='lili' where DoctorKey =1233443");

            System.out.println("Data send successful");
//        5.处理结果
            if(n>0)
                System.out.println("Data insert Successfully");
            else
                System.out.println("Data insert Failed");
            System.out.println("5 successful");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            //        6.关闭资源
            try {if(statement!=null)
                statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {if(conn!= null)
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        //Connection conn = DriverManager.getConnection("jdbc:mysql://db-space-maozi.c8ohasuinryn.us-east-2.rds.amazonaws.com:1433/guest", "admin", "Aa12345678");



    }
}
