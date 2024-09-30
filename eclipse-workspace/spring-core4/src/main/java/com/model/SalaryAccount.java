package com.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor

public class SalaryAccount implements InterestCalculator {

	private double roi;
	
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
