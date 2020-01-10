package CalculatorTest;

import Modular.*;

public class Calculator {
	ModularController mc;
	
	public Calculator() {
		mc = new ModularController();
	}
	
	public void add(int a, int b) {
		if (mc.installedModules.containsKey("AdditionModule")) {
			System.out.println(mc.installedModules.get("AdditionModule").function(new int[] {a, b}));
		}
		else {
			System.out.println("Addition Not Installed");
		}
	}
	
	public void subtract(int a, int b) {
		if (mc.installedModules.containsKey("SubtractionModule")) {
			System.out.println(mc.installedModules.get("SubtractionModule").function(new int[] {a, b}));
		}
		else {
			System.out.println("Subtraction Not Installed");
		}
	}
	
	public void multiply(int a, int b) {
		if (mc.installedModules.containsKey("MultiplicationModule")) {
			System.out.println(mc.installedModules.get("MultiplicationModule").function(new int[] {a, b}));
		}
		else {
			System.out.println("Multiplication Not Installed");
		}
	}
	
}
