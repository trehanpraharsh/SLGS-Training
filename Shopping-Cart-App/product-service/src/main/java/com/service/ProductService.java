package com.service;

import java.util.List;

import com.entity.Product;

public interface ProductService {
	
	public List<Product> addProduct(List<Product> products);
	
	public List<Product> getProducts();
	
	public List<Product> getProductByIds(List<Long> pID);

}
