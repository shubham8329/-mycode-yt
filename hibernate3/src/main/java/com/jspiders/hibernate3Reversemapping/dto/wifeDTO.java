package com.jspiders.hibernate3Reversemapping.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;
@Entity
@Data
public class wifeDTO {
	@Id
	int id;
	String name;
	int age;
	@OneToOne
	HusbandDTO Husband;
}
