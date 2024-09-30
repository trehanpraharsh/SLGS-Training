package com.app;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorTest2 {
	
	static Calculator calculator;
	
	//This method compulsorily has to be static
	@BeforeAll
	public static void callBeforeAll() {
		System.out.println("called before all...");
		calculator = new Calculator();
		
	}
	
	@BeforeEach
	public void callBefore() {
		System.out.println("called before...");
	}

	@Test
	void testAdd() {
//		fail("Not yet implemented");
		assertEquals(10, calculator.add(5, 5));
	}

	@Test
	void testSub() {
//		fail("Not yet implemented");
		assertEquals(1, calculator.sub(6, 5));
	}

	@Test
	void testMul() {
//		fail("Not yet implemented");
		assertEquals(25, calculator.mul(5, 5));
	}
	
	@AfterEach
	public void callAfter() {
		System.out.println("called after...");
	}
	
	//This method has to be static compulsorily
	@AfterAll
	public static void callAfterAll() {
		System.out.println("called after all...");
	}

}
