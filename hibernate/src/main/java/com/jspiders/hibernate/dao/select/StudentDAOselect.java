package com.jspiders.hibernate.dao.select;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernate.dto.StudentDTO;

public class StudentDAOselect {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("student");

		EntityManager entityManager = entityManagerFactory.createEntityManager();

		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();

		StudentDTO student = new StudentDTO();
		
		entityManager.find(StudentDTO.class,1);
		System.out.println(student);
		
		entityTransaction.commit();
		entityManagerFactory.close();
		entityManager.close();
}
}