package com.jspider.multithreading.resourses;

public class  Account {
	private int accountBalance;

	public Account(int accountBalance) {// constructor
		super();
		this.accountBalance = accountBalance;
	}

	public void deposit(int depositAmount) {
		System.out.println("Depositing" + depositAmount + "rupees in the account");
		accountBalance += depositAmount;//+=
		System.out.println("AvailableBalance" + accountBalance);
	}

	public void withdraw(int withdrawAmount) {
		if (accountBalance >= withdrawAmount) {

		System.out.println("withdrawing" + withdrawAmount + "from the Account");
		accountBalance -= withdrawAmount;//-=
		System.out.println("AvailableBalance:" + accountBalance);
		}
		else {
			System.out.println("Insufficient Balance");
		}
	}
}