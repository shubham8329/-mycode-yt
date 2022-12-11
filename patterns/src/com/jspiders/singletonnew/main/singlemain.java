package com.jspiders.singletonnew.main;
import  com.jspiders.singletonnew.account;
import java.util.Scanner;
public class singlemain {
	//private static Scanner scanner = new Scanner(System.in);
	public static void main(String args[])   
	{   
		account a = account.getInstance();   
	 
	System.out.println("accountbalance is " + a.w);
	
	   
	}   
}
