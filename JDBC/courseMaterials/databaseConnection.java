package JDBC.courseMaterials;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class databaseConnection {

     public static void fetchInstructor(Connection conn) {
        try {
            Statement stsm1 = conn.createStatement();
            ResultSet rs1 = stsm1.executeQuery("Select * from instructor;");
            while(rs1.next())
            {
                 System.out.println(
                     rs1.getString("InstructorId")
                    + "\t " +
                    rs1.getString("InstructorName")
                    + " \t" +
                    rs1.getString("DepartmentId")
                );
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        
    }
    public static void findCourseInfoByID(Connection conn) {
        try {
            PreparedStatement pstsm3= conn.prepareStatement("Select * from course where CourseID = ?;");
            pstsm3.setString(1, "CS101");   
            ResultSet rs4 = pstsm3.executeQuery();
            while (rs4.next()) {
             System.out.println(
                 rs4.getString("CourseId")
                 + "\t " +
                 rs4.getString("CourseName")
                 + "\t " +
                 rs4.getString("Credits")
                 + "\t " +
                 rs4.getString("DepartmentId")
             );
         }
        } catch (Exception e) {
            System.out.println(e);
        }
       
    }
    public static void findDepartmentInfoById(Connection conn) {
        try {
            PreparedStatement pstsm4= conn.prepareStatement("Select * from department where DepartmentID = ?;");
            pstsm4.setString(1, "cs");   
            ResultSet rs5 = pstsm4.executeQuery();
            while (rs5.next()) {
                System.out.println(
                    rs5.getString("DepartmentID")
                    + "\t " +
                    rs5.getString("DepartmentName")
            
                );
            } 
        } catch (Exception e) {
            System.out.println(e);
        }
       
    }
    public static void fetchCourse(Connection conn){
        try {
            Statement stsm2 = conn.createStatement();
           ResultSet rs2 = stsm2.executeQuery("Select * from course;");
           while(rs2.next())
           {
                System.out.println(
                    rs2.getString("CourseId")
                    + "\t " +
                    rs2.getString("CourseName")
                    + "\t " +
                    rs2.getString("Credits")
                    + "\t " +
                    rs2.getString("DepartmentId")
                );
           }
        } catch (SQLException e) {
            System.out.println(e);
        }
        
    }
    public static void findInstructorInfoByID(Connection conn){
        try {
            PreparedStatement pstsm1 = conn.prepareStatement("Select * from instructor where InstructorId = ?;");
            pstsm1.setInt(1, 3);   
            ResultSet rs3 = pstsm1.executeQuery();
            while (rs3.next()) {
             System.out.println(
                 rs3.getString("InstructorId")
                 + " " +
                 rs3.getString("InstructorName")
                 + " " +
                 rs3.getString("DepartmentId")
                );
            }   
        } catch (SQLException e) {
            System.out.println(e);
        }
       
    }
    public static void insertDepartment(Connection conn){
        try {
            PreparedStatement pstsm = conn.prepareStatement("INSERT INTO department(DepartmentID, DepartmentName) VALUES(?,?);");
            pstsm.setString(1, "chem");
            pstsm.setString(2, "chemistry");
            int rs = pstsm.executeUpdate();
            System.out.println(rs + "row(s) updated");
        
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    public static void insertInstructor(Connection conn){
        try {
            PreparedStatement pstsm = conn.prepareStatement("INSERT INTO instructor(InstructorId, InstructorName, DepartmentId) VALUES(?,?,?);");
            pstsm.setString(1, "10");
            pstsm.setString(2, "Meet");
            pstsm.setString(3, "chem");
            int rs = pstsm.executeUpdate();
            System.out.println(rs + "row(s) updated");
        
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    public static void insertCourse(Connection conn){
        try {
            PreparedStatement pstsm = conn.prepareStatement("INSERT INTO course(CourseId, CourseName, Credits, DepartmentId) VALUES(?,?,?,?);");
            pstsm.setString(1, "CHEM101");
            pstsm.setString(2, "Meet");
            pstsm.setString(3, "4");
            pstsm.setString(4, "chem");
            int rs = pstsm.executeUpdate();
            System.out.println(rs + "row(s) updated");
        
        } catch (SQLException e) {
            System.out.println(e);
        }
    }


    public static void main(String[] args) {
       
        Connection conn = ConnectExample.getConnection();
        fetchCourse(conn);
        fetchInstructor(conn);
        findCourseInfoByID(conn);
        findDepartmentInfoById(conn);
        findInstructorInfoByID(conn);
        insertDepartment(conn);
        insertCourse(conn);
        insertInstructor(conn);
        
    }
}
