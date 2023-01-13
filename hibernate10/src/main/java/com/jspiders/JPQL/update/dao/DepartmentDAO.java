package com.jspiders.JPQL.update.dao;

import java.sql.ResultSet;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.JPQL.dto.DepartmentDTO;
import com.mysql.cj.Query;

public class DepartmentDAO {
	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static int result;
	private static EntityTransaction transaction;
	private static javax.persistence.Query query;
	private static String jpqlQuery;

	private static void openConnection() {

		factory = Persistence.createEntityManagerFactory("JPQL");
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
	}

	public static void main(String[] args) {
		openConnection();
		transaction.begin();

		//jpqlQuery = from DepartmentDTO;
		query = manager.createQuery(jpqlQuery);
		List<DepartmentDTO> rsultsetList = query.getResultList();

		for (DepartmentDTO departmentDTO : rsultsetList) {
			System.out.println(departmentDTO);
		}
		jpqlQuery = "update DepartmentDTO" + "setlocation='Banglore'" + "where id=4";
		query = manager.createQuery(jpqlQuery);
		result = query.executeUpdate();
		System.out.println(result + "row(s) of affected");
		
		jpqlQuery = "delete from DepartmentDTO" + "where id=4";
		result = query.executeUpdate();
		
		System.out.println(result+"row(s) affected");
		
		transaction.commit();
		closeConnection();
	}

	private static void closeConnection() {
		// TODO Auto-generated method stub
		
	}
}