package testJDBC;

import java.sql.*;
import java.util.Scanner;

public class tesLogin {
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
            //键盘录入账号密码
            System.out.println("-----Welcome to the space connection system-----");
            Scanner sc = new Scanner(System.in);
            System.out.print("username: ");
            String name = sc.next();
            System.out.print("password: ");
            String pwd = sc.next();

            //2.获取链接
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("2 successful");

            //3.创建会话
            statement = conn.createStatement();
            System.out.println("Dialog created successfully");

            //4.发送sql
            //验证登录
            String sql = "select * from maozi.user where username ='"+name+"' and pwd='"+pwd+"'";
            rs = statement.executeQuery(sql);
            //很不安全，还存在sql注入
            //System.out.println(sql);
            //防止sql注入的办法


            System.out.println("Data send successful");

            //5.处理结果
            if(rs.next()){
                System.out.println("login successfully");
            }else{
                System.out.println("login fialed");
            }

            /*while (rs.next()){
                int DoctorKey = rs.getInt(1);
                String DoctorName = rs.getString(2);
                System.out.println(DoctorKey+"\t"+DoctorName);*//*
            }*/
            /*while(rs.next()){
                int i = 1;
                int DoctorKey = rs.getInt(i++);
                String DoctorName = rs.getString(i++);
                System.out.println(DoctorKey+"\t"+DoctorName);

            }*/
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
