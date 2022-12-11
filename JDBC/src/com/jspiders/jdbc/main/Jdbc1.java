package com.jspiders.jdbc.main;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Jdbc1 {
	public static void main(String[] args) {
		//Step1:Load the Driver class
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		//Step2:Open Connections							"protocol:sub-protocol://ip add|localhost:port no/dbname?user=username&password=password"
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/wejm4?user=root&password=root");
		//Step3:Create and Prepare Statement
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("select * from students");
		//Step4:Process the Result
		while (resultSet.next()) {
			System.out.println(resultSet.getInt(1) //here widening done automatically
					+"|"+"|"+ resultSet.getString(2) 
					+"|"+"|"+ resultSet.getString(3) 
					+"|"+"|"+ resultSet.getString(4)
					+"|"+"|"+ resultSet.getString(5));//five columns are there
			
		}
		//Step5:Close Connections
		connection.close();
		statement.close();
		resultSet.close();
		
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		
	}
}
