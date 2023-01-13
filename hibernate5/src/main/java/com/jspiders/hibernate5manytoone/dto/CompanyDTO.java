package com.jspiders.hibernate5manytoone.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class CompanyDTO {
@Id
	private int id;
	private String name;
	private String city;
	
}
