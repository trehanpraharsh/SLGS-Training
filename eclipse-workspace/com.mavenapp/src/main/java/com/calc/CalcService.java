package com.calc;

public class CalcService {
	
	public AddService addService;

	public CalcService(AddService addService) {
		super();
		this.addService = addService;
	}
	
	public int myCalc(int a, int b) {
		return addService.add(a, b);
		
	}
	

}
