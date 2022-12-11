package com.jspider.serialization.read;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import com.jspider.serialization.object.Student;

public class Deserialization {
	public static void main(String[] args) {
		try {
			File file = new File("student.txt");
			file.createNewFile();
			FileInputStream FileInputStream = new FileInputStream("student.txt");
			
			Student student = new Student();
			student.setID(1);
			student.setName("soham");
			student.setEmail("shubham@gmail.com");
			student.setAddress("Pune");
			
			ObjectInputStream ObjectInputStream = new ObjectInputStream(FileInputStream);
			try {
				ObjectInputStream.readObject();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Object written to file successfully");
			System.out.println(file.getAbsolutePath());
			ObjectInputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		}
}
