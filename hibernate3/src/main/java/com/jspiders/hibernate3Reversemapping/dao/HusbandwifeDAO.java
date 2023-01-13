package com.jspiders.hibernate3Reversemapping.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernate3Reversemapping.dto.HusbandDTO;
import com.jspiders.hibernate3Reversemapping.dto.wifeDTO;



public class HusbandwifeDAO {
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
			
			HusbandDTO husband1 = new HusbandDTO();
			husband1.setId(4);
			husband1.setName("Iyer");
			husband1.setAge(40);
			manager.persist(husband1);
			
			wifeDTO wife1 = new wifeDTO();
			wife1.setId(4);
			wife1.setName("Babita");
			wife1.setAge(35);
			wife1.setHusband(husband1);
			husband1.setwife(wife1);
			manager.persist(wife1);
			
			
			transaction.commit();
			closeConnection();
		}
}	
//mysql> select * from husbanddto;
//+----+-----+----------+---------+
//| id | age | name     | wife_id |
//+----+-----+----------+---------+
//|  2 |  40 | Jethalal |    NULL |
//|  3 |  40 | tarak    |    NULL |
//+----+-----+----------+---------+
//2 rows in set (0.00 sec)
//
//mysql> select * from wifedto;
//+----+-----+--------+------------+
//| id | age | name   | Husband_id |
//+----+-----+--------+------------+
//|  1 |  35 | Daya   |       NULL |
//|  3 |  35 | Anjali |          3 |
//+----+-----+--------+------------+	

//<---husband1.setwife(wife1);--->

//mysql> select * from husbanddto;
//+----+-----+----------+---------+
//| id | age | name     | wife_id |
//+----+-----+----------+---------+
//|  2 |  40 | Jethalal |    NULL |
//|  3 |  40 | tarak    |    NULL |
//|  4 |  40 | Iyer     |    NULL |
//+----+-----+----------+---------+
//3 rows in set (0.00 sec)
//
//mysql> select * from wifedto;
//+----+-----+--------+------------+
//| id | age | name   | Husband_id |
//+----+-----+--------+------------+
//|  1 |  35 | Daya   |       NULL |
//|  3 |  35 | Anjali |          3 |
//|  4 |  35 | Babita |          4 |
//+----+-----+--------+------------+