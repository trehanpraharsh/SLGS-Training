package com.calc;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class CalcTest2 {
	
	@Mock
	AddService addService;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		
	}
	

	@Test
	public void testCalc() {
		
		CalcService calcService;
		
		calcService = new CalcService(addService);
		
		int num1 = 20;
		int num2 = 30;
		int expected = 50;
		
		when(addService.add(num1, num2)).thenReturn(expected);
		int actual = calcService.myCalc(num1, num2);
		assertEquals(expected, actual);
		
		
	}

}
