package com.jspider.serialization.write;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import com.jspider.serialization.object.Student;

public class Serialization {
	public static void main(String[] args) {
		try {
			File file = new File("student.txt");
			file.createNewFile();
			FileOutputStream fileOutputStream = new FileOutputStream("student.txt");
			
			Student student = new Student();
			student.setID(1);
			student.setName("soham");
			student.setEmail("shubham@gmail.com");
			student.setAddress("Pune");
			
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(student);
			System.out.println("Object written to file successfully");
			System.out.println(file.getAbsolutePath());
			objectOutputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
