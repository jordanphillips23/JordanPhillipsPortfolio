package CalculatorTest;

import Modular.MissingDependancyException;

public class Tester {
	public static void main(String[] args) {
		Calculator c = new Calculator();
		try {
			c.add(1, 2);
			c.mc.install(new AdditionModule());
			c.add(1, 2);
			
			c.subtract(1, 3);
			c.mc.install(new SubtractionModule());
			c.subtract(1, 3);
			
			c.multiply(3, 4);
			c.mc.install(new MultiplicationModule(c.mc));
			c.multiply(3, 4);
		} catch (MissingDependancyException e) {
			e.printStackTrace();
		}
	}
}
