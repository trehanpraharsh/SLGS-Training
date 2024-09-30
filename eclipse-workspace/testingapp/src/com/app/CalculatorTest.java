package com.app;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculatorTest {

	@Test
	void testAdd() {
		//fail("Not yet implemented");
		Calculator calculator = new Calculator();
		//assertEquals is used to compare the expected and actual value
		assertEquals(10, calculator.add(5, 5));
		
	}

}
