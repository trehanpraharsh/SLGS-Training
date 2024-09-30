package com.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component(value="sla")

public class SalaryAccount implements InterestCalculator {

	@Value("5.6")
	private double roi;
	
	@Value("6")
	private int duration;
	
	public SalaryAccount() {
		System.out.println("Inside Salary Account...");
	}
	
	@Override
	public double calculate(double amount) {
		// TODO Auto-generated method stub
		return amount*roi/duration;
		
	}

}
