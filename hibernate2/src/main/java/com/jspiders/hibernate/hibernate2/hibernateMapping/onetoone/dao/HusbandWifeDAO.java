package com.jspiders.hibernate.hibernate2.hibernateMapping.onetoone.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernate.hibernate2.hibernateMapping.onetoone.HusbandDTO;
import com.jspiders.hibernate.hibernate2.hibernateMapping.onetoone.wifeDTO;

public class HusbandWifeDAO {
	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	
	private static void openConnection() {
		
		factory = Persistence.createEntityManagerFactory("OneToOne");
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
			}
	}
		public static void main(String[] args) {
			openConnection();
			transaction.begin();
			
			wifeDTO wife1 = new wifeDTO();
			wife1.setId(1);
			wife1.setName("Daya");
			wife1.setAge(35);
			manager.persist(wife1);
			
			HusbandDTO husband1 = new HusbandDTO();
			husband1.setId(2);
			husband1.setName("Jethalal");
			husband1.setAge(40);
			manager.persist(husband1);
			
			transaction.commit();
			closeConnection();
		}
}	
	
