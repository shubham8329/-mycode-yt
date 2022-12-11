package com.jspider.jdbc.alloperation;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.lang.NullPointerException;
	public class JdbcAllOperration {
	
		private static Connection connection;
		private static Statement statement;
		private static int result;
		private static FileReader fileReader;
		private static Properties properties;
		private static String query;
		private static String filepath;
		public static void main(String[] args) {
			try {
				filepath="D:\\J2EE\\JDBC\\resourses\\db_info.properties";
				fileReader = new FileReader(filepath);
				properties=new Properties();
				properties.load(fileReader);
				//insert
				connection=DriverManager.getConnection(properties.getProperty("dburl"),properties);//key values
				statement=connection.createStatement();
				result = statement.executeUpdate(properties.getProperty("query7"));//use key 'query1'
			System.out.println(result+"row (S) affected");
				//delete
				
			}catch(SQLException e) {
				e.printStackTrace();
			}catch(FileNotFoundException e) {
				e.printStackTrace();
			}catch(IOException e) {
				e.printStackTrace();
			}catch(NullPointerException e) {
				e.printStackTrace();
			}finally {
				try {
					if (connection != null) {
						connection.close();
					}
					if (statement != null) {
						statement.close();
					}	
				} catch (SQLException e2){
					e2.printStackTrace();
					}
				}
			}
		}


