package com.jspiders.hibernate.hibernate2.hibernateMapping.onetoone;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class HusbandDTO {
@Id
		int id;
		String name;
		int age;
		@OneToOne
		wifeDTO wife;
}
