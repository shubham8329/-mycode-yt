package com.jspiders.hibernate.update;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernate.dto.StudentDTO;

public class StudentDAOupdate {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("student");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		entityTransaction.begin();
		StudentDTO student = entityManager.find(StudentDTO.class, 1);
	
		student.setEmail("amit1234@gmail.com");
		
		entityManager.persist(student);//to save the record persist() is used
		entityTransaction.commit();
		entityManagerFactory.close();
		entityManager.close();
	}
}
