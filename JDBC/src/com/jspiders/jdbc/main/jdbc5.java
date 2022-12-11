package com.jspiders.jdbc.main;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
public class jdbc5 {
	public static void main(String[] args) {
		try {
		//step1:load the Driver class
			Class.forName("com.mysql.cj.jdbc.Driver");
		//Loading the db_info file in FileReader object
			FileReader fileReader = new FileReader("D:\\J2EE\\JDBC\\resourses\\db_info.properties");
		//Loading file as properties of jdbc
			Properties properties = new Properties();
			properties.load(fileReader);
		//step2:Open Connection
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/wejm4",properties);
		//step3:Create/Prepare Statement
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("Select * from agents");
		//step4:Process the result
			while (resultSet.next()) {
					System.out.println(resultSet.getString(1) +"|"
									+resultSet.getString(2)+"|"
									+resultSet.getString(3)+"|"
									+resultSet.getString(4)  +"|"
									+resultSet.getString(5));		
			}
		//step5:Close Connections
			connection.close();
			statement.close();
			resultSet.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
