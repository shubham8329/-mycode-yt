package com.jspider.dynamicqueryInsert;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class JdbcInsert {
		private static Connection connection;
		private static PreparedStatement preparedStatement;
		private static int result;
		private static FileReader fileReader;
		private static Properties properties;
		private static String filepath="D:\\J2EE\\JDBC\\resourses\\db_info.properties";
		private static Scanner scanner = new Scanner(System.in);
		public static void main(String[] args) {
			try {
				fileReader = new FileReader(filepath);
				properties = new Properties();
				properties.load(fileReader);
				
				Class.forName(properties.getProperty("driverpath"));
				connection = DriverManager.getConnection(properties.getProperty("dburl"),properties);
				preparedStatement = connection.prepareStatement(properties.getProperty("query"));
				
				System.out.println("Enter the student id:");
				int id = scanner.nextInt();
				preparedStatement.setInt(1,id);
				
				System.out.println("Enter the student name:");
				String name = scanner.next();
				preparedStatement.setString(2,name);
				
				System.out.println("Enter the student email:");
				String email = scanner.next();
				preparedStatement.setString(3,email);
				
				System.out.println("Enter the student mobileno:");
				String mobileno = scanner.next();
				preparedStatement.setString(4,mobileno);
				
				System.out.println("Enter the student Address:");
				String Address = scanner.next();
				preparedStatement.setString(5,Address);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}catch (FileNotFoundException e) {
				e.printStackTrace();
			}catch (IOException e) {
				e.printStackTrace();
			}catch (ClassNotFoundException e) {
				e.printStackTrace();
			}catch (NullPointerException e) {
				e.printStackTrace();
			}finally {
				try {
					if(connection != null) {
						connection.close();
					}
					if (preparedStatement != null) {
						preparedStatement.close();
					}
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
			}
		}
}
