package com.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor

public class LoanAccount implements InterestCalculator {

	private double roi;
	
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
