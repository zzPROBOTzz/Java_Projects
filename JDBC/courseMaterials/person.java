package JDBC.courseMaterials;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class person {

    public static void insertPerson(Connection conn){
         try {
            PreparedStatement pstsm = conn.prepareStatement("INSERT INTO personalInfo(id, name, email) VALUES(?,?,?);");
            pstsm.setString(1, "4");
            pstsm.setString(2, "wwewww");
            pstsm.setString(3, "wweww@gmail.com");
            int rs = pstsm.executeUpdate();
            System.out.println(rs + "row(s) updated");
        
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void getAllPerson(Connection conn){
        try{
            Statement stsm = conn.createStatement();
            ResultSet rs = stsm.executeQuery("SELECT * FROM personalInfo");
            while(rs.next())
            {
                 System.out.println(
                     rs.getString("id")
                     + "\t " +
                     rs.getString("name")
                     + "\t " +
                     rs.getString("email")
                    
                 );
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Connection conn = ConnectExample.getConnectionPerson();

        getAllPerson(conn);
        //insertPerson(conn);

    }
}
