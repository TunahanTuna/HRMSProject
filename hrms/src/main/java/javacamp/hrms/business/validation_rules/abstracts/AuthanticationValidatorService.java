package javacamp.hrms.business.validation_rules.abstracts;

import javacamp.hrms.core.utilities.results.Result;

public interface AuthanticationValidatorService {

	Result isPasswordConfirm(String password, String passwordConfirm);
	
}
