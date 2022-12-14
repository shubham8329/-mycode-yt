package com.jspiders.jdbc.select;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcSelect {
	private static Connection connection;
	private static Statement statement;
	private static ResultSet resultSet;
	private static FileReader fileReader;
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
			statement = connection.createStatement();
			query="Select * from shop";
			resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				System.out.println(resultSet.getString(1)		+"|"
									+resultSet.getString(2)		+"|"
									+resultSet.getString(3)		+"|"
									+resultSet.getString(4)  	+"|"
									+resultSet.getString(5));
			}
		}catch (ClassNotFoundException e){
				e.printStackTrace();
		}catch (FileNotFoundException e) {
				e.printStackTrace();
		}catch (IOException e) {
				e.printStackTrace();
		}catch (SQLException e) {
				e.printStackTrace();
		}
	finally {
		if(connection != null){
			try {
					connection.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
		}
		if(statement != null){
			try {
					connection.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
		}
		if(resultSet != null){
			try {
					connection.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
		
		
	
