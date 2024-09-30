package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Product;
import com.repo.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository repository;

	@Override
	public List<Product> addProduct(List<Product> products) {
		// TODO Auto-generated method stub
		return repository.saveAll(products);
	}

	@Override
	public List<Product> getProducts() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public List<Product> getProductByIds(List<Long> pID) {
		// TODO Auto-generated method stub
		return repository.findAllById(pID); 
	}
	
	
	

}
