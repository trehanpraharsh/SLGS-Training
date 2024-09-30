package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.model.InterestCalculator;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor

public class CalculateService {
	
	private InterestCalculator ic;
	
	public CalculateService() {
		System.out.println("Inside Calculate Service...");
	}
	
	public double calculateROI(double amount) {
		
		return ic.calculate(amount);
		
	}
	
	@PostConstruct
	public void init() {
		System.out.println("After initialization");
	}
	
	@PreDestroy 
	public void destroy() {
		System.out.println("Before Destruction");
	}
	

}
