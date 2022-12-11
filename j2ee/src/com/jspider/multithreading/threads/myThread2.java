package com.jspider.multithreading.threads;
public class myThread2 implements Runnable {
			public void run() {
				for(int s=1;s <= 5;s++) {
					System.out.println("Mythread2 is now running");
				}
			}
}