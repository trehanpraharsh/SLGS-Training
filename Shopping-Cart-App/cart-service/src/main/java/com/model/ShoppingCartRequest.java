package com.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ShoppingCartRequest {
	
	private Long productID;
	private Integer quantity;

}
