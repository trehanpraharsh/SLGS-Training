package com.model;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Component("welcome")

public class WelcomeDAOImpl implements WelcomeDAO {
	

	@Override
	public String sayHello(String name) {
		// TODO Auto-generated method stub
		return "Hello " + name;
	}

	@Override
	public void sayWelcome() {
		// TODO Auto-generated method stub
		System.out.println("Welcome method is called...");
		
	}

	@Override
	public int calculate(int a, int b) {
		// TODO Auto-generated method stub
		return a+b;
	}

	@Override
	public void testAround() {
		// TODO Auto-generated method stub
		System.out.println("Method which will be executed...");
	}

	
}
