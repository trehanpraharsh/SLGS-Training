package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Product;
import com.model.ShoppingCartRequest;
import com.model.ShoppingCartResponse;
import com.service.CartService;

@RestController
@CrossOrigin
@RequestMapping("/shoppingcart")
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	@Value("${cart.message}")
	String message;
	
	
	@PostMapping("/{userID}/products")
	public ResponseEntity addProduct(@PathVariable Long userID, @RequestBody List<ShoppingCartRequest> reqProdList) {
		ShoppingCartResponse response = cartService.processAndRequest(userID, reqProdList);
		return new ResponseEntity(response, HttpStatus.CREATED);
		
	}
	
	@GetMapping("loadcartproducts")
	public List<Product> loadCartProducts(){
		System.out.println(message);
		return cartService.loadAvailableProducts();
	}
	

}
