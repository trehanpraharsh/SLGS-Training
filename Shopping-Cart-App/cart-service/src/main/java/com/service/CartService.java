package com.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.entity.CartEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.model.Product;
import com.model.ShoppingCartRequest;
import com.model.ShoppingCartResponse;
import com.repo.CartRepo;

@Service
public class CartService {
	
	@Autowired
	private CartRepo repo;
	
	@Autowired
	@Qualifier("webclient")
	private WebClient.Builder builder;
	
	public ShoppingCartResponse processAndRequest(Long userID, List<ShoppingCartRequest> shoppingCartRequestsList) {
		
		//call product API
		ObjectMapper mapper =  new ObjectMapper();
		//here we are getting access to the url and by mapping and joining, we are just passing the product ids
		//of the products requested by the client to url to fetch that
		String productURL = "http://product-service/productapp/getprodcutbyid/" + 
				shoppingCartRequestsList.stream()
				.map(e -> String.valueOf(e.getProductID())).collect(Collectors.joining(","));
		//block function to perform this asynchronously
		//creating the response object as we created in resttemplate in app delegate
		List<Product> productServiceList = builder.build()
											.get()
											.uri(productURL)
											.retrieve()
											.bodyToFlux(Product.class)
											.collectList()
											.block();
		
		System.out.println(productURL);
		System.out.println(productServiceList);
		
		final Double[] totalCost = {0.0};
		//to set the quantity requested and not the quantity saved
		productServiceList.forEach(psl->{
			shoppingCartRequestsList.forEach(scr->{
				if(psl.getProductID() == scr.getProductID()) {
					//setting the quantity
					psl.setQuantity(scr.getQuantity());
					totalCost[0] += psl.getAmount()*scr.getQuantity(); 
				}
			});
		});
		
		
		//creating cart entity - to also save the data in database
		CartEntity cartEntity = null;
		try {
			cartEntity = CartEntity.builder()
							.userID(userID)
							.cartID((long) (Math.random()*Math.pow(10, 10)))
							.totalItems(productServiceList.size())
							.totalCosts(totalCost[0])
							.products(mapper.writeValueAsString(productServiceList))
							.build();
		} catch (Exception e) { }
		
		//saving to db
		cartEntity = repo.save(cartEntity);
		
		
		//generating shopping cart response
		ShoppingCartResponse response = ShoppingCartResponse.builder()
											.cartID(cartEntity.getCartID())
											.userID(cartEntity.getUserID())
											.totalItems(cartEntity.getTotalItems())
											.totalCosts(cartEntity.getTotalCosts())
											.products(productServiceList)
											.build();
		
		return response;

	}
	
	
	//function to call the product and see all the available products
	public List<Product> loadAvailableProducts(){
		String loadProductURL = "http://product-service/productapp/loadproducts";
		List<Product> resultProductServiceList = builder.build()
											.get()
											.uri(loadProductURL)
											.retrieve()
											.bodyToFlux(Product.class)
											.collectList()
											.block();
		
		
		return resultProductServiceList;
		
	}

}
