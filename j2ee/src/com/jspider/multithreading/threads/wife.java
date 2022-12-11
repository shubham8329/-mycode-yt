package com.jspider.multithreading.threads;
import  com.jspider.multithreading.resourses.Account;
public class wife extends Thread{
		Account account;
		public wife(Account account) {
			super();
			this.account=account;
		}
		@Override
			public void run() {
				account.deposit(3000);
				account.withdraw(8000);
			}
		}