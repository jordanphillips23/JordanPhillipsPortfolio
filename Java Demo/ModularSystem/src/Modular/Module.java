package Modular;

import java.util.List;

public interface Module {
	public List<String> getDependancies();
	
	public String getIdentifier();
	
	public Object function(Object o);
}
