package com.jspider.multithreading.threads;
public class myThread1 extends Thread {

			public void run() {
				for(int s=1;s <= 5;s++) {
					System.out.println("Mythread1 is now running");
				}
			}
}