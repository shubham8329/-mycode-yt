package com.jspiders.singletonnew;
import java.util.Scanner;
public class account
{   
 
private static account accountbalance = null;   
   
public int w;   
//private static Scanner scanner = new Scanner(System.in);


@SuppressWarnings("unused")
private void Singleton()   
{   
w = 10000;   
}   

public static account getInstance()   
{   
 
if (accountbalance== null)   
	accountbalance = new account();   
return accountbalance;   
}
public int getW() {
	return w;
}
//int choice= scanner.nextInt(); 
public void setW(int w) {
	this.w = w;
}
public void deposit(int depositAmount) {
	
	System.out.println("enter amount to deposit");}
public void withdraw(int withdrawAmount) {
	
	System.out.println("enter amount to withdraw");
	}
}
