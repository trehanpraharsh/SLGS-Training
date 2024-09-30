package com.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class CartEntity {
	
	@Id
	private Long userID;
	private Long cartID;
	private Integer totalItems;
	private Double totalCosts;
	private String products;

}
