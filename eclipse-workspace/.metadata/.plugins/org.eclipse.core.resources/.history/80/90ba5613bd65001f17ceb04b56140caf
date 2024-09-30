package com.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component(value="fda")

public class FixedAccount implements InterestCalculator {
	
	@Value("6.9")
	private double roi;
	
	@Value("6")
	private int duration;
	
	public FixedAccount() {
		System.out.println("Inside FDA...");
	}
	
	@Override
	public double calculate(double amount) {
		// TODO Auto-generated method stub
		return amount*roi/duration;
		
	}
	
	
}
