package com.jspiders.springmvc.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class StudentPOJO {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private int id;
	
	private String name;
	
	
	private String email;
	
	private long contact;
	
	private String city;
	
	private String username;
	
	private String password;

}
