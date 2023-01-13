package com.jspiders.hibernateonetomany.dao;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernateonetomany.dto.FatherDTO;
import com.jspiders.hibernateonetomany.dto.childDTO;

public class FatherChildDAO {

	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;

	private static void openConnection() {
		factory = Persistence.createEntityManagerFactory("OneToMany");
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

		childDTO child1 = new childDTO();
		child1.setId(1);
		child1.setName("Suresh");
		child1.setAge(20);
		manager.persist(child1);

		childDTO child2 = new childDTO();
		child2.setId(2);
		child2.setName("Mukesh");
		child2.setAge(25);
		manager.persist(child2);

		List<childDTO> children = Arrays.asList(child1, child2);

		FatherDTO father1 = new FatherDTO();
		father1.setId(1);
		father1.setName("Ramesh");
		father1.setAge(50);
		father1.setChildren(children);
		manager.persist(father1);

		transaction.commit();
		closeConnection();
	}
}
//mysql> select * from  fatherdto;
//+----+-----+--------+
//| id | age | name   |
//+----+-----+--------+
//|  1 |  50 | Ramesh |
//+----+-----+--------+
//1 row in set (0.00 sec)
//
//mysql> select * from  childdto;
//+----+-----+--------+
//| id | age | name   |
//+----+-----+--------+
//|  1 |  20 | Suresh |
//|  2 |  25 | Mukesh |
//+----+-----+--------+
//2 rows in set (0.00 sec)
//
//mysql> select * from  fatherdto_childdto;
//+--------------+-------------+
//| FatherDTO_id | children_id |
//+--------------+-------------+
//|            1 |           1 |
//|            1 |           2 |
//+--------------+-------------+
//2 rows in set (0.00 sec)