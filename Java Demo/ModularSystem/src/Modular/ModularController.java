package Modular;

import java.util.HashMap;

public class ModularController {
	public HashMap<String, Module> installedModules = new HashMap<>();
	
	
	public void install(Module m) throws MissingDependancyException {
		for (String s : m.getDependancies()) {
			if (!installedModules.containsKey(s)) {
				throw(new MissingDependancyException(s));
			}
		}
		installedModules.put(m.getIdentifier(), m);
	}
		
}
