package com.jspider.multithreading.threads;
import com.jspider.multithreading.threads.myThread1;
public class ThreadMain {
	public static void main(String[] args) {
		myThread1 myThread1 = new myThread1();
		myThread2 myThread2 = new myThread2();
		Thread thread = new Thread(myThread2);
		myThread1.start();
		thread.start();
	}
}
