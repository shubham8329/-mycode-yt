package com.jspiders.Filehandling.create;
import java.io.File;
import java.io.IOException;
public class FileAbsolutePath {
		public FileAbsolutePath(String string) {
		// TODO Auto-generated constructor stub
	}

		public static void main(String[] args) throws IOException {
			FileAbsolutePath fileAbsolutePath = new FileAbsolutePath("D:\\J2EE\\demo1.txt");
			if (fileAbsolutePath.exists()) {
				System.out.println("File already exists...!");
			}
			else {
				fileAbsolutePath.createNewFile();
				System.out.println("New file is created...!!!");
			}
			}

		private boolean exists() {
			// TODO Auto-generated method stub
			return false;
		}

		private void createNewFile() {
			// TODO Auto-generated method stub
			 
		}

		

}
