package com.jspiders.hibernate6manytomany.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class ProductDTO {
@Id
	private int id;
	private String name;
	private double price;
	private String Category;
	public void setCustomers(List<CustomerDTO> customers) {
		// TODO Auto-generated method stub
		
	}
}
//mysql> select * from customerdto;
//+----+-----------+------------------+---------+
//| id | contact   | email            | name    |
//+----+-----------+------------------+---------+
//|  1 | 987456123 | dhiraj@gmail.com | Dhiraj  |
//|  2 | 984576123 | pushpa@gmail.com | Pushapa |
//|  3 | 984576123 | rocky@gmail.com  | Rocky   |
//+----+-----------+------------------+---------+
//3 rows in set (0.00 sec)
//
//mysql> select * from productdto;
//+----+-------------+-------+-------+
//| id | Category    | name  | price |
//+----+-------------+-------+-------+
//|  1 | Clothings   | Shirt |  2000 |
//|  2 | Footwear    | shoes |  2500 |
//|  3 | Accessories | watch |  2000 |
//+----+-------------+-------+-------+
//3 rows in set (0.00 sec)
//
//mysql> select * from customerdto_productdto;
//+----------------+-------------+
//| CustomerDTO_id | products_id |
//+----------------+-------------+
//|              1 |           1 |
//|              1 |           3 |
//|              2 |           2 |
//|              2 |           3 |
//|              3 |           1 |
//|              3 |           2 |
//|              3 |           3 |
//+----------------+-------------+
//7 rows in set (0.00 sec)