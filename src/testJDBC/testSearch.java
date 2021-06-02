package testJDBC;

import java.sql.*;

public class testSearch {
    public static void main(String[] args) {
        String drive;
        String url = "jdbc:mysql://db-space-connection.c8ohasuinryn.us-east-2.rds.amazonaws.com:3306/maozi";
        String username= "admin";
        String password="Aa12345678";

        //完成连接数据库，或者说一个简单的JDBC操作
        //1.加载驱动
        //Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Drive load successfully");

        Connection conn = null;
        Statement statement = null;
        ResultSet rs = null;
        try {
            //2.获取链接
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("2 successful");

            //3.创建会话
            statement = conn.createStatement();
            System.out.println("Dialog created successfully");

            //4.发送sql
            //测试一个搜索的
            rs = statement.executeQuery("select * from maozi.Doctor");

            System.out.println("Data send successful");

            //5.处理结果
            /*while (rs.next()){
                int DoctorKey = rs.getInt(1);
                String DoctorName = rs.getString(2);
                System.out.println(DoctorKey+"\t"+DoctorName);*//*
            }*/
            while(rs.next()){
                int i = 1;
                int DoctorKey = rs.getInt(i++);
                String DoctorName = rs.getString(i++);
                System.out.println(DoctorKey+"\t"+DoctorName);

            }
            //如果只要很多列其中的几列， 直接输入名字

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {

            //6.
            try {if(rs!= null)
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

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
    }
}
