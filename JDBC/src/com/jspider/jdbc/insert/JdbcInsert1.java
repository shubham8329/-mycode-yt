package com.jspider.jdbc.insert;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.sql.ResultSet; 
public class JdbcInsert1 {
	private static Connection connection;
	private static Statement statement;
	private static ResultSet resultSet;
	
	private static FileReader fileReader;
	public static int result;
	private static Properties properties;
	private static String query;
	private static String filepath;
	private static String driverpath="com.mysql.cj.jdbc.Driver";
	private static String dburl="jdbc:mysql://localhost:3306/wejm4";
	public static void main(String[] args) {
		try {
			Class.forName(driverpath);
			filepath="D:\\J2EE\\JDBC\\resourses\\db_info.properties";
			fileReader = new FileReader(filepath);
			properties=new Properties();
			properties.load(fileReader);
			connection = DriverManager.getConnection(dburl,properties);
			
			//Insert record
			PreparedStatement statement = connection.prepareStatement("query6");
			int result = statement.executeUpdate(properties.getProperty("query6"));//update
			if (result > 0) {
				System.out.println("A new students was inserted successfully!\\n");
			}
			
			//Display all the record
			query="Select * from students";
			Statement statement1 = connection.createStatement();
			ResultSet resultSet = statement1.executeQuery(query);
			while (resultSet.next()) {
				System.out.println(resultSet.getString(1)		+"|"
									+resultSet.getString(2)		+"|"
									+resultSet.getString(3)		+"|"
									+resultSet.getString(4)  	+"|"
									+resultSet.getString(5)  	+"|"
									+resultSet.getString(5)  	+"|"
									+resultSet.getString(6)  	+"|"
									+resultSet.getString(7)  	+"|"
									+resultSet.getString(8)  	+"|"
									+resultSet.getString(9)  	+"|"
									+resultSet.getString(10));
			}
			//Update record
			PreparedStatement statement11 = connection.prepareStatement("query7");
			int result1 = statement11.executeUpdate(properties.getProperty("query7"));//update
			if (result1 > 0) {
				System.out.println("A new students was inserted successfully!\\n");
			}
        //Delete record
        
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		}
}
