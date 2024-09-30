package com.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Using this instead of getters and setters by @Data
@NoArgsConstructor
@AllArgsConstructor

@Component(value="sa")

public class SavingAccount implements InterestCalculator {

	@Value("9.2")
	private double roi;
	
	@Value("3")
	private int duration;
	
//	public SavingAccount() {
//		System.out.println("Inside SavingsAccount...");
//	}
	
	@Override
	public double calculate(double amount) {
		// TODO Auto-generated method stub
		return amount*roi/duration;
		
	}

}
