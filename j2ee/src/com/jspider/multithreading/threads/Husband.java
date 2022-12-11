package com.jspider.multithreading.threads;
import  com.jspider.multithreading.resourses.Account;
public class Husband extends Thread{
		Account account;
		public Husband(Account account) {
			super();
			this.account=account;
		}
		@Override
			public synchronized void run() {
				account.deposit(5000);
				account.withdraw(7000);
			}
		}


