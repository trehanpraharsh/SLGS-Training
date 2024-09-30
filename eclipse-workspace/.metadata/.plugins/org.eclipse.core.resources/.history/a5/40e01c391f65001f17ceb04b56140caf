package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.model.InterestCalculator;

import lombok.Data;

@Data
@Service(value="service")


public class CalculateService {
	
	@Autowired
	@Qualifier(value = "fda")
	private InterestCalculator ic;
	
//	public CalculateService() {
//		System.out.println("Inside Calculate Service...");
//	}
	
	public double calculateROI(double amount) {
		
		return ic.calculate(amount);
		
	}
	
	public void init() {
		System.out.println("After initialization");
	}
	
	public void destroy() {
		System.out.println("Before Destruction");
	}
	

}
