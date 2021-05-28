package javacamp.hrms.core.utilities.adapters;

public interface ValidationService {

	boolean checkService(long nationalityId, String firstName, String lastName, int birthYear);
	
}
