package com.jspiders.JPQL.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.JPQL.dto.DepartmentDTO;
import com.mysql.cj.Query;

public class DepartmentDAO {
		private static EntityManagerFactory factory;
		private static EntityManager manager;
		private static EntityTransaction transaction;
		private static Query query;
		private static String jpqlQuery;
		
		private static void openConnection() {
			
			factory = Persistence.createEntityManagerFactory("JPQL");
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
					
					DepartmentDTO dept1 = new DepartmentDTO();
					dept1.setName("Finance");
					dept1.setLocation("Pune");
					manager.persist(dept1);
					
					DepartmentDTO dept2 = new DepartmentDTO();
					dept2.setName("Sales");
					dept2.setLocation("Mumbai");
					manager.persist(dept2);
					
					DepartmentDTO dept3 = new DepartmentDTO();
					dept3.setName("Accounts");
					dept3.setLocation("Delhi");
					manager.persist(dept3);
					
					transaction.commit();
					closeConnection();
		}
}
