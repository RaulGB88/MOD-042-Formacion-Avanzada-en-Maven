package com.lm2a;

import org.junit.jupiter.api.Test;
import  static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Tag;
public class CalculatorTest {

	@Test
	@Tag("lento")
	public void evaluateExpression() {
		Calculator calculator = new Calculator();
		int sum = calculator.evaluate("1+2+3");
		System.out.println("Test ejecutando...");
		assertTrue(true);
	}
}
