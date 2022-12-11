package com.jspiders.jdbc.main;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class jdbc3 {
	public static void main(String args[]) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/wejm4?user=root&password=root");
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from shop");
			while (resultSet.next()) {
				System.out.println(resultSet.getInt(1) 
						+"|"+"|"+	resultSet.getString(2) 
						+"|"+"|"+	resultSet.getString(3) 
						+"|"+"|"+	resultSet.getString(4) 
						+"|"+"|"+	resultSet.getString(5)
						+"|"+"|"+	resultSet.getString(6));
		} 
			connection.close();
			statement.close();
			resultSet.close();
			
		}catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
		}
		}
}
