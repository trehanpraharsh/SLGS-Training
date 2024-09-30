package com.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor

public class FixedAccount implements InterestCalculator {
	
	private double roi;
	
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
