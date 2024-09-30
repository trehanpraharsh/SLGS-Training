package com.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
//@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity
public class Product {
	
	@Id
	@GeneratedValue
	private Long productID;
	private String productName;
	private Integer quantity;
	private Double amount;
	
	public Product(String productName, Integer quantity, Double amount) {
		super();
		this.productName = productName;
		this.quantity = quantity;
		this.amount = amount;
	}
	
	

}
