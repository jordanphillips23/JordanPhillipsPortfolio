package CalculatorTest;

import java.util.ArrayList;
import java.util.List;

import Modular.Module;

public class SubtractionModule implements Module{
	
	private List<String> Dependancies = new ArrayList<>();
	
	@Override
	public List<String> getDependancies() {
		
		return Dependancies;
	}

	@Override
	public String getIdentifier() {
	
		return "SubtractionModule";
	}

	@Override
	public Object function(Object o) {
		
		int[] arr = (int[]) o;
		return (Integer) arr[0] - arr[1];
	}

}
