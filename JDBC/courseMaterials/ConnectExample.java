package JDBC.courseMaterials;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectExample{ 
    
    public static Connection getConnection(){
        String url = "jdbc:mysql://localhost:3306/courseexample";
        String user = "sqluser";
        String password = "password";
        Connection conn = null;
       try{
        conn = DriverManager.getConnection(url, user, password);
        System.out.println("Connection sUCCESSFUL!");  

       } catch(SQLException e){
        System.out.println(e);
       }
       return conn;
    }
    public static Connection getConnectionPerson(){
        String url = "jdbc:mysql://localhost:3306/person";
        String user = "sqluser";
        String password = "password";
        Connection conn = null;
       try{
        conn = DriverManager.getConnection(url, user, password);
        System.out.println("Connection sUCCESSFUL!");  

       } catch(SQLException e){
        System.out.println(e);
       }
       return conn;
    }
    
   public static void main(String[] args){
        Connection conn =  getConnection();

        Connection conn2 = getConnectionPerson();
   }
      

}


   