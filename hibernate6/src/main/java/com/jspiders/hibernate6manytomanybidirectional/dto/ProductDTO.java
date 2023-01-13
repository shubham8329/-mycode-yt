package com.jspiders.hibernate6manytomanybidirectional.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;

@Entity
@Data
public class ProductDTO {
@Id
	private int id;
	private String name;
	private double price;
	private String category;
@ManyToMany
	private List<CustomerDTO>Customers;
}
