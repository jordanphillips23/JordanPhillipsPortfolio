package CalculatorTest;

import java.util.ArrayList;
import java.util.List;

import Modular.ModularController;
import Modular.Module;

public class MultiplicationModule implements Module {

		private List<String> Dependancies = new ArrayList<>();
		
		ModularController mc;
		
		public MultiplicationModule(ModularController mc) {
			Dependancies.add("AdditionModule");
			this.mc = mc;
		}
		
		@Override
		public List<String> getDependancies() {
			
			return Dependancies;
		}

		@Override
		public String getIdentifier() {
			
			return "MultiplicationModule";
		}

		@Override
		public Object function(Object o) {
			int arr[] = (int[]) o;
			int out = 0;
			for (int i = 0; i < arr[0]; i++) {
				out = (int) mc.installedModules.get("AdditionModule").function(new int[] {out, arr[1]});
			}
			return out;
		}

	
}
