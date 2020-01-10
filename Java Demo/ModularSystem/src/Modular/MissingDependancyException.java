package Modular;

public class MissingDependancyException extends Exception {
	public MissingDependancyException(String Dependancy) {
		super("Missing " + Dependancy  + " Dependancy");
	}
}
