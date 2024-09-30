package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Product;
import com.service.ProductService;
import com.service.ProductServiceImpl;

@RestController
@RequestMapping("/productapp")
@RefreshScope
public class ProductApp {
	
	@Autowired
	private ProductServiceImpl service;
	
	@Value("${product.message}")
	String message;
	
	@PostMapping("/addproduct")
	public List<Product> addProducts(@RequestBody List<Product> prodList){
		return service.addProduct(prodList);
	}
	
	@GetMapping("/loadproducts")
	public List<Product> loadProducts(){
		System.out.println(message);
		return service.getProducts();
	}
	
	@GetMapping("/getprodcutbyid/{pIDs}")
	public List<Product> getProductByID(@PathVariable List<Long> pIDs){
		return service.getProductByIds(pIDs);
	}
	
	
	

}
