package com.jspiders.hibernate3Reversemapping.dto;

import javax.persistence.Entity;
import javax.persistence.Id;


import lombok.Data;

@Entity
@Data
public class HusbandDTO {
@Id
		int id;
		String name;
		int age;
		public void setwife(wifeDTO wife1) {
			// TODO Auto-generated method stub
			
		}
		
}
