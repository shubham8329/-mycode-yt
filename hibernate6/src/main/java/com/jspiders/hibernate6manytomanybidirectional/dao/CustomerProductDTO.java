package com.jspiders.hibernate6manytomanybidirectional.dao;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernate6manytomany.dto.CustomerDTO;
import com.jspiders.hibernate6manytomany.dto.ProductDTO;

public class CustomerProductDTO {
	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;

	private static void openConnection() {
		factory = Persistence.createEntityManagerFactory("ManyToMany");
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
	}

	private static void closeConnection() {
		if (factory != null) {
			factory.close();
		}
		if (manager != null) {
			manager.close();
		}
		if (transaction.isActive()) {
			transaction.rollback();
			;
		}
	}

	public static void main(String[] args) {
		openConnection();
		transaction.begin();

		CustomerDTO customerDTO1 = new CustomerDTO();
		customerDTO1.setId(1);
		customerDTO1.setName("Dhiraj");
		customerDTO1.setEmail("dhiraj@gmail.com");
		customerDTO1.setContact(987456123L);

		CustomerDTO customerDTO2 = new CustomerDTO();
		customerDTO2.setId(2);
		customerDTO2.setName("Pushapa");
		customerDTO2.setEmail("pushpa@gmail.com");
		customerDTO2.setContact(984576123L);

		CustomerDTO customerDTO3 = new CustomerDTO();
		customerDTO3.setId(3);
		customerDTO3.setName("Rocky");
		customerDTO3.setEmail("rocky@gmail.com");
		customerDTO3.setContact(984576123L);

		ProductDTO productDTO1 = new ProductDTO();
		productDTO1.setId(1);
		productDTO1.setName("Shirt");
		productDTO1.setPrice(2000);
		productDTO1.setCategory("Clothings");

		ProductDTO productDTO2 = new ProductDTO();
		productDTO2.setId(2);
		productDTO2.setName("shoes");
		productDTO2.setPrice(2500);
		productDTO2.setCategory("Footwear");

		ProductDTO productDTO3 = new ProductDTO();
		productDTO3.setId(3);
		productDTO3.setName("watch");
		productDTO3.setPrice(2000);
		productDTO3.setCategory("Accessories");

		List<ProductDTO> Products = Arrays.asList(productDTO1, productDTO2, productDTO3);

		customerDTO1.setProducts(Products);
		customerDTO2.setProducts(Products);
		customerDTO3.setProducts(Products);

		manager.persist(customerDTO1);
		manager.persist(customerDTO2);
		manager.persist(customerDTO3);

		List<CustomerDTO> Customers = Arrays.asList(customerDTO1, customerDTO2, customerDTO3);

		productDTO1.setCustomers(Customers);
		productDTO2.setCustomers(Customers);
		productDTO3.setCustomers(Customers);

		manager.persist(productDTO1);
		manager.persist(productDTO2);
		manager.persist(productDTO3);
	}
}