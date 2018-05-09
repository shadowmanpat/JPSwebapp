package dataLayer;

import java.sql.DriverManager;
import java.sql.*;

public class DB_user {



    public static  String JDBC_DRIVER = "com.mysql.jdbc.Driver";
//    public static  String JDBC_DR_URL = "jdbc:mysql://localhost/webapptutorial";
//
//    public static  String JDBC_USER = "webappuser";
//    public static  String JDBC_PASSWORD = "123";

    public boolean isValidUserLogin(String sUserName,String sUserPassWord){
        boolean isValidUser=false;
        Connection conn = null;
        Statement stmt =null;
        String sql = "";
        try{
            //step 2
            Class.forName(JDBC_DRIVER).newInstance();
            //step 3
            System.out.println("Connecting to database...");

            String DB_url=System.getProperty("JDBC_CONNECTION_STRING");
            String DB_user=System.getProperty("JDBC_USER");
            String DB_password=System.getProperty("JDBC_PASSWORD");
          //  conn = DriverManager.getConnection(DB_url);
            System.out.println(DB_url);
            conn = DriverManager.getConnection(DB_url,DB_user,DB_password);

            //step 4
            System.out.println("Creating statement");
         //   stmt = conn.createStatement();

           // sql = "SELECT * FROM `users` WHERE `username`= '"+sUserName+"'";
            //ResultSet rs = stmt.executeQuery(sql);
            PreparedStatement ps=conn.prepareStatement(
                    "select * from users where username=?");
            ps.setString(1,sUserName);
            //ps.setString(2,pass);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                isValidUser=true;
            }
            rs.close();
           // stmt.close();
            conn.close();

        }catch ( Exception e){
            e.printStackTrace();
        }
        System.out.println("Closing");
        return isValidUser;
    }
}
