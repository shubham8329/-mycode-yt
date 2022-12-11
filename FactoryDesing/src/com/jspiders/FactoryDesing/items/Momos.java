package com.jspiders.FactoryDesing.items;

import com.jspiders.FactoryDesign.order.Order;

public class Momos implements Order{
	@Override
		public void orderItem() {
			System.out.println("Ordering Momos");
		try {
			Thread.sleep(3000);
		}catch(InterruptedException e) {
				e.printStackTrace();
			}
		System.out.println("Momos is ready");
		}
}