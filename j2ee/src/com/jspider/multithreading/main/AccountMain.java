package com.jspider.multithreading.main;
import com.jspider.multithreading.resourses.Account;
import com.jspider.multithreading.threads.Husband;
import com.jspider.multithreading.threads.wife;
public class AccountMain {
		public static void main(String[] args) {
			System.out.println("Available Balance in Account:10000");
			Account account = new Account(10000);
			Husband husband = new Husband(account);
			wife wife1 = new wife(account);
			husband.start();
			wife1.start();
		}
}
