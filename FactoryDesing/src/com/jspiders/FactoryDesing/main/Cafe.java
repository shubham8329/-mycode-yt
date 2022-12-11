package com.jspiders.FactoryDesing.main;
import java.util.Scanner;
import com.jspiders.FactoryDesing.items.Burger;
import com.jspiders.FactoryDesing.items.Coffee;
import com.jspiders.FactoryDesing.items.Fries;
import com.jspiders.FactoryDesing.items.Momos;
import com.jspiders.FactoryDesing.items.Pasta;
import com.jspiders.FactoryDesing.items.Pizza;
import com.jspiders.FactoryDesign.order.Order;
public class Cafe {
private static Order order;
private static boolean loop=true;
private static int choice;
private static Scanner scanner = new Scanner(System.in);

public static void main(String[] args) {
	while (loop) {
		try {

			factory().orderItem();
		} catch (NullPointerException e) {
			System.out.println("No order Received");

	}
	}
}
private static Order factory() {
	System.out.println("*-*-*-*-*MENU*-*-*-*-*\n"
			+"1.Pizza \n"
			+"2.Burger \n"
			+"3.Fries \n"
			+"4.Coffee \n"
			+"5.Momos \n"
			+"6.Pasta \n"
			+"7.Exit ");
	choice = scanner.nextInt();
	switch (choice) {
	case 1: {
		order = new Pizza();
		return order;
		//break;
	}
	case 2: {
		order = new Burger();
		return order;
		//break;
	}
	case 3: {
		order = new Fries();
		return order;
		//break;
	}
	case 4: {
		order = new Coffee();
		return order;
		//break;
	}
	case 5: {
		order = new Momos();
		return order;
		//break;
	}
	case 6: {
		order = new Pasta();
		return order;
		//break;
	}
	case 7: {
		System.out.println("Thank you.Visit Again!!!");
		loop = false;
		//break;
	}
	default:
		System.out.println("Invalid choice");
		//order = null;
		break;
	}
	return null;
}
}
