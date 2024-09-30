package com.model;

import java.util.List;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class ShoppingCartResponse {
	
	private Long userID;
	private Long cartID;
	private Integer totalItems;
	private Double totalCosts;
	private List<Product> products;

}
