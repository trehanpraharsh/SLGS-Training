package com.calc;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.mockito.Mockito;

public class CalcTest {

	@org.junit.jupiter.api.Test
	void testCalc() {
		
		AddService addService;
		CalcService calcService;
		
		addService = Mockito.mock(AddService.class);
		calcService = new CalcService(addService);
		
		int num1 = 20;
		int num2 = 30;
		int expected = 50;
		
		when(addService.add(num1, num2)).thenReturn(expected);
		int actual = calcService.myCalc(num1, num2);
		assertEquals(expected, actual);
		
		
	}

}
