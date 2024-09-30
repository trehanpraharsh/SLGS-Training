package com.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component(value="la")

public class LoanAccount implements InterestCalculator {

	@Value("7.3")
	private double roi;
	
	@Value("4")
	private int duration;
	
	public LoanAccount() {
		System.out.println("Inside Loan Account...");
	}
	
	@Override
	public double calculate(double amount) {
		// TODO Auto-generated method stub
		return amount*roi/duration;
		
	}
}
