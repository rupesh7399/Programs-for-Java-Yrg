import java.sql.*;
 public class JDBCDemo1 {
 public static void main(String[] args) {
 Connection conn = null; try {
 //Register jdbc driver
 Class.forName("com.mysql.jdbc.Driver"); //Establish connection 
 String dbURL = "jdbc:mysql://localhost:3306/test";
 String user = "root"; String pass = "";
 conn = DriverManager.getConnection(dbURL, user, pass); System.out.println("Connected."); // Create and execute an SQL statement String SQL = "SELECT * from STUDENT"; Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(SQL); // Iterate through the data in the result set while (rs.next()){ System.out.println(rs.getString(1)+":"+ rs.getString(2)); } } catch (Exception e) { e.printStackTrace(); } }