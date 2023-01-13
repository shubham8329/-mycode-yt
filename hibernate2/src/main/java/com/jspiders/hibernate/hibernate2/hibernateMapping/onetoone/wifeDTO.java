package com.jspiders.hibernate.hibernate2.hibernateMapping.onetoone;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
@Entity
@Data
public class wifeDTO {
	@Id
	int id;
	String name;
	int age;
	HusbandDTO Husband;
}

