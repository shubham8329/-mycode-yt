package com.jspiders.hibernateonetomany.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class childDTO {
@Id
	private int id;
	private String name;
	private int age;
	
}
