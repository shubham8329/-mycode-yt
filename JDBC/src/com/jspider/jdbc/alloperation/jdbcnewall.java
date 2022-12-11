package com.jspider.jdbc.alloperation;
import java.sql.*;
public class jdbcnewall {
	
	
	     public static final String dburl = "jdbc:mysql://localhost:3306/wejm4";
	     public static final String dbuser = "root";
	     public static final String dbpassword = "root";
	     private static String query;
	     private static ResultSet resultSet;
	     public static void main(String args[])
	     {
	          try
	          {
	               //Loading the driver
	               Class.forName("driverpath");
	               //Cretae the connection object
	               Connection con = DriverManager.getConnection(dburl, dbuser, dbpassword);
	               //Insert the record
	               query = "INSERT INTO students (id, name, email, mobileno, Address) VALUES (?, ?, ?, ?)";
	               PreparedStatement statement = con.prepareStatement(query);
	               statement.setInt(1, 10);
	               statement.setString(2, "Prashant");
	               statement.setString(3, "prasant@saxena.com");
	               statement.setString(4, "Pune");

	               int rowsInserted = statement.executeUpdate();
	               if (rowsInserted > 0)
	               {
	                    System.out.println("A new students was inserted successfully!\n");
	               }
	               // Display the record
	                String query2= "SELECT * FROM students";
	               Statement stmt = con.createStatement();
	               resultSet result = stmt.executeQuery(query2);

	               while (result.next())
	               {
	                    System.out.println (result.getInt(1)+" "+
	                    result.getString(2)+" "+
	                    result.getString(3)+" "+
	                    result.getString(4));
	               }

	               //Update the record
	               String sql2 = "Update students set email = ? where students = ?";
	               PreparedStatement pstmt = con.prepareStatement(sql2);
	               pstmt.setString(1, "Jaya@gmail.com");
	               pstmt.setString(2, "Jaya");
	               int rowUpdate = pstmt.executeUpdate();
	               if (rowUpdate > 0)
	               {
	                    System.out.println("\nRecord updated successfully!!\n");
	               }

	               //Delete the record
	               String sql3 = "DELETE FROM students WHERE students=?";
	               PreparedStatement statement1 = con.prepareStatement(sql3);
	               statement1.setString(1, "Prashant");

	               int rowsDeleted = statement1.executeUpdate();
	               if (rowsDeleted > 0)
	               {
	                    System.out.println("A students was deleted successfully!\n");
	               }
	          }
	          catch(Exception ex)
	          {
	               ex.printStackTrace();
	          }
	     }
	}


}
